package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

/**
 * Classe de testes para a User Story 2.
 * Valida a geração do link de convite para jogar Batalha Naval com um amigo.
 */
public class UserStory2Test {
    private WebDriver driver;
    private UserStory2 us2;
    private JavascriptExecutor js;

    /**
     * Configuração inicial antes de cada teste.
     * Inicializa o WebDriver, maximiza a janela e navega para a página do jogo.
     */
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

    /**
     * Limpeza após cada teste, encerrando a sessão do browser.
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Testa o cenário de geração de link de convite.
     * Utiliza JavascriptExecutor para garantir o clique em elementos dinâmicos.
     */
    @Test
    public void testarGerarLinkParaAmigo() throws InterruptedException {
        js.executeScript("arguments[0].click();", us2.playWithFriendButton);
        Thread.sleep(3000);

        assertTrue(us2.copyLinkButton.isDisplayed(), "O modal com o link de convite não apareceu!");
    }
}