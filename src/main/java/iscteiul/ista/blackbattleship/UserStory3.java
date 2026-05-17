package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;

public class UserStory3 {

    private WebDriver driver;

    public UserStory3(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://papergames.io/en/battleship");
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}