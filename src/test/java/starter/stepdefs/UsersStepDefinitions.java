package starter.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import starter.objects.EndpointStatus;
import starter.objects.EndpointsConst;
import starter.objects.PlaceholderEndpoints;

import static org.hamcrest.Matchers.*;

public class UsersStepDefinitions {

    private Response response;

    PlaceholderEndpoints jsonPlaceHolderUsers = new PlaceholderEndpoints();
    EndpointStatus jsonPlaceHolderStatus = new EndpointStatus();

    @Given("The rest endpoint is online")
    public void theRestEndpointIsOnline() {
        Assert.assertEquals(200, jsonPlaceHolderStatus.getStatusCode(EndpointsConst.USERS_ENDPOINT));
    }

    @When("we POST valid user body")
    public void wePOSTValidUserInformation() {
        response = PlaceholderEndpoints.postRequest(EndpointsConst.USERS_ENDPOINT, EndpointsConst.NEW_USER_BODY);
    }

    @And("we Assert that new user id is posted")
    public void weAssertThatNewUserIdIsPosted() {
        response.then().assertThat().body("id", equalTo(11));
    }

    @And("we GET user information")
    public void weGETUserInformation() {
        PlaceholderEndpoints.getRequest(EndpointsConst.USERS_ENDPOINT);
    }

    @Then("we DELETE the user information")
    public void weDELETETheUserInformation() {
        jsonPlaceHolderUsers.deleteRequest(EndpointsConst.NEW_USERS_ENDPOINT);
    }

    @When("we GET users")
    public void weGETUsers() {
        response = PlaceholderEndpoints.getRequest(EndpointsConst.USERS_ENDPOINT);
    }

    @Then("we Assert that all users are returned")
    public void weAssertThatAllUsersAreReturned() {
        response.then().assertThat().contentType(ContentType.JSON)
                .and().body("size()", equalTo(10));
    }

    @When("we GET users albums")
    public void weGETUsersAlbums() {
        response = PlaceholderEndpoints.getRequest(EndpointsConst.USERS_ONE_ALBUMS_ENDPOINT);
    }

    @Then("we Assert that all albums are returned")
    public void weAssertThatAllAlbumsAreReturned() {
        response.then().assertThat().contentType(ContentType.JSON)
                .and().body("size()", equalTo(10))
                .and().body("userId", hasItem(is(1)));
    }

    @When("we GET users posts")
    public void weGETUsersPosts() {
        response = PlaceholderEndpoints.getRequest(EndpointsConst.USERS_ONE_POSTS_ENDPOINT);
    }

    @Then("we Assert that all posts are returned")
    public void weAssertThatAllPostsAreReturned() {
        response.then().assertThat().contentType(ContentType.JSON)
                .and().body("size()", equalTo(10))
                .and().body("userId", hasItem(is(1)));
    }

    @When("we GET users todos")
    public void weGETUsersTodos() {
        response = PlaceholderEndpoints.getRequest(EndpointsConst.USERS_ONE_TODOS_ENDPOINT);
    }

    @Then("we Assert that all todos are returned")
    public void weAssertThatAllTodosAreReturned() {
        response.then().assertThat().contentType(ContentType.JSON)
                .and().body("size()", equalTo(20))
                .and().body("userId", hasItem(is(1)));
    }
}
