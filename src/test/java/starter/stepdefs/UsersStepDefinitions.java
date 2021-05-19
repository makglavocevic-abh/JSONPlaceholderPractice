package starter.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import starter.objects.EndpointStatus;
import starter.objects.PlaceholderUsers;

import static org.hamcrest.Matchers.*;


public class UsersStepDefinitions {

    private Response responseGETUsers;
    private Response responseGETUsersAlbums;

    private final String NEW_USERS_ENDPOINT = "https://jsonplaceholder.typicode.com/users/11";
    private final String USERS_ENDPOINT = "https://jsonplaceholder.typicode.com/users";
    private final String USERS_ONE_ALBUMS_ENDPOINT = "https://jsonplaceholder.typicode.com/users/1/albums";
    PlaceholderUsers jsonPlaceHolderUsers = new PlaceholderUsers();
    EndpointStatus jsonPlaceHolderStatus = new EndpointStatus();

    @Given("The rest endpoint is online")
    public void theRestEndpointIsOnline() {
        Assert.assertEquals(200, jsonPlaceHolderStatus.getStatusCode(USERS_ENDPOINT));
    }

    @When("we POST valid user information")
    public void wePOSTValidUserInformation() {
        PlaceholderUsers.postNewUser(USERS_ENDPOINT);
    }

    @And("we GET user information")
    public void weGETUserInformation() {
        PlaceholderUsers.getUsers(USERS_ENDPOINT);

    }

    @Then("we DELETE the user information")
    public void weDELETETheUserInformation() {
        jsonPlaceHolderUsers.deleteNewUsers(NEW_USERS_ENDPOINT);
    }

    @When("we GET users")
    public void weGETUsers() {
        responseGETUsers = PlaceholderUsers.getUsers(USERS_ENDPOINT);
    }

    @Then("we Assert that all users are returned")
    public void weAssertThatAllUsersAreReturned() {
        responseGETUsers.then().assertThat().contentType(ContentType.JSON).and().body("size()", equalTo(10));
    }

    @When("we GET users albums")
    public void weGETUsersAlbums() {
        responseGETUsersAlbums = PlaceholderUsers.getUsers(USERS_ONE_ALBUMS_ENDPOINT);
    }

    @Then("we Assert that all albums are returned")
    public void weAssertThatAllAlbumsAreReturned() {
        responseGETUsersAlbums.then().assertThat().contentType(ContentType.JSON).and().body("userId", hasItem(is(1)));
    }
}
