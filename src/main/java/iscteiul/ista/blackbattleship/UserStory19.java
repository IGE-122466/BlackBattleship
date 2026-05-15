package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Class para a User Story 19.
 * <p>
 * Como utilizador, quero saber mais sobre o RANKA (/blog/ranka),
 * para saber quais são os benefícios de ter mais pontos.
 * </p>
 * URL: https://papergames.io/en/battleship
 */
public class UserStory19 {

    private final WebDriver driver;

    /**
     * Link "RANKA" no menu de navegação.
     * Seletor retirado do ficheiro TestSuite_110323.side (UserStoryTest19, passo 3).
     */
    @FindBy(linkText = "RANKA")
    private WebElement rankaLink;

    /**
     * Construtor. Inicializa os elementos da página via PageFactory.
     *
     * @param driver instância do WebDriver
     */
    public UserStory19(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clica no link "RANKA" para navegar para a respetiva página.
     */
    public void clickRanka() {
        rankaLink.click();
    }

    /**
     * Devolve o URL atual da página.
     *
     * @return URL atual
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
