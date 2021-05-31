package starter.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import starter.objects.VerifyEndpoint;
import starter.objects.PlaceholderEndpoints;
import static starter.objects.EndpointPath.*;

import static org.hamcrest.Matchers.*;

public class UsersStepDefinitions {

    private Response response;

    @Steps
    PlaceholderEndpoints placeholderEndpoints;

    @Steps
    VerifyEndpoint JSONPlaceholderCheck;

    @Given("the rest endpoint is online")
    public void theRestEndpointIsOnline() {
        response = placeholderEndpoints.getRequest(usersEndpoint);
        JSONPlaceholderCheck.validateHttpStatusCode(200, response);
    }

    @When("user creates a new user")
    public void createNewUser() {
        response = placeholderEndpoints.postRequest(usersEndpoint, userBody);
    }

    @And("new user id is returned")
    public void confirmThatTheUserIsCreated() {
        response.then().assertThat().body("id", equalTo(11));
    }

    @Then("delete the new user")
    public void deleteTheNewUser() {
        placeholderEndpoints.deleteRequest(specificUser, 11);
    }

    @When("user sends GET request to users endpoint")
    public void retrieveUserInformation() {
        response = placeholderEndpoints.getRequest(usersEndpoint);
    }

    @Then("all users are returned")
    public void thenAllUsersAreReturned() {
        JSONPlaceholderCheck.validateResponseSize(10, response);
    }

    @When("user sends GET request to users albums endpoint")
    public void userGetAlbums() {
        response = placeholderEndpoints.getSpecificRequest(userAlbums, 1);
    }

    @Then("all albums are returned")
    public void allAlbumsAreReturned() {
        JSONPlaceholderCheck.validateResponseSizeAndUserId(10, 1, response);
    }

    @When("user sends GET request to users posts endpoint")
    public void userGetPosts() {
        response = placeholderEndpoints.getSpecificRequest(userPosts, 1);
    }

    @Then("all posts are returned")
    public void allPostsAreReturned() {
        JSONPlaceholderCheck.validateResponseSizeAndUserId(10, 1, response);
    }

    @When("user sends GET request to users todos endpoint")
    public void userGetTodos() {
        response = placeholderEndpoints.getSpecificRequest(userTodos, 1);
    }

    @Then("all todos are returned")
    public void allTodosAreReturned() {
        JSONPlaceholderCheck.validateResponseSizeAndUserId(20, 1, response);
    }

}
