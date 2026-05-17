package iscteiul.ista.blackbattleship.selenide_122994;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Set;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;
import static com.codeborne.selenide.Condition.*;

public class UserStory16SelenideTest {

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    @Test
    public void clickingGoodiesOpensNewPage() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory16Selenide.URL);
        UserStory16Selenide us16 = new UserStory16Selenide();

        sleep(5000);

        String janelaPrincipal = WebDriverRunner.getWebDriver().getWindowHandle();

        // Goodies
        us16.goodiesNavLink.shouldBe(visible).click();
        sleep(3000);

        Set<String> janelas = WebDriverRunner.getWebDriver().getWindowHandles();
        for (String janela : janelas) {
            if (!janela.equals(janelaPrincipal)) {
                switchTo().window(janela);
                break;
            }
        }

        webdriver().shouldHave(urlContaining("merch.papergames.io"));
    }

    @Test
    public void navigatesToTheRightPage() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory16Selenide.URL);
        UserStory16Selenide us16 = new UserStory16Selenide();

        sleep(5000);

        // Shop
        us16.shopNavLink.shouldBe(visible).click();
        sleep(3000);

        webdriver().shouldHave(urlContaining("/en/shop"));
    }

    @Test
    public void clickingGoodiesInShopOpensNewPage() throws InterruptedException {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 8000;

        open(UserStory16Selenide.URL);
        UserStory16Selenide us16 = new UserStory16Selenide();

        sleep(5000);

        String janelaPrincipal = WebDriverRunner.getWebDriver().getWindowHandle();

        // Shop
        us16.shopNavLink.shouldBe(visible).click();
        sleep(3000);

        // Botão Goodies
        us16.goodiesShopButton.shouldBe(visible).click();
        sleep(3000);

        Set<String> janelas = WebDriverRunner.getWebDriver().getWindowHandles();
        for (String janela : janelas) {
            if (!janela.equals(janelaPrincipal)) {
                switchTo().window(janela);
                break;
            }
        }

        webdriver().shouldHave(urlContaining("merch.papergames.io"));
    }
}
