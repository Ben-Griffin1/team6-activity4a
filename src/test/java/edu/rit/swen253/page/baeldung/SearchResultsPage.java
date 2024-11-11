package edu.rit.swen253.page.baeldung;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.logging.Logger;
import edu.rit.swen253.utils.SeleniumUtils;


public class SearchResultsPage {
    private static final Logger logger = Logger.getLogger(SearchResultsPage.class.getName());

    /**
     * Logs the title and URL of each search result.
     * This method waits until the search results container is visible, then 
     * retrieves a list of search result elements (links) within the container.
     * For each result, it extracts the title (text) and URL (href attribute),
     * and logs these results using the logger.
     */
    public void logResults() {
        WebDriverWait wait = new WebDriverWait(SeleniumUtils.getDriver(), Duration.ofSeconds(10));
        WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.archive-columns.layout-stacked.click-whole.no-more.rounded-on")));
        List<WebElement> results = searchResults.findElements(By.cssSelector("a"));
        for (WebElement result : results) {
            String title = result.getText();
            String url = result.getAttribute("href");
            logger.info("Title: " + title + " | URL: " + url);
        }   
    }
        
    /**
     * Clicks on the first search result link to navigate to the linked page.
     * waits until the search results container is visible, then
     * retrieves a list of search result elements (links). It identifies the first
     * result in the list and clicks on it to navigate to the page associated with that result.
     */
    public void clickFirstResult() {
        WebDriverWait wait = new WebDriverWait(SeleniumUtils.getDriver(), Duration.ofSeconds(10));
        WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.archive-columns.layout-stacked.click-whole.no-more.rounded-on")));
        List<WebElement> results = searchResults.findElements(By.cssSelector("a"));
        WebElement firstResult = results.get(0);
        firstResult.click();
    }

}


