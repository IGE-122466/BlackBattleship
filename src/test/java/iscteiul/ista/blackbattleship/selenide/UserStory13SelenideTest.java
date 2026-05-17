package iscteiul.ista.blackbattleship.selenide;

import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserStory13SelenideTest {

    private UserStory13Selenide page;

    @BeforeEach
    public void setUp() {
        page = new UserStory13Selenide();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void viewProfileStats() {
        page.openProfileStats();

        assertTrue(page.getUrl().contains("profile"));
    }
}