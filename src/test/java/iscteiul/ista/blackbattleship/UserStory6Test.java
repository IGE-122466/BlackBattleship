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
 * Page Test Class para o cenário {@code UserStoryTest6} do ficheiro
 * {@code TestSuite_122994.side}, referente à aplicação
 * {@code https://papergames.io}.
 *
 * <p>Esta classe contém o código JUnit 5 que orquestra os passos do cenário e
 * realiza as asserções. Toda a localização de elementos está encapsulada na
 * {@link UserStory6 Page Object Class}; aqui apenas se acede aos
 * {@link org.openqa.selenium.WebElement}s expostos por essa classe e se
 * verifica o comportamento esperado da aplicação.</p>
 *
 * <p>O cenário {@code UserStoryTest6} reproduz os seguintes passos do Selenium
 * IDE:</p>
 * <ol>
 *   <li>{@code open /en/battleship} – navegação inicial.</li>
 *   <li>{@code setWindowSize 1057x900} – definição das dimensões da janela.</li>
 *   <li>Login com email e password.</li>
 *   <li>Criação do 1.º torneio: Battleship | Leaderboard | IGE_122994
 *       | Best of 3 | 3 min | 15 pts.</li>
 *   <li>Criação do 2.º torneio: Battleship | Single elimination | IGE_122466
 *       | Best of 1 | 1 min.</li>
 *   <li>Criação do 3.º torneio: Battleship | Double elimination | IGE_110323
 *       | Best of 5 | 5 min.</li>
 * </ol>
 *
 * @author IGE_122994
 */
public class UserStory6Test {

    /**
     * Instância do WebDriver que controla o browser durante cada teste.
     * Criada em {@link #setUp()} e destruída em {@link #tearDown()}.
     */
    private WebDriver driver;

    /**
     * Page Object que expõe os {@link org.openqa.selenium.WebElement}s da
     * página de Battleship necessários ao cenário.
     */
    private UserStory6 userStory6Page;

    // -------------------------------------------------------------------------
    // Ciclo de vida
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
     *   <li>Instancia a {@link UserStory6 Page Object}.</li>
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

        userStory6Page = new UserStory6(driver);
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
        userStory6Page.loginButton.click();
        sleep(1000);

        // Passo 4 – email
        userStory6Page.emailInput.sendKeys("goufrappocrugra-7205@y.w80.it");
        sleep(1000);

        // Passo 6 – password
        userStory6Page.passwordInput.sendKeys("12345678");
        sleep(1000);

        // Passo 7 – click Login no diálogo
        userStory6Page.loginDialogButton.click();
        sleep(5000);
    }

    // -------------------------------------------------------------------------
    // Testes
    // -------------------------------------------------------------------------

    /**
     * Verifica que é possível criar o 1.º torneio com as configurações
     * Battleship | Leaderboard | IGE_122994 | Best of 3 | 3 min | 15 pts,
     * e que após a criação o URL contém {@code /en/t/}.
     *
     * <p>Reproduz os passos 3 a 22 do Selenium IDE (login + 1.º torneio).</p>
     *
     * <p><strong>Asserção:</strong> após criar e fechar o popup, o URL deve
     * conter {@code /en/t/} (página do torneio criado).</p>
     *
     * @throws InterruptedException se a thread for interrompida durante o
     *                              {@code sleep}
     */
    @Test
    public void createLeaderboardTournamentSucceeds() throws InterruptedException {
        doLogin();

        // Passo 8 – click Create tournament na página principal
        userStory6Page.createTournamentButton.click();
        sleep(1000);

        // Passos 9 e 10 – Game: Battleship
        userStory6Page.gameSelector.click();
        sleep(1000);
        userStory6Page.battleshipOption.click();
        sleep(1000);

        // Passos 11 e 12 – Mode: Leaderboard
        userStory6Page.modeSelector.click();
        sleep(1000);
        userStory6Page.leaderboardOptionT1.click();
        sleep(1000);

        // Passos 13 e 14 – Tournament name: IGE_122994
        userStory6Page.tournamentNameInput.click();
        userStory6Page.tournamentNameInput.sendKeys("IGE_122994");
        sleep(1000);

        // Passos 15 e 16 – Matches per round: Best of 3
        userStory6Page.matchesPerRoundSelector.click();
        sleep(1000);
        userStory6Page.bestOf3OptionT1.click();
        sleep(1000);

        // Passos 17 e 18 – Minutes per player: 3 minutes
        userStory6Page.minutesPerPlayerSelector.click();
        sleep(1000);
        userStory6Page.threeMinutesOptionT1.click();
        sleep(1000);

        // Passos 19 e 20 – Penalty points: 15 pts
        userStory6Page.penaltyPointsSelector.click();
        sleep(1000);
        userStory6Page.fifteenPtsOptionT1.click();
        sleep(1000);

        // Passo 21 – Create and share
        userStory6Page.createAndShareButton.click();
        sleep(3000);

        // Passo 22 – fechar popup
        userStory6Page.closePopupButton.click();
        sleep(1000);

        assertTrue(driver.getCurrentUrl().contains("/en/t/"),
                "Após criar o torneio, o URL deveria conter '/en/t/'.");
    }

    /**
     * Verifica que é possível criar o 2.º torneio com as configurações
     * Battleship | Single elimination | IGE_122466 | Best of 1 | 1 min,
     * e que após a criação o URL contém {@code /en/t/}.
     *
     * <p>Reproduz os passos 3 a 7 (login) e 25 a 37 do Selenium IDE
     * (2.º torneio). Teste completamente independente do anterior.</p>
     *
     * <p><strong>Asserção:</strong> após criar e fechar o popup, o URL deve
     * conter {@code /en/t/}.</p>
     *
     * @throws InterruptedException se a thread for interrompida durante o
     *                              {@code sleep}
     */
    @Test
    public void createSingleEliminationTournamentSucceeds() throws InterruptedException {
        doLogin();

        // Passo 25 -click Create tournament na aba esquerda
        userStory6Page.createTournamentNavLink.click();
        sleep(1000);

        // Passos 26 e 27 – Game: Battleship
        userStory6Page.gameSelector.click();
        sleep(500);
        userStory6Page.battleshipOption.click();
        sleep(500);

        // Passos 28 e 29 – Mode: Single elimination
        userStory6Page.modeSelector.click();
        sleep(500);
        userStory6Page.singleEliminationOptionT2.click();
        sleep(500);

        // Passos 30 e 31 – Tournament name: IGE_122466
        userStory6Page.tournamentNameInput.click();
        userStory6Page.tournamentNameInput.sendKeys("IGE_122466");
        sleep(500);

        // Passos 32 e 33 – Matches per round: Best of 1
        userStory6Page.matchesPerRoundSelector.click();
        sleep(500);
        userStory6Page.bestOf1OptionT2.click();
        sleep(500);

        // Passos 34 e 35 – Minutes per player: 1 minutes
        userStory6Page.minutesPerPlayerSelector.click();
        sleep(500);
        userStory6Page.oneMinuteOptionT2.click();
        sleep(500);

        // Passos 36 – Create and share
        userStory6Page.createAndShareButton.click();
        sleep(3000);

        // Passos 37 – fechar popup
        userStory6Page.closePopupButton.click();
        sleep(1000);

        assertTrue(driver.getCurrentUrl().contains("/en/t/"),
                "Após criar o torneio, o URL deveria conter '/en/t/'.");
    }

    /**
     * Verifica que é possível criar o 3.º torneio com as configurações
     * Battleship | Double elimination | IGE_110323 | Best of 5 | 5 min,
     * e que após a criação o URL contém {@code /en/t/}.
     *
     * <p>Reproduz os passos 3 a 7 (login) e 40 a 53 do Selenium IDE
     * (3.º torneio). Teste completamente independente dos anteriores: navega
     * diretamente para {@code /en/t/create-tournament} via "My tournaments"
     * sem depender dos fluxos anteriores.</p>
     *
     * <p><strong>Asserção:</strong> após criar e fechar o popup, o URL deve
     * conter {@code /en/t/}.</p>
     *
     * @throws InterruptedException se a thread for interrompida durante o
     *                              {@code sleep}
     */
    @Test
    public void createDoubleEliminationTournamentSucceeds() throws InterruptedException {
        doLogin();

        // Passo 40 - click My tournaments na aba esquerda
        userStory6Page.myTournamentsNavLink.click();
        sleep(1000);

        // Passo 41 - click Create tournament no canto superior direito
        userStory6Page.createTournamentPageButton.click();
        sleep(1000);

        // Passos 42 e 43 – Game: Battleship
        userStory6Page.gameSelectorT3.click();
        sleep(500);
        userStory6Page.battleshipOptionT3.click();
        sleep(500);

        // Passos 44 e 45 – Mode: Double elimination
        userStory6Page.modeSelectorT3.click();
        sleep(500);
        userStory6Page.doubleEliminationOptionT3.click();
        sleep(500);

        // Passos 46 e 47 – Tournament name: IGE_110323
        userStory6Page.tournamentNameInputT3.click();
        userStory6Page.tournamentNameInputT3.sendKeys("IGE_110323");
        sleep(500);

        // Passos 48 e 49 – Matches per round: Best of 5
        userStory6Page.matchesPerRoundSelectorT3.click();
        sleep(500);
        userStory6Page.bestOf5OptionT3.click();
        sleep(500);

        // Passos 50 e 51 – Minutes per player: 5 minutes
        userStory6Page.minutesPerPlayerSelectorT3.click();
        sleep(500);
        userStory6Page.fiveMinutesOptionT3.click();
        sleep(500);

        // Passo 52 – Create and share
        userStory6Page.createAndShareButton.click();
        sleep(3000);

        // Passo 53 – Fechar popup
        userStory6Page.closePopupButton.click();
        sleep(1000);

        assertTrue(driver.getCurrentUrl().contains("/en/t/"),
                "Após criar o torneio, o URL deveria conter '/en/t/'.");
    }
}