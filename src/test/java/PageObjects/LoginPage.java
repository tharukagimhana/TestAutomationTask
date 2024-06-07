package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator for username field
    By uName = By.xpath("//*[@id=\"user-name\"]");

    //Locator for password field
    By pswd = By.xpath("//*[@id=\"password\"]");

    //Locator for login button
    By loginBtn = By.xpath("//*[@id=\"login-button\"]");

    //Locator for login button
    By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");


    //Method to enter username
    public void enterUsername(String user) {
        driver.findElement(uName).sendKeys(user);
    }

    //Method to enter password
    public void enterPassword(String pass) {
        driver.findElement(pswd).sendKeys(pass);
    }

    //Method to click on Login button
    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    //Method to find Error Message
    public By getErrorMessage() {
        return errorMessage;
    }

}
