package baseTest;

import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;

public abstract class BaseTestForWebServices {

    public Logger logger = LogManager.getRootLogger();

    String jsonPlaceholderUsersHost = "https://jsonplaceholder.typicode.com/users";

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
    }
}