package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    public class SeleniumLocator {
        public static void main(String[] args) {
            // kenapa menggunakan dua "\"?, karena escape character, agar satu "\" bisa terbaca
            System.setProperty("webdriver.chrome.driver","C:\\juaracoding\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            //menambahkan untuk fungsi javascrips seperti kasus ini menambahkan scrolling
            JavascriptExecutor js = (JavascriptExecutor) driver;
            driver.get("https://demoqa.com/text-box");

//        //bisa juga menggunakan gini
//        String url = "https://www.google.com";
//        driver.get(url);


//        //menutup satu tab
//        driver.close();

            //menutup semua tab
            //agar chrome driver tidak numpuk di task manager

//            driver.getWindowHandle();
            System.out.println("Get Url");
            driver.manage().window().maximize();  //agar pas dibuka langsung besar
            System.out.println("Maximize Browser");

            //untuk menampilkan title header yang kuping page
            driver.getTitle();

            String titleHeader = driver.getTitle();
            System.out.println("title Heade :" +titleHeader);

            //locator
            //scrapping
            String titlePage = driver.findElement(By.className("main-header")).getText();
            System.out.println("Title Page : "+titlePage);

            // gak jalan pake ini System.out.println(driver.findElement(By.className("main-header")).getText());
            // harus di inisialisi variabel nya dulu

            //keyboard cari id nya di inspect halaman
            driver.findElement(By.id("userName")).sendKeys("Juara Coding");
            driver.findElement(By.id("userEmail")).sendKeys("juaracoding.com");
            driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
            driver.findElement(By.id("permanentAddress")).sendKeys("jakarta");

            //scroll hby pixel (vertikal)
            js.executeScript("window.scrollBy(0,500)");
            //mouse cari di inspect halaman
            driver.findElement(By.id("submit")).click();
            System.out.println("Data Berhasil Disimpan");

            //untuk verifikisasi atau validasi
            //untuk mengecek benerga test casenya sedang berada di halaman test box
            //scraping dulu baru nanti di get text
            //lalu bisa diakali dengan if menggunakan getText juga
            System.out.println(" Test Case Result : ");
            if (titlePage.equals("Text Box")){
                System.out.println("Pass");
            } else {
                System.out.println("Failed");
            }

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
