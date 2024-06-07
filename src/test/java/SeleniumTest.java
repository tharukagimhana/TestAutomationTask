import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    public WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public CheckoutPage checkoutPage;
    public CheckoutInfoPage checkoutInfoPage;
    public CheckoutOverviewPage checkoutOverviewPage;

    @BeforeMethod
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @AfterMethod
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void login() throws InterruptedException {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(homePage.gethLabel()).getText(), "Swag Labs");
        homePage.clickOnHomePageDropdownMenu();
        homePage.clickOnLogoutOption();
        Thread.sleep(2000);
    }

    @Test
    void purchaseProduct() throws InterruptedException {
        checkoutPage = new CheckoutPage(driver);
        checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
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
        homePage.clickOnHomePageDropdownMenu();
        homePage.clickOnLogoutOption();
        Thread.sleep(2000);
    }

    @Test
    void sortProducts() throws InterruptedException {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(3000);
        homePage.clickOnSortDropdownButton();
        homePage.clickOnSortOption();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(homePage.getSlOnesie()).getText(), "Sauce Labs Onesie");
        homePage.clickOnHomePageDropdownMenu();
        homePage.clickOnLogoutOption();
        Thread.sleep(2000);
    }

    @Test
    void lockedOutUser() throws InterruptedException {
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(loginPage.getErrorMessage()).getText(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
