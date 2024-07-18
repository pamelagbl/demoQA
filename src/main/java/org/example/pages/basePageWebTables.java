package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class basePageWebTables {
    WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "addNewRecordButton")
    WebElement addButton;

    @FindBy(id = "firstName")
    WebElement firstNameField;

    @FindBy(id = "lastName")
    WebElement lastNameField;

    @FindBy(id = "age")
    WebElement ageField;

    @FindBy(id = "userEmail")
    WebElement userEmailField;

    @FindBy(id = "salary")
    WebElement salaryField;

    @FindBy(id = "department")
    WebElement departmentField;

    @FindBy(xpath ="//*[@id='submit']")
    WebElement buttonSubmit;


    public basePageWebTables(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstname) {
        firstNameField.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        lastNameField.sendKeys(lastname);
    }

    public void enterAge(String age) {
        ageField.sendKeys(age);
    }

    public void enterEmail(String email) {
        userEmailField.sendKeys(email);
    }

    public void enterSalary(String salary) {
        salaryField.sendKeys(salary);
    }

    public void enterDepartment(String department) {
        departmentField.sendKeys(department);
    }

    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickButtonAdd() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addButton);
        addButton.click();

    }

    public void clickButtonSubmit() {
        buttonSubmit.click();
    }
    /*public String getMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }*/
}
