package edu.rit.swen253.page.baeldung;

import org.openqa.selenium.By;

import edu.rit.swen253.utils.DomElement;

// This class represents a single search result on the search results page.
// It stores the title and URL of the result and provides methods to access these properties.


public class SearchResultView {
    private String title;
    private String url;
    private DomElement link;
    private DomElement viewContainer;

    public SearchResultView(DomElement link) {
        this.link = link;
        this.title = link.getText();  
        this.url = link.getAttribute("href");  
    }

    public String getTitle() {
        // scrollIntoView();
        return viewContainer.findChildBy(By.cssSelector("h3.post-title > a > span.hover-wrapper")).getText();
      }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "SearchResultView{" +
                "title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}


