package author;

import java.util.ArrayList;
import java.util.List;

public class Author {
  private String name;
  private String numOfCitations;
  private String numOfi10After2009;
  private List<String> titleOfFirst3Pub;
  private int totalFirst5PapersCitation;
  private int totalCoAuthors;
  private List<String> coAuthorlist;

  public static class Builder {
    private String name;
    private String numOfCitations;
    private String numOfi10After2009;
    private List<String> titleOfFirst3Pub;
    private int totalFirst5PapersCitation;
    private int totalCoAuthors;
    private List<String> coAuthorlist;

    public Builder() {
      name = "";
      numOfCitations = "";
      numOfi10After2009 = "";
      titleOfFirst3Pub = new ArrayList<String>();
      totalFirst5PapersCitation = 0;
      totalCoAuthors = 0;
      coAuthorlist = new ArrayList<String>();
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder numOfCitations(String numOfCitations) {
      this.numOfCitations = numOfCitations;
      return this;
    }

    public Builder numOfi10After2009(String numOfi10After2009) {
      this.numOfi10After2009 = numOfi10After2009;
      return this;
    }

    public Builder titleOfFirst3Pub(List<String> titleOfFirst3Pub) {
      this.titleOfFirst3Pub = titleOfFirst3Pub;
      return this;
    }

    public Builder totalFirst5PapersCitation(
        int totalFirst5PapersCitation) {
      this.totalFirst5PapersCitation = totalFirst5PapersCitation;
      return this;
    }

    public Builder totalCoAuthors(int totalCoAuthors) {
      this.totalCoAuthors = totalCoAuthors;
      return this;
    }

    public Builder coAuthorlist(List<String> coAuthorlist) {
      this.coAuthorlist = coAuthorlist;
      return this;
    }

    public Author build() {
      return new Author(this);
    }
  }

  private Author(Builder builder) {
    this.name = builder.name;
    this.numOfCitations = builder.numOfCitations;
    this.numOfi10After2009 = builder.numOfi10After2009;
    this.titleOfFirst3Pub = builder.titleOfFirst3Pub;
    this.totalFirst5PapersCitation =
        builder.totalFirst5PapersCitation;
    this.totalCoAuthors = builder.totalCoAuthors;
    this.coAuthorlist = builder.coAuthorlist;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @return the numOfCitations
   */
  public String getNumOfCitations() {
    return numOfCitations;
  }

  /**
   * @return the numOfi10After2009
   */
  public String getNumOfi10After2009() {
    return numOfi10After2009;
  }

  /**
   * @return the titleOfFirst3Pub
   */
  public List<String> getTitleOfFirst3Pub() {
    return titleOfFirst3Pub;
  }

  /**
   * @return the totalFirst5PapersCitation
   */
  public int getTotalFirst5PapersCitation() {
    return totalFirst5PapersCitation;
  }

  /**
   * @return the totalCoAuthors
   */
  public int getTotalCoAuthors() {
    return totalCoAuthors;
  }

  /**
   * @return the coAuthorlist
   */
  public List<String> getCoAuthorlist() {
    return coAuthorlist;
  }
}
