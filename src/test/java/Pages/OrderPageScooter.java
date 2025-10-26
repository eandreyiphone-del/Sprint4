package Pages;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;
import static ScooterTest.Locators.*;

public class OrderPageScooter {

    private WebDriver driver;

    public OrderPageScooter(WebDriver driver){
        this.driver = driver;
    }

    // Геттер для получения текста заголовка страницы заказа
    public String getOrderHeader() {
        return driver.findElement(ORDER_HEADER).getText();
    }

    // Геттер для получения текста на кнопке для просмотра статуса заказа
    public String getConfirmHeader() {
        return driver.findElement(CONFIRM_HEADER).getText();
    }

    // Метод для проверки открытия страницы
    public void isPageOpen(String headerText, String text) {
        MatcherAssert.assertThat(headerText, is(text));
    }

    // Метод для принятия куки
    public void acceptCookieButtonClick() {
        driver.findElement(ACCEPT_COOKIE_BUTTON).click();
    }

    // Метод для заполнения поля * Имя
    public void setName(String name) {
        driver.findElement(NAME_FIELD).sendKeys(name);
    }

    // Метод для заполнения поля * Фамилия
    public void setSurname(String surname) {
        driver.findElement(SURNAME_FIELD).sendKeys(surname);
    }

    // Метод для заполнения поля * Адрес: куда привезти заказ
    public void setAddress(String address) {
        driver.findElement(ADDRESS_FIELD).sendKeys(address);
    }

    // Метод для заполнения поля * Станция метро
    public void setSubway(String subway) {
        driver.findElement(SUBWAY_FIELD).click();
        driver.findElement(By.xpath(".//div[text()='"+subway+"']")).click();
    }

    // Метод для заполнения поля * Телефон: на него позвонит курьер
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(PHONE_NUMBER_FIELD).sendKeys(phoneNumber);
    }

    // Метод для перехода ко второй странице создания заказа
    public void clickOrderNextButton() {
        driver.findElement(ORDER_NEXT_BUTTON).click();
    }

    // Метод для заполнения поля * Когда привезти самокат
    public void setDate(String date) {
        driver.findElement(DATE_FIELD).sendKeys(date);
    }

    // Метод для заполнения поля Срок аренды
    public void setRentalPeriod(String rentalPeriod) {
        driver.findElement(ABOUT_ORDER_HEADER).click();
        driver.findElement(RENTAL_PERIOD_FIELD).click();
        driver.findElement(By.xpath(".//div[text()='"+rentalPeriod+"']")).click();
    }

    // Метод для заполнения поля Цвет самоката
    public void setColor(String color) {
        driver.findElement(By.xpath(".//label[text()='"+color+"']")).click();
    }

    // Метод для заполнения поля Комментарий для курьера
    public void setComment(String comment) {
        driver.findElement(COMMENT_FIELD).sendKeys(comment);
    }

    // Метод для перехода к подтверждению заказа
    public void clickOrderCreateButton() {
        driver.findElement(ORDER_CREATE_BUTTON).click();
    }

    // Метод для подтверждения заказа
    public void clickOrderConfirmButton() {
        driver.findElement(ORDER_CONFIRM_BUTTON).click();
    }
}