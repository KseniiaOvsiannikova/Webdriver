package webservices.jsonPlaceholder;

import baseTest.BaseTestForWebServices;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import webservices.User;

public class ResponseBodyTest extends BaseTestForWebServices {

    @Test
    public void checkResponseBody() {
        Response response = RestAssured.when()
                .get("/users")

                .andReturn();
        ResponseBody<?> responseBody = response.getBody();
        User[] users = responseBody.as(User[].class);

        logger.info(String.format("The quantity of 'User' objects is: %s", users.length));

        Assert.assertEquals(users.length, 10, "Incorrect number of objects");
    }
}