package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderPageScooter {

    private WebDriver driver;

    // Приватные локаторы
    private final By ORDER_HEADER = By.xpath(".//div[text()='Для кого самокат']");
    private final By ABOUT_ORDER_HEADER = By.xpath(".//div[text()='Про аренду']");
    private final By ACCEPT_COOKIE_BUTTON = By.xpath(".//button[text()='да все привыкли']");
    private final By NAME_FIELD = By.xpath(".//input[@placeholder='* Имя']");
    private final By SURNAME_FIELD = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By ADDRESS_FIELD = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By SUBWAY_FIELD = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By PHONE_NUMBER_FIELD = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By ORDER_NEXT_BUTTON = By.xpath(".//button[text()='Далее']");
    private final By DATE_FIELD = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By RENTAL_PERIOD_FIELD = By.xpath(".//div[@class='Dropdown-placeholder']");
    private final By COMMENT_FIELD = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By ORDER_CREATE_BUTTON = By.xpath("//div[contains(@class,'Order_Buttons')]/button[text()='Заказать']");
    private final By ORDER_CONFIRM_BUTTON = By.xpath(".//button[text()='Да']");
    private final By CONFIRM_HEADER = By.xpath(".//button[text()='Посмотреть статус']");

    public OrderPageScooter(WebDriver driver) {
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
        assertThat(headerText, is(text));
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