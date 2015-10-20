// **********************************************************
// Assignment3:
// CDF user_name: yangran
//
// Author: Ran Yang
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// *********************************************************
package driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import author.Author;
import author.AuthorGenerator;
import author.AuthorPrinter;

public class MyParser {

  /**
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    // DEBUGStarterCode(args);
    MyParser parser = new MyParser();
    String html2 = parser.getHTML(args[0].split(",")[0]);
    String html1 = parser.getHTML(args[0].split(",")[1]);
    AuthorGenerator generator = new AuthorGenerator();
    List<Author> authors = new ArrayList<Author>();
    authors.add(generator.createAuthor(html1));
    authors.add(generator.createAuthor(html2));
    AuthorPrinter printer = new AuthorPrinter();
    if (args.length == 1) {
      printer.printAuthorInfor(authors);
    } else if (args.length == 2) {
      printer.printAuthorInfor(authors, new File(args[1]));
    } else {
      String errorMessage = "Invalid Arguments!";
      System.out.print(errorMessage);
    }
  }

  public String getHTML(String urlString) throws Exception {
    // create object to store html source text as it is being
    // collected
    StringBuilder html = new StringBuilder();
    // open connection to given url
    URL url = new File(urlString).toURI().toURL();
    // create BufferedReader to buffer the given url's HTML source
    BufferedReader htmlbr =
        new BufferedReader(new InputStreamReader(url.openStream()));
    String line;
    // read each line of HTML code and store in StringBuilder
    while ((line = htmlbr.readLine()) != null) {
      html.append(line);
    }
    htmlbr.close();
    // convert StringBuilder into a String and return it
    return html.toString();
  }
}
