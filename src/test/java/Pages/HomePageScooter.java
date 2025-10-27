package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageScooter {

    private WebDriver driver;

    // Приватные локаторы для вопросов и ответов
    private final By QUESTION_PRICE_AND_PAYMENT = By.xpath(".//div[@class='accordion__item'][1]");
    private final By QUESTION_MULTIPLE_SCOOTERS = By.xpath(".//div[@class='accordion__item'][2]");
    private final By QUESTION_RENTAL_TIME = By.xpath(".//div[@class='accordion__item'][3]");
    private final By QUESTION_ORDER_TODAY = By.xpath(".//div[@class='accordion__item'][4]");
    private final By QUESTION_EXTEND_ORDER = By.xpath(".//div[@class='accordion__item'][5]");
    private final By QUESTION_CHARGE = By.xpath(".//div[@class='accordion__item'][6]");
    private final By QUESTION_CANCEL_ORDER = By.xpath(".//div[@class='accordion__item'][7]");
    private final By QUESTION_OUTSIDE_MKAD = By.xpath(".//div[@class='accordion__item'][8]");

    // Приватные локаторы для ответов
    private final By ANSWER_PRICE_AND_PAYMENT = By.id("accordion__panel-0");
    private final By ANSWER_MULTIPLE_SCOOTERS = By.id("accordion__panel-1");
    private final By ANSWER_RENTAL_TIME = By.id("accordion__panel-2");
    private final By ANSWER_ORDER_TODAY = By.id("accordion__panel-3");
    private final By ANSWER_EXTEND_ORDER = By.id("accordion__panel-4");
    private final By ANSWER_CHARGE = By.id("accordion__panel-5");
    private final By ANSWER_CANCEL_ORDER = By.id("accordion__panel-6");
    private final By ANSWER_OUTSIDE_MKAD = By.id("accordion__panel-7");

    // Локаторы для кнопок заказа
    private final By HEADER_ORDER_BUTTON = By.xpath(".//button[text()='Заказать'][1]");
    private final By PAGE_ORDER_BUTTON = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button");

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // Геттеры для вопросов
    public By getQuestionPriceAndPayment() {
        return QUESTION_PRICE_AND_PAYMENT;
    }

    public By getQuestionMultipleScooters() {
        return QUESTION_MULTIPLE_SCOOTERS;
    }

    public By getQuestionRentalTime() {
        return QUESTION_RENTAL_TIME;
    }

    public By getQuestionOrderToday() {
        return QUESTION_ORDER_TODAY;
    }

    public By getQuestionExtendOrder() {
        return QUESTION_EXTEND_ORDER;
    }

    public By getQuestionCharge() {
        return QUESTION_CHARGE;
    }

    public By getQuestionCancelOrder() {
        return QUESTION_CANCEL_ORDER;
    }

    public By getQuestionOutsideMKAD() {
        return QUESTION_OUTSIDE_MKAD;
    }

    // Геттеры для ответов
    public By getAnswerPriceAndPayment() {
        return ANSWER_PRICE_AND_PAYMENT;
    }

    public By getAnswerMultipleScooters() {
        return ANSWER_MULTIPLE_SCOOTERS;
    }

    public By getAnswerRentalTime() {
        return ANSWER_RENTAL_TIME;
    }

    public By getAnswerOrderToday() {
        return ANSWER_ORDER_TODAY;
    }

    public By getAnswerExtendOrder() {
        return ANSWER_EXTEND_ORDER;
    }

    public By getAnswerCharge() {
        return ANSWER_CHARGE;
    }

    public By getAnswerCancelOrder() {
        return ANSWER_CANCEL_ORDER;
    }

    public By getAnswerOutsideMKAD() {
        return ANSWER_OUTSIDE_MKAD;
    }

    public void clickQuestion(By question) {
        driver.findElement(question).click();
    }

    public String getAnswer(By answer) {
        return driver.findElement(answer).getText();
    }

    public void clickHeaderOrderButton() {
        driver.findElement(HEADER_ORDER_BUTTON).click();
    }

    public void clickPageOrderButton() {
        WebElement bigButton = driver.findElement(PAGE_ORDER_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", bigButton);
        driver.findElement(PAGE_ORDER_BUTTON).click();
    }
}