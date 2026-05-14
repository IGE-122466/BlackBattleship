package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

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

    @Test
    public void testarAcessoPaginaChatComoConvidado() throws InterruptedException {
        // Passo 1: Clicar em "Play with a friend" para invocar o popup de Nickname
        js.executeScript("arguments[0].click();", us15.playWithFriendButton);
        Thread.sleep(2000);

        // Passo 2: Escrever o Nickname do nosso Robô
        us15.nicknameInput.clear(); // Limpa o campo por precaução
        us15.nicknameInput.sendKeys("RobotZe");
        Thread.sleep(1000);

        // Em vez de procurar o botão de submeter, simulamos a tecla ENTER
        us15.nicknameInput.sendKeys(Keys.ENTER);
        Thread.sleep(3000); // Dá tempo ao site de fazer o "login" de convidado

        // Passo 3: Agora que o menu foi destrancado, clicamos no "Messaging"
        js.executeScript("arguments[0].click();", us15.chatMenuButton);
        Thread.sleep(3000);

        // Validação: Verificar se o URL mudou efetivamente para o chat
        assertTrue(driver.getCurrentUrl().contains("chat"), "A navegação para a página do Chat falhou!");
    }
}