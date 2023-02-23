package com.juaracoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {
    public static void main(String[] args) {
        // kenapa menggunakan dua "\"?, karena escape character, agar satu "\" bisa terbaca
        System.setProperty("webdriver.chrome.driver","C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

//        //bisa juga menggunakan gini
//        String url = "https://www.google.com";
//        driver.get(url);


//        //menutup satu tab
//        driver.close();

        //menutup semua tab
        //agar chrome driver tidak numpuk di task manager

        System.out.println("Get Url");
        driver.manage().window().maximize();  //agar pas dibuka langsung besar
        System.out.println("Maximize Browser");
        System.out.println("Delay 3 Detik");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Browser Quit");
    }
}