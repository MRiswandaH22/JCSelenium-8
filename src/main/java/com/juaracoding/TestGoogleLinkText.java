package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestGoogleLinkText {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\juaracoding\\chromedriver.exe");

        //instans Web driver (google)
        WebDriver driver = new ChromeDriver();
        //kalau elementnya selama 10 detik gak ada maka akan error
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //website yang akan di Test
        driver.get("https://www.google.com/");
        System.out.println("Get Url Google.com");

        //tampilan agar besar
        driver.manage().window().maximize();
        System.out.println("Windows Maximaze");

        //mengambil title header
        driver.getTitle();
        System.out.println("Title Header : "+driver.getTitle());

        //menggunakan link text yang ada di element website
        driver.findElement(By.linkText("Basa Bali")).click();
        System.out.println("Bahasa berubah jadi bahasa bali");
    }
}
