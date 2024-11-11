package edu.rit.swen253.test.youtube;
import edu.rit.swen253.test.AbstractWebTest;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertTrue;



@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class YoutubTests extends AbstractWebTest {
  private static final Logger logger = Logger.getLogger(YoutubTests.class.getName());

  private YoutubeHomePage homePage;
  private YoutubeSearchResultsPage resultsPage;


  @Test
  @Order(1)
  public void navigateToHomePage() {
    homePage = navigateToPage("https://youtube.com", YoutubeHomePage::new);
  }

  @Test
  @Order(2)
  public void searchForPageObjectModel() {
      resultsPage = homePage.search("page object model");
      List<YoutubeSearchResultItem> searchResults = resultsPage.getSearchResults();
      searchResults.forEach(result -> {
        logger.info("Title: " + result.getTitle() + ", URL: " + result.getUrl());
    });

      assertTrue(searchResults.size() > 0);

  }
}
