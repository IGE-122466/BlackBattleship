package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Class para a User Story 1.
 * <p>
 * Como jogador, quero iniciar uma partida de Batalha Naval contra um bot,
 * para que possa jogar de forma rápida e testar a minha estratégia.
 * </p>
 * URL: https://papergames.io/en/battleship
 */
public class UserStory1 {

    private final WebDriver driver;

    /**
     * Botão de consentimento do tratamento de dados (popup inicial).
     */
    @FindBy(css = "p.fc-button-label")
    private WebElement consentButton;

    /**
     * Botão "Play vs bot" na página principal do Battleship.
     * Seletor retirado do ficheiro TestSuite_110323.side (UserStoryTest1).
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
     * Construtor. Inicializa os elementos da página via PageFactory.
     *
     * @param driver instância do WebDriver
     */
    public UserStory1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Aceita o popup de consentimento do tratamento de dados.
     */
    public void acceptConsent() {
        consentButton.click();
    }

    /**
     * Clica no botão "Play vs bot" para iniciar uma partida contra o bot.
     */
    public void clickPlayVsBot() {
        playVsBotButton.click();
    }

    /**
     * Insere o nickname no campo de texto do popup.
     *
     * @param nickname nome a utilizar na partida
     */
    public void enterNickname(String nickname) {
        nicknameInput.clear();
        nicknameInput.sendKeys(nickname);
    }

    /**
     * Clica em "Continue" para confirmar o nickname e iniciar o jogo.
     */
    public void clickContinue() {
        continueButton.click();
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