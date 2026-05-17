package iscteiul.ista.blackbattleship.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object Class (Selenide) para a User Story 19.
 * <p>
 * Como utilizador, quero saber mais sobre o RANKA (/blog/ranka),
 * para saber quais são os benefícios de ter mais pontos.
 * </p>
 * URL: https://papergames.io/en/battleship
 */
public class UserStory19Selenide {

    /** Link "RANKA" no menu de navegação. */
    private final SelenideElement rankaLink = $("a[href*='/blog/ranka']");

    /** Clica no link "RANKA". */
    public void clickRanka() {
        rankaLink.shouldBe(Condition.visible).click();
    }

    /** Devolve o URL atual. */
    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
