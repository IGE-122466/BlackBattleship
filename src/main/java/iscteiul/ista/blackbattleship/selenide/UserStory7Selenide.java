// Ficheiro: UserStory7Selenide.java
package iscteiul.ista.blackbattleship.selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class UserStory7Selenide {
    public SelenideElement shopButton = $x("//a[contains(@href, '/shop')]");
    public SelenideElement avatarsAndEmojisTab = $x("//*[contains(text(), 'Avatars') or contains(text(), 'Emojis')]");
}