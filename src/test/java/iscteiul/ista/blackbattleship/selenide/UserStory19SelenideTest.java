package iscteiul.ista.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class (Selenide) para a User Story 19.
 * <p>
 * Como utilizador, quero saber mais sobre o RANKA (/blog/ranka),
 * para saber quais são os benefícios de ter mais pontos.
 * </p>
 */
public class UserStory19SelenideTest {

    private UserStory19Selenide page;

    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.browserSize = "1516x891";
        open("https://papergames.io/en/battleship");
        page = new UserStory19Selenide();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    /**
     * Verifica que ao clicar em "RANKA" o URL contém "/blog/ranka".
     */
    @Test
    public void testAcederRanka() {
        page.clickRanka();
        Selenide.sleep(1500);
        assertTrue(page.getCurrentUrl().contains("/blog/ranka"),
                "O URL devia conter '/blog/ranka' após clicar no link RANKA");
    }
}
