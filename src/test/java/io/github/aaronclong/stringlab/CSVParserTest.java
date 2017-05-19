package io.github.aaronclong.stringlab;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by aaronlong on 5/19/17.
 */
public class CSVParserTest {
  @Test
  public void checkCSVHeader() {
    String headerTest = "LAST_NAME,FIRST_NAME,ADDR,STATE,LICENSE_NUMBER,D.O.B.,ISS_D,EXP_D,SEX,EYES,HGT,ORGANDONOR,CLASS\n";
    assertEquals("Checking that the strings are equal", headerTest, "");
  }
}
