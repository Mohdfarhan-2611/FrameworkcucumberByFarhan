package org.example.Test.Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SampleTest
{

    @Test
    public void loginlogout()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Launch URL
        driver.get("https://crio-qkart-frontend-qa.vercel.app/");

        //Click LoginLink on hompe page
        WebElement loginlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button' and contains(text(),'Login')]")));
        loginlink.click();

        //enter the usernametext
        WebElement usernametext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']")));
        usernametext.sendKeys("mhdfarhan2611@gmail.com");

        //enter the password
        WebElement passwordtext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']")));
        passwordtext.sendKeys("Acc0@mf#7");

        //Click LogintoQKart button
        WebElement loginbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='button' and contains(text(),'Login to QKart')]")));
        loginbutton.click();


        //Verify user logged in successfully text
        String successMessage  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='notistack-snackbar']"))).getText();
        Assert.assertEquals(successMessage, "Logged in successfully");

        //close the browser
        driver.quit();
    }

}
