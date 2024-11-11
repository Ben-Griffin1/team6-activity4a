package edu.rit.swen253.page.baeldung;

import org.openqa.selenium.By;
import edu.rit.swen253.utils.DomElement;



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

    /**
     * Retrieves the title of the search result.
     * 
     * @return title of search result
     */
    public String getTitle() {
        // scrollIntoView();
        return viewContainer.findChildBy(By.cssSelector("h3.post-title > a > span.hover-wrapper")).getText();
      }

      
    /**
     * Retrieves URL of the search result 
     *
     * @return the URL as a String
     */
    public String getUrl() {
        return viewContainer.findChildBy(By.cssSelector("a[rel='bookmark']")).getAttribute("href");
    }





    

}


