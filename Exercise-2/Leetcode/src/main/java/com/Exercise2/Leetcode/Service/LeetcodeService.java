package com.Exercise2.Leetcode.Service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

@Service
public class LeetcodeService
{
    public String pastingCode()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor) driver;

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        try
        {
            driver.get("https://leetcode.com/playground/new/empty");
            wait.until(ExpectedConditions.elementToBeClickable(By.id("langMenu"))).click();
            WebElement programmingLanguage= driver.findElement(By.xpath("//ul[@class='dropdown-menu']//div[@class='language-dropdown-menu-item' and contains(text(),'Java')]"));
            programmingLanguage.click();

            WebElement codeMirror=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"CodeMirror-lines\"]")));
            wait.until(ExpectedConditions.visibilityOf(codeMirror));

            Actions actions=new Actions(driver);
            actions.moveToElement(codeMirror).click().build().perform();
            actions
                    .keyDown(Keys.CONTROL)
                    .sendKeys("a")
                    .keyUp(Keys.CONTROL)
                    .sendKeys(Keys.DELETE)
                    .build()
                    .perform();

            String classContent=loadClassContent();
            actions.sendKeys(classContent).build().perform();

            WebElement runButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"btn btn-success round run-code-btn\"]")));
            runButton.click();

            WebElement successResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"success result\"]")));
            String success = successResult.getText();

            WebElement outputResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"output\"]")));
            String output = outputResult.getText();

            Thread.sleep(1000);

            return (success + "<br>" + output.replace("\n", "<br>"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            driver.quit();
        }
    }
    private String loadClassContent() {
        String fileLocation = "C:/Users/U6074547/Downloads/Leetcode/Leetcode/src/main/java/com/Exercise2/Leetcode/Week1Class/Exercise_2.java";
        try {
            Path path = Paths.get(fileLocation);
            List<String> numberOfLines = Files.readAllLines(path);
            String code = String.join("", numberOfLines);

            return code;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
