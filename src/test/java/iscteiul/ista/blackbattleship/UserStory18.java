package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserStory18 {

    // Tal como o teu gravador apanhou na Linha 4: linkText=Developers
    @FindBy(linkText = "Developers")
    public WebElement developersLink;

    // Título que aparece na página nova para confirmarmos que carregou
    @FindBy(tagName = "h1")
    public WebElement tituloPrincipal;

    public UserStory18(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}