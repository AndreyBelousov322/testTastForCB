package ru.tusur;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;




public class TestTusurRu extends WebDriverSettings{

    @Test
    public void Title() {
        driver.get(SiteURL);

        assertEquals(driver.getTitle(), "Томский государственный университет систем управления и радиоэлектроники");
    }

    @Test
    public void LogIn() {
        driver.get(SiteURL);
        driver.findElement(By.xpath("//li [@class=\"tusur-cdn-sign-in\"]")).click();
        driver.findElement(By.id("user_email")).sendKeys(TestEmail);
        driver.findElement(By.id("user_password")).sendKeys(TestPassword, Keys.ENTER);
        assertEquals(driver.findElement(By.className("tusur-cdn-username")).getText(),"Тест Т. Т.");
    }

    @Test
    public void LogInWithIncorrectEmail() {
        driver.get(SiteURL);
        driver.findElement(By.xpath("//li [@class=\"tusur-cdn-sign-in\"]")).click();
        driver.findElement(By.id("user_email")).sendKeys(TestEmail + "2");
        driver.findElement(By.id("user_password")).sendKeys(TestPassword, Keys.ENTER);

        assertEquals(driver.findElement(By.xpath("//div[@class=\"alert flash_message alert-danger\"]")).getText(), "Неверный email или пароль.");
    }

    @Test
    public void LogInWithIncorrectPassword() {
        driver.get(SiteURL);
        driver.findElement(By.xpath("//li [@class=\"tusur-cdn-sign-in\"]")).click();
        driver.findElement(By.id("user_email")).sendKeys(TestEmail);
        driver.findElement(By.id("user_password")).sendKeys(TestPassword + "ff", Keys.ENTER);

        assertEquals(driver.findElement(By.xpath("//div[@class=\"alert flash_message alert-danger\"]")).getText(), "Неверный email или пароль.");
    }

    @Test
    public void LogOut() {
        driver.get(SiteURL);
        driver.findElement(By.xpath("//li [@class=\"tusur-cdn-sign-in\"]")).click();
        driver.findElement(By.id("user_email")).sendKeys(TestEmail);
        driver.findElement(By.id("user_password")).sendKeys(TestPassword, Keys.ENTER);
        driver.findElement(By.xpath("//span[@class=\"tusur-cdn-username\"]")).click();
        driver.findElement(By.xpath("//a[@data-method=\"delete\"]")).click();
        assertEquals((driver.findElement(By.xpath("//div[@class=\"js-flash flash flash-notice\"]")).getText()), "Выход из системы выполнен.");
    }

}
