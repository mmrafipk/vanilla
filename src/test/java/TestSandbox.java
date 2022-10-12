import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.pages.HomePage;
import amazon.pages.ResultDetailPage;
import amazon.pages.SearchResultsPage;
import com.typesafe.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestSandbox {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private static WebDriver driver;
    static HomePage homePage;
    static SearchResultsPage resultPage;
    static ResultDetailPage detailPage;

    @BeforeAll
    public static void setup() {							
    	try {
			driver = DriverFactory.getDriver();
			homePage = new HomePage(driver);
			resultPage = new SearchResultsPage(driver);
			detailPage = new ResultDetailPage(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}	
    }	
    
    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void assertThatHomePageTitleIsCorrect() {
        driver.get(HOME_PAGE_URL);
        assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
        
        homePage.clickHamburgerMenu();
        homePage.clickTvApplianceLink();
        homePage.clickTelevisionLink();
        resultPage.clickFilterCheckbox();
        resultPage.sortByPrice();
        resultPage.openSearchResult();
        detailPage.swithToNewTab();
        WebElement title = detailPage.verifySectionTitle();
        assertEquals("About this item", title.getText());
    }
    
    @AfterAll
    public static void tearDown() {
    	driver.quit();
    }
}
