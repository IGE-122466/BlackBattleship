package iscteiul.ista.blackbattleship.selenide;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class UserStory15Selenide {
    public SelenideElement playWithFriendButton = $x("//*[contains(text(), 'Play with a friend') or contains(text(), 'PLAY WITH A FRIEND')]");
    public SelenideElement nicknameInput = $(".input-xl");
    public SelenideElement confirmButton = $(".p-3 > .btn");

    // NOVO LOCALIZADOR: Procura diretamente o link que leva à página de chat!
    // Assim, não interessa se o texto está escondido ou se só lá está o ícone.
    public SelenideElement chatMenuButton = $("a[href*='chat']");
}