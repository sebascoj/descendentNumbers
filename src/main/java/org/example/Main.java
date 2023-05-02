package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

//Am incercat sa o rezolv, dar nu am reusit.
public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/sortable");
        String xPathDescedentChilds = "//div[@class ='vertical-list-container mt-4']";
        List<WebElement> descedentChilds = driver.findElements(By.xpath(xPathDescedentChilds));
        Actions actions = new Actions(driver);
        for(int i = descedentChilds.size() - 1 ; i>=0;i--){
            actions.dragAndDrop(descedentChilds.get(i+1),descedentChilds.get(i)).perform();
            driver.quit();


    }
    }
}

