package ScooterTest;

import Pages.HomePageScooter;
import Pages.OrderPageScooter;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;

import static ScooterTest.Constants.CONFIRM_HEADER; // Импортируем константу из другого класса
import static org.hamcrest.CoreMatchers.equalTo;

import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class OrderTest {

    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String subway;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderTest(String name, String surname, String address, String subway, String phoneNumber, String date, String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDataSetForOrder() {
        return new Object[][] {
                {"Иван", "Иванов", "г. Москва, ул. Пушкина, д.10", "Театральная", "89151234567", "01.01.2050", "сутки", "чёрный жемчуг", "Не звонить в дверь"},
                {"Ирина", "Авдеева", "проспект Маяковского 6", "Маяковская", "+79657654321", "10.10.2030", "двое суток", "серая безысходность", "Привезите чистый самокат"},
        };
    }

    @Test
    public void OrderPositiveTest() {
        // Запустить браузер Firefox
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");

        // Главная страница: инициируем оформление заказа
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickHeaderOrderButton();

        // Страница заказа: принять куки и заполнить поля
        OrderPageScooter objOrderPage = new OrderPageScooter(driver);
        objOrderPage.acceptCookieButtonClick();
        objOrderPage.setName(name);
        objOrderPage.setSurname(surname);
        objOrderPage.setAddress(address);
        objOrderPage.setSubway(subway);
        objOrderPage.setPhoneNumber(phoneNumber);
        objOrderPage.clickOrderNextButton();

        // Заполните подробности заказа
        objOrderPage.setDate(date);
        objOrderPage.setRentalPeriod(rentalPeriod);
        objOrderPage.setColor(color);
        objOrderPage.setComment(comment);

        // Отправляем заказ
        objOrderPage.clickOrderCreateButton();
        objOrderPage.clickOrderConfirmButton();

        // Проверяем, что открылся экран подтверждения заказа
        String actualConfirmHeader = objOrderPage.getConfirmHeader();
        assertThat(actualConfirmHeader, equalTo(CONFIRM_HEADER)); // Утверждаем, что заголовок совпал с постоянной строкой
    }

    @After
    public void teardown() {
            driver.quit();
    }
}
