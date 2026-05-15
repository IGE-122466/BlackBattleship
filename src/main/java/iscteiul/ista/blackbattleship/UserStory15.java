package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model para a User Story 15.
 * Representa os elementos necessários para interagir com o chat,
 * exigindo a criação prévia de um perfil de utilizador convidado.
 */
public class UserStory15 {

    /** Botão para iniciar o processo de convidar um amigo (abre modal de perfil). */
    @FindBy(xpath = "//*[contains(text(), 'Play with a friend') or contains(text(), 'PLAY WITH A FRIEND')]")
    public WebElement playWithFriendButton;

    /** Campo de texto para inserção do nickname do convidado. */
    @FindBy(css = ".input-xl")
    public WebElement nicknameInput;

    /** Botão de confirmação de criação do nickname temporário. */
    @FindBy(css = ".p-3 > .btn")
    public WebElement confirmButton;

    /** Botão do menu lateral para aceder à funcionalidade de mensagens. */
    @FindBy(xpath = "//*[contains(text(), 'Messaging') or contains(text(), 'MESSAGING')]")
    public WebElement chatMenuButton;

    /**
     * Construtor da classe UserStory15.
     * @param driver Instância do WebDriver utilizada.
     */
    public UserStory15(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}