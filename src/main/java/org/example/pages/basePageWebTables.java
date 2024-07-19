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
import java.util.Arrays;
import java.util.List;

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

    @FindBy(xpath = "//*[@id='submit']")
    WebElement buttonSubmit;

    @FindBy(css = ".rt-tbody .rt-tr-group")
    List<WebElement> rows;

    @FindBy(id = "delete-record-1")
    WebElement deleteButton;

    @FindBy(id = "edit-record-1")
    WebElement editButton;


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
        js.executeScript("arguments[0].scrollIntoView(true);", addButton);

        Actions actions = new Actions(driver);
        actions.moveToElement(addButton).click().perform();

        // Esperar a que el modal esté visible
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
    }

    public boolean newRecord(String firstN, String lastN) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".rt-tbody .rt-tr-group")));

        return rows.stream().anyMatch(row -> row.getText().contains(firstN) && row.getText().contains(lastN));
    }

    public void clickButtonSubmit() {
        buttonSubmit.click();
    }

    public void setDeleteButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", deleteButton);

        Actions actions = new Actions(driver);
        actions.moveToElement(deleteButton).click().perform();
    }

    public boolean validateDeleteRecord(String firstN, String lastN) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".rt-tbody .rt-tr-group")));
        return rows.stream().anyMatch(row -> row.getText().contains(firstN) && row.getText().contains(lastN));
    }

    public void setEditButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", editButton);

        Actions actions = new Actions(driver);
        actions.moveToElement(editButton).click().perform();
    }

    public void enterEditFirstName(String firstname) {
        firstNameField.clear();
        firstNameField.sendKeys(firstname);
    }

    public void enterEditLastName(String lastname) {
        lastNameField.clear();
        lastNameField.sendKeys(lastname);
    }

    public void enterEditAge(String age) {
        ageField.clear();
        ageField.sendKeys(age);
    }

    public void enterEditEmail(String email) {
        userEmailField.clear();
        userEmailField.sendKeys(email);
    }

    public void enterEditSalary(String salary) {
        salaryField.clear();
        salaryField.sendKeys(salary);
    }

    public void enterEditDepartment(String department) {
        departmentField.clear();
        departmentField.sendKeys(department);
    }


}
