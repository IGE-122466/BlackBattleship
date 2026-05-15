package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class UserStory11Test {
    private WebDriver driver;
    private UserStory11 us11;
    private JavascriptExecutor js;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;

        // Abre o site na página inicial
        driver.get("https://papergames.io/en/");
        us11 = new UserStory11(driver);
        Thread.sleep(3000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testarAcessoLojaMoedasVirtuais() throws InterruptedException {
        // Passo 1: Abrir o menu da Loja
        js.executeScript("arguments[0].click();", us11.shopButton);
        Thread.sleep(2000);

        // Passo 2: Clicar na aba das Moedas Virtuais
        js.executeScript("arguments[0].click();", us11.virtualCoinsTab);
        Thread.sleep(3000); // Dá tempo à nova página de carregar

        // Validação: Verificar se o URL mudou para as virtual-coins
        assertTrue(driver.getCurrentUrl().contains("virtual-coins"), "Não navegou para a página de Moedas Virtuais!");
    }
}