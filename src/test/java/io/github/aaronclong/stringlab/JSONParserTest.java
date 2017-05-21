package io.github.aaronclong.stringlab;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 * Created by aaronlong on 5/20/17.
 */
public class JSONParserTest {
  private static Logger logger = Logger.getLogger(JSONParserTest.class.toString());
  private String jsonString;
  private DriverLicense[] csvDriversTestAgainst;

  @Before
  public void setUpForJSON() {
    try {
      ClassLoader classLoader = getClass().getClassLoader();
      Path file = Paths.get(classLoader.getResource("testJSONFile.json").toURI());
      byte[] jsonBytes = Files.readAllBytes(file);
      jsonString = new String(jsonBytes);
    } catch(Exception e) {
      logger.warning(e.toString());
    }
  }

  @Before
  public void setUpForCSVObject() {
      try {
        ClassLoader classLoader = getClass().getClassLoader();
        Path file = Paths.get(classLoader.getResource("testCSVFile.csv").toURI());
        byte[] csvBytes = Files.readAllBytes(file);
        String csvString = new String(csvBytes);
        csvDriversTestAgainst = CSVParser.deserializeFromCSV(csvString);
      } catch(Exception e) {
        logger.warning(e.toString());
      }
  }

  @Test
  public void testDeserializeJSON() {
    DriverLicense[] driversFromJSON = JSONParser.deserializeFromJSON(jsonString);
    assertEquals("Checking for identical DriverLicense Object creation",
            csvDriversTestAgainst.length, driversFromJSON.length);
    for (int i = 0; i < driversFromJSON.length; i++) {
      assertEquals("Checking for identical DriverLicense Object creation",
              csvDriversTestAgainst[i], driversFromJSON[i]);
    }
  }
}
