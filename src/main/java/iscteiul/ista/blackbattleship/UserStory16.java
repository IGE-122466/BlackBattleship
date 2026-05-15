package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Class para o cenário de teste {@code UserStoryTest16} do ficheiro
 * {@code TestSuite_122994.side}, referente à aplicação
 * {@code https://papergames.io/en/battleship}.
 *
 * <p>Esta classe segue o padrão <em>Page Object Model (POM)</em> e declara
 * exclusivamente os {@link WebElement}s necessários ao cenário, anotados com
 * {@link FindBy}. A instanciação dos elementos é delegada ao
 * {@link PageFactory}, que os inicializa de forma lazy assim que cada
 * elemento é acedido pela primeira vez.</p>
 *
 * <p>O cenário {@code UserStoryTest16} executa os seguintes passos:</p>
 * <ol>
 *   <li>Abertura da página {@code /en/battleship}.</li>
 *   <li>Definição das dimensões da janela para 1057 × 900 píxeis.</li>
 *   <li>Clique na hiperligação "Goodies" da barra de navegação lateral
 *       (abre uma nova janela de merchandising).</li>
 *   <li>Mudança de foco para a janela de merchandising e regresso
 *       à janela principal.</li>
 *   <li>Clique na hiperligação "Shop" da barra de navegação lateral.</li>
 *   <li>Clique na opção "Goodies" dentro da página de Shop
 *       (abre uma nova janela de merchandising).</li>
 *   <li>Mudança de foco para a nova janela de merchandising.</li>
 * </ol>
 *
 * @author IGE_122994
 */
public class UserStory16 {

    /**
     * Hiperligação "Goodies" da barra de navegação lateral.
     *
     * <p>Localizador XPath selecionado por ser o mais robusto entre os
     * registados pelo Selenium IDE: ancora-se no atributo {@code href},
     * sendo imune a alterações de posição no DOM ou de formatação do texto.</p>
     *
     * <p>Alternativas registadas pelo Selenium IDE:</p>
     * <ul>
     *   <li>CSS: {@code .cdk-focused}</li>
     *   <li>XPath por posição: {@code //ul[2]/li[3]/a}</li>
     *   <li>XPath por texto interno: {@code //a[contains(.,'Goodies')]}</li>
     * </ul>
     */
    @FindBy(xpath = "//a[contains(@href, 'https://merch.papergames.io')]")
    public WebElement goodiesNavLink;

    /**
     * Hiperligação "Shop" da barra de navegação lateral.
     *
     * <p>Localizador XPath selecionado por ser o mais robusto entre os
     * registados pelo Selenium IDE: ancora-se no atributo {@code href}.</p>
     *
     * <p>Alternativas registadas pelo Selenium IDE:</p>
     * <ul>
     *   <li>CSS: {@code .cdk-focused}</li>
     *   <li>XPath por posição: {@code //ul[2]/li[2]/a}</li>
     *   <li>XPath por texto interno: {@code //a[contains(.,'Shop')]}</li>
     * </ul>
     */
    @FindBy(xpath = "//a[contains(@href, '/en/shop')]")
    public WebElement shopNavLink;

    /**
     * Imagem/botão "Goodies" dentro da página de Shop, cujo clique abre
     * uma nova janela de merchandising.
     *
     * <p>Localizador CSS selecionado por ser o registado pelo Selenium IDE
     * como {@code css:finder} para este elemento.</p>
     *
     * <p>Alternativas registadas pelo Selenium IDE:</p>
     * <ul>
     *   <li>XPath por atributo alt: {@code //img[@alt='Goodies']}</li>
     *   <li>XPath por posição: {@code //div[5]/a/div/img}</li>
     * </ul>
     */
    @FindBy(css = ".mb-2 > .w-100")
    public WebElement goodiesShopButton;

    /**
     * Constrói uma nova instância de {@code UserStory16} e inicializa todos os
     * {@link WebElement}s declarados com {@link FindBy} através do
     * {@link PageFactory}.
     *
     * @param driver o {@link WebDriver} já instanciado e configurado pelo teste
     */
    public UserStory16(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}