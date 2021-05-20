package starter.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import starter.objects.EndpointStatus;
import starter.objects.PlaceholderEndpoints;

import static org.hamcrest.Matchers.*;

public class UsersStepDefinitions {

    private Response responseGETUsers;
    private Response responseGETUsersAlbums;
    private Response responsePOSTUser;

    private final String NEW_USERS_ENDPOINT = "https://jsonplaceholder.typicode.com/users/11";
    private final String NEW_USER_BODY = "src/test/java/starter/objects/validpostbody.json";
    private final String USERS_ENDPOINT = "https://jsonplaceholder.typicode.com/users";
    private final String USERS_ONE_ALBUMS_ENDPOINT = "https://jsonplaceholder.typicode.com/users/1/albums";
    PlaceholderEndpoints jsonPlaceHolderUsers = new PlaceholderEndpoints();
    EndpointStatus jsonPlaceHolderStatus = new EndpointStatus();

    @Given("The rest endpoint is online")
    public void theRestEndpointIsOnline() {
        Assert.assertEquals(200, jsonPlaceHolderStatus.getStatusCode(USERS_ENDPOINT));
    }

    @When("we POST valid user information")
    public void wePOSTValidUserInformation() {
        responsePOSTUser = PlaceholderEndpoints.postRequest(USERS_ENDPOINT, NEW_USER_BODY);
    }


    @And("we Assert that new user id is posted")
    public void weAssertThatNewUserIdIsPosted() {
        responsePOSTUser.then().assertThat().body("id", equalTo(11));
    }

    @And("we GET user information")
    public void weGETUserInformation() {
        PlaceholderEndpoints.getRequest(USERS_ENDPOINT);
    }

    @Then("we DELETE the user information")
    public void weDELETETheUserInformation() {
        jsonPlaceHolderUsers.deleteRequest(NEW_USERS_ENDPOINT);
    }

    @When("we GET users")
    public void weGETUsers() {
        responseGETUsers = PlaceholderEndpoints.getRequest(USERS_ENDPOINT);
    }

    @Then("we Assert that all users are returned")
    public void weAssertThatAllUsersAreReturned() {
        responseGETUsers.then().assertThat().contentType(ContentType.JSON).and().body("size()", equalTo(10));
    }

    @When("we GET users albums")
    public void weGETUsersAlbums() {
        responseGETUsersAlbums = PlaceholderEndpoints.getRequest(USERS_ONE_ALBUMS_ENDPOINT);
    }

    @Then("we Assert that all albums are returned")
    public void weAssertThatAllAlbumsAreReturned() {
        responseGETUsersAlbums.then().assertThat().contentType(ContentType.JSON).and().body("userId", hasItem(is(1)));
    }

}
