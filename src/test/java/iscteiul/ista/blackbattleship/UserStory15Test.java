package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.JavascriptExecutor;
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
        // Passo 1: Clicar em "Play with a friend"
        js.executeScript("arguments[0].click();", us15.playWithFriendButton);
        Thread.sleep(3000); // Aumentei o tempo para deixar a animação do pop-up terminar


        js.executeScript("arguments[0].value='RobotZe';", us15.nicknameInput);

        // Em sites modernos, é preciso avisar o sistema que o texto mudou
        js.executeScript("arguments[0].dispatchEvent(new Event('input'));", us15.nicknameInput);
        Thread.sleep(1000);

        // Passo 3: Clicar no botão de confirmar (o tal que apanhaste no IDE)
        js.executeScript("arguments[0].click();", us15.confirmButton);
        Thread.sleep(3000); // Dá tempo para fazer o login de convidado

        // Passo 4: Agora sim, abrir o menu Messaging
        js.executeScript("arguments[0].click();", us15.chatMenuButton);
        Thread.sleep(3000);

        // Validação: Verificar se entrou no chat
        assertTrue(driver.getCurrentUrl().contains("chat"), "A navegação para a página do Chat falhou!");
    }
}