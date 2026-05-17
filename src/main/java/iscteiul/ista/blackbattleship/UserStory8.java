package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;

public class UserStory8 {

    private WebDriver driver;

    public UserStory8(WebDriver driver) {
        this.driver = driver;
    }

    public void openPlusPlan() {
        driver.get("https://papergames.io/en/pricing/plus");
    }

    public void openGruppoPlan() {
        driver.get("https://papergames.io/en/pricing/gruppo");
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }
}