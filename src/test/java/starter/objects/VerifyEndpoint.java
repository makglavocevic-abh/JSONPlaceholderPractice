package starter.objects;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.*;

public class VerifyEndpoint {

    @Step("Assert expected HTTP status code")
    public void validateHttpStatusCode(int StatusCode, Response response) {
        response.then().statusCode(StatusCode);
    }

    @Step("Assert body size")
    public void validateResponseSize(int ExpectedSize, Response response){
        response.then().assertThat().contentType(ContentType.JSON)
                .and().body("size()", equalTo(ExpectedSize));

    }

    @Step("Assert body size and userid")
    public void validateResponseSizeAndUserId(int ExpectedSize, int UserId, Response response){
        response.then().assertThat().contentType(ContentType.JSON)
                .and().body("size()", equalTo(ExpectedSize))
                .and().body("userId", hasItem(is(UserId)));

    }
}
