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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class testLinks {
    WebDriver driver;
    basePageLinks basePageLinks;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./src/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://demoqa.com/links");
        driver.manage().window().maximize();
        basePageLinks = new basePageLinks(driver);
    }

    @Test
    public void newTabHome() {

        System.out.println("Validación que la página tiene el _target");

        boolean isTargetBlank;
        isTargetBlank = basePageLinks.isLinkTargetBlank();
        Assert.assertTrue(isTargetBlank, "El enlace no tiene el atributo target='_blank'");
        System.out.println("El enlace tiene el atributo target='_blank'");
        basePageLinks.newTabHome();
    }

    @Test
    public void staticLinkCreated() {

        System.out.println("Validación página estática 'Created', return 201");
        basePageLinks.staticLinkPageCreated();

        String response = basePageLinks.getLinkResponse();
        Assert.assertTrue(response.contains("201"), "El enlace no produjo la respuesta esperada");
        System.out.println("Respuesta después de hacer clic en el enlace: " + response);
    }

    @Test
    public void staticLinkNoContent() {

        System.out.println("Validación página estática 'No-Content', return 204");
        basePageLinks.staticLinkPageNoContent();

        String response = basePageLinks.getLinkResponse();
        Assert.assertTrue(response.contains("204"), "El enlace no produjo la respuesta esperada");
        System.out.println("Respuesta después de hacer clic en el enlace: " + response);
    }

    @Test
    public void staticLinkUnauthorized() {

        System.out.println("Validación página estática 'Unauthorized', return 401");
        basePageLinks.staticLinkUnauthorized();

        String response = basePageLinks.getLinkResponse();
        Assert.assertTrue(response.contains("401"), "El enlace no produjo la respuesta esperada");
        System.out.println("Respuesta después de hacer clic en el enlace: " + response);
    }

    @Test
    public void staticLinkInvalidUrl() {

        System.out.println("Validación página estática 'Not-Found', return 404");
        basePageLinks.staticLinkInvalidUrl();

        String response = basePageLinks.getLinkResponse();
        Assert.assertTrue(response.contains("404"), "El enlace no produjo la respuesta esperada");
        System.out.println("Respuesta después de hacer clic en el enlace: " + response);
    }

    @Test
    public void statusCodeValidation() {

        System.out.println("Validación statusCode 'Not-Found', return 404");
        basePageLinks.staticLinkInvalidUrl();

        String response = basePageLinks.getLinkResponse();
        Assert.assertTrue(response.contains("401"), "El enlace no produjo la respuesta esperada");
        System.out.println("Respuesta después de hacer clic en el enlace: " + response);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


