package iscteiul.ista.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class (Selenide) para a User Story 10.
 * <p>
 * Como utilizador, quero aceder à página de Changelog,
 * para que possa ver as últimas atualizações e correções de bugs feitas no jogo.
 * </p>
 */
public class UserStory10SelenideTest {

    private UserStory10Selenide page;

    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.browserSize = "1516x891";
        open("https://papergames.io/en/battleship");
        page = new UserStory10Selenide();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    /**
     * Verifica que ao clicar em "Changelog" o URL contém "/changelog".
     */
    @Test
    public void testAcederChangelog() {
        page.clickChangelog();
        Selenide.sleep(2000);
        assertTrue(page.getCurrentUrl().contains("/changelog"),
                "O URL devia conter '/changelog' após clicar no link");
    }
}
