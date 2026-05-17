package iscteiul.ista.blackbattleship.selenide;

import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserStory17SelenideTest {

    private UserStory17Selenide page;

    @BeforeEach
    public void setUp() {
        page = new UserStory17Selenide();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void viewMyTournamentsHistory() {
        page.openMyTournaments();

        assertTrue(page.getUrl().contains("my-tournaments"));
    }
}