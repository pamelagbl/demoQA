package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Set;

public class basePageLinks {
    WebDriver driver;

    @FindBy(id = "simpleLink")
    WebElement linkSimple;

    @FindBy(xpath = "dynamicLink")
    WebElement linkDinamic;

    public basePageLinks(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void newTabHome() {
        linkSimple.click();
    }


    public void newTabHome2() {
        linkDinamic.click();
    }
}
