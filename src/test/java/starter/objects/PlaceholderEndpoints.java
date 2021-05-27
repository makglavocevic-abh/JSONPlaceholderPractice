package starter.objects;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.rest;

import java.io.File;

public class PlaceholderEndpoints {

    @Step("POST Request")
    public Response postRequest(final String Endpoint, final String body){

        File jsonBody = new File(body);

        return rest()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .post(Endpoint);

    }
    @Step("POST Specific request")
    public Response postSpecificRequest(final String Endpoint, final String body, int Id){

        File jsonBody = new File(body);

        return RestAssured.given()
                .header("Content-Type", "application/json")
                .pathParam("Id", Id)
                .body(jsonBody)
                .when()
                .post(Endpoint);

    }
    @Step("PUT Specific request")
    public Response putSpecificRequest(final String Endpoint, final String body, int Id){

        return RestAssured.given()
                .pathParam("Id", Id)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put(Endpoint);

    }
    @Step("GET Request")
    public Response getRequest(final String Endpoint){

        return RestAssured.given()
                .when()
                .get(Endpoint);

    }

    @Step("GET Specific request")
    public Response getSpecificRequest(final String Endpoint, int Id){

        return RestAssured.given()
                .pathParam("Id", Id)
                .when()
                .get(Endpoint);

    }
    @Step("DELETE Request")
    public Response deleteRequest(final String Endpoint, int Id){

        return RestAssured.given()
                .pathParam("Id", Id)
                .delete(Endpoint);

    }

}

