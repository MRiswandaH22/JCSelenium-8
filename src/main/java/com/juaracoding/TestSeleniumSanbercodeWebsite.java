package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSeleniumSanbercodeWebsite {
    public static void main(String[] args) {

        //Test Website Sanbercode/Register

        //locasi webdriver pada laptop
        System.setProperty("webdriver.chrome.driver","C:\\juaracoding\\chromedriver.exe");

        //instans Web driver (google)
        WebDriver driver = new ChromeDriver();

        //website yang akan di Test
        driver.get("https://sanbercode.com/register");
        System.out.println("Get Url Sanbercode");

        //tampilan agar besar
        driver.manage().window().maximize();
        System.out.println("Windows Maximaze");

        //mengambil title header
        driver.getTitle();
        System.out.println("Title Header : "+driver.getTitle());

        //locator dan scrapping
        //locator adalah sebuah alamat element yang ada dalam target website
        //scrapping adalah mengambil data dari sebuah website yang dituju
        //menangkap tulisan "Pendaftaran sanbercode"
        String tulisan = driver.findElement(By.xpath("//*[@id='1']/div[1]/div[1]/h6")).getText();
        System.out.println(tulisan);

        //menginput pada kolom regiter (masukan email)
        WebElement element1 = driver.findElement(By.id("email")); element1.sendKeys("mriswandahasan22@gmail.com");
        ////menginput pada kolom regiter (masukan password)
        WebElement element2 = driver.findElement(By.cssSelector("input#password")); element2.sendKeys("apaweh");
        //menginput pada kolom regiter (re-enter password)
        WebElement element3 = driver.findElement(By.id("ulangPassword")); element3.sendKeys("apaweh");


        //Validasi
        //saat reenter password tidak sesuai atau nilainya tidak ada, maka tidak akan diklikbutton
        String value1 = element2.getAttribute("apaweh");
        String value2 = element3.getAttribute("apaweh");

        //element2.getText() != element3.getText()
        if (value1 != value2){
            System.out.println("Data berbeda");
            driver.close();
        }else {
            //menekan tombol (lanjutkan)
            driver.findElement(By.xpath("//*[@id=\"1\"]/div[3]/button")).click();
            System.out.println("Data berhasil diinput");
        }

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
