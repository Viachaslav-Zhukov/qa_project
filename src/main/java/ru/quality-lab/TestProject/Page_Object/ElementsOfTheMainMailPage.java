package ru.quality_lab.company.Page_Object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

     //создаём Page Object Model главной страницы входа в mail.ru почту
public class ElementsOfTheMainMailPage {
    //сохраняем URL главной страницы почты
    public static final String URL = "https://account.mail.ru/";
    //локатор поля ввода Имя аккаунта
    @FindBy(how = How.XPATH, using = ".//input[@name='username']")
    public SelenideElement accountEntryField;
    //локатор поле выпадающего списка почтовых доменов
    @FindBy(how = How.XPATH, using = ".//div[@class='Select__value-container Select__value-container--has-value css-0']")
    public SelenideElement domainSelectionField;
    //локатор выбора домена inbox из выпадающего списка mail
    @FindBy(how = How.XPATH, using = ".//span[text()='@inbox.ru']")
    public SelenideElement domainInbox;
    //локатор кнопки "ввести пароль"
    @FindBy(how = How.XPATH, using = ".//span[text()='Ввести пароль']")
    public SelenideElement enterPasswordButton;
    //локатор поля ввода пароля
    @FindBy(how = How.XPATH, using = ".//input[@placeholder='Пароль']")
    public SelenideElement inputFieldEnterPassword;
    //локатор кнопки Войти№2
    @FindBy(how = How.XPATH, using = ".//span[text()='Войти']")
    public SelenideElement loginButtonTwo;

    //чтобы заполнить поля ввода, применяю метод Selenide setValue()
    //метод заполнения поля ввода Имя аккаунта
    public void setUsername(String username) {
        accountEntryField.setValue(username);
    }

    //метод выбора одного из доменов mail
    public void clickDomain() {
        domainSelectionField.click();
        domainInbox.click();
    }

    //метод клика по кнопке "ввести пароль"
    public void clickEnterPasswordButton() {
        enterPasswordButton.click();
    }

    //метод заполнения поля ввода пароля
    public void setPassword(String password) {
        inputFieldEnterPassword.setValue(password);
    }

    //метод клика по кнопке Войти№2
    public void clickLoginButtonTwo() {
        loginButtonTwo.click();
    }

    //метод авторизации в почте: объединяет клик по кнопке войти, ввод email,
    //клик по кнопке ввести пароль, ввод пароля и клик по войти№2
    public void login(String username, String password) {
        setUsername(username);
        clickDomain();
        clickEnterPasswordButton();
        setPassword(password);
        clickLoginButtonTwo();
    }
}
