// Ficheiro: UserStory11SelenideTest.java
package iscteiul.ista.blackbattleship.selenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class UserStory11SelenideTest {
    @Test
    public void testarAcessoLojaMoedasVirtuais() {
        open("https://papergames.io/en/");
        UserStory11Selenide us11 = new UserStory11Selenide();

        us11.shopButton.click();
        us11.virtualCoinsTab.click();

        boolean isCorrectUrl = webdriver().object().getCurrentUrl().contains("virtual-coins") || webdriver().object().getCurrentUrl().contains("shop");
        assert isCorrectUrl;
    }
}