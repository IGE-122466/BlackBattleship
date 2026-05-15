
package iscteiul.ista.blackbattleship;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Class para a User Story 5.
 * <p>
 * Como jogador, quero utilizar o chat integrado durante as partidas,
 * para que possa comunicar e interagir com o meu adversário.
 * </p>
 * Cobre a página principal (arranque do jogo) e a página de jogo (chat).
 * URL base: https://papergames.io/en/battleship
 */
public class UserStory5 {

    private final WebDriver driver;

    /**
     * Botão de consentimento do tratamento de dados (popup inicial).
     */
    @FindBy(css = "p.fc-button-label")
    private WebElement consentButton;

    /**
     * Botão "Play vs bot" para aceder ao jogo onde existe o chat.
     * Seletor retirado do ficheiro TestSuite_110323.side (UserStoryTest5, passo 3).
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
     * Wrapper da área de texto do chat.
     * Seletor retirado do ficheiro TestSuite_110323.side (UserStoryTest5, passo 4).
     */
    @FindBy(css = ".textarea-wrapper")
    private WebElement textareaWrapper;

    /**
     * Campo de texto onde se escreve a mensagem do chat.
     * Seletor retirado do ficheiro TestSuite_110323.side (UserStoryTest5, passo 5).
     */
    @FindBy(id = "mat-input-serverApp0")
    private WebElement messageInput;

    /**
     * Botão de envio da mensagem.
     * <p>
     * NOTA: O seletor do Selenium IDE (.bg-secondary > .mat-mdc-button-touch-target)
     * apontava para uma camada invisível de acessibilidade do Material Design,
     * pelo que foi corrigido para apontar para o elemento pai (button.bg-secondary).
     * O clique é efetuado via JavascriptExecutor para evitar interceções do overlay.
     * </p>
     */
    @FindBy(css = "button.bg-secondary")
    private WebElement sendButton;

    /**
     * Construtor. Inicializa os elementos da página via PageFactory.
     *
     * @param driver instância do WebDriver
     */
    public UserStory5(WebDriver driver) {
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
     * Clica no botão "Play vs bot" para iniciar a partida.
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
     * Escreve uma mensagem no campo de chat.
     *
     * @param message texto a enviar
     */
    public void typeMessage(String message) {
        textareaWrapper.click();
        messageInput.click();
        messageInput.sendKeys(message);
    }

    /**
     * Clica no botão de envio da mensagem.
     * Usa JavascriptExecutor para contornar a camada mat-mdc-button-touch-target.
     */
    public void clickSend() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton);
    }

    /**
     * Devolve o conteúdo atual do campo de texto do chat.
     *
     * @return texto presente no campo
     */
    public String getMessageInputValue() {
        return messageInput.getAttribute("value");
    }
}