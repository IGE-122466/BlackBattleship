package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserStory12Test {

    private WebDriver driver;
    private UserStory12 page;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        page = new UserStory12(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void accessBoostersShop() {
        page.openBoostersPage();

        assertTrue(page.getUrl().contains("shop/boosters"));
        assertTrue(page.getPageSource().toLowerCase().contains("booster")
                || page.getPageSource().toLowerCase().contains("shop"));
    }
}