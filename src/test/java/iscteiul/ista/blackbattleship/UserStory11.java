package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserStory11 {

    // Botão principal da Loja
    @FindBy(xpath = "//a[contains(@href, '/shop')]")
    public WebElement shopButton;

    // Procura por qualquer elemento no ecrã que diga "Coins" ou "Virtual Coins"
    @FindBy(xpath = "//*[contains(text(), 'Virtual Coins') or contains(text(), 'Coins') or contains(text(), 'COINS')]")
    public WebElement virtualCoinsTab;

    public UserStory11(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}