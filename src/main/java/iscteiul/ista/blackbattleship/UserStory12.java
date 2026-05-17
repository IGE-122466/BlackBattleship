package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;

public class UserStory12 {

    private WebDriver driver;

    public UserStory12(WebDriver driver) {
        this.driver = driver;
    }

    public void openBoostersPage() {
        driver.get("https://papergames.io/en/shop/boosters");
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }
}
