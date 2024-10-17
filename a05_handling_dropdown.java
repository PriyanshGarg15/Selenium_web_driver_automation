import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;

public class DropdownExample {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://www.sugarcrm.com/au/request-demo/");
        driver.manage().window().maximize();

        // Locate the dropdown
        WebElement ddown = driver.findElement(By.name("employees_c"));
        Select select = new Select(ddown);

        // Select options from the dropdown
        select.selectByValue("level11"); // Corrected value (ensure it exists in the dropdown)
        Thread.sleep(2000); // Pause for 2 seconds

        select.selectByVisibleText("51 - 100 employees");
        Thread.sleep(2000); // Pause for 2 seconds

        select.selectByIndex(5); // Ensure index 5 is valid
        Thread.sleep(2000); // Pause for 2 seconds

        // Close the driver
        driver.quit();
    }
}
