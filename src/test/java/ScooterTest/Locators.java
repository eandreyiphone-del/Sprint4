package ScooterTest;

import org.openqa.selenium.By;

public class Locators {

    // HomePageScooter
    public static final By QUESTION_PRICE_AND_PAYMENT = By.xpath(".//div[@class='accordion__item'][1]");
    public static final By QUESTION_MULTIPLE_SCOOTERS = By.xpath(".//div[@class='accordion__item'][2]");
    public static final By QUESTION_RENTAL_TIME = By.xpath(".//div[@class='accordion__item'][3]");
    public static final By QUESTION_ORDER_TODAY = By.xpath(".//div[@class='accordion__item'][4]");
    public static final By QUESTION_EXTEND_ORDER = By.xpath(".//div[@class='accordion__item'][5]");
    public static final By QUESTION_CHARGE = By.xpath(".//div[@class='accordion__item'][6]");
    public static final By QUESTION_CANCEL_ORDER = By.xpath(".//div[@class='accordion__item'][7]");
    public static final By QUESTION_OUTSIDE_MKAD = By.xpath(".//div[@class='accordion__item'][8]");
    public static final By ANSWER_PRICE_AND_PAYMENT = By.id("accordion__panel-0");
    public static final By ANSWER_MULTIPLE_SCOOTERS = By.id("accordion__panel-1");
    public static final By ANSWER_RENTAL_TIME = By.id("accordion__panel-2");
    public static final By ANSWER_ORDER_TODAY = By.id("accordion__panel-3");
    public static final By ANSWER_EXTEND_ORDER = By.id("accordion__panel-4");
    public static final By ANSWER_CHARGE = By.id("accordion__panel-5");
    public static final By ANSWER_CANCEL_ORDER = By.id("accordion__panel-6");
    public static final By ANSWER_OUTSIDE_MKAD = By.id("accordion__panel-7");
    public static final By HEADER_ORDER_BUTTON = By.xpath(".//button[text()='Заказать'][1]");
    public static final By PAGE_ORDER_BUTTON = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button");

    // OrderPageScooter
    public static final By ORDER_HEADER = By.xpath(".//div[text()='Для кого самокат']");
    public static final By ABOUT_ORDER_HEADER = By.xpath(".//div[text()='Про аренду']");
    public static final By ACCEPT_COOKIE_BUTTON = By.xpath(".//button[text()='да все привыкли']");
    public static final By NAME_FIELD = By.xpath(".//input[@placeholder='* Имя']");
    public static final By SURNAME_FIELD = By.xpath(".//input[@placeholder='* Фамилия']");
    public static final By ADDRESS_FIELD = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    public static final By SUBWAY_FIELD = By.xpath(".//input[@placeholder='* Станция метро']");
    public static final By PHONE_NUMBER_FIELD = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    public static final By ORDER_NEXT_BUTTON = By.xpath(".//button[text()='Далее']");
    public static final By DATE_FIELD = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    public static final By RENTAL_PERIOD_FIELD = By.xpath(".//div[@class='Dropdown-placeholder']");
    public static final By COMMENT_FIELD = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    public static final By ORDER_CREATE_BUTTON = By.xpath("//div[contains(@class,'Order_Buttons')]/button[text()='Заказать']");
    public static final By ORDER_CONFIRM_BUTTON = By.xpath(".//button[text()='Да']");
    public static final By CONFIRM_HEADER = By.xpath(".//button[text()='Посмотреть статус']");
}
