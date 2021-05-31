package starter.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.objects.VerifyEndpoint;
import starter.objects.JsonBodyRandomData;
import starter.objects.PlaceholderEndpoints;
import static starter.objects.EndpointPath.*;

import static org.hamcrest.Matchers.equalTo;

public class PostsStepDefinitions {

    private Response response;

    @Steps
    PlaceholderEndpoints placeholderEndpoints;

    @Steps
    VerifyEndpoint JSONPlaceholderCheck;

        @Given("the posts rest endpoint is online")
    public void theRestPostsEndpointIsOnline() {
        response = placeholderEndpoints.getRequest(postsEndpoint);
        JSONPlaceholderCheck.validateHttpStatusCode(200, response);
    }

    @When("user sends GET request to posts endpoint")
    public void userGetPosts() {
        response = placeholderEndpoints.getRequest(postsEndpoint);
    }

    @Then("all Posts are returned")
    public void allPostsAreReturned() {
        JSONPlaceholderCheck.validateResponseSize(100, response);
    }

    @When("user creates new post")
    public void userCreatesPost() {
        response = placeholderEndpoints.postRequest(postsEndpoint, postsBody);
    }

    @Then("new post id is returned")
    public void newPostIdIsReturned() {
        response.then().assertThat().body("id", equalTo(101));
    }

    @When("user updates a post")
    public void userUpdatePost() {
        response = placeholderEndpoints.putSpecificRequest(specificPost, JsonBodyRandomData.TITLE_PUT_BODY(), 1);
    }

    @Then("the post update is successful")
    public void thePostUpdateIsSuccessful() {
        response.then().assertThat().body("title", equalTo(JsonBodyRandomData.randomString));
    }

    @When("user deletes a post")
    public void userDeletesPost() {
        response = placeholderEndpoints.deleteRequest(specificPost, 101);
    }

    @Then("the post is deleted successfully")
    public void thePostIsDeletedSuccessfully() {
        response.then().assertThat().body("isEmpty()", Matchers.is(true));
    }

    @When("user sends GET request to (\\d+) posts comments endpoint$")
    public void userGetComments(int posts) {
        response = placeholderEndpoints.getSpecificRequest(commentPOST , posts);
    }

    @Then("all comments are returned")
    public void allCommentsAreReturned() {
        JSONPlaceholderCheck.validateResponseSize(5, response);
    }

    @When("user creates a new comment within a post")
    public void userCreatesNewComment() {
        response = placeholderEndpoints.postSpecificRequest(commentPOST , commentBody, 1);
    }

    @Then("new comment id is returned")
    public void newCommentIdReturned() {
        response.then().assertThat().body("id", equalTo(501));
    }

    @When("user deletes a comment")
    public void userDeletesComment() {
        response = placeholderEndpoints.deleteRequest(specificComment, 501);
    }

    @Then("the comment is deleted successfully")
    public void commentIsRemovedSuccessfully() {
        response.then().assertThat().body("isEmpty()", Matchers.is(true));
    }

}



