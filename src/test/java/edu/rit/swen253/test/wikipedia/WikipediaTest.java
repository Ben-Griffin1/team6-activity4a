package edu.rit.swen253.test.wikipedia;
import edu.rit.swen253.page.wikipedia.WikipediaHomePage;
import edu.rit.swen253.page.wikipedia.WikipediaSearchResultItem;
import edu.rit.swen253.page.wikipedia.WikipediaSearchResultsPage;
import edu.rit.swen253.test.AbstractWebTest;
import edu.rit.swen253.utils.SeleniumUtils;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;



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
        homePage.closePopUpIfPresent();
   
      resultsPage = homePage.search("fruit salad yum");
      List<WikipediaSearchResultItem> searchResults = resultsPage.getSearchResults();
      searchResults.forEach(result -> {
        logger.info("Title: " + result.getTitle());
    });

      WebElement resultButton = SeleniumUtils.getDriver().findElement(By.xpath("//a[@title='Fruit salad']"));
      resultButton.click();
  }
}