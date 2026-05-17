package iscteiul.ista.blackbattleship.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object Class (Selenide) para a User Story 10.
 * <p>
 * Como utilizador, quero aceder à página de Changelog,
 * para que possa ver as últimas atualizações e correções de bugs feitas no jogo.
 * </p>
 * URL: https://papergames.io/en/battleship
 */
public class UserStory10Selenide {

    /** Link "Changelog" no menu de navegação. */
    private final SelenideElement changelogLink = $("a[href*='/changelog']");

    /** Clica no link "Changelog". */
    public void clickChangelog() {
        changelogLink.shouldBe(Condition.visible).click();
    }

    /** Devolve o URL atual. */
    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
