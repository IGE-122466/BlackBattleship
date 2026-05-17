package iscteiul.ista.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class (Selenide) para a User Story 5.
 * <p>
 * Como jogador, quero utilizar o chat integrado durante as partidas,
 * para que possa comunicar e interagir com o meu adversário.
 * </p>
 */
public class UserStory5SelenideTest {

    private UserStory5Selenide page;

    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.browserSize = "1516x891";
        open("https://papergames.io/en/battleship");
        page = new UserStory5Selenide();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    /**
     * Verifica que o jogador consegue escrever e enviar uma mensagem no chat.
     * O campo de texto deve ficar vazio após o envio.
     */
    @Test
    public void testEnviarMensagemChat() {
        page.closeAdIfPresent();
        page.acceptConsent();

        Selenide.sleep(2000);
        page.closeAdIfPresent();
        page.clickPlayVsBot();

        Selenide.sleep(2000);
        page.closeAdIfPresent();
        page.enterNickname("IGE-110323");
        sleep(1500);
        page.clickContinue();
        Selenide.sleep(1500);


        page.typeMessage("Mensagem teste");
        assertEquals("Mensagem teste", page.getMessageInputValue(),
                "O campo devia conter o texto escrito antes do envio");

        page.clickSend();
        Selenide.sleep(2000);

        assertEquals("", page.getMessageInputValue(),
                "O campo devia estar vazio após enviar a mensagem");
    }
}
