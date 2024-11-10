package edu.rit.swen253.test.youtube;

import edu.rit.swen253.utils.DomElement;
import org.openqa.selenium.By;


public class YoutubeSearchResultItem {
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
        DomElement titleElement = resultElement.findChildBy(By.cssSelector("a#video-title"));
        return titleElement.getAttribute("title");
    }

    /**
     * Retrieves the URL of the search result.
     * 
     * @return the URL of the search result
     */
    public String getUrl() {
        DomElement linkElement = resultElement.findChildBy(By.cssSelector("a#video-title"));
        return linkElement.getAttribute("href");
    }
}
