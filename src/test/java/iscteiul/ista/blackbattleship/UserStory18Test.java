package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

/**
 * Classe de testes para a User Story 18.
 * Valida a navegação e o correto carregamento da página dos desenvolvedores,
 * lidando com a abertura de um novo separador (window handles).
 */
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

        driver.get("https://papergames.io/en/");
        us18 = new UserStory18(driver);
        Thread.sleep(3000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Testa o clique no link de Developers e a respetiva mudança de contexto
     * para a nova janela/separador gerada pelo browser.
     */
    @Test
    public void testarAcessoPaginaDevelopers() throws InterruptedException {
        js.executeScript("arguments[0].click();", us18.developersLink);
        Thread.sleep(2000);

        // Muda o foco do WebDriver para o novo separador aberto
        for (String janela : driver.getWindowHandles()) {
            driver.switchTo().window(janela);
        }
        Thread.sleep(3000);

        assertTrue(driver.getCurrentUrl().contains("developers.papergames.io"), "Não navegou para o separador de developers!");
        assertTrue(us18.tituloPrincipal.isDisplayed(), "O título da página de developers não está visível!");
    }
}