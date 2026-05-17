package iscteiul.ista.blackbattleship;

import iscteiul.ista.blackbattleship.selenide.UserStory3Selenide;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserStory3SelenideTest {

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void viewMatchHistory() {
        UserStory3Selenide page = new UserStory3Selenide();

        page.open();

        assertTrue(page.getUrl().contains("battleship"));
    }
}