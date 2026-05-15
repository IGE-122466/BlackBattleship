package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para o cenário {@code UserStoryTest14} do ficheiro
 * {@code TestSuite_122994.side}, referente à aplicação
 * {@code https://papergames.io}.
 *
 * <p>Esta classe contém o código JUnit 5 que orquestra os passos do cenário e
 * realiza as asserções. Toda a localização de elementos está encapsulada na
 * {@link UserStory14 Page Object Class}; aqui apenas se acede aos
 * {@link org.openqa.selenium.WebElement}s expostos por essa classe e se
 * verifica o comportamento esperado da aplicação.</p>
 *
 * <p>O cenário {@code UserStoryTest14} reproduz os seguintes passos do Selenium
 * IDE:</p>
 * <ol>
 *   <li>{@code open /en/battleship} – navegação inicial.</li>
 *   <li>{@code setWindowSize 1057x900} – definição das dimensões da janela.</li>
 *   <li>{@code runScript window.scrollTo(0,0)} – scroll para o topo da página.</li>
 *   <li>{@code click linkText=Privacy} – clique na hiperligação "Privacy".</li>
 * </ol>
 *
 * @author IGE_122994
 */
public class UserStory14Test {

    /**
     * Instância do WebDriver que controla o browser durante cada teste.
     * Criada em {@link #setUp()} e destruída em {@link #tearDown()}.
     */
    private WebDriver driver;

    /**
     * Page Object que expõe os {@link org.openqa.selenium.WebElement}s da
     * página de Battleship necessários ao cenário.
     */
    private UserStory14 userStory14Page;

    // -------------------------------------------------------------------------
    // Ciclo de vida do teste
    // -------------------------------------------------------------------------

    /**
     * Configuração executada antes de cada método {@link Test}.
     *
     * <p>Passos realizados:</p>
     * <ol>
     *   <li>Instancia o {@link ChromeDriver}.</li>
     *   <li>Define um tempo de espera implícita de 10 segundos.</li>
     *   <li>Define as dimensões da janela para 1057 × 900 píxeis
     *       (comando {@code setWindowSize 1057x900} do Selenium IDE).</li>
     *   <li>Navega para {@code https://papergames.io/en/battleship}
     *       (comando {@code open /en/battleship} do Selenium IDE).</li>
     *   <li>Executa scroll para o topo via JavaScript
     *       (comando {@code runScript window.scrollTo(0,0)} do Selenium IDE).</li>
     *   <li>Instancia a {@link UserStory14 Page Object}.</li>
     * </ol>
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Passo 2 do Selenium IDE – setWindowSize 1057x900
        driver.manage().window().setSize(new Dimension(1057, 900));

        // Passo 1 do Selenium IDE – open /en/battleship
        driver.get("https://papergames.io/en/battleship");

        // Passo 3 do Selenium IDE – runScript window.scrollTo(0,0)
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");

        userStory14Page = new UserStory14(driver);
    }

    /**
     * Limpeza executada após cada método {@link Test}, independentemente
     * do resultado.
     *
     * <p>Fecha o browser e liberta todos os recursos do {@link WebDriver}.</p>
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    // -------------------------------------------------------------------------
    // Métodos de teste
    // -------------------------------------------------------------------------

    /**
     * Verifica que, após clicar na hiperligação "Privacy", o URL da página
     * resultante contém o caminho {@code /en/blog/privacy-policy}.
     *
     * <p>Reproduz o passo 4 do Selenium IDE:
     * {@code click linkText=Privacy}.</p>
     *
     * <p><strong>Asserção:</strong> o URL da nova aba deve conter
     * {@code /en/blog/privacy-policy}.</p>
     */
    @Test
    public void navigatesToTheRightPage() throws InterruptedException {
        sleep(5000);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                userStory14Page.privacyLink
        );

        sleep(2000);

        // Passo 4 do Selenium IDE – click linkText=Privacy
        userStory14Page.privacyLink.click();
        sleep(1000);

        assertTrue(driver.getCurrentUrl().contains("/en/blog/privacy-policy"),
                "O URL deveria conter '/en/blog/privacy-policy' após clicar em 'Privacy'.");
    }

    /**
     * Verifica que a hiperligação "Privacy" está visível na página de
     * Battleship antes de qualquer interação.
     *
     * <p><strong>Asserção:</strong> o elemento {@code privacyLink} deve estar
     * apresentado no ecrã.</p>
     */
    @Test
    public void linkIsVisible() throws InterruptedException {
        sleep(5000);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                userStory14Page.privacyLink
        );

        sleep(2000);

        assertTrue(userStory14Page.privacyLink.isDisplayed(),
                "A hiperligação 'Privacy' deveria estar visível na página.");
    }

    /**
     * Verifica que a hiperligação "Privacy" apresenta o texto correto.
     *
     * <p><strong>Asserção:</strong> o texto do elemento deve ser
     * {@code "Privacy"}.</p>
     */
    @Test
    public void linkHasTheCorrectText() throws InterruptedException {
        sleep(5000);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                userStory14Page.privacyLink
        );

        sleep(2000);

        assertEquals("Privacy", userStory14Page.privacyLink.getText(),
                "O texto da hiperligação deveria ser 'Privacy'.");
    }
}