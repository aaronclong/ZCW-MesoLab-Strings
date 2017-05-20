package io.github.aaronclong.stringlab;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aaronlong on 5/19/17.
 */
public class CSVParser {

  public static ArrayList<String> getCSVHeader(String csv) {
    Pattern pattern = Pattern.compile("([A-Z_\\.]+(?![a-z])[^,1-9])");
    Matcher matcher = pattern.matcher(csv);
    ArrayList<String> matchedColumns = new ArrayList<>();
    while (matcher.find()) {
      matchedColumns.add(matcher.group());
    }
    return matchedColumns;
  }

  public static DriverLicense[] deserializeFromCSV(String csv) {
    String[] splitByLine = csv.split("\n");
    ArrayList<String> csvList = getCSVHeader(splitByLine[0]);
    //ArrayList<DriverLicense> licenses = new ArrayList<>();
    DriverLicense[] licenses = new DriverLicense[splitByLine.length-1];
    for (int i = 1; i < splitByLine.length; i++) {
      licenses[i - 1] = stringToDriverLicense(csvList, splitByLine[i]);
    }
    return licenses;
  }

  private static DriverLicense stringToDriverLicense(ArrayList<String> csvList, String line) {
    DriverLicense license = DriverLicense.printLicense(csvList);
    Pattern pattern = Pattern.compile("([a-zA-Z0-9\\/\\s']+)");
    ArrayList<String> fields = new ArrayList<>();
    Matcher matcher = pattern.matcher(line);
    while (matcher.find()) {
      fields.add(matcher.group());
    }
    license.lastName(fields.get(0)).firstName(fields.get(1)).address(fields.get(2))
      .state(fields.get(3)).licenseNumber(fields.get(4)).dateOfBirth(fields.get(5))
      .issuedDate(fields.get(6)).expirationDate(fields.get(7)).sex(fields.get(8))
      .eyes(fields.get(9)).height(fields.get(10)).organDonor(fields.get(11))
      .licenseClass(fields.get(12));
    return license;
  }

}
