package iscteiul.ista.blackbattleship.selenide_122994;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverConditions.*;

public class UserStory14SelenideTest {

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void navigatesToTheRightPage() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory14Selenide.URL);
        UserStory14Selenide us14 = new UserStory14Selenide();

        sleep(5000);

        // Scroll até ao link
        us14.privacyLink.scrollIntoView(true);
        sleep(2000);

        // Privacy
        us14.privacyLink.shouldBe(visible).click();
        sleep(3000);

        webdriver().shouldHave(urlContaining("/en/blog/privacy-policy"));
    }

    @Test
    public void linkIsVisible() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory14Selenide.URL);
        UserStory14Selenide us14 = new UserStory14Selenide();

        sleep(5000);

        // Scroll até ao link
        us14.privacyLink.scrollIntoView(true);
        sleep(2000);

        // Verificar visibilidade
        us14.privacyLink.shouldBe(visible);
        sleep(1000);
    }

    @Test
    public void linkHasCorrectText() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory14Selenide.URL);
        UserStory14Selenide us14 = new UserStory14Selenide();

        sleep(5000);

        // Scroll até ao link
        us14.privacyLink.scrollIntoView(true);
        sleep(2000);

        // Verificar texto
        us14.privacyLink.shouldHave(text("Privacy"));
        sleep(1000);
    }
}
