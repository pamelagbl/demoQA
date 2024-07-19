package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class basePage {
    WebDriver driver;

    @FindBy(id = "userName")
    WebElement usernameField;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "currentAddress")
    WebElement current_Address;

    @FindBy(id = "permanentAddress")
    WebElement permanent;

    @FindBy(xpath = "//*[@id='submit']")
    WebElement submitButton;

    public basePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFullName(String username) {
        usernameField.sendKeys(username);
    }

    public void enterEmail(String email) {
        userEmail.sendKeys(email);
    }

    public void enterCurrentAddress(String currentAddress) {
        current_Address.sendKeys(currentAddress);
    }

    public void enterPermanentAddress(String permanentAddress) {
        permanent.sendKeys(permanentAddress);
    }

    public void clickSubmit() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);

        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).click().perform();

        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", submitButton);
        submitButton.click();*/
    }

}

