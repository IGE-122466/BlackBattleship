package iscteiul.ista.blackbattleship.selenide;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class UserStory18SelenideTest {

    @Test
    public void testarAcessoPaginaDevelopers() {
        open("https://papergames.io/en/");
        UserStory18Selenide us18 = new UserStory18Selenide();

        us18.developersLink.click();

        // Mudar para o separador novo (índice 1) é feito numa única linha
        switchTo().window(1);

        webdriver().shouldHave(com.codeborne.selenide.WebDriverConditions.urlContaining("developers"));
        us18.tituloPrincipal.shouldBe(visible);
    }
}