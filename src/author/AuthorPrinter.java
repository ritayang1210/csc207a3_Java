package author;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuthorPrinter {
  private final static String DIVIDINGLINE =
      "------------------------------------------------------------"
          + "-----------";

  public void printAuthorInfor(List<Author> authors) {

    System.out.print(buildOutput(authors));
  }

  public void printAuthorInfor(List<Author> authors, File outFile) {
    String output = buildOutput(authors);
    try {
      BufferedWriter writer =
          new BufferedWriter(new FileWriter(outFile));
      writer.write(output.toString());
      writer.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private String buildOutput(List<Author> authors) {
    StringBuilder output = new StringBuilder();
    int totalCoAuthors = 0;
    List<String> allCoAuthors = new ArrayList<String>();
    for (Author author : authors) {
      output.append(DIVIDINGLINE + "\n");
      output.append(String.format("1. Name of Author:\n\t%s\n",
          author.getName()));
      output.append(String.format(
          "2. Number of All Citations:\n\t%s\n",
          author.getNumOfCitations()));
      output.append(String.format(
          "3. Number of i10-index after 2009:\n\t%s\n",
          author.getNumOfi10After2009()));
      output.append("4. Title of the first 3 publications:\n");
      List<String> publsList = author.getTitleOfFirst3Pub();
      for (int i = 1; i <= publsList.size(); i++) {
        output.append(String.format("\t%s-   %s\n", i,
            publsList.get(i - 1)));
      }
      output.append(String.format(
          "5. Total paper citation (first 5 papers):\n\t%s\n",
          author.getTotalFirst5PapersCitation()));
      output.append(String.format("6. Total Co-Authors:\n\t%s\n",
          author.getTotalCoAuthors()));
      totalCoAuthors += author.getTotalCoAuthors();
      allCoAuthors.addAll(author.getCoAuthorlist());
    }
    output.append("\n" + DIVIDINGLINE + "\n");
    output.append(String.format("7. Co-Author list sorted "
        + "(Total: %s):\n", totalCoAuthors));
    Collections.sort(allCoAuthors);
    for (String coAuthor : allCoAuthors) {
      output.append(coAuthor + "\n");
    }
    return output.toString();
  }
}
