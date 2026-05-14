package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Class para o cenário de teste {@code UserStoryTest14} do ficheiro
 * {@code TestSuite_122994.side}, referente à aplicação
 * {@code https://papergames.io/en/battleship}.
 *
 * <p>Esta classe segue o padrão <em>Page Object Model (POM)</em> e declara
 * exclusivamente os {@link WebElement}s necessários ao cenário, anotados com
 * {@link FindBy}. A instanciação dos elementos é delegada ao
 * {@link PageFactory}, que os inicializa de forma lazy assim que cada
 * elemento é acedido pela primeira vez.</p>
 *
 * <p>O cenário {@code UserStoryTest14} executa os seguintes passos:</p>
 * <ol>
 *   <li>Abertura da página {@code /en/battleship}.</li>
 *   <li>Definição das dimensões da janela para 1057 × 900 píxeis.</li>
 *   <li>Scroll para o topo da página via JavaScript.</li>
 *   <li>Clique na hiperligação "Privacy" no rodapé da página.</li>
 * </ol>
 *
 * @author  IGE_122994
 */
public class UserStory14 {

    /**
     * Hiperligação "Privacy" localizada no rodapé da página.
     *
     * <p>Localizador XPath selecionado por ser o mais robusto entre os
     * registados pelo Selenium IDE: ancora-se diretamente no atributo
     * {@code href}, sendo imune a alterações de posição no DOM ou de
     * formatação do texto.</p>
     *
     * <p>Alternativas registadas pelo Selenium IDE:</p>
     * <ul>
     *   <li>CSS: {@code .col-md-6:nth-child(3) > div:nth-child(6) > .text-reset}</li>
     *   <li>XPath por link text: {@code //a[contains(text(),'Privacy')]}</li>
     *   <li>XPath por posição: {@code //div[3]/div[6]/a}</li>
     *   <li>XPath por texto interno: {@code //a[contains(.,'Privacy')]}</li>
     * </ul>
     */
    @FindBy(xpath = "//a[contains(@href, '/en/blog/privacy-policy')]")
    public WebElement privacyLink;

    /**
     * Constrói uma nova instância de {@code UserStory14} e inicializa todos os
     * {@link WebElement}s declarados com {@link FindBy} através do
     * {@link PageFactory}.
     *
     * @param driver o {@link WebDriver} já instanciado e configurado pelo teste
     */
    public UserStory14(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}