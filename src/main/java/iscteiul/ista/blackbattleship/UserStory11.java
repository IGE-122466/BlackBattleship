package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model para a User Story 11.
 * Representa os elementos de navegação para a aquisição de moedas virtuais.
 */
public class UserStory11 {

    /** Botão de acesso ao menu principal da Loja. */
    @FindBy(xpath = "//a[contains(@href, '/shop')]")
    public WebElement shopButton;

    /** Aba de seleção para a categoria de Moedas Virtuais. */
    @FindBy(xpath = "//*[contains(text(), 'Virtual Coins') or contains(text(), 'Coins') or contains(text(), 'COINS')]")
    public WebElement virtualCoinsTab;

    /**
     * Construtor da classe UserStory11.
     * @param driver Instância do WebDriver utilizada.
     */
    public UserStory11(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}