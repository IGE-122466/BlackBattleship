package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

/**
 * Classe de testes para a User Story 11.
 * Valida o acesso à secção de Moedas Virtuais da loja.
 */
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

        driver.get("https://papergames.io/en/");
        us11 = new UserStory11(driver);
        Thread.sleep(3000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Testa a navegação contornando possíveis iframes de anúncios
     * através de cliques injetados via JavaScript.
     */
    @Test
    public void testarAcessoLojaMoedasVirtuais() throws InterruptedException {
        js.executeScript("arguments[0].click();", us11.shopButton);
        Thread.sleep(2000);

        js.executeScript("arguments[0].click();", us11.virtualCoinsTab);
        Thread.sleep(3000);

        assertTrue(driver.getCurrentUrl().contains("virtual-coins"), "Não navegou para a página de Moedas Virtuais!");
    }
}