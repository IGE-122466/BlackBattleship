// Ficheiro: UserStory11Selenide.java
package iscteiul.ista.blackbattleship.selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class UserStory11Selenide {
    public SelenideElement shopButton = $x("//a[contains(@href, '/shop')]");
    public SelenideElement virtualCoinsTab = $x("//*[contains(text(), 'Virtual Coins') or contains(text(), 'Coins')]");
}