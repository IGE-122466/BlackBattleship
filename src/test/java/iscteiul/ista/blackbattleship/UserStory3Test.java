package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserStory3Test {

    private WebDriver driver;
    private UserStory3 page;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        page = new UserStory3(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void viewMatchHistory() {
        page.open();

        assertTrue(page.getUrl().contains("battleship"));
    }
}
