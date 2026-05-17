package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;

public class UserStory13 {

    private WebDriver driver;

    public UserStory13(WebDriver driver) {
        this.driver = driver;
    }

    public void openProfileStats() {
        driver.get("https://papergames.io/en/profile");
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }
}