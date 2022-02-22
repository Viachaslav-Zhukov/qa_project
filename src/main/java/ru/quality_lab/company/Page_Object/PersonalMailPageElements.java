package ru.quality_lab.company.Page_Object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PersonalMailPageElements {
    //сохраняем URL личной страницы авторизированного пользователя почты
    public static final String URL = "https://e.mail.ru/inbox/?afterReload=1/";
    //локатор раздела "написать письмо"
    @FindBy(how = How.XPATH, using = ".//span[@class='compose-button__txt']")
    public SelenideElement buttonWriteALetter;
    //локатор поля ввода "Кому" в форме письма
    @FindBy(how = How.XPATH, using = ".//input[@class='container--H9L5q size_s--3_M-_']")
    public SelenideElement toField;
    //локатор поля ввода "Тема" в форме письма
    @FindBy(how = How.XPATH, using = ".//input[@name='Subject']")
    public SelenideElement temField;
    //локатор поля ввода текста письма
    @FindBy(how = How.XPATH, using = ".//div[@role='textbox']")
    public SelenideElement letterTextInputField;
    //локатор кнопки "Отправить"
    @FindBy(how = How.XPATH, using = ".//span[text()='Отправить']")
    public SelenideElement sendButton;

    // метод клика по разделу "Написать письмо"
    //поставил небольшую задержку, притормаживается отображение страницы при переходе
    public void clickButtonWriteALetter() throws InterruptedException {
        Thread.sleep(10000);
        buttonWriteALetter.click();

    }

    //метод ввода адресата получателя письма
    public void setToFieldtoField() {
        toField.sendKeys("slava.slava.zhukov@yandex.by");
    }

    //метод ввода темы письма
    public void setTemField() {
        temField.sendKeys("QA_Test_Project");
    }

    //метод ввода текста письма
    //задержку поставил, для отображения заполнения всех полей письма
    public void setLetterTextInputField() throws InterruptedException {
        letterTextInputField.sendKeys("Hello, world! Hello, Java!");
        Thread.sleep(5000);
    }

    //метод клика по кнопке "Отправить" письмо
    //задержка лишь для вывода ожидаемого результата "Письмо отправлено"
    public void clickSendButton() throws InterruptedException {
        sendButton.click();
        Thread.sleep(5000);
    }

    //метод написания и отправки письма в почте: объединяет метод клика по "Написать письмо", метод ввода адресата, метод ввода темы письма,
    //метод ввода текста письма, метод клика на кнопку "Отправить"
    public void writeSendEmail() throws InterruptedException {
        clickButtonWriteALetter();
        setToFieldtoField();
        setTemField();
        setLetterTextInputField();
        clickSendButton();
    }

}



