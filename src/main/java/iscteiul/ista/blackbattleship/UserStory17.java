package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;

public class UserStory17 {

    private WebDriver driver;

    public UserStory17(WebDriver driver) {
        this.driver = driver;
    }

    public void openMyTournaments() {
        driver.get("https://papergames.io/en/t/my-tournaments");
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }
}