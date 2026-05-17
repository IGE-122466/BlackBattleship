package iscteiul.ista.blackbattleship.selenide_122994;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverConditions.*;

public class UserStory9SelenideTest {

    private void doLogin(UserStory9Selenide us9) throws InterruptedException {
        sleep(5000);

        us9.loginButton.shouldBe(visible).click();
        sleep(1000);

        us9.emailInput.shouldBe(visible).setValue("goufrappocrugra-7205@y.w80.it");
        sleep(1000);

        us9.passwordInput.shouldBe(visible).setValue("12345678");
        sleep(1000);

        us9.loginDialogButton.shouldBe(visible).click();
        sleep(5000);
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void abortGameVsRobotGoesBackToTheRightPage() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory9Selenide.URL);
        UserStory9Selenide us9 = new UserStory9Selenide();

        // Login
        doLogin(us9);

        // Play vs robot
        us9.playVsRobotButton.click();
        sleep(5000);

        // Abort game
        us9.abortGameButton.shouldBe(visible).click();
        sleep(1000);

        us9.abortGameConfirmButton.shouldBe(visible).click();
        sleep(2000);

        webdriver().shouldHave(urlContaining("/en/battleship"));
    }

    @Test
    public void buttonIsVisible() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory9Selenide.URL);
        UserStory9Selenide us9 = new UserStory9Selenide();

        // Login
        doLogin(us9);

        // Verificar visibilidade
        us9.playVsRobotButton.shouldBe(visible);
    }

    @Test
    public void buttonHasCorrectText() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory9Selenide.URL);
        UserStory9Selenide us9 = new UserStory9Selenide();

        // Login
        doLogin(us9);

        // Verificar texto
        us9.playVsRobotButton.shouldHave(text("Play vs robot"));
    }
}
