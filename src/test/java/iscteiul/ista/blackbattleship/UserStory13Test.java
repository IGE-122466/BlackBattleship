package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserStory13Test {

    private WebDriver driver;
    private UserStory13 page;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        page = new UserStory13(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void viewProfileStats() {
        page.openProfileStats();

        assertTrue(page.getUrl().contains("profile"));
        assertTrue(page.getPageSource().toLowerCase().contains("win")
                || page.getPageSource().toLowerCase().contains("loss")
                || page.getPageSource().toLowerCase().contains("draw"));
    }
}