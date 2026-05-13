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
 * Page Test Class para a User Story 5.
 * <p>
 * Como jogador, quero utilizar o chat integrado durante as partidas,
 * para que possa comunicar e interagir com o meu adversário.
 * </p>
 */
public class UserStoryTest5 {

    private WebDriver driver;
    private UserStory5 page;

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
        page = new UserStory5(driver);
    }

    /**
     * Encerra o browser após cada teste.
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Verifica que o jogador consegue escrever e enviar uma mensagem no chat.
     * Após o envio, o campo de texto deve ficar vazio, confirmando a submissão.
     */
    @Test
    public void testEnviarMensagemChat() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Aceitar popup de consentimento de dados
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("p.fc-button-label")));
        page.acceptConsent();

        // Clicar em Play vs bot
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".w-100:nth-child(2) > .btn .flex-grow-1")));
        page.clickPlayVsBot();

        // Inserir nickname e confirmar
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[placeholder='Nickname']")));
        page.enterNickname("IGE-110323");
        page.clickContinue();

        // Aguardar o campo de chat ficar disponível
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".textarea-wrapper")));

        // Escrever mensagem e verificar conteúdo
        page.typeMessage("Mensagem teste");
        assertEquals("Mensagem teste", page.getMessageInputValue(),
                "O campo devia conter o texto escrito antes do envio");

        // Enviar e verificar que o campo ficou vazio
        page.clickSend();
        wait.until(ExpectedConditions.attributeToBe(
                By.id("mat-input-serverApp0"), "value", ""));
        assertEquals("", page.getMessageInputValue(),
                "O campo devia estar vazio após enviar a mensagem");
    }
}