package org.example.tests;

import org.example.pages.basePageRadioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class testRadioButton {
    WebDriver driver;
    basePageRadioButton basePageRadioButton;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://demoqa.com/radio-button");
        driver.manage().window().maximize();
        basePageRadioButton = new basePageRadioButton(driver);
    }

    @Test
    public void selectRadioButtonTest() {

        String expectedMessage = "Yes";

        basePageRadioButton.yesRadio();

        System.out.println("Radio Button seleccionado");

        basePageRadioButton.getMessage();
        WebElement messageOutput = driver.findElement(By.xpath("//span[@class='text-success']"));
        String messageActual1 = messageOutput.getText().replace("You have selected", "").trim();
        String messageReplace = messageActual1.substring(messageActual1.indexOf(":") + 1).trim();
        Assert.assertEquals(expectedMessage, messageReplace);
        System.out.println("Aserción completada. La respuesta es la deseada");
        System.out.println("Actual: " + expectedMessage + ", Expected: " + messageReplace);
    }
@Test
    public void selectRadioButtonImpressive() {
        String expectedMessage = "Yes";

        basePageRadioButton.impressiveRadio();

        System.out.println("Radio Button seleccionado");

        basePageRadioButton.getMessage();
        WebElement messageOutput = driver.findElement(By.xpath("//span[@class='text-success']"));
        String messageActual1 = messageOutput.getText().replace("You have selected", "").trim();
        String messageReplace = messageActual1.substring(messageActual1.indexOf(":") + 1).trim();
        Assert.assertEquals(expectedMessage, messageReplace);
        System.out.println("Aserción completada. La respuesta es la deseada");
        System.out.println("Actual: " + expectedMessage + ", Expected: " + messageReplace);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
