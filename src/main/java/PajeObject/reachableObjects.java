package PajeObject;
import org.openqa.selenium.By;

public class reachableObjects {

    protected By
            userField = By.id("user-name"),
            passwordField = By.id("password"),
            logInButton = By.name("login-button"),
            menuButton = By.id("react-burger-menu-btn"),
            logOutButton = By.id("logout_sidebar_link"),
            continueButton = By.name("continue"),
            finishButton = By.name("finish"),
            addCartButton = By.xpath("//button[text()='Add to cart']"),
            firstNameInput = By.id("first-name"),
            lastNameInput = By.id("last-name"),
            postalCodeInput = By.id("postal-code"),
            removeButton = By. id("remove-sauce-labs-backpack"),
            cartCheckButton = By.className("shopping_cart_badge"),
            twitterButton =(By.xpath("//a[contains(@href, 'twitter.com/saucelabs')]"));
}



