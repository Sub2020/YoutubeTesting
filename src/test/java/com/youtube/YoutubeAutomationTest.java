package com.youtube;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class YoutubeAutomationTest {

    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Devraj\\IdeaProjects\\YoutubeTesting\\.idea\\WebDriver\\MsEdge\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void searchOnYouTube() {
        // Find the search bar and enter a search query
        driver.findElement(By.name("search_query")).sendKeys("Subrat Devkota");

        // Press Enter to perform the search
        driver.findElement(By.name("search_query")).sendKeys(Keys.RETURN);

        // Wait for the search results to load (you might need to adjust the wait time)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify if the search results contain the expected keyword
        assertTrue(driver.getPageSource().contains("Subrat Devkota"));
    }

    @After
    public void tearDown() {
        // Close the browser window after the test
        if (driver != null) {
            driver.quit();
        }
    }
}