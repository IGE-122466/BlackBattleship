package iscteiul.ista.blackbattleship.selenide;

import static com.codeborne.selenide.Selenide.*;

public class UserStory12Selenide {

    public void openBoostersPage() {
        open("https://papergames.io/en/shop/boosters");
    }

    public String getUrl() {
        return webdriver().driver().url();
    }
}