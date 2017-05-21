package io.github.aaronclong.stringlab;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.util.logging.Logger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by aaronlong on 5/19/17.
 */
public class CSVParserTest {
  private static Logger logger = Logger.getLogger(CSVParserTest.class.toString());
  private ArrayList<String> linesAsStrings;
  private String csvFile;

  @Before
  public void setUp() {
    try {
      ClassLoader classLoader = getClass().getClassLoader();
      Path file = Paths.get(classLoader.getResource("testCSVFile.csv").toURI());
      linesAsStrings = new ArrayList<>();
      Files.lines(file).forEach(linesAsStrings::add);
      byte[] csvBytes = Files.readAllBytes(file);
      csvFile = new String(csvBytes);
    } catch(Exception e) {
      logger.warning(e.toString());
    }

  }

  @Test
  public void checkCSVHeader() {
     String csvFirstLine = linesAsStrings.get(0);
     String[] columns = new String[]{"LAST_NAME","FIRST_NAME","ADDR","STATE",
             "LICENSE_NUMBER","D.O.B.","ISS_D","EXP_D",
             "SEX","EYES","HGT","ORGANDONOR","CLASS"};
    ArrayList<String> compareList = CSVParser.getCSVHeader(csvFirstLine);
     for (int i = 0; i < compareList.size(); i++) {
       assertEquals("Checking that the CSV Headers are equal", columns[i], compareList.get(i));
     }
  }

  @Test
  public void testDeserializeFromCSV() {
    DriverLicense[] licenses = CSVParser.deserializeFromCSV(csvFile);
    assertTrue("Checking csv file consistency", licenses.length > 0);
    for (int i = 0; i < licenses.length; i++) {
      assertEquals("Confirming license is equivalent to the CSV",
              linesAsStrings.get(i+1) + '\n', licenses[i].toString());
    }
  }

  @Test
  public void testSerializeToCSV() {
    DriverLicense[] licenses = CSVParser.deserializeFromCSV(csvFile);
    String licenseObjectsToString = CSVParser.serializeToCSV(licenses);
    assertTrue("Checking csv file consistency", licenses.length > 0);
    assertEquals("Checking csv file consistency", csvFile, licenseObjectsToString);
  }
}
