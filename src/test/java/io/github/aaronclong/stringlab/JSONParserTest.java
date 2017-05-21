package io.github.aaronclong.stringlab;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 * Created by aaronlong on 5/20/17.
 */
public class JSONParserTest {
  private static Logger logger = Logger.getLogger(CSVParserTest.class.toString());
  private String jsonString;

  @Before
  public void setUp() {
    try {
      ClassLoader classLoader = getClass().getClassLoader();
      Path file = Paths.get(classLoader.getResource("testJSONFile.json").toURI());
      byte[] jsonBytes = Files.readAllBytes(file);
      jsonString = new String(jsonBytes);
    } catch(Exception e) {
      logger.warning(e.toString());
    }
  }

  @Test
  public void testDeserializeJSON() {
    logger.info(jsonString);
  }
}
