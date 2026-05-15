package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserStory2 {

    // Procura o botão principal para jogar com um amigo
    @FindBy(xpath = "//*[contains(text(), 'Play with a friend') or contains(text(), 'PLAY WITH A FRIEND')]")
    public WebElement playWithFriendButton;

    // Procura o botão de copiar o link no modal que aparece a seguir
    @FindBy(xpath = "//*[contains(text(), 'Copy') or contains(text(), 'COPY')]")
    public WebElement copyLinkButton;

    public UserStory2(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}