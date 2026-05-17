package iscteiul.ista.blackbattleship.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object Class (Selenide) para a User Story 1.
 * <p>
 * Como jogador, quero iniciar uma partida de Batalha Naval contra um bot,
 * para que possa jogar de forma rápida e testar a minha estratégia.
 * </p>
 * URL: https://papergames.io/en/battleship
 */
public class UserStory1Selenide {

    /**
     * Botão de consentimento do tratamento de dados (popup inicial).
     */
    private final SelenideElement consentButton = $("p.fc-button-label");

    /**
     * Botão "Play vs bot" na página principal do Battleship.
     */
    private final SelenideElement playVsBotButton = $(".w-100:nth-child(2) > .btn .flex-grow-1");

    /**
     * Campo de texto para inserir o nickname.
     */
    private final SelenideElement nicknameInput = $("input[placeholder='Nickname']");

    /**
     * Botão "Continue" para confirmar o nickname.
     */
    private final SelenideElement continueButton = $("button[type='submit'].btn-secondary");

    /**
     * Aguarda e aceita o popup de consentimento do tratamento de dados.
     * Se o popup não aparecer dentro do timeout, continua normalmente.
     */
    public void acceptConsent() {
        try {
            consentButton.shouldBe(Condition.visible).click();
        } catch (Exception ignored) {
            // popup não apareceu, continuar normalmente
        }
    }

    /**
     * Clica no botão "Play vs bot" para iniciar uma partida contra o bot.
     */
    public void clickPlayVsBot() {
        playVsBotButton.shouldBe(Condition.enabled).click();
    }

    /**
     * Insere o nickname no campo de texto do popup.
     *
     * @param nickname nome a utilizar na partida
     */
    public void enterNickname(String nickname) {
        nicknameInput.shouldBe(Condition.visible).clear();
        nicknameInput.sendKeys(nickname);
    }

    /**
     * Clica em "Continue" para confirmar o nickname.
     */
    public void clickContinue() {
        continueButton.shouldBe(Condition.enabled).click();
    }

    /**
     * Fecha o popup de publicidade se este aparecer.
     */
    public void closeAdIfPresent() {
        SelenideElement ad = $("div.continue-prompt-text");
        if (ad.exists()) ad.click();
    }

    /**
     * Fecha o popup "welcome back" se este aparecer.
     */
    public void closeWelcomeBackIfPresent() {
        SelenideElement dialog = $("mat-dialog-container button");
        if (dialog.exists()) dialog.click();
    }

    /**
     * Devolve o URL atual da página.
     *
     * @return URL atual
     */
    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}