package ScooterTest;

import Pages.HomePageScooter;
import Pages.OrderPageScooter;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;

import static ScooterTest.Constants.CONFIRM_HEADER;

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

    public OrderTest(
            String name,
            String surname,
            String address,
            String subway,
            String phoneNumber,
            String date,
            String rentalPeriod,
            String color,
            String comment
    ) {
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
    public static Iterable<Object[]> getDataSetForOrder() {
        return Arrays.asList(new Object[][]{
                {"Иван", "Иванов", "г. Самара, ул. Московское шоссе, д.1", "Аэропорт", "89271234567", "01.01.2001", "сутки", "чёрный жемчуг", "Не звонить в дверь"},
                {"Петр", "Петров", "Марс, ул. Марсианская, д.2", "Спортивная", "89273215476", "02.02.2002", "двое суток", "серая безысходность", "Привезите чистый самокат"}
        });
    }

    @Test
    public void OrderPositiveTest() {
        // Создаем веб-драйвер для Firefox
        // driver = new FirefoxDriver();
        // Переходим на страницу заказа Яндекс.Самокат
        // driver.get("https://qa-scooter.praktikum-services.ru");
        // Создаем объект класса с домашней страницей
        // HomePageScooter homePage = new HomePageScooter(driver);
        // Нажимаем на кнопку "Заказать" на чердаке
        // homePage.clickHeaderOrderButton();
        // Создаем объект класса со страницей заказа
        // OrderPageScooter orderPage = new OrderPageScooter(driver);
        // Примем куки
        // orderPage.acceptCookieButtonClick();
        // Заполняем форму заказа
        // orderPage.setName(name);
        // orderPage.setSurname(surname);
        // orderPage.setAddress(address);
        // orderPage.setSubway(subway);
        // orderPage.setPhoneNumber(phoneNumber);
        // orderPage.clickOrderNextButton();
        // orderPage.setDate(date);
        // orderPage.setRentalPeriod(rentalPeriod);
        // orderPage.setColor(color);
        // orderPage.setComment(comment);
        // orderPage.clickOrderCreateButton();
        // orderPage.clickOrderConfirmButton();
        // Проверяем успешное оформление заказа
        // orderPage.isPageOpen(orderPage.getConfirmHeader(), confirmHeader);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
