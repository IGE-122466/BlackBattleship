package iscteiul.ista.blackbattleship.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object Class (Selenide) para a User Story 5.
 * <p>
 * Como jogador, quero utilizar o chat integrado durante as partidas,
 * para que possa comunicar e interagir com o meu adversário.
 * </p>
 * URL base: https://papergames.io/en/battleship
 */
public class UserStory5Selenide {

    /** Botão de consentimento do tratamento de dados. */
    private final SelenideElement consentButton = $("p.fc-button-label");

    /** Botão "Play vs bot". */
    private final SelenideElement playVsBotButton = $(".w-100:nth-child(2) > .btn .flex-grow-1");

    /** Campo de texto para inserir o nickname. */
    private final SelenideElement nicknameInput = $("input[placeholder='Nickname']");

    /** Botão "Continue" para confirmar o nickname. */
    private final SelenideElement continueButton = $("button[type='submit'].btn-secondary");

    /** Wrapper da área de texto do chat. */
    private final SelenideElement textareaWrapper = $(".textarea-wrapper");

    /** Campo de texto do chat. */
    private final SelenideElement messageInput = $("#mat-input-serverApp0");

    /**
     * Botão de envio da mensagem.
     * Usa JavascriptExecutor para evitar o overlay mat-mdc-button-touch-target.
     */
    private final SelenideElement sendButton = $("button.bg-secondary");

    /** Aceita o popup de consentimento. */
    public void acceptConsent() {
        consentButton.shouldBe(Condition.visible).click();
    }

    /** Clica em "Play vs bot". */
    public void clickPlayVsBot() {
        playVsBotButton.shouldBe(Condition.enabled).click();
    }

    /**
     * Insere o nickname no popup.
     * @param nickname nome a utilizar
     */
    public void enterNickname(String nickname) {
        nicknameInput.shouldBe(Condition.visible).clear();
        nicknameInput.sendKeys(nickname);
    }

    /** Clica em "Continue". */
    public void clickContinue() {
        continueButton.shouldBe(Condition.enabled).click();
    }

    /** Escreve uma mensagem no campo de chat. */
    public void typeMessage(String message) {
        textareaWrapper.shouldBe(Condition.visible).click();
        messageInput.click();
        messageInput.sendKeys(message);
    }

    /**
     * Clica no botão de envio via JavascriptExecutor
     * para contornar o overlay do Material Design.
     */
    public void clickSend() {
        ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("arguments[0].click();", sendButton.toWebElement());
    }

    /** Devolve o valor atual do campo de texto do chat. */
    public String getMessageInputValue() {
        return messageInput.getAttribute("value");
    }

    /** Fecha o popup de publicidade se presente. */
    public void closeAdIfPresent() {
        SelenideElement ad = $("div.continue-prompt-text");
        if (ad.exists()) ad.click();
    }

    /** Fecha o popup "welcome back" se presente. */
    public void closeWelcomeBackIfPresent() {
        SelenideElement dialog = $("mat-dialog-container button");
        if (dialog.exists()) dialog.click();
    }
}
