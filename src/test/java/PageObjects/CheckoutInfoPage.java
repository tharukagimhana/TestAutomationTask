package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage {

    WebDriver driver;

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator for Firstname field
    By firstName = By.xpath("//*[@id=\"first-name\"]");

    //Locator for Lastname field
    By lastName = By.xpath("//*[@id=\"last-name\"]");

    //Locator for Zip/Postal code field
    By postalCode = By.xpath("//*[@id=\"postal-code\"]");

    //Locator for continue button
    By continueButton = By.xpath("//*[@id=\"continue\"]");

    //Method to enter Firstname
    public void enterFirstName(String user) {
        driver.findElement(firstName).sendKeys(user);
    }

    //Method to enter Lastname
    public void enterLastName(String user) {
        driver.findElement(lastName).sendKeys(user);
    }

    //Method to enter Postal Code
    public void enterPostalCode(String user) {
        driver.findElement(postalCode).sendKeys(user);
    }

    //Method to click on Continue button
    public void clickOnContinue() {
        driver.findElement(continueButton).click();
    }

}
