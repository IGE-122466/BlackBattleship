package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserStory7 {

    @FindBy(xpath = "//a[contains(@href, '/shop')]")
    public WebElement shopButton;

    @FindBy(xpath = "//a[contains(@href, '/shop/emojis')]")
    public WebElement emojisTab;

    @FindBy(xpath = "//a[contains(@href, '/shop/avatars')]")
    public WebElement avatarsTab;

    public UserStory7(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}