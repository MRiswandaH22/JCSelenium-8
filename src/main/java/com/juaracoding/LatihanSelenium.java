package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LatihanSelenium {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://demoqa.com/checkbox");

        System.out.println("Get Url");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");

        driver.getTitle();
        String titleHeader = driver.getTitle();
        System.out.println("title Header :" +titleHeader);

        //pake xpath bukan pake id atau class
        driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/span/button")).click();
        driver.findElement(By.xpath("//*[@id='tree-node']/ol/li/ol/li[3]/span/label/span[3]")).click();
        String txtDownload = driver.findElement(By.xpath("//*[@id='result']/span[2]")).getText();
        System.out.println(txtDownload);
        js.executeScript("window.scrollBy(0,500)");

        System.out.println("Delay 3 Detik");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Browser Quit");

        //ini yang string download
        //*[@id="result"]/span[2]

        //ini yang toggle button
        //*[@id="tree-node"]/ol/li/span/button
    }
}
