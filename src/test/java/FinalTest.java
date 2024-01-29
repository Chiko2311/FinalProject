import DataObject.DataInformation;
import StepObject.Steps;
import Utils.BrowserAction;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import static DataObject.DataInformation.*;
import static Methods.Method.*;


public class FinalTest extends BrowserAction {

    @Test(priority = 1)
    @Description ("სწორი მონაცემებით დალოგინება")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.saucedemo.com/")

       public void loginWithCorrectData() {
        Steps step1 = new Steps(driver);

        loginData(step1, corretctUsserNameData, correctPasswordData);

        WebDriverWait wait = step1.webDriverWaitAction();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl, actualUrl);}


    @Test(priority = 2)
    @Description("არასწორი მონაცემებით დალოგინება")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://www.saucedemo.com/")

       public void loginWithInCorrectData() {
        Steps step1 = new Steps(driver);

        step1.usernameFieldAction(incorrectUsserNameData);
        step1.passwordFieldAction(incorrectPasswordData);
        step1.loginButtonAction();

        WebDriverWait wait = step1.webDriverWaitAction();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/";
        Assert.assertEquals(expectedUrl, actualUrl);

        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]")));
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = errorMessageElement.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);}


    @Test(priority = 3)
    @Description("არასწორი მონაცემებით დალოგინება/Faker-ის საშუალებით")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://www.saucedemo.com/")

       public void loginWithFakertData() {
        Steps step1 = new Steps(driver);

        step1.usernameFieldAction(fakerUserName);
        step1.passwordFieldAction(fakerPassword);
        step1.loginButtonAction();

        WebDriverWait wait = step1.webDriverWaitAction();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/"));

        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]")));
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = errorMessageElement.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);}


    @Test(priority = 4)
    @Description("სისტემიდან გამოსვლა")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://www.saucedemo.com/")

       public void logOutTest() {
        Steps step1 = new Steps(driver);

        loginData(step1, corretctUsserNameData, correctPasswordData);

        step1.menuButtonAction();
        WebDriverWait wait = step1.webDriverWaitAction();
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(step1.getLogOutButton()));
        step1.logOutButtonAction();

        String actualUrlAfterLogout = driver.getCurrentUrl();
        String expectedUrlAfterLogout = "https://www.saucedemo.com/";
        Assert.assertEquals(expectedUrlAfterLogout, actualUrlAfterLogout);}


    @Test(priority = 5)
    @Description("პროდუქტის კალათაში დამატება")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.saucedemo.com/")

       public void addToCartTest() {
         Steps step1 = new Steps(driver);
         loginData(step1, corretctUsserNameData, correctPasswordData);

         step1.addCartAction();

         WebDriverWait wait = step1.webDriverWaitAction();

         WebElement cartCheck = driver.findElement(By.className("shopping_cart_badge"));
         Assert.assertEquals(cartCheck.getText(), "1", "Product was not added to the cart");}


    @Test(priority = 6)
    @Description("კალათიდან პროდუქტის წაშლა")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://www.saucedemo.com/")

       public void deleteFromCart() {
          Steps step1 = new Steps(driver);

          loginData(step1, corretctUsserNameData, correctPasswordData);

          step1.addCartAction();

          WebElement cartCheck = driver.findElement(By.className("shopping_cart_badge"));
          Assert.assertEquals (cartCheck.getText(), "1", "Product was not added to the cart");
          cartCheck.click();

          WebDriverWait wait = step1.webDriverWaitAction();
          step1.removeButtonAction();}


    @Test(priority = 7)
    @Description("კალათაში დამატებული პროდუქტის შეძენა")
    @Severity(SeverityLevel.CRITICAL)
    @Link("https://www.saucedemo.com/")

       public void checkOutCart() {
         Steps step1 = new Steps(driver);

         loginData(step1, corretctUsserNameData, correctPasswordData);
         step1.addCartAction();
         step1.cartCheckButtonAction();

         Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(), "1", "Product was not added to the cart");

         WebDriverWait wait = step1.webDriverWaitAction();
         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".checkout_button"))).click();

         personalData(step1, DataInformation.firstNameData, DataInformation.lastNameData, DataInformation.postalCodeData);

         step1.continueButtonAction();
         step1.finishButtonAction();}


    @Test(priority = 8)
    @Description("კალათაში დამატებული პროდუქტის შეძენა, სადაც პირადი მონაცემები ცარიელია")
    @Severity(SeverityLevel.NORMAL)
    @Link("https://www.saucedemo.com/")

       public void checkOutWithEmptyData()  {
        Steps step1 = new Steps(driver);

        loginData(step1, corretctUsserNameData, correctPasswordData);
        step1.addCartAction();
        step1.cartCheckButtonAction();

        Assert.assertEquals(driver.findElement(By.className("shopping_cart_badge")).getText(), "1", "Product was not added to the cart");

        WebDriverWait wait = step1.webDriverWaitAction();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".checkout_button"))).click();

        step1.continueButtonAction();}


    @Test(priority = 9)
    @Description("საიტის სოციალური გვერდის შემოწმება/Twitter")
    @Severity(SeverityLevel.TRIVIAL)
    @Link("https://www.saucedemo.com/")

      public void checkSocialPage() {
        Steps step1 = new Steps(driver);

        loginData(step1, corretctUsserNameData, correctPasswordData);

        WebDriverWait wait = step1.webDriverWaitAction();
        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl, expectedUrl, "Incorrect URL after login");

        step1.twitterButtonAction();}


    @Test(priority = 10)
    @Description("პროდუქტის დალაგება პროდუქტის ფასის კლებადობის მიხედვით")
    @Severity(SeverityLevel.TRIVIAL)
    @Link("https://www.saucedemo.com/")

      public void sortProductByPrice()  {
        Steps step1 = new Steps(driver);
        loginData(step1, corretctUsserNameData, correctPasswordData);

        String[] filterTypes = {"Price (high to low)"};
        int filterCount = filterTypes.length;

        for (int i = 0; i < filterCount; i++) {
            String filterType = filterTypes[i];

            WebElement filterDropdown = driver.findElement(By.className("product_sort_container"));
            filterDropdown.click();}}
    }






















































