package edu.rit.swen253.test.youtube;
import edu.rit.swen253.page.AbstractPage;
import edu.rit.swen253.page.sample.RitAreaOfStudyLink;
import edu.rit.swen253.utils.DomElement;
import edu.rit.swen253.utils.HtmlUtils;
import edu.rit.swen253.utils.SeleniumUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.fail;



public class YoutubeHomePage extends AbstractPage {
  private static final Logger logger = Logger.getLogger(YoutubeHomePage.class.getName());
  private static final By MAIN_CONTENT_FINDER = By.tagName("ytd-app");
  private static final By searchInput = By.cssSelector("input[name='search_query']");
  private static final By searchButton = By.cssSelector("button[aria-label='Search']");
  private static final By searchResult = By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]");
  private DomElement mainContentPanel;



  public YoutubeHomePage() {
    super();
    try {
      mainContentPanel = findOnPage(MAIN_CONTENT_FINDER);
    } catch (TimeoutException e) {
      fail("Main content panel not found");
    }
  }

  public YoutubeSearchResultsPage search(String searchPhrase) {
    WebDriver driver = SeleniumUtils.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    DomElement searchField = DomElement.findBy(searchInput);
    searchField.enterText(searchPhrase);
    wait.until(ExpectedConditions.elementToBeClickable(searchButton));
    DomElement searchButtonElement = DomElement.findBy(searchButton);
    searchButtonElement.click();

    return new YoutubeSearchResultsPage();

  }

}
