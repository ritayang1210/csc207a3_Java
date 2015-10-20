/**
 * 
 */
package extractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
public class AuthorNameExtractor extends AuthorInforExtractor {

  private final static String REGEX_NAME =
      ".*<title>([a-zA-Z\\s]+) - Google Scholar Citations</title>.*";

  public AuthorNameExtractor() {
    p = Pattern.compile(REGEX_NAME);
  }

  @Override
  public String extractAuthor(String htmlContents) {
    String authorName = null;
    Matcher m = p.matcher(htmlContents);
    if (m.matches()) {
      authorName = m.group(1);
    }
    return authorName;
  }
}
