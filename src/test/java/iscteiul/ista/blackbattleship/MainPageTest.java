package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private JavascriptExecutor js;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Inicializamos o executor de Javascript
        js = (JavascriptExecutor) driver;

        driver.get("https://www.jetbrains.com/");

        mainPage = new MainPage(driver);

        Thread.sleep(2000);
        try {
            mainPage.acceptCookiesButton.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            // Se não houver cookies, avança
        }
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void navigateToStore() throws InterruptedException {
        // Usamos Javascript para forçar o clique, ignorando se o botão está fora do ecrã
        js.executeScript("arguments[0].click();", mainPage.storeLink);
        Thread.sleep(2000);

        assertTrue(driver.getCurrentUrl().contains("store"));
    }

    @Test
    public void navigateToCompany() throws InterruptedException {
        // Usamos Javascript para forçar o clique
        js.executeScript("arguments[0].click();", mainPage.companyLink);
        Thread.sleep(2000);

        assertTrue(driver.getCurrentUrl().contains("company"));
    }
}