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
