package io.github.aaronclong.stringlab;

import org.junit.Before;
import org.junit.Test;

import javax.print.URIException;
import java.io.File;
import java.nio.file.Path;
import java.io.IOException;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


import static org.junit.Assert.assertEquals;

/**
 * Created by aaronlong on 5/19/17.
 */
public class CSVParserTest {

  private Path file;
  private ArrayList<String> linesAsStrings;

  @Before
  public void setUp() {
    try {
      ClassLoader classLoader = getClass().getClassLoader();
      file = Paths.get(classLoader.getResource("testCSVFile.csv").toURI());
      linesAsStrings = new ArrayList<>();
      Files.lines(file).forEach(linesAsStrings::add);
    } catch(Exception e) {
      System.out.println(e);
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
  public void deserializeFromCSV() {

  }
}
