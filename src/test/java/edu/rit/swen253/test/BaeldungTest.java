package edu.rit.swen253.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.List;
import edu.rit.swen253.page.baeldung.BaeldungHomePage;
import edu.rit.swen253.utils.SeleniumUtils;
import java.util.logging.Logger;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaeldungTest extends AbstractWebTest {

  private BaeldungHomePage homePage;
  private static final Logger logger = Logger.getLogger(BaeldungHomePage.class.getName());
  @Test
  @Order(1)
  public void navigateToHomePage() {
    homePage = navigateToPage("https://www.baeldung.com/", BaeldungHomePage::new);
  }

  @Test
  @Order(2)
  public void performSearch() {
    // Navigate to the home page
    homePage = navigateToPage("https://www.baeldung.com/", BaeldungHomePage::new);
    WebDriverWait wait = new WebDriverWait(SeleniumUtils.getDriver(), Duration.ofSeconds(10));

    homePage.closePopUpIfPresent();
   
    // Click search button
    WebElement searchButton = SeleniumUtils.getDriver().findElement(By.id("menu-item-40489"));
    searchButton.click();

    // Find the search field and perform a search
    homePage.search("Spring");

    WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.archive-columns.layout-stacked.click-whole.no-more.rounded-on")));
    
    // Display the title and URL for each search result
    List<WebElement> results = searchResults.findElements(By.cssSelector("a"));
    for (WebElement result : results) {
        String title = result.getText();
        String url = result.getAttribute("href");
        logger.info("Title: " + title + " | URL: " + url);
    }

    // Click the first search result
    WebElement firstResult = results.get(0);
    firstResult.click();
    
    // Validate that the browser navigates to the expected page
    WebDriverWait navigationWait = new WebDriverWait(SeleniumUtils.getDriver(), Duration.ofSeconds(10));
    navigationWait.until(ExpectedConditions.urlContains("spring"));
  
    assertTrue(SeleniumUtils.getDriver().getCurrentUrl().contains("spring"));
  }

  // Test using page object model won't work page object model isn't found on site
  @Disabled
  @Test
  @Order(2)
  public void performSearch_W_page_object_model() {
    // Navigate to the home page
    homePage = navigateToPage("https://www.baeldung.com/", BaeldungHomePage::new);
    homePage.search("Spring");
    WebDriverWait wait = new WebDriverWait(SeleniumUtils.getDriver(), Duration.ofSeconds(10));
    // Close pop up
    homePage.closePopUpIfPresent();
  
    // Click search button
    WebElement searchButton = SeleniumUtils.getDriver().findElement(By.id("menu-item-40489"));
    searchButton.click();
    
    // Find the search field and perform a search
    homePage.search("page object model");
    WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.archive-columns.layout-stacked.click-whole.no-more.rounded-on")));
    
    // Display the title and URL for each search result
    List<WebElement> results = searchResults.findElements(By.cssSelector("a"));
    for (WebElement result : results) {
        String title = result.getText();
        String url = result.getAttribute("href");
        logger.info("Title: " + title + " | URL: " + url);
    }
    // Click the first search result
    WebElement firstResult = results.get(0);
    firstResult.click();
    
    // Validate that the browser navigates to the expected page
    WebDriverWait navigationWait = new WebDriverWait(SeleniumUtils.getDriver(), Duration.ofSeconds(10));
    navigationWait.until(ExpectedConditions.urlContains("page-object-model"));
  
    assertTrue(SeleniumUtils.getDriver().getCurrentUrl().contains("page-object-model"));
  }


}






