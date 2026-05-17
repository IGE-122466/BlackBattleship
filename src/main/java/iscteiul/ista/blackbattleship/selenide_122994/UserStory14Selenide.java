package iscteiul.ista.blackbattleship.selenide_122994;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class UserStory14Selenide {

    public static final String URL = "https://papergames.io/en/battleship";

    // Link "Privacy" no rodapé
    public SelenideElement privacyLink =
            $x("//a[contains(@href, '/en/blog/privacy-policy')]");
}
