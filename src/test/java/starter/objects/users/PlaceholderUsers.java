package starter.objects.users;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.File;

public class PlaceholderUsers {

    RequestSpecification request = RestAssured.given();;

    private final String ENDPOINT_GET_USERS_FROM_JSONPLACEHOLDER = "https://jsonplaceholder.typicode.com/users";
    private final String ENDPOINT_GET_NEWUSER_FROM_JSONPLACEHOLDER = "https://jsonplaceholder.typicode.com/users/11";

    public int getUsersStatusCode() {

        int statusresponse = request
                .when()
                .get(ENDPOINT_GET_USERS_FROM_JSONPLACEHOLDER)
                .getStatusCode();

        return statusresponse;

    }

    public void postNewUsers(){

        File jsonBody = new File("src/test/java/starter/objects/users/validpostbody.json");

            request
                   .header("Content-Type", "application/json")
                   .body(jsonBody)
                   .when()
                   .post(ENDPOINT_GET_USERS_FROM_JSONPLACEHOLDER)
                   .then()
                   .statusCode(201);

    }

    public void getNewUsers(){

        request
                .header("Content-Type", "application/json")
                .when()
                .get(ENDPOINT_GET_USERS_FROM_JSONPLACEHOLDER)
                .then()
                .statusCode(200);

    }

    public void deleteNewUsers(){

        request
                .delete(ENDPOINT_GET_NEWUSER_FROM_JSONPLACEHOLDER)
                .then()
                .statusCode(200);

    }

}

