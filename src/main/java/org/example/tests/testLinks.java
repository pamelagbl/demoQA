package org.example.tests;

import org.example.pages.basePageLinks;
import org.example.pages.basePageRadioButton;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class testLinks {
    WebDriver driver;
    basePageLinks basePageLinks;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://demoqa.com/links");
        driver.manage().window().maximize();
        basePageLinks = new basePageLinks(driver);
    }

    @Test
    public void newTabHome() {
        basePageLinks.newTabHome();
        System.out.println("Radio Button seleccionado");

        String newLink = driver.getWindowHandle();
        Set<String> allTabs = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>((allTabs));
        for (String tab : tabs) {
            if (!tab.equals(newLink)) {
                driver.switchTo().window(tab);
                break;
            }
        }
        String expectedUrl = "https://demoqa.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "The new tab did not open the expected URL");

        // Cierra la nueva pestaña y vuelve a la pestaña original
        driver.close();
        driver.switchTo().window(newLink);
    }
}


