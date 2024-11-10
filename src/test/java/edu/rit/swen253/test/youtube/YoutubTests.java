package edu.rit.swen253.test.youtube;
import edu.rit.swen253.page.SimplePage;
import edu.rit.swen253.page.sample.RitAreaOfStudyLink;
import edu.rit.swen253.page.sample.RitHomePage;
import edu.rit.swen253.test.AbstractWebTest;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * A simple test that explores RIT's area of study; 'Computing' in particular.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 */
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
      System.out.println("THE SIZE OF THIS SHIT IS " + searchResults.size());

      assertTrue(searchResults.size() > 0);
      // assertEquals(10, searchResults.size());

  }
}
