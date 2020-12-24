import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class IndexPage extends Page{

    @FindBy(id="userid")
    private WebElement useridField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(id="logIn")
    private WebElement logInButton;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void setUseridField(String userid) {
        useridField.clear();
        useridField.sendKeys(userid);
    }

    public void setPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public TestRegisterPage login() {
        logInButton.click();
        return PageFactory.initElements(driver, TestRegisterPage.class);
    }

    public void loginSamePage() {
        logInButton.click();
    }

    public boolean hasNavToTestPage() {
        ArrayList<WebElement> listItems=(ArrayList<WebElement>) driver.findElements(By.cssSelector("nav ul li a"));
        boolean found=false;
        for (WebElement listItem:listItems) {
            if (listItem.getText().contains("Add Test")) {
                found=true;
            }
        }
        return found;
    }
}
