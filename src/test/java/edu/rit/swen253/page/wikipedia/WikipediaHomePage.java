package edu.rit.swen253.page.wikipedia;

import edu.rit.swen253.page.AbstractPage;
import edu.rit.swen253.utils.DomElement;
import edu.rit.swen253.utils.SeleniumUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.fail;


public class WikipediaHomePage extends AbstractPage {
  private static final By MAIN_CONTENT_FINDER = By.cssSelector("main");
  private static final By searchInput = By.id("searchInput");
  private static final By searchButton = By.cssSelector("main > div > div.banner banner-overlay banner--visible > div.pure-button pure-button-primary-progressive");
//   private static final By searchResult = By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]");
  private DomElement mainContentPanel;


  public WikipediaHomePage() {
    super();
    try {
      mainContentPanel = findOnPage(MAIN_CONTENT_FINDER);
    } catch (TimeoutException e) {
      fail("Main content panel not found");
    }
  }

  /**
     * Finds the search field, types in the searchPhrase, and presses the search button.
     * Waits until the search input is visible before typing searchPhrase
     * Waits until search button is clickable before clicking
     * 
     * @return a new instance of YoutubeSearchResultsPage
     */
  public WikipediaSearchResultsPage search(String searchPhrase) {
    WebDriver driver = SeleniumUtils.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
    DomElement searchField = DomElement.findBy(searchInput);
    searchField.enterText(searchPhrase);
    wait.until(ExpectedConditions.elementToBeClickable(searchButton));
    DomElement searchButtonElement = DomElement.findBy(searchButton);
    searchButtonElement.click();

    return new WikipediaSearchResultsPage();

  }

}