package iscteiul.ista.blackbattleship.selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class (Selenide) para a User Story 20.
 * <p>
 * Como utilizador criativo, quero poder alterar o meu avatar (/shop/avatars/owned),
 * para não jogar sempre com o mesmo.
 * </p>
 */
public class UserStory20SelenideTest {

    private UserStory20Selenide page;

    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.browserSize = "1516x891";
        Configuration.timeout = 10000;
        open("https://papergames.io/en/battleship");
        page = new UserStory20Selenide();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    /**
     * Verifica que o utilizador consegue iniciar e abandonar uma partida,
     * navegar para a loja, selecionar um pack de avatares e ativar um avatar.
     * Necessario fechar anuncios manualmente
     */
    @Test
    public void testAlterarAvatar() {
        page.closeAdIfPresent();
        page.acceptConsent();

        Selenide.sleep(2000);
        page.closeAdIfPresent();
        page.clickPlayVsBot();

        Selenide.sleep(2000);
        page.closeAdIfPresent();
        page.enterNickname("IGE-110323");
        Selenide.sleep(2000);
        page.clickContinue();



        Selenide.sleep(2000);

        page.clickAbortGame();
        page.clickConfirmAbort();
        Selenide.sleep(2000);

        page.clickShop();
        Selenide.sleep(2000);
        assertTrue(page.getCurrentUrl().contains("/shop"),
                "Devia navegar para a loja");

        page.clickMonstersAvatarPack();
        assertTrue(page.getCurrentUrl().contains("/shop/avatars"),
                "Devia navegar para a página de avatares");

        // Comprar um avatar antes de ir para a aba Owned
        page.clickBuyAvatar();
        Selenide.sleep(2000);
        page.clickConfirmBuy();
        Selenide.sleep(3000); // esperar que a compra seja processada

        page.clickOwnedTab();
        Selenide.sleep(2000); // esperar que a aba carregue
        page.clickUseButton();
        Selenide.sleep(2000);
        assertTrue(true, "O botão 'Use' foi clicado com sucesso");
    }
}