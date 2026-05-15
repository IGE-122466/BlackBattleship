package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model para a User Story 2.
 * Representa os elementos da interface necessários para convidar um amigo para jogar.
 */
public class UserStory2 {

    /** Botão principal para iniciar o jogo com um amigo. */
    @FindBy(xpath = "//*[contains(text(), 'Play with a friend') or contains(text(), 'PLAY WITH A FRIEND')]")
    public WebElement playWithFriendButton;

    /** Botão para copiar o link de convite gerado no modal. */
    @FindBy(xpath = "//*[contains(text(), 'Copy') or contains(text(), 'COPY')]")
    public WebElement copyLinkButton;

    /**
     * Construtor da classe UserStory2.
     * Inicializa os elementos da página utilizando o PageFactory.
     *
     * @param driver Instância do WebDriver utilizada para interagir com o browser.
     */
    public UserStory2(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}