package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a User Story 10.
 * <p>
 * Como utilizador, quero aceder à página de Changelog,
 * para que possa ver as últimas atualizações e correções de bugs feitas no jogo.
 * </p>
 */
public class UserStory10Test {

    private WebDriver driver;
    private UserStory10 page;

    /**
     * Configuração executada antes de cada teste.
     * Abre o Chrome, define a dimensão da janela (1516x891) e navega
     * para a página principal do Battleship.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1516, 891));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://papergames.io/en/battleship");
        page = new UserStory10(driver);
    }

    /**
     * Encerra o browser após cada teste.
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Verifica que ao clicar em "Changelog" o URL passa a conter "/changelog",
     * confirmando que a navegação para a página foi bem-sucedida.
     */
    @Test
    public void testAcederChangelog() throws InterruptedException {

        page.clickChangelog();
        sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/changelog"));

        assertTrue(page.getCurrentUrl().contains("/changelog"),
                "O URL devia conter '/changelog' após clicar no link");
    }
}
