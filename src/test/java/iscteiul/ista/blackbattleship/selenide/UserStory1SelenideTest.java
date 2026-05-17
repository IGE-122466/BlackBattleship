package iscteiul.ista.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class (Selenide) para a User Story 1.
 * <p>
 * Como jogador, quero iniciar uma partida de Batalha Naval contra um bot,
 * para que possa jogar de forma rápida e testar a minha estratégia.
 * </p>
 */
public class UserStory1SelenideTest {

    private UserStory1Selenide page;

    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.browserSize = "1516x891";
        Configuration.timeout = 10000; // aumentar timeout para 10 segundos
        open("https://papergames.io/en/battleship");
        page = new UserStory1Selenide();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    /**
     * Verifica que ao aceitar o consentimento, clicar em "Play vs bot",
     * inserir um nickname e confirmar, o URL muda para a página do jogo.
     */
    @Test
    public void testIniciarPartidaVsBot() {
        page.closeAdIfPresent();
        page.acceptConsent();

        Selenide.sleep(1500);
        page.closeAdIfPresent();

        String urlInicial = page.getCurrentUrl();
        page.clickPlayVsBot();

        Selenide.sleep(1500);
        page.closeAdIfPresent();
        page.enterNickname("IGE-110323");
        Selenide.sleep(1500);
        page.clickContinue();

        new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.not(ExpectedConditions.urlToBe(urlInicial)));

        assertNotEquals(urlInicial, page.getCurrentUrl(),
                "O URL devia mudar após iniciar a partida");
    }
}