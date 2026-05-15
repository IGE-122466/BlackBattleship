package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a User Story 1.
 * <p>
 * Como jogador, quero iniciar uma partida de Batalha Naval contra um bot,
 * para que possa jogar de forma rápida e testar a minha estratégia.
 * </p>
 */
public class UserStory1Test {

    private WebDriver driver;
    private UserStory1 page;

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
        page = new UserStory1(driver);
    }

    /**
     * Encerra o browser após cada teste.
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Verifica que ao aceitar o consentimento, clicar em "Play vs bot",
     * inserir um nickname e confirmar, o URL muda para a página do jogo.
     */
    @Test
    public void testIniciarPartidaVsBot() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Aceitar popup de consentimento de dados
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("p.fc-button-label")));
        page.acceptConsent();

        // Clicar em Play vs bot
        sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".w-100:nth-child(2) > .btn .flex-grow-1")));
        String urlInicial = page.getCurrentUrl();
        page.clickPlayVsBot();

        // Inserir nickname e confirmar
        sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[placeholder='Nickname']")));
        page.enterNickname("IGE-110323");
        sleep(2000);
        page.clickContinue();
        sleep(2000);
        // Verificar que o URL mudou (jogo iniciado)
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(urlInicial)));
        sleep(2000);
        assertNotEquals(urlInicial, page.getCurrentUrl(),
                "O URL devia mudar após iniciar a partida");
    }
}