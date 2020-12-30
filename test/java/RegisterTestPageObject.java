package pageobjecttesten.story7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;
//Maarten Van Briel, r0746926

public class RegisterTestPageObject {

    private WebDriver driver;
    private String path = "http://localhost:8080/Opdracht1_war_exploded/Controller";
    //private String path = "http://localhost:8080/Controller";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maarten\\Documents\\school\\2020-2021\\Web3\\Selenium\\chromedriver.exe");
        // windows: gebruik dubbele \\ om pad aan te geven
        // hint: zoek een werkende test op van web 2 ...
        //System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        driver = new ChromeDriver();
        driver.get(path+"");
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void succesfull_test_add_brings_you_to_contact_page() {
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.setUseridField("admin");
        indexPage.setPasswordField("t");

        TestRegisterPage testRegisterPage = indexPage.login();
        testRegisterPage.setDateField(LocalDate.now());
        ContactOverviewPage contactOverviewPage = testRegisterPage.submitSuccesful();

        assertEquals("Contact Overview", contactOverviewPage.getTitle());

    }

    @Test
    public void unsuccesfull_test_add_gives_an_error_message() {
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.setUseridField("admin");
        indexPage.setPasswordField("t");

        TestRegisterPage testRegisterPage = indexPage.login();
        testRegisterPage.submitUnsuccesful();
        assertEquals("Add Test", testRegisterPage.getTitle());
        assertTrue(testRegisterPage.hasErrorMessage("No date given"));
    }

    @Test
    public void not_logged_in_user_cant_see_Add_Test_in_navigation() {
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        boolean b = indexPage.hasNavToTestPage();
        assertFalse(b);
    }

    @Test
    public void logged_in_user_can_see_Add_Test_in_navigation() {
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        indexPage.setUseridField("admin");
        indexPage.setPasswordField("t");
        indexPage.loginSamePage();

        boolean b = indexPage.hasNavToTestPage();
        assertTrue(b);
    }
}
