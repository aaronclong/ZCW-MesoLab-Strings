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
    Pattern pattern = Pattern.compile("[\\b\\w+'?.?\\/?]+");
    Matcher match = pattern.matcher(keyValue);
    ArrayList<String> list = new ArrayList<>();
    while (match.find()) {
      list.add(match.group());
    }
    result[0] = list.get(0);
    StringBuilder builder = new StringBuilder();
    for (int i = 1; i < list.size(); i++) {
      builder.append(list.get(i));
    }
    result[1] = builder.toString();
    return result;
  }

  private static DriverLicense stringToDriverLicense(String block) {
    Pattern pattern = Pattern.compile("(\"[\\w\\.]+\":\\s\"[\\w\\/'\\s]+\",?)");
    DriverLicense driver = DriverLicense.printLicense(new ArrayList<>());
    Matcher matcher = pattern.matcher(block);
    while (matcher.find()) {
      String match = matcher.group();
      
    }

  }

  public static DriverLicense[] deserializeFromJSON(String json) {

    return new DriverLicense[]{};
  }

}
