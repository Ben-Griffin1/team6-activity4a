package edu.rit.swen253.page.wikipedia;

import edu.rit.swen253.page.AbstractPage;
import edu.rit.swen253.utils.DomElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;


public class WikipediaSearchResultsPage extends AbstractPage {
    private static final By resultItem = By.cssSelector(".mw-search-results");
    private static final By secondRenderer = By.tagName("a");

    private final DomElement resultsContainer;

    public WikipediaSearchResultsPage() {
        super();
        this.resultsContainer = findOnPage(resultItem);
    }

    /**
     * Gets the list of search results.
     * 
     * @return a list of YoutubeSearchResultItem representing each search result
     */
    public List<WikipediaSearchResultItem> getSearchResults() {
        DomElement second = DomElement.findBy(secondRenderer);
        System.out.println(second.toString());
        List<DomElement> resultElements = second.findChildrenBy(resultItem);
       System.out.println(resultElements.toString());
        return resultElements.stream()
                .map(WikipediaSearchResultItem::new)
                .collect(Collectors.toList());
    }
}