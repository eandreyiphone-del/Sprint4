package ScooterTest;

import Pages.HomePageScooter;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

import static ScooterTest.Constants.*;
import static ScooterTest.Locators.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class FAQTest {

    private WebDriver driver;
    private By question;
    private By answer;
    private String expectedText;

    public FAQTest(By question, By answer, String expectedText) {
        this.question = question;
        this.answer = answer;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getDataSetForFAQ() {
        return Arrays.asList(new Object[][]{
                {QUESTION_PRICE_AND_PAYMENT, ANSWER_PRICE_AND_PAYMENT, TEXT_1},
                {QUESTION_MULTIPLE_SCOOTERS, ANSWER_MULTIPLE_SCOOTERS, TEXT_2},
                {QUESTION_RENTAL_TIME, ANSWER_RENTAL_TIME, TEXT_3},
                {QUESTION_ORDER_TODAY, ANSWER_ORDER_TODAY, TEXT_4},
                {QUESTION_EXTEND_ORDER, ANSWER_EXTEND_ORDER, TEXT_5},
                {QUESTION_CHARGE, ANSWER_CHARGE, TEXT_6},
                {QUESTION_CANCEL_ORDER, ANSWER_CANCEL_ORDER, TEXT_7},
                {QUESTION_OUTSIDE_MKAD, ANSWER_OUTSIDE_MKAD, TEXT_8}
        });
    }

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
        objHomePage.clickQuestion(question);
        String actualAnswer = objHomePage.getAnswer(answer);
        assertThat(actualAnswer, is(expectedText));
    }

    @After
    public void teardown() {
        driver.quit();
    }
}