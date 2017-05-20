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
    while(matcher.find()) {
      matchedColumns.add(matcher.group());
    }
    System.out.println(matchedColumns.size());
    return matchedColumns;
  }

}
