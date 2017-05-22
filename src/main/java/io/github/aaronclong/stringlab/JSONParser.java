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
        driver.firstName(keyValue[1]);
        break;
      case "ADDR":
        driver.address(keyValue[1]);
        break;
      case "STATE":
        driver.state(keyValue[1]);
        break;
      case "LICENSE_NUMBER":
        driver.licenseNumber(keyValue[1]);
        break;
      case "D.O.B.":
        driver.dateOfBirth(keyValue[1]);
        break;
      case "ISS_D":
        driver.issuedDate(keyValue[1]);
        break;
      case "EXP_D":
        driver.expirationDate(keyValue[1]);
        break;
      case "SEX":
        driver.sex(keyValue[1]);
        break;
      case "EYES":
        driver.eyes(keyValue[1]);
        break;
      case "HGT":
        driver.height(keyValue[1]);
        break;
      case "ORGANDONOR":
        driver.organDonor(keyValue[1]);
        break;
      case "CLASS":
        driver.licenseClass(keyValue[1]);
        break;
    }

  }

  private static String valueGetter(DriverLicense driver, String key) {
    switch (key.toUpperCase()) {
      case "LAST_NAME":
        return driver.getLastName();
      case "FIRST_NAME":
        return driver.getFirstName();
      case "ADDR":
        return driver.getAddress();
      case "STATE":
        return driver.getState();
      case "LICENSE_NUMBER":
        return driver.getLicenseNumber();
      case "D.O.B.":
        return driver.getDateOfBirth();
      case "ISS_D":
        return driver.getIssuedDate();
      case "EXP_D":
        return driver.getExpirationDate();
      case "SEX":
        return driver.getSex();
      case "EYES":
        return driver.getEyes();
      case "HGT":
        return driver.getHeight();
      case "ORGANDONOR":
        return driver.getOrganDonor();
      case "CLASS":
        return driver.getLicenseClass();
      default:
        return null;
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
    String regexPattern = "(\\{\\s+(\"[\\w\\.]+\":\\s\"[\\w '\\/-]+\",?\\s+)+\\})";
    Pattern pattern = Pattern.compile(regexPattern);
    Matcher matcher = pattern.matcher(json);
    ArrayList<DriverLicense> licenses = new ArrayList<>();
    while (matcher.find()) {
      String curGroup = (matcher.group());
      licenses.add(stringToDriverLicense(curGroup));
    }
    return licenses.toArray(new DriverLicense[licenses.size()]);
  }

  public static String serializeToJSON(DriverLicense[] licenses) {
    StringBuilder sb = new StringBuilder(1000);
    sb.append("[\n");
    for (int i = 0; i < licenses.length; i++) {
      sb.append(buildBlock(licenses[i]));
      if (i != licenses.length - 1) {
        sb.append(",\n");
      }
    }
    sb.append("\n]");
    return sb.toString();
  }

  private static String buildBlock(DriverLicense license) {
    StringBuilder sb = new StringBuilder(1000);
    sb.append("  {\n");
    LicenseFields[] fields = LicenseFields.values();
    for (int i = 0; i < fields.length; i++) {
      String key = fields[i].getValue();
      String value = valueGetter(license, key);
      boolean punctuation = i == (fields.length - 1);
      sb.append(lineBuilder(key, value, punctuation));
    }
    sb.append("  }");
    return sb.toString();
  }

  private static String lineBuilder(String key, String value, boolean lastItem) {
    String punctuation = lastItem ? "" : ",";
    return String.format("    \"%s\": \"%s\"%s\n", key, value, punctuation);
  }

}
