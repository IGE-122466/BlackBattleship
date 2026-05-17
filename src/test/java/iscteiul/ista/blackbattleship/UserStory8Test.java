package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserStory8Test {

    private WebDriver driver;
    private UserStory8 page;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        page = new UserStory8(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void accessPlusPlan() {
        page.openPlusPlan();

        assertTrue(page.getUrl().contains("pricing/plus"));
    }

    @Test
    public void accessGruppoPlan() {
        page.openGruppoPlan();

        assertTrue(page.getUrl().contains("pricing/gruppo"));
    }
}