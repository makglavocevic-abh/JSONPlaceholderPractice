package starter.objects;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class PlaceholderPosts {

    RequestSpecification request = RestAssured.given();

    private final String ENDPOINT_GET_POSTS_FROM_JSONPLACEHOLDER = "https://jsonplaceholder.typicode.com/posts";
    private final String ENDPOINT_GET_NEW_POSTS_FROM_JSONPLACEHOLDER = "https://jsonplaceholder.typicode.com/posts/101";


    public int getPoststatusCode() {

        int statusresponse = request
                .when()
                .get(ENDPOINT_GET_POSTS_FROM_JSONPLACEHOLDER)
                .getStatusCode();

        return statusresponse;

    }












}
