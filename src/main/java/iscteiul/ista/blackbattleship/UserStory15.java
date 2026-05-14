package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserStory15 {

    @FindBy(xpath = "//*[contains(text(), 'Play with a friend') or contains(text(), 'PLAY WITH A FRIEND')]")
    public WebElement playWithFriendButton;

    @FindBy(css = ".input-xl")
    public WebElement nicknameInput;


    @FindBy(css = ".p-3 > .btn")
    public WebElement confirmButton;

    @FindBy(xpath = "//*[contains(text(), 'Messaging') or contains(text(), 'MESSAGING')]")
    public WebElement chatMenuButton;

    public UserStory15(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}