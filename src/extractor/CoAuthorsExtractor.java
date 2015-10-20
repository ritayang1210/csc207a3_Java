package extractor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoAuthorsExtractor extends AuthorInforExtractor {
  private final static String REGEX_COAUTHORS =
      "href=\"http://scholar.google.ca/citations\\?user=.*?=en\" "
          + "title=\".*?\">(.*?)</a><br>";

  public CoAuthorsExtractor() {
    p = Pattern.compile(REGEX_COAUTHORS);
  }

  @Override
  public List<String> extractAuthor(String htmlContents) {
    List<String> coAuthors = new ArrayList<String>();
    Matcher m = p.matcher(htmlContents);
    while (m.find()) {
      coAuthors.add(m.group(1));
    }
    Collections.sort(coAuthors);
    return coAuthors;
  }
}
