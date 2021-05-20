package starter.objects;

import io.restassured.RestAssured;

public class EndpointStatus {

    public int getStatusCode( final String endpointUrl) {

        int statusresponse = RestAssured.given()
                .when()
                .get(endpointUrl)
                .getStatusCode();

        return statusresponse;

    }
    
}
