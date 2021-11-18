package api.RestAssured;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class Sweatband {

    @Test
    public void createSweatband()
    {
        String endpoint = "http://localhost:80/api_testing/product/create.php";
        String body = """
                {
                "name": "Sweatband",
                "description": "White sweatband. One size fits all.",
                "price": 5,
                "category_id": 3
                }
                """;

        var response = given().body(body).when().post(endpoint).then();
        response.log().body();
    }

    @Test
    public void updateSweatband()
    {
        String endpoint = "http://localhost:80/api_testing/product/update.php";
        String body = """
                {
                "id" = 26
                "price": 6,
                }
                """;
        var response = given().body(body).when().put(endpoint).then();
        response.log().body();
    }

    @Test
    public void getSweatband()
    {
        String endpoint = "http://localhost:80/api_testing/product/read-one.php";
        var response = given().queryParam("id", 26).when().get(endpoint).then();
        response.log().body();
    }

    @Test
    public void deleteSweatband()
    {
        String endpoint = "http://localhost:80/api_testing/product/delete.php";
        String body = """
                {
                "id" = 26
                }
                """;
        var response = given().body(body).when().delete(endpoint).then();
        //var response = given().queryParam("id", 26).when().delete(endpoint).then();
        response.log().body();
    }
}
