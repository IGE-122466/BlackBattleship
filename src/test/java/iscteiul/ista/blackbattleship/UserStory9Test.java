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
 * Page Test Class para o cenário {@code UserStoryTest9} do ficheiro
 * {@code TestSuite_122994.side}, referente à aplicação
 * {@code https://papergames.io}.
 *
 * <p>Esta classe contém o código JUnit 5 que orquestra os passos do cenário e
 * realiza as asserções. Toda a localização de elementos está encapsulada na
 * {@link UserStory9 Page Object Class}; aqui apenas se acede aos
 * {@link org.openqa.selenium.WebElement}s expostos por essa classe e se
 * verifica o comportamento esperado da aplicação.</p>
 *
 * <p>O cenário {@code UserStoryTest9} reproduz os seguintes passos do Selenium
 * IDE:</p>
 * <ol>
 *   <li>{@code open /en/battleship} – navegação inicial.</li>
 *   <li>{@code setWindowSize 1057x900} – definição das dimensões da janela.</li>
 *   <li>{@code click css=.btn-outline-dark} – clique no botão "Login".</li>
 *   <li>{@code type id=mat-input-serverApp0} – preenchimento do email.</li>
 *   <li>{@code type id=mat-input-serverApp1} – preenchimento da password.</li>
 *   <li>{@code click css=.w-100:nth-child(1) > .btn-secondary > .front}
 *       – clique no botão "Login" dentro do diálogo.</li>
 *   <li>{@code click css=.w-100:nth-child(2) > .btn > .front}
 *       – clique em "Play vs robot".</li>
 *   <li>{@code click css=.btn} – clique em "Abort game".</li>
 *   <li>{@code click css=.btn-danger} – clique em "Abort game" no diálogo.</li>
 * </ol>
 *
 * <p>As asserções verificam que o jogo inicia corretamente e que o processo de
 * abortar o jogo funciona como esperado.</p>
 *
 * @author IGE_122994
 */
public class UserStory9Test {

    /**
     * Instância do WebDriver que controla o browser durante cada teste.
     * Criada em {@link #setUp()} e destruída em {@link #tearDown()}.
     */
    private WebDriver driver;

    /**
     * Page Object que expõe os {@link org.openqa.selenium.WebElement}s da
     * página de Battleship necessários ao cenário.
     */
    private UserStory9 userStory9Page;

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
     *       (comando {@code setWindowSize 1057x900}).</li>
     *   <li>Navega para {@code https://papergames.io/en/battleship}
     *       (comando {@code open /en/battleship}).</li>
     *   <li>Instancia a {@link UserStory9 Page Object}.</li>
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

        userStory9Page = new UserStory9(driver);
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
     * Verifica que o processo de login funciona corretamente e que o utilizador
     * consegue iniciar um jogo contra um robot e abortá-lo com sucesso.
     *
     * <p>Reproduz os passos 3 a 10 do Selenium IDE.</p>
     *
     * <p><strong>Asserção:</strong> após abortar o jogo, o URL deve voltar a
     * conter {@code /en/battleship}.</p>
     */
    @Test
    public void loginAndAbortGameVsRobotGoesBackToTheRightPage() throws InterruptedException {
        sleep(5000);

        // Passo 3 – click Login
        userStory9Page.loginButton.click();
        sleep(1000);

        // Passo 4 – email
        userStory9Page.emailInput.sendKeys("goufrappocrugra-7205@y.w80.it");
        sleep(1000);

        // Passo 6 – password
        userStory9Page.passwordInput.sendKeys("12345678");
        sleep(1000);

        // Passo 7 – click Login no diálogo
        userStory9Page.loginDialogButton.click();
        sleep(5000);

        // Passo 8 – click Play vs robot
        userStory9Page.playVsRobotButton.click();
        sleep(5000);

        // Passo 9 – click Abort game
        userStory9Page.abortGameButton.click();
        sleep(1000);

        // Passo 10 – click Abort game no diálogo
        userStory9Page.abortGameConfirmButton.click();
        sleep(1000);

        assertTrue(driver.getCurrentUrl().contains("/en/battleship"),
                "Após abortar o jogo, o URL deveria regressar a '/en/battleship'.");
    }

    /**
     * Verifica que o processo de login funciona corretamente e que o botão "Play vs robot"
     * está visível na página de Battleship antes de qualquer interação.
     *
     * <p><strong>Asserção:</strong> o elemento {@code playVsRobotButton} deve estar
     * apresentado no ecrã.</p>
     */
    @Test
    public void loginAndPlayVsRobotIsVisible() throws InterruptedException {
        sleep(5000);

        // Passo 3 – click Login
        userStory9Page.loginButton.click();
        sleep(1000);

        // Passo 4 – email
        userStory9Page.emailInput.sendKeys("goufrappocrugra-7205@y.w80.it");
        sleep(1000);

        // Passo 6 – password
        userStory9Page.passwordInput.sendKeys("12345678");
        sleep(1000);

        // Passo 7 – click Login no diálogo
        userStory9Page.loginDialogButton.click();
        sleep(5000);

        assertTrue(userStory9Page.playVsRobotButton.isDisplayed(),
                "O botão 'Play vs robot' deveria estar visível na página.");
    }

    /**
     * Verifica que o processo de login funciona corretamente e que o
     * botão "Play vs robot" apresenta o texto correto.
     *
     * <p><strong>Asserção:</strong> o texto do elemento deve ser
     * {@code "Play vs robot"}.</p>
     */
    @Test
    public void loginAndPlayVsRobotHasCorrectText() throws InterruptedException {
        sleep(5000);

        // Passo 3 – click Login
        userStory9Page.loginButton.click();
        sleep(1000);

        // Passo 4 – email
        userStory9Page.emailInput.sendKeys("goufrappocrugra-7205@y.w80.it");
        sleep(1000);

        // Passo 6 – password
        userStory9Page.passwordInput.sendKeys("12345678");
        sleep(1000);

        // Passo 7 – click Login no diálogo
        userStory9Page.loginDialogButton.click();
        sleep(5000);

        assertEquals("Play vs robot", userStory9Page.playVsRobotButton.getText(),
                "O texto da hiperligação deveria ser 'Play vs robot'.");
    }
}
