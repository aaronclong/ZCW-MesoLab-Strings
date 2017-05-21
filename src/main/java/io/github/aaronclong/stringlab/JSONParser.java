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
    return new DriverLicense[]{};
  }

}
