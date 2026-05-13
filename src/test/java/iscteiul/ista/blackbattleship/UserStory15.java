package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserStory15 {

    // 1. Botão para jogar com um amigo
    @FindBy(xpath = "//*[contains(text(), 'Play with a friend') or contains(text(), 'PLAY WITH A FRIEND')]")
    public WebElement playWithFriendButton;

    // 2. A caixa de texto do Nickname (Localizador descoberto por ti no Selenium IDE!)
    @FindBy(css = ".input-xl")
    public WebElement nicknameInput;

    // 3. O botão do menu de mensagens
    @FindBy(xpath = "//*[contains(text(), 'Messaging') or contains(text(), 'MESSAGING')]")
    public WebElement chatMenuButton;

    public UserStory15(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}