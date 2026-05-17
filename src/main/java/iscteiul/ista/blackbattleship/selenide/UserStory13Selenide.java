package iscteiul.ista.blackbattleship.selenide;

import static com.codeborne.selenide.Selenide.*;

public class UserStory13Selenide {

    public void openProfileStats() {
        open("https://papergames.io/en/profile");
    }

    public String getUrl() {
        return webdriver().driver().url();
    }
}