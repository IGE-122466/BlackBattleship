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
 * Page Test Class para o cenário {@code UserStoryTest4} do ficheiro
 * {@code TestSuite_122994.side}, referente à aplicação
 * {@code https://papergames.io}.
 *
 * <p>Esta classe contém o código JUnit 5 que orquestra os passos do cenário e
 * realiza as asserções. Toda a localização de elementos está encapsulada na
 * {@link UserStory4 Page Object Class}; aqui apenas se acede aos
 * {@link org.openqa.selenium.WebElement}s expostos por essa classe e se
 * verifica o comportamento esperado da aplicação.</p>
 *
 * <p>O cenário {@code UserStoryTest4} reproduz os seguintes passos do Selenium
 * IDE:</p>
 * <ol>
 *   <li>{@code open /en/battleship} – navegação inicial.</li>
 *   <li>{@code setWindowSize 1057x900} – definição das dimensões da janela.</li>
 *   <li>{@code click css=.btn-outline-dark} – clique no botão "Login".</li>
 *   <li>{@code type id=mat-input-serverApp0} – preenchimento do email.</li>
 *   <li>{@code type id=mat-input-serverApp1} – preenchimento da password.</li>
 *   <li>{@code click css=.w-100:nth-child(1) > .btn-secondary > .front}
 *       – clique no botão "Login" dentro do diálogo.</li>
 *   <li>{@code click linkText=Friends} – clique na hiperligação "Friends"
 *       da barra de navegação lateral.</li>
 * </ol>
 *
 * <p>As asserções verificam que a navegação ocorre como esperado após o login
 * e após o clique na hiperligação "Friends".</p>
 *
 * @author IGE_122994
 */
public class UserStory4Test {

    /**
     * Instância do WebDriver que controla o browser durante cada teste.
     * Criada em {@link #setUp()} e destruída em {@link #tearDown()}.
     */
    private WebDriver driver;

    /**
     * Page Object que expõe os {@link org.openqa.selenium.WebElement}s da
     * página de Battleship necessários ao cenário.
     */
    private UserStory4 userStory4Page;

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
     *   <li>Instancia a {@link UserStory4 Page Object}.</li>
     * </ol>
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Passo 2 – setWindowSize 1057x900
        driver.manage().window().setSize(new Dimension(1057, 900));

        // Passo 1 – open /en/battleship
        driver.get("https://papergames.io/en/battleship");

        userStory4Page = new UserStory4(driver);
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
    // Método auxiliar de login (evita repetição nos três testes)
    // -------------------------------------------------------------------------

    /**
     * Executa o fluxo de login completo (passos 3 a 7 do Selenium IDE) e
     * aguarda que a página esteja pronta após a autenticação.
     *
     * <p>Este método é partilhado pelos três testes, que são todos
     * independentes entre si mas requerem login como pré-condição.</p>
     *
     * @throws InterruptedException se a thread for interrompida durante o
     *                              {@code sleep}
     */
    private void doLogin() throws InterruptedException {
        sleep(5000);

        // Passo 3 – click Login
        userStory4Page.loginButton.click();
        sleep(1000);

        // Passo 4 – email
        userStory4Page.emailInput.sendKeys("goufrappocrugra-7205@y.w80.it");
        sleep(1000);

        // Passo 6 – password
        userStory4Page.passwordInput.sendKeys("12345678");
        sleep(1000);

        // Passo 7 – click Login no diálogo
        userStory4Page.loginDialogButton.click();
        sleep(5000);
    }

    // -------------------------------------------------------------------------
    // Métodos de teste
    // -------------------------------------------------------------------------

    /**
     * Verifica que o processo de login funciona corretamente e que,
     * após o clique na hiperligação "Friends", a aplicação navega para
     * {@code /en/friends}.
     *
     * <p>Reproduz os passos 3 a 8 do Selenium IDE.</p>
     *
     * <p><strong>Asserção:</strong> o URL deve conter {@code /en/friends}
     * após o clique na hiperligação "Friends".</p>
     */
    @Test
    public void loginAndNavigatesToTheRightPage() throws InterruptedException {
        doLogin();

        // Passo 8 – click linkText=Friends
        userStory4Page.friendsNavLink.click();
        sleep(1000);

        assertTrue(driver.getCurrentUrl().contains("/friends"),
                "O URL deveria conter '/friends' após clicar em 'Friends'.");
    }

    /**
     * Verifica que o processo de login funciona corretamente e que a hiperligação
     * "Friends" está visível na página de Battleship antes de qualquer interação.
     *
     * <p><strong>Asserção:</strong> o elemento {@code friendsNavLink} deve estar
     * apresentado no ecrã.</p>
     */
    @Test
    public void loginAndLinkIsVisible() throws InterruptedException {
        doLogin();

        // Passo 8 – click linkText=Friends
        userStory4Page.friendsNavLink.click();
        sleep(1000);

        assertTrue(userStory4Page.friendsNavLink.isDisplayed(),
                "A hiperligação 'Friends' deveria estar visível na página.");
    }

    /**
     * Verifica que o processo de login funciona corretamente e que a hiperligação
     * "Friends" apresenta o texto correto.
     *
     * <p><strong>Asserção:</strong> o texto do elemento deve ser
     * {@code "Friends"}.</p>
     */
    @Test
    public void loginAndLinkHasCorrectText() throws InterruptedException {
        doLogin();

        // Passo 8 – click linkText=Friends
        userStory4Page.friendsNavLink.click();
        sleep(1000);

        assertEquals("Friends", userStory4Page.friendsNavLink.getText(),
                "O texto da hiperligação deveria ser 'Friends'.");
    }
}
