package io.github.aaronclong.stringlab;

import java.util.ListIterator;

/**
 * Created by aaronlong on 5/21/17.
 */
public enum LicenseFields {
  LAST_NAME("LAST_NAME"),
  FIRST_NAME("FIRST_NAME"),
  ADDR("ADDR"),
  STATE("STATE"),
  LICENSE_NUMBER("LICENSE_NUMBER"),
  DOB("D.O.B"),
  ISS_D("ISS_D"),
  EXP_D("EXP_D"),
  SEX("SEX"),
  EYES("EYES"),
  HGT("HGT"),
  ORGANDONOR("ORGANDONOR"),
  CLASS("CLASS");

  private String value;
  LicenseFields(String theVal) {
    value = theVal;
  }

  public String getValue() {
    return value;
  }
}
