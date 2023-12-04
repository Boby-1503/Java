package com.clarivate.Clarivate.Service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.util.*;

@Service
public class ClarivateService
{
    public Map<String,List<String>>getAllData()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((20)));
        try {
            driver.get("https://clarivate.com/");
            wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-close-btn-container"))).click();
            WebElement productsAndServicesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class=\"nav-link\"])[5]")));
            productsAndServicesLink.click();
//            WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"megamenu-row row\"]")));

           List<WebElement> subTitles=driver.findElements(By.xpath("//div[@class=\"subnav-col border-left\"]"));
            Map<String,List<String>> productService=new LinkedHashMap<>();
            for(WebElement subTitle:subTitles)
            {
                WebElement TitleElements=subTitle.findElement(By.xpath("//p[@class=\"product-category-title mb-0 pr-2\"]"));
                String TitleName=TitleElements.getText();

                List<WebElement> subTitleElements=subTitle.findElements(By.xpath("//div[@class=\"subnav-items mb-1 pr-2\"]"));
                List<String>subTitleList=subTitleElements.stream().map(WebElement::getText).collect(ArrayList::new,ArrayList::add,ArrayList::addAll);
                productService.put(TitleName,subTitleList);
            }
            printStructuredOutput(productService);

            // Close the browser
            driver.quit();
            return productService;

        }
        catch(Exception e) {
            e.printStackTrace();
            driver.quit();
            return null;
        }




    }

    private void printStructuredOutput(Map<String,List<String>>productService)
    {
        productService.forEach((category, subcategories) ->
        {
            System.out.println(category);
            subcategories.forEach(subcategory -> System.out.println("\t" + subcategory));
        });
    }


}
