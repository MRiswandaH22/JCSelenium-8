package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TestSelectMenu {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //kalau elementnya selama 10 detik gak ada maka akan error
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //website yang akan di Test
        driver.get("https://demoqa.com/select-menu");
        System.out.println("Get Url Demoqa");

        //tampilan agar besar
        driver.manage().window().maximize();
        System.out.println("Windows Maximaze");

        String url = "https://demoqa.com/select-menu";
        driver.get(url);
        //mengambil title header
        driver.getTitle();
        System.out.println("Title Header : "+driver.getTitle());

        String judul = driver.findElement(By.className("main-header")).getText();
        System.out.println("Page Title : "+judul);

        WebElement selectColor = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(selectColor);

        select.selectByValue("10");
        select.selectByIndex(9);
        select.selectByVisibleText("Black");
        System.out.println("Test Select");
        System.out.println("=== Delay 3 Detik ===");

        //untuk delay 3 detik
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
