package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator for Finish Button
    By finishButton = By.xpath("//*[@id=\"finish\"]");

    //Method to click on Finish button
    public void clickOnFinish() {
        driver.findElement(finishButton).click();
    }
}
