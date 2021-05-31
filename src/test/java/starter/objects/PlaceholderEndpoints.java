package starter.objects;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import net.thucydides.core.annotations.Step;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PlaceholderEndpoints {

    private static RequestSpecification request() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("https://jsonplaceholder.typicode.com");
        builder.setContentType(ContentType.JSON);

        return builder.build();

 }

    @Step("POST Request")
    public Response postRequest(final String Endpoint, final String body){

        File jsonBody = new File(body);

        return given()
                .spec(request())
                .body(jsonBody)
                .when()
                .post(Endpoint);

    }
    @Step("POST Specific request")
    public Response postSpecificRequest(final String Endpoint, final String body, int Id){

        File jsonBody = new File(body);

        return given()
                .spec(request())
                .pathParam("Id", Id)
                .body(jsonBody)
                .when()
                .post(Endpoint);

    }
    @Step("PUT Specific request")
    public Response putSpecificRequest(final String Endpoint, final String body, int Id){

        return given()
                .spec(request())
                .pathParam("Id", Id)
                .body(body)
                .when()
                .put(Endpoint);

    }
    @Step("GET Request")
    public Response getRequest(final String Endpoint){

        return given()
                .spec(request())
                .when()
                .get(Endpoint);

    }

    @Step("GET Specific request")
    public Response getSpecificRequest(final String Endpoint, int Id){

        return given()
                .spec(request())
                .pathParam("Id", Id)
                .when()
                .get(Endpoint);

    }
    @Step("DELETE Request")
    public Response deleteRequest(final String Endpoint, int Id){

        return given()
                .spec(request())
                .pathParam("Id", Id)
                .delete(Endpoint);

    }

}

