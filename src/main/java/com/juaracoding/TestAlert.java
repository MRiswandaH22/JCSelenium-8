package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestAlert {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\juaracoding\\chromedriver.exe");

        //instans Web driver (google)
        WebDriver driver = new ChromeDriver();
        //kalau elementnya selama 10 detik gak ada maka akan error
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //website yang akan di Test
        driver.get("https://demoqa.com/alerts");
        System.out.println("Get Url Demoqa");

        //tampilan agar besar
        driver.manage().window().maximize();
        System.out.println("Windows Maximaze");

        //mengambil title header
        driver.getTitle();
        System.out.println("Title Header : "+driver.getTitle());

        String judul = driver.findElement(By.className("main-header")).getText();
        System.out.println("Page Title : "+judul);

        //driver.findElement(By.id("alertButton")).click();
//        driver.findElement(By.id("timerAlertButton")).click();
//        //untuk delay 5 detik
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Menunggu 5 detik");

        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("Riswanda");
        //untuk delay 3 detik
        System.out.println("Nama dimasukan");

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //menggunakan switct to untuk memencet Ok pada allert
        driver.switchTo().alert().accept();
        System.out.println("Alert Ok Clicked");

        //kalau cancel pakai dismiss
        //driver.switchTo().alert().dismiss();

        //untuk delay 3 detik
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        //untuk menutup chrome
        driver.quit();
        System.out.println("Browser Quit");
    }
}
