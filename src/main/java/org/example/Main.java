package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Tema de weekend: https://demoqa.com/sortable sa se sorteze in ordine descrescatoare elementele din pagina folosind selenium / actions / drag and drop.
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/sortable");
        String xPathDescedentChilds = "//*[@id='demo-tabpane-list']//*[contains(@class,'list-group-item')]";
        List<WebElement> descedentChilds = driver.findElements(By.xpath(xPathDescedentChilds));
        Actions actions = new Actions(driver);
        int i = descedentChilds.size() - 1;
        Thread.sleep(3000);

        for (int j = 0; j <= i; j++) {
            actions.dragAndDrop(descedentChilds.get(i), descedentChilds.get(j)).perform();
            Thread.sleep(1000);
            descedentChilds = driver.findElements(By.xpath(xPathDescedentChilds));
        }
        driver.quit();
    }
}

