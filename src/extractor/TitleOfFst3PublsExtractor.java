package extractor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TitleOfFst3PublsExtractor extends AuthorInforExtractor {
  private final static String REGEX_TITLEOfFIRST3PUBLS =
      "class=\"cit-dark-large-link\">(.*?)</a><br>";

  public TitleOfFst3PublsExtractor() {
    p = Pattern.compile(REGEX_TITLEOfFIRST3PUBLS);
  }

  @Override
  public List<String> extractAuthor(String htmlContents) {
    List<String> titleOfFirst3Publs = new ArrayList<String>();
    Matcher m = p.matcher(htmlContents);
    for (int i = 0; i < 3; i++) {
      if (m.find()) {
        titleOfFirst3Publs.add(m.group(1));
      }
    }
    return titleOfFirst3Publs;
  }
}
