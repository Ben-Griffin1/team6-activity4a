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

	/**
	 * Closes privacy pop-up dialog if present on the page.
	 * attempts to locate a pop-up close button 
	 * If the close button is found and visible it's clicked and closes pop up
	 * If the pop-up is not present, the method catches the exception prints that no pop-up was found.
	 * @throws NoSuchElementException if the close button cannot be located on the page 
	 */
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

	/**
	 * Performs a search on the page using the specified query string.
	 * Waits until the search input field is visible, 
	 * then enters provided search query and submits the search. 
	 * @param query the search query to be entered into the search field
	 */
	public void search(String query) {
		WebDriverWait wait = new WebDriverWait(SeleniumUtils.getDriver(), Duration.ofSeconds(10));
		WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		searchInput.sendKeys(query);
		searchInput.submit(); // submit the search field
    }

}

