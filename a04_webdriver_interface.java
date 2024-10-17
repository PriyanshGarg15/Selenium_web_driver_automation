//not a good approach becz we need to change again anad again for diff. browser in below example
package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    public static String browser = "Edge"; // external configuration like XLS, CSV file, etc.

    public static void main(String[] args) {
        ChromeDriver chromeDriver = null;
        EdgeDriver edgeDriver = null;

        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            chromeDriver = new ChromeDriver(); // Use ChromeDriver to initialize
        } else if (browser.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
            edgeDriver = new EdgeDriver(); // Use EdgeDriver to initialize
        }

        if (chromeDriver != null) {
            chromeDriver.get("https://www.saucedemo.com/");
            chromeDriver.findElement(By.id("user-name")).sendKeys("standard_user");
            chromeDriver.findElement(By.id("password")).sendKeys("secret_sauce");
            chromeDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/form/input")).click();
            chromeDriver.close();
        } else if (edgeDriver != null) {
            edgeDriver.get("https://www.saucedemo.com/");
            edgeDriver.findElement(By.id("user-name")).sendKeys("standard_user");
            edgeDriver.findElement(By.id("password")).sendKeys("secret_sauce");
            edgeDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/form/input")).click();
            edgeDriver.close();
        } else {
            System.out.println("Driver initialization failed.");
        }
    }
}


//so we will do:-
package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    public static String browser = "Chrome"; // external configuration like XLS, CSV file, etc.

    public static void main(String[] args) {
        WebDriver driver = null;

        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(); // Use ChromeDriver to initialize the driver
        }

        if (driver != null) { 
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/form/input")).click();
            driver.close();
        } else {
            System.out.println("Driver initialization failed.");
        }
    }
}
