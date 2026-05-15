package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

/**
 * Classe de testes para a User Story 15.
 * Valida o acesso ao chat desbloqueando a funcionalidade através
 * da criação de um utilizador "Guest" para contornar a autenticação.
 */
public class UserStory15Test {
    private WebDriver driver;
    private UserStory15 us15;
    private JavascriptExecutor js;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;

        driver.get("https://papergames.io/en/battleship");
        us15 = new UserStory15(driver);
        Thread.sleep(3000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Testa o registo de utilizador convidado via injenção de JavaScript
     * para evitar ElementNotInteractableException durante as animações de CSS.
     */
    @Test
    public void testarAcessoPaginaChatComoConvidado() throws InterruptedException {
        js.executeScript("arguments[0].click();", us15.playWithFriendButton);
        Thread.sleep(3000);

        js.executeScript("arguments[0].value='RobotZe';", us15.nicknameInput);
        js.executeScript("arguments[0].dispatchEvent(new Event('input'));", us15.nicknameInput);
        Thread.sleep(1000);

        js.executeScript("arguments[0].click();", us15.confirmButton);
        Thread.sleep(3000);

        js.executeScript("arguments[0].click();", us15.chatMenuButton);
        Thread.sleep(3000);

        assertTrue(driver.getCurrentUrl().contains("chat"), "A navegação para a página do Chat falhou!");
    }
}