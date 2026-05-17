package iscteiul.ista.blackbattleship.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Page Object Class (Selenide) para a User Story 20.
 * <p>
 * Como utilizador criativo, quero poder alterar o meu avatar (/shop/avatars/owned),
 * para não jogar sempre com o mesmo.
 * </p>
 * Fluxo: consent → play vs bot → nickname → abort game → shop → avatares → Use.
 * URL base: https://papergames.io/en/battleship
 */
public class UserStory20Selenide {

    /** Botão de consentimento do tratamento de dados. */
    private final SelenideElement consentButton = $("p.fc-button-label");

    /** Botão "Play vs bot". */
    private final SelenideElement playVsBotButton = $(".w-100:nth-child(2) > .btn .flex-grow-1");

    /** Campo de texto para inserir o nickname. */
    private final SelenideElement nicknameInput = $("input[placeholder='Nickname']");

    /** Botão "Continue". */
    private final SelenideElement continueButton = $("button[type='submit'].btn-secondary");

    /** Link "Shop" no menu de navegação. */
    private final SelenideElement shopLink = $("a[href*='/shop']");

    /** Pack de avatares "Monsters" na loja. */
    private final SelenideElement monstersAvatarPack = $(".box-shadow-1:nth-child(2) .w-75");

    /** Botão de confirmação de compra. */
    private final SelenideElement confirmBuyButton = $x("//span[contains(.,'Confirm')]");

    /** Botão de compra de avatar (contém ícone de moedas e preço 990). */
    private final SelenideElement buyButton = $("button[confirmbuttonclass='btn-secondary']");

    /** Aba "Owned" na página de avatares. */
    private final SelenideElement ownedTab = $("#mat-tab-group-serverApp0-label-2 > .mdc-tab__content");

    /** Botão "Use" para ativar o avatar. */
    private final SelenideElement useButton = $x("//button[contains(.,'Use')]");

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

    /**
     * Clica em "Abort game".
     * Selenide retenta automaticamente em caso de StaleElementReferenceException.
     */
    public void clickAbortGame() {
        $("button.btn-outline-dark").shouldBe(Condition.enabled).click();
    }

    /**
     * Confirma o abandono — opcional, continua se o botão não aparecer.
     */
    public void clickConfirmAbort() {
        SelenideElement confirmBtn = $("button.btn-danger");
        if (confirmBtn.exists()) confirmBtn.click();
    }

    /** Navega para a loja. */
    public void clickShop() {
        closeAdIfPresent();
        shopLink.shouldBe(Condition.visible).click();
    }

    /** Clica no pack de avatares "Monsters". */
    public void clickMonstersAvatarPack() {
        closeAdIfPresent();
        monstersAvatarPack.shouldBe(Condition.visible).click();
    }

    /** Compra um avatar na página do pack. */
    public void clickBuyAvatar() {
        try {
            closeAdIfPresent();
            buyButton.shouldBe(Condition.enabled).click();
        } catch (Exception ignored) {
            // botão de compra não disponível (sem moedas ou já comprado)
        }
    }

    /** Confirma a compra do avatar clicando em "Confirm". */
    public void clickConfirmBuy() {
        try {
            confirmBuyButton.shouldBe(Condition.visible).click();
        } catch (Exception ignored) {
            // diálogo de confirmação não apareceu
        }
    }

    /** Clica na aba "Owned". */
    public void clickOwnedTab() {
        closeAdIfPresent();
        ownedTab.shouldBe(Condition.visible).click();
    }

    /** Clica em "Use" para ativar o avatar. */
    public void clickUseButton() {
        closeAdIfPresent();
        useButton.shouldBe(Condition.enabled).click();
    }

    /** Fecha o popup de publicidade se presente. */
    public void closeAdIfPresent() {
        SelenideElement ad = $("div.continue-prompt-text");
        if (ad.exists()) ad.click();
    }

    /** Fecha o popup "welcome back" se presente. */
    public void closeWelcomeBackIfPresent() {
        try {
            $("mat-dialog-container button").click();
        } catch (Exception ignored) {
            // popup não presente, continuar normalmente
        }
    }

    /** Devolve o URL atual. */
    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}