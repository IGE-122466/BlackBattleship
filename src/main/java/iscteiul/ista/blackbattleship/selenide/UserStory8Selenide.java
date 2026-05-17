package iscteiul.ista.blackbattleship.selenide;

import static com.codeborne.selenide.Selenide.*;

public class UserStory8Selenide {

    public void openPlusPlan() {
        open("https://papergames.io/en/pricing/plus");
    }

    public void openGruppoPlan() {
        open("https://papergames.io/en/pricing/gruppo");
    }

    public String getUrl() {
        return webdriver().driver().url();
    }
}