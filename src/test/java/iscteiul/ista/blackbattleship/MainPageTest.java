package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPageTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void openHomePage() {
        driver.get("https://www.jetbrains.com/");
        assertFalse(driver.getCurrentUrl().isEmpty());
    }

    @Test
    public void navigateToToolsPage() {
        driver.get("https://www.jetbrains.com/tools/");
        assertTrue(driver.getCurrentUrl().contains("tools"));
    }

    @Test
    public void navigateToProductsPage() {
        driver.get("https://www.jetbrains.com/products/");
        assertTrue(driver.getCurrentUrl().contains("products"));
    }
}