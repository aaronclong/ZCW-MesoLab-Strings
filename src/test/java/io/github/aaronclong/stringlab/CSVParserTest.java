package io.github.aaronclong.stringlab;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by aaronlong on 5/19/17.
 */
public class CSVParserTest {
  @Test
  public void checkCSVHeader() {
     String csvFirstLine = "LAST_NAME,FIRST_NAME,ADDR,STATE,LICENSE_NUMBER,D.O.B.,ISS_D,EXP_D,SEX,EYES,HGT,ORGANDONOR,CLASS";
     String[] columns = new String[]{"LAST_NAME","FIRST_NAME","ADDR","STATE",
             "LICENSE_NUMBER","D.O.B.","ISS_D","EXP_D",
             "SEX","EYES","HGT","ORGANDONOR","CLASS"};
    ArrayList<String> compareList = CSVParser.getCSVHeader(csvFirstLine);
     for (int i = 0; i < compareList.size(); i++) {
       assertEquals("Checking that the CSV Headers are equal", columns[i], compareList.get(i));
     }
  }
}
