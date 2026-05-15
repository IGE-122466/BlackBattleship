package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model para a User Story 18.
 * Representa os elementos da página dedicada aos desenvolvedores do Papergames.
 */
public class UserStory18 {

    /** Link no rodapé que redireciona para a página de developers. */
    @FindBy(linkText = "Developers")
    public WebElement developersLink;

    /** Título principal (h1) na página de destino, usado para validar o carregamento. */
    @FindBy(tagName = "h1")
    public WebElement tituloPrincipal;

    /**
     * Construtor da classe UserStory18.
     * @param driver Instância do WebDriver utilizada.
     */
    public UserStory18(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}