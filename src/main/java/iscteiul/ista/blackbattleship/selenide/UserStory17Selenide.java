package iscteiul.ista.blackbattleship.selenide;

import static com.codeborne.selenide.Selenide.*;

public class UserStory17Selenide {

    public void openMyTournaments() {
        open("https://papergames.io/en/t/my-tournaments");
    }

    public String getUrl() {
        return webdriver().driver().url();
    }
}
