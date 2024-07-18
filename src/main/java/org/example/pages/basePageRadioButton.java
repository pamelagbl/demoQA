package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class basePageRadioButton {
    WebDriver driver;

    @FindBy(xpath = "//label[@for='impressiveRadio']")
    WebElement impressiveButton;

    @FindBy(xpath = "//label[@for='yesRadio']")
    WebElement yesButton;

    @FindBy(css = "span.text-success")
    WebElement successMessage;


    public basePageRadioButton(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void yesRadio() {
        yesButton.click();
    }

    public void impressiveRadio() {
        impressiveButton.click();
    }

    public String getMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }


}
