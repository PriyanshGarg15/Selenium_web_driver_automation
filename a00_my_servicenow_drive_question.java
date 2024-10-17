
// Sure! Here's the complete version of your problem description along with the provided code skeleton.

// Problem Description:
// You are given a link to a product search page on a website, where you can type a product name (e.g., "Laptop") and it will return a table of products. Your task is to implement a class ProductSearch that contains two methods to automate this process using Selenium WebDriver (ChromeDriver or FirefoxDriver).

// Shared Requirements for Both Methods:
// Parameters: Both methods take the following three parameters:

// A WebDriver object.
// The URL of the website’s search page (String searchPageUrl).
// The product name to search for (String productName).
// Steps:

// Navigate to the search page using the provided searchPageUrl.
// Enter the product name into the input textbox with the ID search.
// Submit the search form.
// After submission, you will be redirected to a result page containing a table, where each row represents a product.
// Table Details:

// The table has two columns:
// Product Vendor (name of the seller).
// Product Price (price of the product).
// You need to extract these two columns from the table.

// Method 1: searchProduct
// java
// Copy code
// Map<String, Integer> searchProduct(WebDriver driver, String searchPageUrl, String productName)
// Return Type: Returns a Map<String, Integer> where the key is the product vendor and the value is the product price.
// Objective: Search for the product, extract vendor names and their corresponding prices, and return them as a map.
// Method 2: searchMinimumPricedProduct
// java
// Copy code
// String searchMinimumPricedProduct(WebDriver driver, String searchPageUrl, String productName)
// Return Type: Returns a String representing the name of the product vendor offering the minimum priced product.
// Objective: Find the vendor offering the lowest-priced product and return the vendor's name.
// Provided Code Skeleton:
// java
// Copy code
// package com.hackerrank.selenium;

// import org.openqa.selenium.WebDriver;
// import java.util.HashMap;
// import java.util.Map;

// public class ProductSearch {

//     // Method 1: Search for products and return vendor-price map
//     public static Map<String, Integer> searchProduct(WebDriver driver, String searchPageUrl, String productName) {
//         // TODO: Implement the logic to search products and return vendor-price map
//         return null;
//     }

//     // Method 2: Search for the minimum priced product and return the vendor name
//     public static String searchMinimumPricedProduct(WebDriver driver, String searchPageUrl, String productName) {
//         // TODO: Implement the logic to find and return the vendor of the minimum priced product
//         return null;
//     }
// }
// How to Implement:
// For searchProduct:

// Navigate to the search page URL.
// Find the input box by its ID (search) and enter the product name.
// Submit the search form.
// On the result page, locate the product table.
// Loop through the rows of the table and extract the vendor and price for each product.
// Store these values in a Map<String, Integer> and return it.
// For searchMinimumPricedProduct:

// Follow the same steps to navigate and extract the table.
// Loop through the rows, keeping track of the vendor with the lowest price.
// Return the name of the vendor with the minimum price.
// This skeleton code provides a structure to solve the problem with Selenium WebDriver, and you can now proceed with implementing the logic. Let me know if you need more guidance!



package com.hackerrank.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductSearch {

    // Method 1: Search for products and return a map of vendor and price
    public static Map<String, Integer> searchProduct(WebDriver driver, String searchPageUrl, String productName) {
        // Navigate to the search page URL
        driver.get(searchPageUrl);

        // Enter the product name into the search box (ID: search)
        driver.findElement(By.id("search")).sendKeys(productName);

        // Submit the search form
        driver.findElement(By.id("search")).submit();

        // Create a map to store vendor and price
        Map<String, Integer> productMap = new HashMap<>();

        // Locate the table containing the products
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));

        // Loop through the rows and extract the vendor and price
        for (WebElement row : rows) {
            String vendor = row.findElement(By.xpath("td[1]")).getText();  // Vendor name
            int price = Integer.parseInt(row.findElement(By.xpath("td[2]")).getText());  // Product price
            productMap.put(vendor, price);
        }

        // Return the map of vendors and prices
        return productMap;
    }

    // Method 2: Search for the minimum priced product and return the vendor name
    public static String searchMinimumPricedProduct(WebDriver driver, String searchPageUrl, String productName) {
        // Navigate to the search page URL
        driver.get(searchPageUrl);

        // Enter the product name into the search box (ID: search)
        driver.findElement(By.id("search")).sendKeys(productName);

        // Submit the search form
        driver.findElement(By.id("search")).submit();

        // Variables to track the minimum price and corresponding vendor
        String minPricedVendor = null;
        int minPrice = Integer.MAX_VALUE;

        // Locate the table containing the products
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));

        // Loop through the rows and find the vendor with the minimum price
        for (WebElement row : rows) {
            String vendor = row.findElement(By.xpath("td[1]")).getText();  // Vendor name
            int price = Integer.parseInt(row.findElement(By.xpath("td[2]")).getText());  // Product price

            // Check if this price is lower than the current minimum price
            if (price < minPrice) {
                minPrice = price;
                minPricedVendor = vendor;
            }
        }

        // Return the vendor with the minimum price
        return minPricedVendor;
    }
}
