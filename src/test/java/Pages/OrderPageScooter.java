package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(CONFIRM_HEADER));
        return confirmButton.getText();
    }

    // Метод для проверки открытия страницы
    public void isPageOpen(String headerText, String text) {
        assertEquals(headerText, text);
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

    // Метод для выбора станции метро
    public void setSubway(String subway) {
        // Ожидаем кликабельность поля ввода станций метро
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement selectField = wait.until(ExpectedConditions.elementToBeClickable(SUBWAY_FIELD));
        selectField.click();

        // Ожидаем кликабельность конкретного пункта списка станций
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[text()='" + subway + "']")));

        // Перемещаем мышь к элементу и кликаем
        Actions actions = new Actions(driver);
        actions.moveToElement(option).perform();
        option.click();
    }

    // Метод для заполнения поля * Телефон: на него позвонит курьер
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(PHONE_NUMBER_FIELD).sendKeys(phoneNumber);
    }

    // Переходим к следующей странице заказа
    public void clickOrderNextButton() {
        driver.findElement(ORDER_NEXT_BUTTON).click();
    }

    // Устанавливаем дату доставки
    public void setDate(String date) {
        driver.findElement(DATE_FIELD).sendKeys(date);
    }

    // Выбираем срок аренды
    public void setRentalPeriod(String rentalPeriod) {
        driver.findElement(ABOUT_ORDER_HEADER).click();
        driver.findElement(RENTAL_PERIOD_FIELD).click();
        driver.findElement(By.xpath(".//div[text()='" + rentalPeriod + "']")).click();
    }

    // Выбор цвета самоката
    public void setColor(String color) {
        driver.findElement(By.xpath(".//label[text()='" + color + "']")).click();
    }

    // Заполнение комментария для курьера
    public void setComment(String comment) {
        driver.findElement(COMMENT_FIELD).sendKeys(comment);
    }

    // Подтверждение заказа
    public void clickOrderCreateButton() {
        driver.findElement(ORDER_CREATE_BUTTON).click();
    }

    // Окончательное подтверждение заказа
    public void clickOrderConfirmButton() {
        driver.findElement(ORDER_CONFIRM_BUTTON).click();
    }
}