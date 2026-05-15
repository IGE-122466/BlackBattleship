package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class UserStory7Test {
    private WebDriver driver;
    private UserStory7 us7;
    private JavascriptExecutor js;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;

        driver.get("https://papergames.io/en/");
        us7 = new UserStory7(driver);
        Thread.sleep(3000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testarAcessoALojaDeEmojisEAvatares() throws InterruptedException {
        // Passo 1: Abre a aba da Loja no menu lateral
        js.executeScript("arguments[0].click();", us7.shopButton);
        Thread.sleep(2000);

        // Passo 2: Clica nos Emojis
        js.executeScript("arguments[0].click();", us7.emojisTab);
        Thread.sleep(3000); // Dá tempo à nova página de carregar

        // Verifica se chegámos aos emojis
        assertTrue(driver.getCurrentUrl().contains("emojis"), "Não navegou para a loja de Emojis!");

        // Passo 3: A página recarregou, por isso temos de abrir o menu Shop outra vez!
        js.executeScript("arguments[0].click();", us7.shopButton);
        Thread.sleep(2000);

        // Passo 4: Agora sim, os Avatares estão visíveis e podemos clicar
        js.executeScript("arguments[0].click();", us7.avatarsTab);
        Thread.sleep(3000);

        // Verifica se chegámos aos avatares
        assertTrue(driver.getCurrentUrl().contains("avatars"), "Não navegou para a loja de Avatares!");
    }
}