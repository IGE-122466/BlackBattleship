package iscteiul.ista.blackbattleship.selenide;

import static com.codeborne.selenide.Selenide.*;

public class UserStory3Selenide {

    public void open() {
        com.codeborne.selenide.Selenide.open("https://papergames.io/en/battleship");
    }

    public String getUrl() {
        return webdriver().driver().url();
    }

}
