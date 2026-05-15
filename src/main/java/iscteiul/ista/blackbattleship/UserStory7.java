package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe Page Object para a User Story 7.
 * Responsável por mapear os elementos da loja de Avatares e Emojis.
 * * @author José Maria Remédios
 * @version 1.0
 */
public class UserStory7 {

    /** * Elemento que representa o botão ou link de acesso à Loja (Shop).
     */
    @FindBy(xpath = "//a[contains(@href, '/shop')]")
    public WebElement shopButton;

    /** * Elemento que representa a aba de Avatares e Emojis dentro da Loja.
     * Utiliza uma pesquisa por texto para maior flexibilidade.
     */
    @FindBy(xpath = "//*[contains(text(), 'Avatars') or contains(text(), 'Emojis')]")
    public WebElement avatarsAndEmojisTab;

    /**
     * Construtor da classe que inicializa os elementos através do PageFactory.
     * * @param driver Instância do WebDriver para interação com o browser.
     */
    public UserStory7(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}