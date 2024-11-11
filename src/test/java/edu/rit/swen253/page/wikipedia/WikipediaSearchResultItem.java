package edu.rit.swen253.page.wikipedia;

import edu.rit.swen253.utils.DomElement;
import org.openqa.selenium.By;


public class WikipediaSearchResultItem {
    private final DomElement resultElement;

    public WikipediaSearchResultItem(DomElement resultElement) {
        this.resultElement = resultElement;
    }

    /**
     * Gets the title of the search result.
     * 
     * @return the title of the search result
     */
    public String getTitle() {
        DomElement titleElement = resultElement.findChildBy(By.cssSelector(".mw-search-result-heading"));
        System.out.println("TITLE: "+titleElement.getAttribute("title"));;
        return titleElement.getAttribute("title");
    }

    /**
     * Gets the URL of the search result.
     * 
     * @return the URL of the search result
     */
    public String getUrl() {
        DomElement linkElement = resultElement.findChildBy(By.cssSelector("a#video-title"));
        return linkElement.getAttribute("href");
    }
}