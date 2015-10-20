package extractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumOfAllCitsExtractor extends AuthorInforExtractor {
  private final static String REGEX_NUMOFCITATIONS =
      ".*Citations</a></td><td class=\"cit-borderleft cit-data\">(\\d+).*";

  public NumOfAllCitsExtractor() {
    p = Pattern.compile(REGEX_NUMOFCITATIONS);
  }

  @Override
  public String extractAuthor(String htmlContents) {
    String numOfCitations = null;
    Matcher m = p.matcher(htmlContents);
    if (m.matches()) {
      numOfCitations = m.group(1);
    }
    return numOfCitations;
  }

}
