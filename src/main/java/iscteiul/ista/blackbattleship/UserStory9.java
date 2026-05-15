package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Class para o cenário de teste {@code UserStoryTest9} do ficheiro
 * {@code TestSuite_122994.side}, referente à aplicação
 * {@code https://papergames.io/en/battleship}.
 *
 * <p>Esta classe segue o padrão <em>Page Object Model (POM)</em> e declara
 * exclusivamente os {@link WebElement}s necessários ao cenário, anotados com
 * {@link FindBy}. A instanciação dos elementos é delegada ao
 * {@link PageFactory}, que os inicializa de forma lazy assim que cada
 * elemento é acedido pela primeira vez.</p>
 *
 * <p>O cenário {@code UserStoryTest9} executa os seguintes passos:</p>
 * <ol>
 *   <li>Abertura da página {@code /en/battleship}.</li>
 *   <li>Definição das dimensões da janela para 1057 × 900 píxeis.</li>
 *   <li>Clique no botão "Login".</li>
 *   <li>Preenchimento do campo "Email".</li>
 *   <li>Preenchimento do campo "Password".</li>
 *   <li>Clique no botão "Login" dentro do diálogo.</li>
 *   <li>Clique em "Play vs robot".</li>
 *   <li>Clique em "Abort game" no canto inferior direito.</li>
 *   <li>Clique em "Abort game" no diálogo de confirmação.</li>
 * </ol>
 *
 * <p>Todos os localizadores abaixo foram selecionados com base nos
 * <em>targets</em> registados pelo Selenium IDE, privilegiando sempre
 * o mais robusto entre eles.</p>
 *
 * @author IGE_122994
 */
public class UserStory9 {

    /**
     * Botão "Login" presente na página Battleship antes de abrir o diálogo.
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
     *   <li>XPath por atributos: {@code //input[@id='mat-input-serverApp0']}</li>
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
     *   <li>XPath por atributos: {@code //input[@id='mat-input-serverApp1']}</li>
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
     *   <li>XPath relativo ao diálogo:
     *       {@code //div[4]/app-juicy-button/button/span[2]}</li>
     * </ul>
     */
    @FindBy(css = ".w-100:nth-child(1) > .btn-secondary > .front")
    public WebElement loginDialogButton;

    /**
     * Botão "Play vs robot" na página principal após login.
     *
     * <p>Localizador CSS registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>XPath por posição: {@code //app-juicy-button[2]/button/span[2]}</li>
     * </ul>
     */
    @FindBy(css = ".w-100:nth-child(2) > .btn > .front")
    public WebElement playVsRobotButton;

    /**
     * Botão "Abort game" no canto inferior direito durante o jogo.
     *
     * <p>Localizador CSS registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>XPath por texto interno: {@code //button[contains(.,'Abort game')]}</li>
     * </ul>
     */
    @FindBy(css = ".btn")
    public WebElement abortGameButton;

    /**
     * Botão "Abort game" no diálogo de confirmação.
     *
     * <p>Localizador CSS registado pelo Selenium IDE.</p>
     *
     * <p>Alternativas registadas:</p>
     * <ul>
     *   <li>XPath por posição: {@code (//button[@type='button'])[3]}</li>
     * </ul>
     */
    @FindBy(css = ".btn-danger")
    public WebElement abortGameConfirmButton;

    /**
     * Constrói uma nova instância de {@code UserStory9} e inicializa todos os
     * {@link WebElement}s declarados com {@link FindBy} através do
     * {@link PageFactory}.
     *
     * @param driver o {@link WebDriver} já instanciado e configurado pelo teste
     */
    public UserStory9(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
