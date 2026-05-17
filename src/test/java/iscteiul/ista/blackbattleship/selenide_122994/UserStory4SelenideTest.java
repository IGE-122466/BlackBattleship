package iscteiul.ista.blackbattleship.selenide_122994;

import com.codeborne.selenide.Configuration;
import iscteiul.ista.blackbattleship.UserStory4;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverConditions.*;

public class UserStory4SelenideTest {

    private void doLogin(UserStory4Selenide us4) throws InterruptedException {
        sleep(5000);

        us4.loginButton.shouldBe(visible).click();
        sleep(1000);

        us4.emailInput.shouldBe(visible).setValue("goufrappocrugra-7205@y.w80.it");
        sleep(1000);

        us4.passwordInput.shouldBe(visible).setValue("12345678");
        sleep(1000);

        us4.loginDialogButton.shouldBe(visible).click();
        sleep(5000);
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void loginAndNavigatesToFriends() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory4Selenide.URL);
        sleep(5000);
        UserStory4Selenide us4 = new UserStory4Selenide();

        // Login
        doLogin(us4);

        // Navegar para Friends
        us4.friendsNavLink.shouldBe(visible).click();
        sleep(3000);

        webdriver().shouldHave(urlContaining("/friends"));
    }

    @Test
    public void loginAndFriendsLinkIsVisible() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory4Selenide.URL);
        sleep(5000);
        UserStory4Selenide us4 = new UserStory4Selenide();

        // Login
        doLogin(us4);

        // Verificar visibilidade
        us4.friendsNavLink.shouldBe(visible);
    }

    @Test
    public void loginAndFriendsLinkHasCorrectText() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory4Selenide.URL);
        sleep(5000);
        UserStory4Selenide us4 = new UserStory4Selenide();

        // Login
        doLogin(us4);

        // Verificar texto
        us4.friendsNavLink.shouldHave(text("Friends"));
    }
}
