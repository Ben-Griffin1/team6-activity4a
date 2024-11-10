package edu.rit.swen253.test.youtube;

import edu.rit.swen253.utils.DomElement;
import org.openqa.selenium.By;


public class YoutubeSearchResultItem {
    private static final By TITLE_LINK = By.cssSelector("h3 > a");
    private final DomElement resultElement;

    public YoutubeSearchResultItem(DomElement resultElement) {
        this.resultElement = resultElement;
    }

    /**
     * Retrieves the title of the search result.
     * 
     * @return the title of the search result
     */
    public String getTitle() {
        return resultElement.findChildBy(TITLE_LINK).getText();
    }

    /**
     * Retrieves the URL of the search result.
     * 
     * @return the URL of the search result
     */
    public String getUrl() {
        return resultElement.findChildBy(TITLE_LINK).getAttribute("href");
    }

    /**
     * Clicks the search result to navigate to the video page.
     */
    public void click() {
        resultElement.findChildBy(TITLE_LINK).click();
    }
}
