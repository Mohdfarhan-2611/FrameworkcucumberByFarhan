package org.example.Test.Stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class QKartStepdefs extends BaseTest {


    @Given("Launch the qKart url and user is at login page")
    public void launch_the_q_kart_url_and_user_is_at_login_page() {
        setUp();
        driver.get("https://crio-qkart-frontend-qa.vercel.app/");
    }


    @When("User logs in with valid credentials {string} and {string}")
    public void user_logs_in_with_valid_credentials_and(String email, String pass) {

        //Click LoginLink on hompe page
        WebElement loginlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button' and contains(text(),'Login')]")));
        loginlink.click();

        //enter the usernametext
        WebElement usernametext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));
        usernametext.sendKeys(email);

        //enter the password
        WebElement passwordtext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        passwordtext.sendKeys(pass);

        //Click LogintoQKart button
        WebElement loginbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button' and contains(text(),'Login to QKart')]")));
        loginbutton.click();

    }

    @When("User logs in with invalid credentials {string} and {string}")
    public void user_logs_in_with_invalid_credentials_and(String email, String pass) {

        //Click LoginLink on hompe page
        WebElement loginlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button' and contains(text(),'Login')]")));
        loginlink.click();

        //enter the usernametext
        WebElement usernametext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));
        usernametext.sendKeys(email);

        //enter the password
        WebElement passwordtext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        passwordtext.sendKeys(pass);

        //Click LogintoQKart button
        WebElement loginbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button' and contains(text(),'Login to QKart')]")));
        loginbutton.click();

    }

    @Then("User should logged in successfully")
    public void user_should_logged_in_successfully() {
        String successMessage  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='notistack-snackbar']"))).getText();
        try {
            Assert.assertEquals(successMessage, "Logged in successfully");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + e.getMessage());
            throw e; // Rethrow to ensure test failure is reported
        }
        tearDown();
    }

    @Then("User should verify the error message")
    public void user_should_verify_the_error_message() {
        String error_Message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='notistack-snackbar']"))).getText();
        try {
            Assert.assertEquals(error_Message, "Username does not exist");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + e.getMessage());
            throw e; // Rethrow to ensure test failure is reported
        }
        tearDown();
    }

}
