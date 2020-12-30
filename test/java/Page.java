package pageobjecttesten.story7;

import org.openqa.selenium.WebDriver;
//Maarten Van Briel, r0746926

public abstract class Page {

    WebDriver driver;
    private String path = "http://localhost:8080/Opdracht1_war_exploded/Controller";
    //String path = "http://localhost:8080/Controller";

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
