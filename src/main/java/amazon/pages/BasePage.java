package amazon.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class BasePage {

	WebDriver driver;
	By hambugerMenu = By.id("nav-hamburger-menu");
	By menuTvAppliance = By.linkText("TV, Appliances, Electronics");
	By subMenuTelevision = By.linkText("Televisions");
	By brandSamsung = By.linkText("Samsung");
	By sortBy = By.id("s-result-sort-select");
	By resultIndex =  By.cssSelector("div[data-index='2']");
	By sectionTitle = By.xpath("//*[@id=\'feature-bullets\']/h1");

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToNewTab(int index) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30L))
				.pollingEvery(Duration.ofSeconds(5L))
				.ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(index));
	}

	public WebElement waitFor(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions
				.elementToBeClickable(locator));
	}
	
	public void click(By by) {
	    driver.findElement(by).click();
	}

	public void selectBy(By by, String text) {
		waitFor(sortBy);
		Select sorting = new Select(driver.findElement(by));
		sorting.selectByVisibleText(text);
	}
}
