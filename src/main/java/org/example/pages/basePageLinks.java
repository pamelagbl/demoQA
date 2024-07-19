package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class basePageLinks {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "simpleLink")
    WebElement linkSimple;

    @FindBy(id = "created")
    WebElement linkStatic;

    @FindBy(id = "no-content")
    WebElement linkStaticNoContent;

    @FindBy(id = "unauthorized")
    WebElement linkStaticUnauthorized;

    @FindBy(id = "invalid-url")
    WebElement linkStaticInvalidUrl;


    @FindBy(id = "linkResponse")
    WebElement linkResponse;

    public basePageLinks(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void newTabHome() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkSimple);
        linkSimple.click();
    }

    public boolean isLinkTargetBlank() {
        return linkSimple.getAttribute("target").equals("_blank");
    }
    public void staticLinkPageCreated() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkStatic);
        linkStatic.click();
    }

    public void staticLinkPageNoContent() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkStaticNoContent);
        linkStaticNoContent.click();
    }

    public void staticLinkUnauthorized() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkStaticUnauthorized);
        linkStaticUnauthorized.click();
    }

    public void staticLinkInvalidUrl() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkStaticInvalidUrl);
        linkStaticInvalidUrl.click();
    }

    public String getLinkResponse() {
        wait.until(ExpectedConditions.visibilityOf(linkResponse));
        return linkResponse.getText();
    }
}
