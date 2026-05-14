package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserStory2Test {
    private WebDriver driver;
    private UserStory2 us2;
    private JavascriptExecutor js;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;


        driver.get("https://papergames.io/en/battleship");
        us2 = new UserStory2(driver);
        Thread.sleep(3000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testarGerarLinkParaAmigo() throws InterruptedException {
        // Passo 1: Clicar no botão "Play with a friend"
        js.executeScript("arguments[0].click();", us2.playWithFriendButton);
        Thread.sleep(3000); // Dá tempo ao site para gerar o link e abrir o modal

        // Validação: Verifica se o botão "Copy" apareceu no ecrã.
        assertTrue(us2.copyLinkButton.isDisplayed(), "O modal com o link de convite não apareceu!");
    }
}