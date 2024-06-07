package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator for header
    By checkoutbutton = By.xpath("//*[@id=\"checkout\"]");

    //Method to click on Checkout button
    public void clickCheckoutButton() {
        driver.findElement(checkoutbutton).click();
    }

}
