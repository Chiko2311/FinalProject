package Utils;


import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BrowserAction {
    public static WebDriver driver;

    @BeforeMethod (description = "Chrome ბრაუზერის გახსნა")
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod (description = "Chrome ბრაუზერის დახურვა")
    public void closeBrowser(){
        driver.quit();


    }
}

