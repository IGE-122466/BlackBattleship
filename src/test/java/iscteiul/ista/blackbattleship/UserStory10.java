package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Class para a User Story 10.
 * <p>
 * Como utilizador, quero aceder à página de Changelog,
 * para que possa ver as últimas atualizações e correções de bugs feitas no jogo.
 * </p>
 * URL: https://papergames.io/en/battleship
 */
public class UserStory10 {

    private final WebDriver driver;

    /**
     * Link "Changelog" no menu de navegação do rodapé.
     * Seletor retirado do ficheiro TestSuite_110323.side (UserStoryTest10, passo 3).
     */
    @FindBy(linkText = "Changelog")
    private WebElement changelogLink;

    /**
     * Construtor. Inicializa os elementos da página via PageFactory.
     *
     * @param driver instância do WebDriver
     */
    public UserStory10(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Clica no link "Changelog" para navegar para a respetiva página.
     */
    public void clickChangelog() {
        changelogLink.click();
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
