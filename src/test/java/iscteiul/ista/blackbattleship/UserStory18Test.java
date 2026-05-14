package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class UserStory18Test {
    private WebDriver driver;
    private UserStory18 us18;
    private JavascriptExecutor js;

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;

        // O robot abre a página inicial do jogo
        driver.get("https://papergames.io/en/");
        us18 = new UserStory18(driver);
        Thread.sleep(3000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testarAcessoPaginaDevelopers() throws InterruptedException {
        // Passo 1: Clicar no link "Developers"
        // Como o link está no fundo da página, o JavascriptExecutor é perfeito porque clica mesmo que esteja invisível
        js.executeScript("arguments[0].click();", us18.developersLink);
        Thread.sleep(2000);

        // Pedimos ao Java para olhar para todos os separadores abertos e mudar para o mais recente
        for (String janela : driver.getWindowHandles()) {
            driver.switchTo().window(janela);
        }
        Thread.sleep(3000); // Dá tempo ao novo separador de carregar

        // Validação 1: O URL no novo separador está correto?
        assertTrue(driver.getCurrentUrl().contains("developers.papergames.io"), "Não navegou para o separador de developers!");

        // Validação 2: A página abriu e tem o título?
        assertTrue(us18.tituloPrincipal.isDisplayed(), "O título da página de developers não está visível!");
    }
}