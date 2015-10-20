package extractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumOfI10After2009Extractor extends AuthorInforExtractor {
  private final static String REFEX_NUMOFI10AFTER2009 =
      ".*\">i10-index</a></td><td class=\"cit-borderleft cit-data\">(\\d+).*";

  public NumOfI10After2009Extractor() {

    p = Pattern.compile(REFEX_NUMOFI10AFTER2009);
  }

  @Override
  public String extractAuthor(String htmlContents) {
    String numOfI10AterR2009 = null;
    Matcher m = p.matcher(htmlContents);
    if (m.matches()) {
      numOfI10AterR2009 = m.group(1);
    }
    return numOfI10AterR2009;
  }

}
