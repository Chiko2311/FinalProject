package Methods;
import StepObject.Steps;

public class Method {

    public static void loginData(Steps step1, String username, String password) {
        step1.usernameFieldAction(username);
        step1.passwordFieldAction(password);
        step1.loginButtonAction();
    }
    public static void personalData(Steps step1, String firstName, String lastName, String postalCode) {
        step1.firstNameField(firstName);
        step1.lastNameField(lastName);
        step1.postalCodeField(postalCode);
    }}





