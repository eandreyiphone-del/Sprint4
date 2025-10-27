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
                {new HomePageScooter(null).getQuestionPriceAndPayment(), new HomePageScooter(null).getAnswerPriceAndPayment(), FAQ_PRICE_AND_PAYMENT_TEXT},
                {new HomePageScooter(null).getQuestionMultipleScooters(), new HomePageScooter(null).getAnswerMultipleScooters(), FAQ_MULTIPLE_SCOOTERS_TEXT},
                {new HomePageScooter(null).getQuestionRentalTime(), new HomePageScooter(null).getAnswerRentalTime(), FAQ_RENTAL_TIME_TEXT},
                {new HomePageScooter(null).getQuestionOrderToday(), new HomePageScooter(null).getAnswerOrderToday(), FAQ_ORDER_TODAY_TEXT},
                {new HomePageScooter(null).getQuestionExtendOrder(), new HomePageScooter(null).getAnswerExtendOrder(), FAQ_EXTEND_ORDER_TEXT},
                {new HomePageScooter(null).getQuestionCharge(), new HomePageScooter(null).getAnswerCharge(), FAQ_CHARGE_TEXT},
                {new HomePageScooter(null).getQuestionCancelOrder(), new HomePageScooter(null).getAnswerCancelOrder(), FAQ_CANCEL_ORDER_TEXT},
                {new HomePageScooter(null).getQuestionOutsideMKAD(), new HomePageScooter(null).getAnswerOutsideMKAD(), FAQ_OUTSIDE_MKAD_TEXT}
        });
    }

    @Test
    public void FAQCorrectAnswerText() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");

        WebElement closeCookiePopupButton = driver.findElement(By.id("rcc-confirm-button"));
        closeCookiePopupButton.click();

        WebElement tableFAQ = driver.findElement(By.className("accordion"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickQuestion(question);
        String actualAnswer = objHomePage.getAnswer(answer);
        assertThat(actualAnswer, is(expectedText));
    }

    @After
    public void teardown() {
            driver.quit();
        }
    }