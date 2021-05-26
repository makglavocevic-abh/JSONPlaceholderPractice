package starter.objects;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

public class PlaceholderEndpoints {

    public static Response postRequest(final String Endpoint, final String body){

        File jsonBody = new File(body);

        return RestAssured.given()
                    .header("Content-Type", "application/json")
                    .body(jsonBody)
                    .when()
                    .post(Endpoint);

    }

    public static Response postSpecificRequest(final String Endpoint, final String body, int Id){

        File jsonBody = new File(body);

        return RestAssured.given()
                .header("Content-Type", "application/json")
                .pathParam("Id", Id)
                .body(jsonBody)
                .when()
                .post(Endpoint);

    }

    public static Response putSpecificRequest(final String Endpoint, final String body, int Id){

        return RestAssured.given()
                .pathParam("Id", Id)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put(Endpoint);

    }

    public static Response getRequest(final String Endpoint){

        return RestAssured.given()
                    .when()
                    .get(Endpoint);

    }

    public static Response getSpecificRequest(final String Endpoint, int Id){

        return RestAssured.given()
                .pathParam("Id", Id)
                .when()
                .get(Endpoint);

    }

    public static Response deleteRequest(final String Endpoint, int Id){

        return RestAssured.given()
                .pathParam("Id", Id)
                .delete(Endpoint);

    }

}

