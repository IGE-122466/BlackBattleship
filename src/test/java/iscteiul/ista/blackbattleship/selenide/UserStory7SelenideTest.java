// Ficheiro: UserStory7SelenideTest.java
package iscteiul.ista.blackbattleship.selenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class UserStory7SelenideTest {
    @Test
    public void testarAcessoLojaEmojisEAvatares() {
        open("https://papergames.io/en/");
        UserStory7Selenide us7 = new UserStory7Selenide();

        us7.shopButton.click();
        us7.avatarsAndEmojisTab.click();

        boolean isCorrectUrl = webdriver().object().getCurrentUrl().contains("avatar") || webdriver().object().getCurrentUrl().contains("shop");
        assert isCorrectUrl;
    }
}