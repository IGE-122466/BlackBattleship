package iscteiul.ista.blackbattleship.selenide;

import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserStory12SelenideTest {

    private UserStory12Selenide page;

    @BeforeEach
    public void setUp() {
        page = new UserStory12Selenide();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void accessBoostersShop() {
        page.openBoostersPage();

        assertTrue(page.getUrl().contains("shop/boosters"));
    }
}