package extractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TotalFst5PapersCitsExtractor extends
    AuthorInforExtractor {
  private final static String REGEX_TOTALFIRST5PAPERSCITATION =
      "href=\"http://scholar.google.ca/scholar\\?oi=bibs&hl=en&cites="
          + "\\d+\">(\\d+)</a></td>";

  public TotalFst5PapersCitsExtractor() {
    p = Pattern.compile(REGEX_TOTALFIRST5PAPERSCITATION);
  }

  @Override
  public Integer extractAuthor(String htmlContents) {
    int totalFirst5PapersCitation = 0;
    Matcher m = p.matcher(htmlContents);
    for (int i = 0; i < 5; i++) {
      if (m.find()) {
        totalFirst5PapersCitation += Integer.parseInt(m.group(1));
      }
    }
    return totalFirst5PapersCitation;
  }
}
