package edu.rit.swen253.page.wikipedia;

import edu.rit.swen253.page.AbstractPage;
import edu.rit.swen253.utils.DomElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;


public class WikipediaSearchResultsPage extends AbstractPage {
    private static final By resultItem = By.className("mw-search-results");
    private static final By secondRenderer = By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer[2]");

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
        List<DomElement> resultElements = second.findChildrenBy(resultItem);

        return resultElements.stream()
                .map(WikipediaSearchResultItem::new)
                .collect(Collectors.toList());
    }
}