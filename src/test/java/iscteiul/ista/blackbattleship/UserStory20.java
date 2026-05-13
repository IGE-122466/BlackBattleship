package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Class para a User Story 20.
 * <p>
 * Como utilizador criativo, quero poder alterar o meu avatar (/shop/avatars/owned),
 * para não jogar sempre com o mesmo.
 * </p>
 * Fluxo: consent → play vs bot → nickname → abort game → shop → avatares → Use.
 * URL base: https://papergames.io/en/battleship
 */
public class UserStory20 {

    private final WebDriver driver;

    /**
     * Botão de consentimento do tratamento de dados (popup inicial).
     */
    @FindBy(css = "p.fc-button-label")
    private WebElement consentButton;

    /**
     * Botão "Play vs bot" na página principal do Battleship.
     */
    @FindBy(css = ".w-100:nth-child(2) > .btn .flex-grow-1")
    private WebElement playVsBotButton;

    /**
     * Campo de texto para inserir o nickname (popup após clicar Play vs bot).
     */
    @FindBy(css = "input[placeholder='Nickname']")
    private WebElement nicknameInput;

    /**
     * Botão "Continue" para confirmar o nickname e iniciar o jogo.
     */
    @FindBy(css = "button[type='submit'].btn-secondary")
    private WebElement continueButton;

    /**
     * Link "Shop" no menu de navegação principal.
     * Seletor retirado do ficheiro TestSuite_110323.side (UserStoryTest20).
     */
    @FindBy(linkText = "Shop")
    private WebElement shopLink;

    /**
     * Imagem do pack de avatares "Monsters" na página da loja.
     * Seletor retirado do ficheiro TestSuite_110323.side (UserStoryTest20).
     */
    @FindBy(css = ".box-shadow-1:nth-child(2) .w-75")
    private WebElement monstersAvatarPack;

    /**
     * Aba "Owned" na página de detalhe do pack de avatares.
     * Seletor retirado do ficheiro TestSuite_110323.side (UserStoryTest20).
     */
    @FindBy(css = "#mat-tab-group-serverApp0-label-2 > .mdc-tab__content")
    private WebElement ownedTab;

    /**
     * Botão "Use" para ativar o avatar selecionado.
     * Seletor retirado do ficheiro TestSuite_110323.side (UserStoryTest20).
     */
    @FindBy(xpath = "//button[contains(.,'Use')]")
    private WebElement useButton;

    /**
     * Construtor. Inicializa os elementos da página via PageFactory.
     *
     * @param driver instância do WebDriver
     */
    public UserStory20(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Aceita o popup de consentimento do tratamento de dados.
     */
    public void acceptConsent() {
        closeAdIfPresent();
        consentButton.click();
    }

    /**
     * Clica no botão "Play vs bot" para iniciar uma partida.
     */
    public void clickPlayVsBot() {
        closeAdIfPresent();
        playVsBotButton.click();
    }

    /**
     * Insere o nickname no campo de texto do popup.
     *
     * @param nickname nome a utilizar na partida
     */
    public void enterNickname(String nickname) {
        closeAdIfPresent();
        nicknameInput.clear();
        nicknameInput.sendKeys(nickname);
    }

    /**
     * Clica em "Continue" para confirmar o nickname e iniciar o jogo.
     */
    public void clickContinue() {
        closeAdIfPresent();
        continueButton.click();
    }

    /**
     * Fecha o popup "Estamos excitados por te ver de novo" se este aparecer.
     * Ocorre quando o nickname já foi utilizado anteriormente.
     * Usa mat-dialog-container para garantir que apanha o botão correto.
     */
    public void closeWelcomeBackIfPresent() {
        try {
            WebElement btn = driver.findElement(
                    By.cssSelector("mat-dialog-container button"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
        } catch (NoSuchElementException ignored) {
            // popup não apareceu, continuar normalmente
        }
    }

    /**
     * Injeta um MutationObserver em JavaScript que fecha automaticamente
     * o popup de publicidade sempre que este aparecer, durante toda a duração do teste.
     * Deve ser chamado uma vez no início do teste, após a página carregar.
     */
    public void startAdAutoCloser() {
        ((JavascriptExecutor) driver).executeScript(
                "const observer = new MutationObserver(() => {" +
                        "  const ad = document.querySelector('div.continue-prompt-text');" +
                        "  if (ad) ad.click();" +
                        "});" +
                        "observer.observe(document.body, { childList: true, subtree: true });"
        );
    }

    /**
     * Fecha o popup de publicidade se este aparecer.
     * Alternativa pontual ao {@link #startAdAutoCloser()}.
     */
    public void closeAdIfPresent() {
        try {
            driver.findElement(By.cssSelector("div.continue-prompt-text")).click();
        } catch (NoSuchElementException ignored) {
            // publicidade não apareceu, continuar normalmente
        }
    }

    /**
     * Clica em "Abort game" para abandonar a partida.
     * Tenta primeiro clique normal; se o elemento ficar stale, retenta via JavascriptExecutor.
     */
    public void clickAbortGame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until((ExpectedCondition<Boolean>) d -> {
            try {
                WebElement btn = d.findElement(By.cssSelector("button.btn-outline-dark"));
                btn.click();
                return true;
            } catch (StaleElementReferenceException e) {
                return false;
            }
        });
    }

    /**
     * Confirma o abandono da partida clicando no botão "Abort game" de confirmação (btn-danger).
     * É opcional — se o botão não aparecer (ex: o abort já foi concluído), continua normalmente.
     */
    public void clickConfirmAbort() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button.btn-danger")));
            btn.click();
        } catch (Exception ignored) {
            // confirmação não apareceu — abort já concluído
        }
    }

    /**
     * Clica no link "Shop" para navegar para a loja.
     */
    public void clickShop() {
        closeAdIfPresent();
        shopLink.click();
    }

    /**
     * Clica no pack de avatares "Monsters".
     */
    public void clickMonstersAvatarPack() {
        closeAdIfPresent();
        monstersAvatarPack.click();
    }

    /**
     * Clica na aba "Owned" para ver os avatares já possuídos.
     */
    public void clickOwnedTab() {
        closeAdIfPresent();
        ownedTab.click();
    }

    /**
     * Clica no botão "Use" para ativar o avatar selecionado.
     */
    public void clickUseButton() {
        closeAdIfPresent();
        useButton.click();
    }

    /**
     * Devolve o URL atual da página.
     *
     * @return URL atual
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}