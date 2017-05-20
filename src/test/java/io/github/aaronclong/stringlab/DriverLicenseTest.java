package io.github.aaronclong.stringlab;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by aaronlong on 5/19/17.
 */
public class DriverLicenseTest {
  @Test
  public void testToString() {
    String testString = "Long,Aaron,456 Street Dr,NJ,L364856498487,06/17/1993,06/17/2014,06/30/2018,M,GRN,6'2,YES,D\n";
    DriverLicense aaronsLicense = DriverLicense.printLicense(new ArrayList<>());
    aaronsLicense.lastName("Long").firstName("Aaron").address("456 Street Dr")
      .state("NJ").licenseNumber("L364856498487").dateOfBirth("06/17/1993")
      .issuedDate("06/17/2014").expirationDate("06/30/2018").sex("M")
      .eyes("GRN").height("6'2").organDonor("YES").licenseClass("D");
    assertEquals("Asserting that the items are equal", testString, aaronsLicense.toString());
  }
}
