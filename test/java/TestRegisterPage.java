import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.util.Date;

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
        WebElement errorMsg = driver.findElement(By.id("error-for-date"));
        return (message.equals(errorMsg.getText()));
    }
}
