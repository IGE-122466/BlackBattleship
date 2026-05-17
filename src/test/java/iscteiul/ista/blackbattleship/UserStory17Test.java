package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserStory17Test {

    private WebDriver driver;
    private UserStory17 page;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        page = new UserStory17(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void viewMyTournamentsHistory() {
        page.openMyTournaments();

        assertTrue(page.getUrl().contains("my-tournaments"));
        assertTrue(page.getPageSource().toLowerCase().contains("tournament")
                || page.getPageSource().toLowerCase().contains("history"));
    }
}
