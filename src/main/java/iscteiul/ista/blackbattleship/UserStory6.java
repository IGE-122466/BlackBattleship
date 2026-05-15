package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Class para o cenário de teste {@code UserStoryTest6} do ficheiro
 * {@code TestSuite_122994.side}, referente à aplicação
 * {@code https://papergames.io/en/battleship}.
 *
 * <p>Esta classe segue o padrão <em>Page Object Model (POM)</em> e declara
 * exclusivamente os {@link WebElement}s necessários ao cenário, anotados com
 * {@link FindBy}. A instanciação dos elementos é delegada ao
 * {@link PageFactory}, que os inicializa de forma lazy assim que cada
 * elemento é acedido pela primeira vez.</p>
 *
 * <p>O cenário {@code UserStoryTest6} executa os seguintes passos:</p>
 * <ol>
 *   <li>Abertura da página {@code /en/battleship}.</li>
 *   <li>Definição das dimensões da janela para 1057 × 900 píxeis.</li>
 *   <li>Login com email e password.</li>
 *   <li>Criação do 1.º torneio via "Create tournament" na página principal
 *       (Battleship | Leaderboard | IGE_122994 | Best of 3 | 3 min | 15 pts).</li>
 *   <li>Fecho do popup e regresso à página de Battleship.</li>
 *   <li>Criação do 2.º torneio via "Create tournament" no menu lateral
 *       (Battleship | Single elimination | IGE_122466 | Best of 1 | 1 min).</li>
 *   <li>Fecho do popup e regresso à página de Battleship.</li>
 *   <li>Criação do 3.º torneio via "Create tournament" em "My tournaments"
 *       (Battleship | Double elimination | IGE_110323 | Best of 5 | 5 min).</li>
 *   <li>Fecho do popup.</li>
 * </ol>
 *
 * @author IGE_122994
 */
// page_url = https://papergames.io/en/battleship
public class UserStory6 {

    // -------------------------------------------------------------------------
    // Login
    // -------------------------------------------------------------------------

    /**
     * Botão "Login" presente na página de Battleship antes de abrir o diálogo.
     *
     * <p>Localizador CSS registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>XPath por posição: {@code //span/button}</li>
     *   <li>XPath por texto interno: {@code //button[contains(.,'Login')]}</li>
     * </ul>
     */
    @FindBy(css = ".btn-outline-dark")
    public WebElement loginButton;

    /**
     * Campo de input para o email no diálogo de login.
     *
     * <p>Localizador por ID selecionado por ser o mais direto e estável.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>CSS: {@code #mat-input-serverApp0}</li>
     *   <li>XPath: {@code //input[@id='mat-input-serverApp0']}</li>
     * </ul>
     */
    @FindBy(id = "mat-input-serverApp0")
    public WebElement emailInput;

    /**
     * Campo de input para a password no diálogo de login.
     *
     * <p>Localizador por ID selecionado por ser o mais direto e estável.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>CSS: {@code #mat-input-serverApp1}</li>
     *   <li>XPath: {@code //input[@id='mat-input-serverApp1']}</li>
     * </ul>
     */
    @FindBy(id = "mat-input-serverApp1")
    public WebElement passwordInput;

    /**
     * Botão "Login" dentro do diálogo de autenticação.
     *
     * <p>Localizador CSS registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>XPath relativo: {@code //div[4]/app-juicy-button/button/span[2]}</li>
     * </ul>
     */
    @FindBy(css = ".w-100:nth-child(1) > .btn-secondary > .front")
    public WebElement loginDialogButton;

    // -------------------------------------------------------------------------
    // Botões para aceder ao formulário dos torneios
    // -------------------------------------------------------------------------

    /**
     * Botão "Create tournament" na página principal após login.
     *
     * <p>Localizador CSS registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>XPath por posição: {@code //app-juicy-button[2]/button/span[2]}</li>
     * </ul>
     */
    @FindBy(css = ".position-relative > .front")
    public WebElement createTournamentButton;

    /**
     * Hiperligação "Create tournament" na barra de navegação lateral (menu
     * de torneios), utilizada na criação do 2.º torneio.
     *
     * <p>Localizador XPath por texto interno registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>CSS: {@code .cdk-focused > .hide-if-collapsed}</li>
     *   <li>XPath por posição: {@code //ul[3]/li/a/span}</li>
     * </ul>
     */
    @FindBy(xpath = "//span[contains(.,'Create tournament')]")
    public WebElement createTournamentNavLink;

    /**
     * Hiperligação "My tournaments" na barra de navegação lateral, utilizada
     * para navegar para a lista de torneios antes de criar o 3.º torneio.
     *
     * <p>Localizador XPath por texto interno registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>CSS: {@code .cdk-focused > .hide-if-collapsed}</li>
     *   <li>XPath por posição: {@code //ul[3]/li[2]/a/span}</li>
     * </ul>
     */
    @FindBy(xpath = "//span[contains(.,'My tournaments')]")
    public WebElement myTournamentsNavLink;

    /**
     * Botão "Create tournament" no canto superior direito da página
     * "My tournaments", utilizado para iniciar a criação do 3.º torneio.
     *
     * <p>Localizador CSS registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>XPath por link text: {@code //a[contains(text(),'Create tournament')]}</li>
     *   <li>XPath por href: {@code (//a[contains(@href, '/en/t/create-tournament')])[2]}</li>
     * </ul>
     */
    @FindBy(css = ".btn")
    public WebElement createTournamentPageButton;

    // -------------------------------------------------------------------------
    // Formulário dos primeiros dois torneios
    // -------------------------------------------------------------------------

    /**
     * Dropdown "Game" no formulário do 1.º torneio.
     *
     * <p>Localizador CSS registado pelo Selenium IDE.</p>
     */
    @FindBy(css = "#mat-select-serverApp0 svg")
    public WebElement gameSelector;

    /**
     * Opção "Battleship" no dropdown "Game" do 1.º torneio.
     *
     * <p>Localizador CSS registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>XPath: {@code //span/app-game-select-option/div/div/div[2]/div[2]}</li>
     * </ul>
     */
    @FindBy(css = "#mat-option-serverApp0 .c-gray-700")
    public WebElement battleshipOption;

    /**
     * Dropdown "Mode" no formulário do 1.º torneio.
     *
     * <p>Localizador CSS registado pelo Selenium IDE.</p>
     */
    @FindBy(css = "#mat-select-serverApp1 svg")
    public WebElement modeSelector;

    /**
     * Opção "Leaderboard" no dropdown "Mode" do 1.º torneio.
     *
     * <p>Localizador CSS registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>XPath: {@code //mat-option[@id='mat-option-serverApp6']/span/div/div[2]}</li>
     * </ul>
     */
    @FindBy(css = "#mat-option-serverApp6 .c-gray-700")
    public WebElement leaderboardOptionT1;

    /**
     * Campo de input para o nome do 1.º torneio.
     *
     * <p>Localizador por ID selecionado por ser o mais estável.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>CSS: {@code #mat-input-serverApp2}</li>
     *   <li>XPath: {@code //input[@id='mat-input-serverApp2']}</li>
     * </ul>
     */
    @FindBy(id = "mat-input-serverApp2")
    public WebElement tournamentNameInput;

    /**
     * Dropdown "Matches per round" no formulário do 1.º torneio.
     *
     * <p>Localizador CSS registado pelo Selenium IDE.</p>
     */
    @FindBy(css = "#mat-select-serverApp2 svg")
    public WebElement matchesPerRoundSelector;

    /**
     * Opção "Best of 3" no dropdown "Matches per round" do 1.º torneio.
     *
     * <p>Localizador por ID registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>XPath por texto: {@code //mat-option[contains(.,'Best of 3')]}</li>
     * </ul>
     */
    @FindBy(id = "mat-option-serverApp12")
    public WebElement bestOf3OptionT1;

    /**
     * Dropdown "Minutes per player" no formulário do 1.º torneio.
     *
     * <p>Localizador CSS registado pelo Selenium IDE.</p>
     */
    @FindBy(css = "#mat-select-serverApp3 svg")
    public WebElement minutesPerPlayerSelector;

    /**
     * Opção "3 minutes" no dropdown "Minutes per player" do 1.º torneio.
     *
     * <p>Localizador XPath por texto interno registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>ID: {@code mat-option-serverApp16}</li>
     *   <li>XPath por posição: {@code //div[@id='mat-select-serverApp3-panel']/mat-option[3]}</li>
     * </ul>
     */
    @FindBy(xpath = "//mat-option[contains(.,'3 minutes')]")
    public WebElement threeMinutesOptionT1;

    /**
     * Dropdown "Penalty points" no formulário do 1.º torneio.
     *
     * <p>Localizador por ID selecionado por ser o mais direto.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>CSS: {@code #mat-select-value-serverApp4}</li>
     *   <li>XPath: {@code //mat-select[@id='mat-select-serverApp4']/div/div}</li>
     * </ul>
     */
    @FindBy(id = "mat-select-value-serverApp4")
    public WebElement penaltyPointsSelector;

    /**
     * Opção "15 pts" no dropdown "Penalty points" do 1.º torneio.
     *
     * <p>Localizador XPath por texto interno registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>ID: {@code mat-option-serverApp22}</li>
     *   <li>XPath por posição: {@code //div[@id='mat-select-serverApp4-panel']/mat-option[4]}</li>
     * </ul>
     */
    @FindBy(xpath = "//mat-option[contains(.,'15 pts')]")
    public WebElement fifteenPtsOptionT1;

    /**
     * Botão "Create and share" no formulário do 1.º torneio.
     *
     * <p>Localizador CSS registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>XPath por texto: {@code //button[contains(.,'Create and share')]}</li>
     * </ul>
     */
    @FindBy(css = ".btn")
    public WebElement createAndShareButton;

    /**
     * Botão de fecho do popup após a criação do 1.º torneio.
     *
     * <p>Localizador XPath registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>CSS: {@code .cdk-focused > .mat-mdc-button-touch-target}</li>
     * </ul>
     */
    @FindBy(xpath = "//div/button/span[3]")
    public WebElement closePopupButton;

    /**
     * Opção "Single elimination" no dropdown "Mode" do 2.º torneio.
     *
     * <p>Localizador XPath registado pelo Selenium IDE.</p>
     */
    // @FindBy(css = "#mat-option-serverApp30 .c-gray-700")
    @FindBy(xpath ="//*[@id=\"mat-option-serverApp7\"]")
    public WebElement singleEliminationOptionT2;

    /**
     * Opção "Best of 1" no dropdown "Matches per round" do 2.º torneio.
     *
     * <p>Localizador XPath registado pelo Selenium IDE.</p>
     */
    @FindBy(xpath = "//*[@id=\"mat-option-serverApp11\"]")
    public WebElement bestOf1OptionT2;

    /**
     * Opção "1 minutes" no dropdown "Minutes per player" do 2.º torneio.
     *
     * <p>Localizador XPath registado pelo Selenium IDE.</p>
     */
    @FindBy(xpath = "//*[@id=\"mat-option-serverApp18\"]")
    public WebElement oneMinuteOptionT2;

    // -------------------------------------------------------------------------
    // Formulário do 3.º torneio (My tournaments – Double elimination)
    // -------------------------------------------------------------------------

    /**
     * Dropdown "Game" no formulário do 3.º torneio.
     *
     * <p>Localizador por ID selecionado por ser o mais direto.</p>
     */
    @FindBy(id = "mat-select-value-serverApp1")
    public WebElement gameSelectorT3;

    /**
     * Opção "Battleship" no dropdown "Game" do 3.º torneio.
     *
     * <p>Localizador XPath registado pelo Selenium IDE.</p>
     */
    @FindBy(xpath = "//*[@id=\"mat-option-serverApp4\"]")
    public WebElement battleshipOptionT3;

    /**
     * Dropdown "Mode" no formulário do 3.º torneio.
     *
     * <p>Localizador por ID selecionado por ser o mais direto.</p>
     */
    @FindBy(id = "mat-select-value-serverApp2")
    public WebElement modeSelectorT3;

    /**
     * Opção "Double elimination" no dropdown "Mode" do 3.º torneio.
     *
     * <p>Localizador XPath registado pelo Selenium IDE.</p>
     */
    @FindBy(xpath = "//*[@id=\"mat-option-serverApp12\"]")
    public WebElement doubleEliminationOptionT3;

    /**
     * Campo de input para o nome do 3.º torneio.
     *
     * <p>Localizador por ID selecionado por ser o mais estável.</p>
     */
    @FindBy(id = "mat-input-serverApp2")
    public WebElement tournamentNameInputT3;

    /**
     * Dropdown "Matches per round" no formulário do 3.º torneio.
     *
     * <p>Localizador por ID selecionado por ser o mais direto.</p>
     */
    @FindBy(id = "mat-select-value-serverApp3")
    public WebElement matchesPerRoundSelectorT3;

    /**
     * Opção "Best of 5" no dropdown "Matches per round" do 3.º torneio.
     *
     * <p>Localizador por ID registado pelo Selenium IDE.</p>
     */
    @FindBy(id = "mat-option-serverApp17")
    public WebElement bestOf5OptionT3;

    /**
     * Dropdown "Minutes per player" no formulário do 3.º torneio.
     *
     * <p>Localizador por ID selecionado por ser o mais direto.</p>
     */
    @FindBy(id = "mat-select-value-serverApp4")
    public WebElement minutesPerPlayerSelectorT3;

    /**
     * Opção "5 minutes" no dropdown "Minutes per player" do 3.º torneio.
     *
     * <p>Localizador XPath por texto interno registado pelo Selenium IDE.</p>
     */
    @FindBy(xpath = "//*[@id=\"mat-option-serverApp25\"]")
    public WebElement fiveMinutesOptionT3;

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    /**
     * Constrói uma nova instância de {@code UserStory6} e inicializa todos os
     * {@link WebElement}s declarados com {@link FindBy} através do
     * {@link PageFactory}.
     *
     * @param driver o {@link WebDriver} já instanciado e configurado pelo teste
     */
    public UserStory6(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}