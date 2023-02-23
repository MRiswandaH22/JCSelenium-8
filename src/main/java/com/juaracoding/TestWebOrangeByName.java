package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestWebOrangeByName {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\juaracoding\\chromedriver.exe");



        //instans Web driver (google)
        WebDriver driver = new ChromeDriver();
        //kalau elementnya selama 10 detik gak ada maka akan error
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //website yang akan di Test
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Get Url Orangermlive");

        //tampilan agar besar
        driver.manage().window().maximize();
        System.out.println("Windows Maximaze");

        //mengambil title header
        driver.getTitle();
        System.out.println("Title Header : "+driver.getTitle());

        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");

        driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
        System.out.println("Button Login Cliked");

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
