package starter.objects;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.*;

public class VerifyEndpoint {

    @Step("Assert expected HTTP status code")
    public void validateHttpStatusCode(int statusCode, Response response) {
        response.then().statusCode(statusCode);
    }

    @Step("Assert body size")
    public void validateResponseSize(int expectedSize, Response response){
        response.then().assertThat().contentType(ContentType.JSON)
                .and().body("size()", equalTo(expectedSize));

    }

    @Step("Assert body size and userid")
    public void validateResponseSizeAndUserId(int expectedSize, int userId, Response response){
        response.then().assertThat().contentType(ContentType.JSON)
                .and().body("size()", equalTo(expectedSize))
                .and().body("userId", hasItem(is(userId)));

    }
}
