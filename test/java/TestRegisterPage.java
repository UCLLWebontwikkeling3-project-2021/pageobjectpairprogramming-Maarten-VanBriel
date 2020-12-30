package pageobjecttesten.story7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;

//Maarten Van Briel, r0746926

public class TestRegisterPage extends Page{


    @FindBy(id="date")
    private WebElement dateField;

    @FindBy(id = "addTest")
    private WebElement submit;

    public TestRegisterPage(WebDriver driver) {
        super(driver);
        this.driver.get(getPath()+"?command=TestRegister");
    }

    public void setDateField(LocalDate date) {
        dateField.clear();
        dateField.sendKeys(date.toString());
    }

    public ContactOverviewPage submitSuccesful() {
        submit.click();
        return PageFactory.initElements(driver, ContactOverviewPage.class);
    }

    public void submitUnsuccesful() {
        submit.click();
    }

    public boolean hasErrorMessage (String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        System.out.println(errorMsg.getText());
        return (message.equals(errorMsg.getText()));
    }
}
