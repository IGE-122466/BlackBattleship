package iscteiul.ista.blackbattleship.selenide_122994;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverConditions.*;

public class UserStory4SelenideTest {

    @Test
    public void loginAndNavigatesToFriends() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory4Selenide.URL);
        sleep(5000);
        UserStory4Selenide us4 = new UserStory4Selenide();

        // Login
        us4.loginButton.shouldBe(visible).click();
        us4.emailInput.shouldBe(visible).setValue("goufrappocrugra-7205@y.w80.it");
        us4.passwordInput.shouldBe(visible).setValue("12345678");
        us4.loginDialogButton.shouldBe(visible).click();
        sleep(3000);

        // Navegar para Friends
        us4.friendsNavLink.shouldBe(visible).click();
        sleep(3000);

        webdriver().shouldHave(urlContaining("/friends"));
    }

    @Test
    public void loginAndFriendsLinkIsVisible() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory4Selenide.URL);
        sleep(5000);
        UserStory4Selenide us4 = new UserStory4Selenide();

        // Login
        us4.loginButton.shouldBe(visible).click();
        us4.emailInput.shouldBe(visible).setValue("goufrappocrugra-7205@y.w80.it");
        us4.passwordInput.shouldBe(visible).setValue("12345678");
        us4.loginDialogButton.shouldBe(visible).click();
        sleep(3000);

        // Verificar visibilidade
        us4.friendsNavLink.shouldBe(visible);
    }

    @Test
    public void loginAndFriendsLinkHasCorrectText() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory4Selenide.URL);
        sleep(5000);
        UserStory4Selenide us4 = new UserStory4Selenide();

        // Login
        us4.loginButton.shouldBe(visible).click();
        us4.emailInput.shouldBe(visible).setValue("goufrappocrugra-7205@y.w80.it");
        us4.passwordInput.shouldBe(visible).setValue("12345678");
        us4.loginDialogButton.shouldBe(visible).click();
        sleep(3000);

        // Verificar texto
        us4.friendsNavLink.shouldHave(text("Friends"));
    }
}
