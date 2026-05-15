package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para o cenário {@code UserStoryTest16} do ficheiro
 * {@code TestSuite_122994.side}, referente à aplicação
 * {@code https://papergames.io}.
 *
 * <p>Esta classe contém o código JUnit 5 que orquestra os passos do cenário e
 * realiza as asserções. Toda a localização de elementos está encapsulada na
 * {@link UserStory16 Page Object Class}; aqui apenas se acede aos
 * {@link org.openqa.selenium.WebElement}s expostos por essa classe e se
 * verifica o comportamento esperado da aplicação.</p>
 *
 * <p>O cenário {@code UserStoryTest16} reproduz os seguintes passos do Selenium
 * IDE:</p>
 * <ol>
 *   <li>{@code open /en/battleship} – navegação inicial.</li>
 *   <li>{@code setWindowSize 1057x900} – definição das dimensões da janela.</li>
 *   <li>{@code click linkText=Goodies} – clique na barra lateral, abre nova janela.</li>
 *   <li>{@code storeWindowHandle root} – guarda o handle da janela principal.</li>
 *   <li>{@code selectWindow handle=${win2222}} – muda para a janela de merchandising.</li>
 *   <li>{@code selectWindow handle=${root}} – regressa à janela principal.</li>
 *   <li>{@code click linkText=Shop} – clique na hiperligação "Shop".</li>
 *   <li>{@code click css=.mb-2 > .w-100} – clique em "Goodies" no Shop, abre nova janela.</li>
 *   <li>{@code selectWindow handle=${win7933}} – muda para a nova janela de merchandising.</li>
 * </ol>
 *
 * @author IGE_122994
 */
public class UserStory16Test {

    /**
     * Instância do WebDriver que controla o browser durante cada teste.
     * Criada em {@link #setUp()} e destruída em {@link #tearDown()}.
     */
    private WebDriver driver;

    /**
     * Page Object que expõe os {@link org.openqa.selenium.WebElement}s da
     * página de Battleship necessários ao cenário.
     */
    private UserStory16 userStory16Page;

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
     *   <li>Instancia a {@link UserStory16 Page Object}.</li>
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

        userStory16Page = new UserStory16(driver);
    }

    /**
     * Limpeza executada após cada método {@link Test}, independentemente
     * do resultado.
     *
     * <p>Fecha todas as janelas abertas e liberta todos os recursos do
     * {@link WebDriver}.</p>
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    // -------------------------------------------------------------------------
    // Métodos de teste
    // -------------------------------------------------------------------------

    /**
     * Verifica que clicar em "Goodies" na barra de navegação lateral abre
     * uma nova janela, e que essa janela contém o URL do site de merchandising
     * ({@code merch.papergames.io}).
     *
     * <p>Reproduz os passos 3 a 5 do Selenium IDE.</p>
     *
     * <p><strong>Asserção:</strong> o URL da nova janela deve conter
     * {@code merch.papergames.io}.</p>
     */
    @Test
    public void clickingGoodiesOpensNewPage() throws InterruptedException {
        sleep(5000);

        String janelaPrincipal = driver.getWindowHandle();

        // Passo 3 do Selenium IDE – click linkText=Goodies
        userStory16Page.goodiesNavLink.click();
        sleep(3000);

        // Passos 4 e 5 – storeWindowHandle + selectWindow para a nova janela
        for (String janela : driver.getWindowHandles()) {
            if (!janela.equals(janelaPrincipal)) {
                driver.switchTo().window(janela);
                break;
            }
        }

        sleep(1000);

        assertTrue(driver.getCurrentUrl().contains("merch.papergames.io"),
                "O URL da nova janela deveria conter 'merch.papergames.io'.");
    }

    /**
     * Verifica que clicar na hiperligação "Shop" da barra de navegação lateral
     * navega para a página de Shop, cujo URL contém {@code /en/shop}.
     *
     * <p>Reproduz o passo 7 do Selenium IDE:
     * {@code click linkText=Shop}</p>
     *
     * <p><strong>Asserção:</strong> o URL da janela principal após clicar em
     * "Shop" deve conter {@code /en/shop}.</p>
     */
    @Test
    public void navigatesToTheRightPage() throws InterruptedException {
        sleep(5000);

        // Passo 7 do Selenium IDE – click linkText=Shop
        userStory16Page.shopNavLink.click();
        sleep(3000);

        assertTrue(driver.getCurrentUrl().contains("/en/shop"),
                "O URL deveria conter '/en/shop' após clicar em 'Shop'.");
    }

    /**
     * Verifica que, dentro da página de Shop, clicar no botão "Goodies" abre
     * uma nova janela de merchandising cujo URL contém
     * {@code merch.papergames.io}.
     *
     * <p>Reproduz os passos 7 a 9 do Selenium IDE.</p>
     *
     * <p><strong>Asserção:</strong> o URL da nova janela de merchandising
     * deve conter {@code merch.papergames.io}.</p>
     */
    @Test
    public void clickingGoodiesInShopOpensNewPage() throws InterruptedException {
        sleep(5000);

        String janelaPrincipal = driver.getWindowHandle();

        // Passo 7 – click linkText=Shop
        userStory16Page.shopNavLink.click();
        sleep(3000);

        // Passo 8 – click css=.mb-2 > .w-100 (botão Goodies no Shop)
        userStory16Page.goodiesShopButton.click();
        sleep(2000);

        // Passo 9 – selectWindow handle=${win7933}: mudar para a nova janela
        for (String janela : driver.getWindowHandles()) {
            if (!janela.equals(janelaPrincipal)) {
                driver.switchTo().window(janela);
                break;
            }
        }

        sleep(1000);

        assertTrue(driver.getCurrentUrl().contains("merch.papergames.io"),
                "O URL da nova janela deveria conter 'merch.papergames.io'.");
    }
}