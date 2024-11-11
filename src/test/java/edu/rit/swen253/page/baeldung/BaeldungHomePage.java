package edu.rit.swen253.page.baeldung;

import edu.rit.swen253.page.AbstractPage;
import edu.rit.swen253.utils.DomElement;
import edu.rit.swen253.utils.SeleniumUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * A Page Object for the Baeldung Home page.
 */
public class BaeldungHomePage extends AbstractPage {
	private static final Logger logger = Logger.getLogger(BaeldungHomePage.class.getName());

	private static final By MAIN_CONTENT_FINDER = By.cssSelector("div.whole-homepage");

	private DomElement mainContentPanel;

	public BaeldungHomePage() {
		super();
		try {
			mainContentPanel = findOnPage(MAIN_CONTENT_FINDER);
		} catch (TimeoutException e) {
			fail("Main content panel not found");
		}
  	}

	public void closePopUpIfPresent() {
		try {
			WebElement closeButton = SeleniumUtils.getDriver().findElement(By.cssSelector(".qc-usp-close-icon"));
			WebDriverWait waitt = new WebDriverWait(SeleniumUtils.getDriver(), Duration.ofSeconds(10));
			waitt.until(ExpectedConditions.visibilityOf(closeButton)); 
			closeButton.click();
		} catch (NoSuchElementException e) {
			System.out.println("No pop up found, proceeding with the test");
		}
        
    }

	public void search(String query) {
		WebDriverWait wait = new WebDriverWait(SeleniumUtils.getDriver(), Duration.ofSeconds(10));
		WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		searchInput.sendKeys(query);
		searchInput.submit(); // submit the search field

    }

}

