package starter.objects;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import net.thucydides.core.annotations.Step;

import java.io.File;

import static net.serenitybdd.rest.SerenityRest.given;


public class PlaceholderEndpoints {

    private static RequestSpecification request() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://jsonplaceholder.typicode.com");
        builder.setContentType(ContentType.JSON);

        return builder.build();

 }

    @Step("POST Request")
    public Response postRequest(final String endpoint, final String body){

        File jsonBody = new File(body);

        return given()
                .spec(request())
                .body(jsonBody)
                .when()
                .post(endpoint);

    }
    @Step("POST Specific request")
    public Response postSpecificRequest(final String endpoint, final String body, int id){

        File jsonBody = new File(body);

        return given()
                .spec(request())
                .pathParam("id", id)
                .body(jsonBody)
                .when()
                .post(endpoint);

    }
    @Step("PUT Specific request")
    public Response putSpecificRequest(final String endpoint, final String body, int id){

        return given()
                .spec(request())
                .pathParam("id", id)
                .body(body)
                .when()
                .put(endpoint);

    }
    @Step("GET Request")
    public Response getRequest(final String endpoint){

        return given()
                .spec(request())
                .when()
                .get(endpoint);

    }

    @Step("GET Specific request")
    public Response getSpecificRequest(final String endpoint, int id){

        return given()
                .spec(request())
                .pathParam("id", id)
                .when()
                .get(endpoint);

    }
    @Step("DELETE Request")
    public Response deleteRequest(final String endpoint, int id){

        return given()
                .spec(request())
                .pathParam("id", id)
                .delete(endpoint);

    }

}

