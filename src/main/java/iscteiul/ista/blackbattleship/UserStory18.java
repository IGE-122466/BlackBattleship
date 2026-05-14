package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserStory18 {


    @FindBy(linkText = "Developers")
    public WebElement developersLink;


    @FindBy(tagName = "h1")
    public WebElement tituloPrincipal;

    public UserStory18(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}