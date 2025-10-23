package ScooterTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static ScooterTest.Сonstants.*;

public class FAQTest {

    private WebDriver driver;

    @Test
    public void FAQCorrectAnswerText() {
        // Создать веб-драйвер для Google Chrome
        driver = new ChromeDriver();
        // Открыть страницу домашнюю Яндекс Самокат
        driver.get("https://qa-scooter.praktikum-services.ru");

        // Найти и нажать кнопку закрытия cookie
        WebElement closeCookiePopupButton = driver.findElement(By.id("rcc-confirm-button"));
        closeCookiePopupButton.click();

        // Проскролить страницу до появления таблицы с вопросами
        WebElement tableFAQ = driver.findElement(By.className("accordion"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);
        // Создать объект класса с домашней страницей
        HomePageScooter objHomePage = new HomePageScooter(driver);
        // Проверка соответствия текста ответа с ожидаемым
        objHomePage.clickQuestion1();
        objHomePage.isCorrectText(objHomePage.getAnswer1(), Text1);
        objHomePage.clickQuestion2();
        objHomePage.isCorrectText(objHomePage.getAnswer2(), Text2);
        objHomePage.clickQuestion3();
        objHomePage.isCorrectText(objHomePage.getAnswer3(), Text3);
        objHomePage.clickQuestion4();
        objHomePage.isCorrectText(objHomePage.getAnswer4(), Text4);
        objHomePage.clickQuestion5();
        objHomePage.isCorrectText(objHomePage.getAnswer5(), Text5);
        objHomePage.clickQuestion6();
        objHomePage.isCorrectText(objHomePage.getAnswer6(), Text6);
        objHomePage.clickQuestion7();
        objHomePage.isCorrectText(objHomePage.getAnswer7(), Text7);
        objHomePage.clickQuestion8();
        objHomePage.isCorrectText(objHomePage.getAnswer8(), Text8);

    }
    @After
    public void teardown() {
        driver.quit();
    }
}