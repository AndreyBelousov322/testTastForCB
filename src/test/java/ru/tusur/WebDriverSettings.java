package ru.tusur;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSettings {
    public ChromeDriver driver;
    public WebDriverWait wait;
    final String SiteURL = "https://tusur.ru";
    final String TestEmail = "solipon564@firmjam.com";
    final String TestPassword = "G94VFuhZk_fcAiU";

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void close() {
        driver.quit();
    }
}
