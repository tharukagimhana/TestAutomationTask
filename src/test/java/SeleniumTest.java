import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SeleniumTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static CheckoutPage checkoutPage;
    public static CheckoutInfoPage checkoutInfoPage;
    public static CheckoutOverviewPage checkoutOverviewPage;

    @BeforeTest
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    void login() throws InterruptedException {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(homePage.gethLabel()).getText(), "Swag Labs");
        driver.close();
    }

    @Test
    void purchaseProduct() throws InterruptedException {
        checkoutPage= new CheckoutPage(driver);
        checkoutInfoPage= new CheckoutInfoPage(driver);
        checkoutOverviewPage=new CheckoutOverviewPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(3000);
        homePage.clickAddCartBackpack();
        homePage.clickAddCartBackLight();
        homePage.clickOnCartButton();
        checkoutPage.clickCheckoutButton();
        checkoutInfoPage.enterFirstName("Standard");
        Thread.sleep(2000);
        checkoutInfoPage.enterLastName("User");
        Thread.sleep(2000);
        checkoutInfoPage.enterPostalCode("20540");
        Thread.sleep(2000);
        checkoutInfoPage.clickOnContinue();
        Thread.sleep(1000);
        checkoutOverviewPage.clickOnFinish();
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    void sortProducts() throws InterruptedException {
        checkoutPage= new CheckoutPage(driver);
        checkoutInfoPage= new CheckoutInfoPage(driver);
        checkoutOverviewPage=new CheckoutOverviewPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(3000);
        homePage.clickOnSortDropdownButton();
        homePage.clickOnSortOption();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(homePage.getSlOnesie()).getText(), "Sauce Labs Onesie");
        driver.close();
    }

    @Test
    void lockedOutUser() throws InterruptedException {
        checkoutPage= new CheckoutPage(driver);
        checkoutInfoPage= new CheckoutInfoPage(driver);
        checkoutOverviewPage=new CheckoutOverviewPage(driver);
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(loginPage.getErrorMessage()).getText(), "Epic sadface: Sorry, this user has been locked out.");
        driver.close();
}






}
