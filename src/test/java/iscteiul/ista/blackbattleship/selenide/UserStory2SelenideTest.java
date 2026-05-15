// Ficheiro: UserStory2SelenideTest.java
package iscteiul.ista.blackbattleship.selenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class UserStory2SelenideTest {
    @Test
    public void testarGerarLinkParaAmigo() {
        open("https://papergames.io/en/battleship");
        UserStory2Selenide us2 = new UserStory2Selenide();

        us2.playWithFriendButton.click(); // Selenide espera sozinho!
        us2.copyLinkButton.shouldBe(visible);
    }
}