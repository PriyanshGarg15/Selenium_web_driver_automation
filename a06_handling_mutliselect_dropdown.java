import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectDropdown {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        
        // Open the website
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        driver.manage().window().maximize();
        
        // Select the first dropdown
        WebElement ddown = driver.findElement(By.id("select-demo")); // Change to the correct ID
        Select select = new Select(ddown);

        // Get the first selected option
        WebElement firstOption = select.getFirstSelectedOption();
        System.out.println(firstOption.getText());

        // Select an option by index
        select.selectByIndex(5); // Make sure the index is valid
        Thread.sleep(2000);
        
        // Select the multi-select dropdown
        WebElement multiSelectDdown = driver.findElement(By.id("multi-select"));
        Select multiSelect = new Select(multiSelectDdown);
        multiSelect.selectByValue("California");
        Thread.sleep(2000);
        
        // Select another index
        multiSelect.selectByIndex(5);
        Thread.sleep(2000);
        
        // Get all selected options
        List<WebElement> allItems = multiSelect.getAllSelectedOptions();
        System.out.println("Number of selected items: " + allItems.size());
        
        // Deselect all options
        multiSelect.deselectAll();
        Thread.sleep(2000);
        
        // Reselect California and check the count
        multiSelect.selectByValue("California");
        allItems = multiSelect.getAllSelectedOptions();
        System.out.println("Number of selected items after reselecting California: " + allItems.size());
        
        // Deselect the index 5 option
        multiSelect.deselectByIndex(5);
        Thread.sleep(2000);
        
        // Check the count of selected options again
        List<WebElement> allItems1 = multiSelect.getAllSelectedOptions();
        System.out.println("Number of selected items after deselecting index 5: " + allItems1.size());
        
        // Close the driver
        driver.quit();
    }
}
