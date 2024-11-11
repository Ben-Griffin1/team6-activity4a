package edu.rit.swen253.page.wikipedia;

import edu.rit.swen253.page.AbstractPage;
import edu.rit.swen253.utils.DomElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;


public class WikipediaSearchResultsPage extends AbstractPage {
    private static final By resultItem = By.cssSelector(".mw-search-results-container");
    private static final By secondRenderer = By.cssSelector("a");

    private final DomElement resultsContainer;

    public WikipediaSearchResultsPage() {
        super();
        this.resultsContainer = findOnPage(resultItem);
    }

    public List<WikipediaSearchResultItem> getSearchResults() {


        DomElement second = DomElement.findBy(secondRenderer);
        List<DomElement> resultElements = second.findChildrenBy(resultItem);
        return resultElements.stream()
                .map(WikipediaSearchResultItem::new)
                .collect(Collectors.toList());
    }
}