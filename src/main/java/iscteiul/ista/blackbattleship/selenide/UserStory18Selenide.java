package iscteiul.ista.blackbattleship.selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;

public class UserStory18Selenide {
    public SelenideElement developersLink = $(By.linkText("Developers"));
    public SelenideElement tituloPrincipal = $("h1");
}