package Pages;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static ScooterTest.Locators.*;

public class HomePageScooter {

    private WebDriver driver;

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для раскрытия вопросов
    public void clickQuestion(By question) {
        driver.findElement(question).click();
    }

    // Геттеры для получения текста ответов
    public String getAnswer(By answer) {
        return driver.findElement(answer).getText();
    }

    // Метод для сравнения ответа на вопрос с правильным текстом
    public void isCorrectText(String answer, String text) {
        MatcherAssert.assertThat(answer, is(text));
    }

    // Методы для клика по кнопкам Заказать
    public void clickHeaderOrderButton() {
        driver.findElement(HEADER_ORDER_BUTTON).click();
    }

    public void clickPageOrderButton() {
        // Проскролить до появления кнопки
        WebElement bigButton = driver.findElement(PAGE_ORDER_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", bigButton);
        driver.findElement(PAGE_ORDER_BUTTON).click();
    }
}
