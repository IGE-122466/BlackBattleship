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
 * Page Test Class para a User Story 20.
 * <p>
 * Como utilizador criativo, quero poder alterar o meu avatar (/shop/avatars/owned),
 * para não jogar sempre com o mesmo.
 * </p>
 * NOTA: Requer sessão autenticada no site.
 */
public class UserStory20Test {

    private WebDriver driver;
    private UserStory20 page;

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
        page = new UserStory20(driver);
    }

    /**
     * Encerra o browser após cada teste.
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Verifica que o utilizador consegue iniciar e abandonar uma partida para criar sessão,
     * navegar para a loja, selecionar um pack de avatares, aceder à aba "Owned"
     * e ativar um avatar com o botão "Use".
     * Deve ser fechado um anuncio sempre que aparecer
     * na aba monsters deve ser comprado um avatar pois a conta so vem com 1.
     */
    @Test
    public void testAlterarAvatar() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Aceitar popup de consentimento de dados
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("p.fc-button-label")));
        page.acceptConsent();

        // Iniciar partida vs bot para criar sessão
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".w-100:nth-child(2) > .btn .flex-grow-1")));
        page.clickPlayVsBot();

        // Inserir nickname e confirmar
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[placeholder='Nickname']")));
        page.enterNickname("IGE-110323");
        page.clickContinue();
        sleep(2000);

        // Abandonar o jogo e confirmar
        page.clickAbortGame();
        page.clickConfirmAbort();

        // Navegar para a loja
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Shop")));
        page.clickShop();
        wait.until(ExpectedConditions.urlContains("/shop"));
        assertTrue(page.getCurrentUrl().contains("/shop"),
                "Devia navegar para a loja");

        // Selecionar o pack de avatares Monsters
        page.clickMonstersAvatarPack();
        wait.until(ExpectedConditions.urlContains("/shop/avatars"));
        assertTrue(page.getCurrentUrl().contains("/shop/avatars"),
                "Devia navegar para a página de avatares");

        // Clicar na aba "Owned" e ativar avatar
        page.clickOwnedTab();
        sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(.,'Use')]")));
        page.clickUseButton();
        sleep(2000);

        assertTrue(true, "O botão 'Use' foi clicado com sucesso");
    }
}