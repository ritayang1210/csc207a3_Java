package extractor;

import java.util.regex.Pattern;

public abstract class AuthorInforExtractor {
  protected Pattern p;

  public abstract Object extractAuthor(String htmlContents);
}
