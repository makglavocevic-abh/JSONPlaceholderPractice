package starter.objects;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

public class PlaceholderUsers {

    public static Response postNewUsers(final String usersEndpoint){

        File jsonBody = new File("src/test/java/starter/objects/validpostbody.json");

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

    public static Response getNewUsers(final String usersEndpoint){

        return RestAssured.given()
                    .header("Content-Type", "application/json")
                    .when()
                    .get(usersEndpoint)
                    .then()
                    .statusCode(200)
                    .extract().response();

    }

    public void deleteNewUsers(final String deleteUsersUrl){

        RestAssured.given()
                .delete(deleteUsersUrl)
                .then()
                .statusCode(200);

    }

}

