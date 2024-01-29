package StepObject;

import PajeObject.reachableObjects;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class Steps extends reachableObjects {
    WebDriver driver;

    public Steps(WebDriver driver1) {
        driver = driver1;
    }

    @Step("User-ის ველში ჩადგება")
    public void usernameFieldAction(String username) {
        driver.findElement(userField).sendKeys(username);
    }
    @Step("პაროლის ველში ჩადგება")
    public void passwordFieldAction(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("შესვლის ღილაკს დააჭერს")
    public void loginButtonAction() {
        driver.findElement(logInButton).click();
    }
    @Step("მენიუს ღილაკს დააჭერს")
    public void menuButtonAction() {
        driver.findElement(menuButton).click();
    }
    @Step("კალათაში დამატების ღილაკს დააჭერს")
    public void addCartAction() {
        driver.findElement(addCartButton).click();
    }
    @Step("კალათაში შესვლის ღილაკს დააჭერს")
    public void cartCheckButtonAction(){
        driver.findElement(cartCheckButton).click();
};
    @Step("საიტზე Twitter-ის ლოგოს იპოვის")
    public void twitterButtonAction(){
        driver.findElement(twitterButton).click();
    }
    @Step("Wait-დალოდება გააკეთებს შემდეგ ნაბიჯამდე")
    public WebDriverWait webDriverWaitAction() {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Step("საიტიდან გამოსვლის ღილაკს დააჭერს")
    public void logOutButtonAction() {
        driver.findElement(logOutButton).click();
    }
    @Step("საიტიდან გამოსვლის ღილაკს დააჭერს")
    public  WebElement getLogOutButton() {return driver.findElement(logOutButton);}
    @Step("კალათაში დამატებულ პროდუტს წაშლის")
    public void removeButtonAction(){
        driver.findElement(removeButton).click();
    };
    @Step("Continue-ღილაკს დააჭერს ყიდვის მონაცემების შესავსებად")
    public void continueButtonAction(){
        driver.findElement(continueButton).click();
    }
    @Step("პროდუქტის შესყიდვას დაასრულებს")
    public void finishButtonAction(){
        driver.findElement(finishButton).click();
    }
    @Step("პროდუქტის ყიდვისათვის პირად მონაცემების ველში ჩადგება/სახელი")
    public void firstNameField (String firstName) {driver.findElement(firstNameInput).sendKeys(firstName);}
    @Step("პროდუქტის ყიდვისათვის პირად მონაცემების ველში ჩადგება/გვარი")
    public void lastNameField (String lastName) {driver.findElement(lastNameInput).sendKeys(lastName);}
    @Step("პროდუქტის ყიდვისათვის პირად მონაცემების ველში ჩადგება/საფოსტო ინდექსი")
    public void postalCodeField (String postalCode) {driver.findElement(postalCodeInput).sendKeys(postalCode);}
}










