package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator for header
    By hLabel = By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div");

    //Locator for Sauce Labs Backpack
    By slBackpack = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");

    //Locator for Sauce Labs BackLight
    By slBacklight = By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");

    //Locator for Cart Button
    By cartButton = By.xpath("//*[@id=\"shopping_cart_container\"]/a");

    //Locator for SortDropdown Button
    By sortDropdownButton = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select");

    //Locator for Sort Option
    By sortOption = By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]");

    //Locator for Sauce Labs Onesie
    By slOnesie = By.xpath("//*[@id=\"item_2_title_link\"]/div");





    public By gethLabel() {
        return hLabel;
    }

    //Method to click on Add to cart button on Backpack
    public void clickAddCartBackpack() {
        driver.findElement(slBackpack).click();
    }

    //Method to click on Add to cart button on BackLight
    public void clickAddCartBackLight() {
        driver.findElement(slBacklight).click();
    }

    //Method to click on Cart button
    public void clickOnCartButton() {
        driver.findElement(cartButton).click();
    }

    //Method to click on Sort Dropdown button
    public void clickOnSortDropdownButton() {
        driver.findElement(sortDropdownButton).click(); }

    //Method to click on Sort Option
    public void clickOnSortOption() {
        driver.findElement(sortOption).click();
    }

    public By getSlOnesie() {
        return slOnesie;
    }

}


