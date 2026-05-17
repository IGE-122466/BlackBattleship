package iscteiul.ista.blackbattleship.selenide;

import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserStory8SelenideTest {

    private UserStory8Selenide page;

    @BeforeEach
    public void setUp() {
        page = new UserStory8Selenide();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void accessPlusPlan() {
        page.openPlusPlan();

        assertTrue(page.getUrl().contains("pricing/plus"));
    }

    @Test
    public void accessGruppoPlan() {
        page.openGruppoPlan();

        assertTrue(page.getUrl().contains("pricing/gruppo"));
    }
}