package starter.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.objects.VerifyEndpoint;
import starter.objects.EndpointPath;
import starter.objects.JsonBodyRandomData;
import starter.objects.PlaceholderEndpoints;

import static org.hamcrest.Matchers.equalTo;

public class PostsStepDefinitions {

    private Response response;

    @Steps
    PlaceholderEndpoints placeholderEndpoints;

    @Steps
    VerifyEndpoint JSONPlaceholderCheck;

        @Given("The posts rest endpoint is online")
    public void theRestPostsEndpointIsOnline() {
        response = placeholderEndpoints.getRequest(EndpointPath.POSTS_ENDPOINT);
        JSONPlaceholderCheck.validateHttpStatusCode(200, response);
    }

    @When("User sends GET request to posts endpoint")
    public void GETPosts() {
        response = placeholderEndpoints.getRequest(EndpointPath.POSTS_ENDPOINT);
    }

    @Then("Assert that all Posts are returned")
    public void AssertThatAllPostsAreReturned() {
        JSONPlaceholderCheck.validateResponseSize(100, response);
    }

    @When("User posts valid posts body")
    public void POSTValidPostBody() {
        response = placeholderEndpoints.postRequest(EndpointPath.POSTS_ENDPOINT, EndpointPath.NEW_POSTS_BODY);
    }

    @Then("Assert that new post id is posted")
    public void AssertThatNewPostIdIsPosted() {
        response.then().assertThat().body("id", equalTo(101));
    }

    @When("User send PUT request with valid body")
    public void PUTPostsWithNewChanges() {
        response = placeholderEndpoints.putSpecificRequest(EndpointPath.POST_ENDPOINT, JsonBodyRandomData.TITLE_PUT_BODY(), 1);
    }

    @Then("Assert that the posts update was successful")
    public void AssertThatTheUpdateWasSuccessful() {
        response.then().assertThat().body("title", equalTo(JsonBodyRandomData.randomString));
    }

    @When("User sends DELETE request to posts endpoint")
    public void DELETEPosts() {
        response = placeholderEndpoints.deleteRequest(EndpointPath.NEW_POST_ENDPOINT, 101);
    }

    @Then("Assert that the post is deleted")
    public void AssertThatThePostIsDeleted() {
        response.then().assertThat().body("isEmpty()", Matchers.is(true));
    }

    @When("User sends GET request to (\\d+) comments$")
    public void GETCommentsNestedRoute(int posts) {
        response = placeholderEndpoints.getSpecificRequest(EndpointPath.POSTS_COMMENTS_ENDPOINT, posts);
    }

    @Then("Assert that all comments are returned")
    public void AssertThatAllCommentsAreReturned() {
        JSONPlaceholderCheck.validateResponseSize(5, response);
    }

    @When("User posts valid comment body to a post")
    public void POSTCommentsNestedRoute() {
        response = placeholderEndpoints.postSpecificRequest(EndpointPath.POSTS_COMMENTS_ENDPOINT, EndpointPath.NEW_COMMENTS_BODY, 1);
    }

    @Then("Assert that the new comment was posted")
    public void AssertThatTheNewCommentWasPosted() {
        response.then().assertThat().body("id", equalTo(501));
    }

    @When("User sends DELETE request to comments endpoint")
    public void DELETECommentsNestedRoute() {
        response = placeholderEndpoints.deleteRequest(EndpointPath.NEW_COMMENT_ENDPOINT, 501);
    }

    @Then("Assert that the comment was deleted")
    public void AssertThatTheCommentWasDeleted() {
        response.then().assertThat().body("isEmpty()", Matchers.is(true));
    }

}



