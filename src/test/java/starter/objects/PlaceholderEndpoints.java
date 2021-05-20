package starter.objects;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

public class PlaceholderEndpoints {

    public static Response postRequest(final String usersEndpoint, final String body){

        File jsonBody = new File(body);

        return RestAssured.given()
                    .header("Content-Type", "application/json")
                    .body(jsonBody)
                    .when()
                    .post(usersEndpoint)
                    .then()
                    .statusCode(201)
                    .extract()
                    .response();

    }

    public static Response getRequest(final String usersEndpoint){

        return RestAssured.given()
                    .header("Content-Type", "application/json")
                    .when()
                    .get(usersEndpoint)
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();

    }

    public void deleteRequest(final String deleteUsersUrl){

        RestAssured.given()
                .delete(deleteUsersUrl)
                .then()
                .statusCode(200)
                .extract()
                .response();

    }

}

