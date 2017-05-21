package io.github.aaronclong.stringlab;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by aaronlong on 5/20/17.
 */
public class JSONParser {

  private static String[] getKeyValuePair(String keyValue) {
    String[] result = new String[2];
    Pattern pattern = Pattern.compile("(\\w+\\s?(\\.?)(\\/?)('?))+");
    Matcher match = pattern.matcher(keyValue);
    for (int i = 0; i < 2; i++) {
      if (!match.find()) {
        return null;
      }
      result[i] = match.group();
    }
    return result;
  }

  private static void valueSetter(DriverLicense driver, String[] keyValue) {
    switch (keyValue[0].toUpperCase()) {
      case "LAST_NAME":
        driver.lastName(keyValue[1]);
        break;
      case "FIRST_NAME":
        driver.lastName(keyValue[1]);
        break;
      case "ADDR":
        driver.lastName(keyValue[1]);
        break;
      case "STATE":
        driver.lastName(keyValue[1]);
        break;
      case "LICENSE_NUMBER":
        driver.lastName(keyValue[1]);
        break;
      case "D.O.B.":
        driver.lastName(keyValue[1]);
        break;
      case "ISS_D":
        driver.lastName(keyValue[1]);
        break;
      case "EXP_D":
        driver.lastName(keyValue[1]);
        break;
      case "SEX":
        driver.lastName(keyValue[1]);
        break;
      case "EYES":
        driver.lastName(keyValue[1]);
        break;
      case "HGT":
        driver.lastName(keyValue[1]);
        break;
      case "ORGANDONOR":
        driver.lastName(keyValue[1]);
        break;
      case "CLASS":
        driver.lastName(keyValue[1]);
        break;
    }

  }

  private static DriverLicense stringToDriverLicense(String block) {
    Pattern pattern = Pattern.compile("(\"[\\w\\.]+\":\\s\"[\\w\\/'\\s]+\",?)");
    DriverLicense driver = DriverLicense.printLicense(new ArrayList<>());
    Matcher matcher = pattern.matcher(block);
    while (matcher.find()) {
      String[] match = getKeyValuePair(matcher.group());
      if (match == null) {
        return null;
      }
      valueSetter(driver, match);
    }
    return driver;
  }

  public static DriverLicense[] deserializeFromJSON(String json) {
    Pattern pattern = Pattern.compile("(\\{\\s+(\"[\\w\\.]+\":\\s\"[\\w\\/'\\s]+\",?\\s+)+\\})");
    Matcher matcher = pattern.matcher(json);
    int groups = matcher.groupCount();
    System.out.println(groups);
    DriverLicense[] licenses = new DriverLicense[groups];
    for (int i = 0; i < groups; i++) {
      matcher.find();
      String curGroup = (matcher.group());
      System.out.println(curGroup);
      licenses[i] = stringToDriverLicense(curGroup);
    }
    return licenses;
  }

}
