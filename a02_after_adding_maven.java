package ui;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoAutomation {
    public static void main(String[] args) {
//    	System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
    	WebDriverManager.chromedriver().setup();
    	ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.ebay.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='gh-ac']")).sendKeys("mobile");
        driver.findElement(By.xpath("//*[@id='gh-btn']")).click();
        driver.close();
    }
}



//maven code pom.xml
// <project xmlns="http://maven.apache.org/POM/4.0.0"
// 	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
// 	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
// 	<modelVersion>4.0.0</modelVersion>

// 	<groupId>com.rcv</groupId>
// 	<artifactId>SeleniumTraining</artifactId>
// 	<version>0.0.1-SNAPSHOT</version>

// 	<dependencies>
// 		<!-- Selenium WebDriver dependency -->
// 		<dependency>
// 			<groupId>org.seleniumhq.selenium</groupId>
// 			<artifactId>selenium-java</artifactId>
// 			<version>4.14.0</version>
// 		</dependency>

// 		<!--
// 		https://mvnrepository.com/artifact/com.github.bonigarcia/webdrivermanager -->
// 		<!--
// 		https://mvnrepository.com/artifact/com.github.bonigarcia/webdrivermanager -->
// 		<dependency>
// 			<groupId>io.github.bonigarcia</groupId>
// 			<artifactId>webdrivermanager</artifactId>
// 			<version>5.9.2</version>
// 			<scope>test</scope>
// 		</dependency>

// 	</dependencies>
// </project>
