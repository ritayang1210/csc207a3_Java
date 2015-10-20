package author;

import extractor.AuthorNameExtractor;
import extractor.CoAuthorsExtractor;
import extractor.NumOfAllCitsExtractor;
import extractor.NumOfI10After2009Extractor;
import extractor.TitleOfFst3PublsExtractor;
import extractor.TotalFst5PapersCitsExtractor;


public class AuthorGenerator {
  public Author createAuthor(String htmlContents) {



    AuthorNameExtractor name = new AuthorNameExtractor();
    NumOfAllCitsExtractor allCits = new NumOfAllCitsExtractor();
    NumOfI10After2009Extractor NumOfi10 =
        new NumOfI10After2009Extractor();
    TitleOfFst3PublsExtractor TitleOfPubls =
        new TitleOfFst3PublsExtractor();
    TotalFst5PapersCitsExtractor total5PaperCits =
        new TotalFst5PapersCitsExtractor();
    CoAuthorsExtractor coAuthor = new CoAuthorsExtractor();
    Author author =
        new Author.Builder()
            .name(name.extractAuthor(htmlContents))
            .numOfCitations(allCits.extractAuthor(htmlContents))
            .numOfi10After2009(NumOfi10.extractAuthor(htmlContents))
            .titleOfFirst3Pub(
                TitleOfPubls.extractAuthor(htmlContents))
            .totalFirst5PapersCitation(
                total5PaperCits.extractAuthor(htmlContents))
            .totalCoAuthors(
                coAuthor.extractAuthor(htmlContents).size())
            .coAuthorlist(coAuthor.extractAuthor(htmlContents))
            .build();
    return author;
  }
}
