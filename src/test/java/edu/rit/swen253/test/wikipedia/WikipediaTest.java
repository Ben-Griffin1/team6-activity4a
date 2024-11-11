package edu.rit.swen253.test.wikipedia;
import edu.rit.swen253.page.wikipedia.WikipediaHomePage;
import edu.rit.swen253.page.wikipedia.WikipediaSearchResultItem;
import edu.rit.swen253.page.wikipedia.WikipediaSearchResultsPage;
import edu.rit.swen253.test.AbstractWebTest;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertTrue;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WikipediaTest extends AbstractWebTest {
  private static final Logger logger = Logger.getLogger(WikipediaTest.class.getName());

  private WikipediaHomePage homePage;
  private WikipediaSearchResultsPage resultsPage;


  @Test
  @Order(1)
  public void navigateToHomePage() {
    homePage = navigateToPage("https://wikipedia.org", WikipediaHomePage::new);    
  }

  @Test
  @Order(2)
  public void searchForPageObjectModel() {
    homePage = navigateToPage("https://wikipedia.org", WikipediaHomePage::new);    
      resultsPage = homePage.search("page object model");
      List<WikipediaSearchResultItem> searchResults = resultsPage.getSearchResults();
      searchResults.forEach(result -> {
        logger.info("Title: " + result.getTitle() + ", URL: " + result.getUrl());
    });

      assertTrue(searchResults.size() > 0);

  }
}