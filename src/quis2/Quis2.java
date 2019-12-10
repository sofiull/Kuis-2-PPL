/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quis2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
/**
 *
 * @author sofiul
 */
public class Quis2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        System.setProperty("webdriver.gecko.driver","/run/media/sofiul/Data/Pelajaran/PPL/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        FirefoxDriver driver = new FirefoxDriver(capabilities);
        
        //selenium
        driver.get("https://demo.1crmcloud.com/index.php");
        WebElement username = driver.findElement(By.name("user_name"));
        username.sendKeys("admin");
        WebElement password = driver.findElement(By.name("user_password"));
        password.sendKeys("admin");
        password.sendKeys(Keys.ENTER);
        Thread.sleep(10000);
        //Avatar 
        WebElement avatar = driver.findElement(By.className("meta-profile"));
        avatar.click();
        //Assert admin
        if(driver.getPageSource().contains(" — admin")){
            System.out.println("Status user: Admin");
        }else{
            System.out.println("Status user: Non-admin");
        }
    }
    
}
