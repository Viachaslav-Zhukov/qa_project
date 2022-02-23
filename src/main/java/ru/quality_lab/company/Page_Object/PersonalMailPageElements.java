package ru.quality_lab.company.Page_Object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;

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
    //использую проверку явно - с целью ожидания нужного состояния у элемента перед действием
    public void clickButtonWriteALetter() {
        buttonWriteALetter.shouldBe(enabled).click();
    }

    //метод ввода адресата получателя письма
    public void setToFieldtoField() {
        toField.sendKeys("slava.slava.zhukov@yandex.by");
    }

    //чтобы заполнить поля письма, применяю метод Selenium sendKeys()
    //метод ввода темы письма
    public void setTemField() {
        temField.sendKeys("QA_Test_Project");
    }

    //метод ввода текста письма
    public void setLetterTextInputField() {
        letterTextInputField.sendKeys("Hello, world! Hello, Java!");
    }

    //метод клика по кнопке "Отправить" письмо
    //ожидание лишь для вывода с паузой ожидаемого результата "Письмо отправлено"
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



