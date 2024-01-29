package DataObject;
import com.github.javafaker.Faker;

public class DataInformation {

    static Faker faker1 = new Faker();

    public static String

            corretctUsserNameData = "standard_user",
            correctPasswordData ="secret_sauce",
            incorrectUsserNameData = "standard",
            incorrectPasswordData = "123456",
            fakerUserName = faker1.bothify("????##"),
            fakerPassword =faker1.bothify("?####???"),
            firstNameData ="Sopo",
            lastNameData ="Gorgadze",
            postalCodeData ="19116";
}

