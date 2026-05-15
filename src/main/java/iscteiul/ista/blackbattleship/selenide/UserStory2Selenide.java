// Ficheiro: UserStory2Selenide.java
package iscteiul.ista.blackbattleship.selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class UserStory2Selenide {
    public SelenideElement playWithFriendButton = $x("//*[contains(text(), 'Play with a friend') or contains(text(), 'PLAY WITH A FRIEND')]");
    public SelenideElement copyLinkButton = $x("//*[contains(text(), 'Copy') or contains(text(), 'COPY')]");
}