package iscteiul.ista.blackbattleship.selenide_122994;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class UserStory16Selenide {

    public static final String URL = "https://papergames.io/en/battleship";

    // Link "Goodies" na barra lateral
    public SelenideElement goodiesNavLink =
            $x("//a[contains(@href, 'https://merch.papergames.io')]");

    // Link "Shop" na barra lateral
    public SelenideElement shopNavLink =
            $x("//a[contains(@href, '/en/shop')]");

    // Botão/imagem "Goodies" dentro da página Shop
    public SelenideElement goodiesShopButton =
            $(".mb-2 > .w-100");
}
