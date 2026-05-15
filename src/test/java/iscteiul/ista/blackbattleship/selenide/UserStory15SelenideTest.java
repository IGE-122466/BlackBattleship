package iscteiul.ista.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class UserStory15SelenideTest {

    @Test
    public void testarAcessoPaginaChatComoConvidado() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open("https://papergames.io/en/battleship");
        UserStory15Selenide us15 = new UserStory15Selenide();

        us15.playWithFriendButton.click();

        us15.nicknameInput.shouldBe(visible).setValue("RobotZeSelenide");
        us15.confirmButton.click();


        executeJavaScript("arguments[0].click();", us15.chatMenuButton);


        webdriver().shouldHave(com.codeborne.selenide.WebDriverConditions.urlContaining("chat"));
    }
}