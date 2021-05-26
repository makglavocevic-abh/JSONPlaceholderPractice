package starter.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import starter.objects.VerifyEndpoint;
import starter.objects.EndpointPath;
import starter.objects.PlaceholderEndpoints;

import static org.hamcrest.Matchers.*;

public class UsersStepDefinitions {

    private Response response;

    VerifyEndpoint JSONPlaceholderCheck = new VerifyEndpoint();

    @Given("The rest endpoint is online")
    public void theRestEndpointIsOnline() {
        response = PlaceholderEndpoints.getRequest(EndpointPath.USERS_ENDPOINT);
        JSONPlaceholderCheck.validateHttpStatusCode(200, response);
    }

    @When("User posts valid user body")
    public void POSTValidUserInformation() {
        response = PlaceholderEndpoints.postRequest(EndpointPath.USERS_ENDPOINT, EndpointPath.NEW_USER_BODY);
    }

    @And("Assert that new user id is posted")
    public void AssertThatNewUserIdIsPosted() {
        response.then().assertThat().body("id", equalTo(11));
    }

    @And("GET user information")
    public void GETUserInformation() {
        PlaceholderEndpoints.getRequest(EndpointPath.USERS_ENDPOINT);
    }

    @Then("DELETE the user")
    public void DELETETheUserInformation() {
        PlaceholderEndpoints.deleteRequest(EndpointPath.NEW_USERS_ENDPOINT, 11);
    }

    @When("User sends GET request to users endpoint")
    public void GETUsers() {
        response = PlaceholderEndpoints.getRequest(EndpointPath.USERS_ENDPOINT);
    }

    @Then("Assert that all users are returned")
    public void AssertThatAllUsersAreReturned() {
        JSONPlaceholderCheck.validateResponseSize(10, response);
    }

    @When("User sends GET request to users albums endpoint")
    public void GETUsersAlbums() {
        response = PlaceholderEndpoints.getSpecificRequest(EndpointPath.USERS_ONE_ALBUMS_ENDPOINT, 1);
    }

    @Then("Assert that all albums are returned")
    public void AssertThatAllAlbumsAreReturned() {
        JSONPlaceholderCheck.validateResponseSizeAndUserId(10, 1, response);
    }

    @When("User sends GET request to users posts endpoint")
    public void GETUsersPosts() {
        response = PlaceholderEndpoints.getSpecificRequest(EndpointPath.USERS_ONE_POSTS_ENDPOINT, 1);
    }

    @Then("Assert that all posts are returned")
    public void AssertThatAllPostsAreReturned() {
        JSONPlaceholderCheck.validateResponseSizeAndUserId(10, 1, response);
    }

    @When("User sends GET request to users todos endpoint")
    public void GETUsersTodos() {
        response = PlaceholderEndpoints.getSpecificRequest(EndpointPath.USERS_ONE_TODOS_ENDPOINT, 1);
    }

    @Then("Assert that all todos are returned")
    public void AssertThatAllTodosAreReturned() {
        JSONPlaceholderCheck.validateResponseSizeAndUserId(20, 1, response);
    }
}
