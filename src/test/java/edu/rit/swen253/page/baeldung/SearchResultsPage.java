package edu.rit.swen253.page.baeldung;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.util.logging.Logger;
import java.util.stream.Collectors;

import edu.rit.swen253.utils.SeleniumUtils;

// SearchResultsPage: This class represents the search results page. 
// It includes methods to fetch the search results and click on the first one.


public class SearchResultsPage {
    private static final Logger logger = Logger.getLogger(SearchResultsPage.class.getName());

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

    // Method to click the first search result
    public void clickFirstResult() {
        WebDriverWait wait = new WebDriverWait(SeleniumUtils.getDriver(), Duration.ofSeconds(10));
        WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.archive-columns.layout-stacked.click-whole.no-more.rounded-on")));
        List<WebElement> results = searchResults.findElements(By.cssSelector("a"));
        WebElement firstResult = results.get(0);
        firstResult.click();
    }

}


