package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//button[contains(., 'Accept') or contains(., 'Aceitar')]")
    public WebElement acceptCookiesButton;

    // Vamos procurar links fixos que sabemos que existem sempre na página
    @FindBy(xpath = "//a[contains(@href, '/store')]")
    public WebElement storeLink;

    @FindBy(xpath = "//a[contains(@href, '/company') or contains(text(), 'Company')]")
    public WebElement companyLink;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}