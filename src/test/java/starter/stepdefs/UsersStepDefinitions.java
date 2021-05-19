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
import static org.hamcrest.Matchers.equalTo;



public class UsersStepDefinitions {

    private Response responseGETusers;
    private final String ENDPOINT_GET_NEW_USERS_FROM_JSONPLACEHOLDER = "https://jsonplaceholder.typicode.com/users/11";
    private final String ENDPOINT_GET_USERS_FROM_JSONPLACEHOLDER = "https://jsonplaceholder.typicode.com/users";
    PlaceholderUsers jsonPlaceHolderUsers = new PlaceholderUsers();
    EndpointStatus jsonPlaceHolderStatus = new EndpointStatus();

    @Given("The rest endpoint is online")
    public void theRestEndpointIsOnline() {
        Assert.assertEquals(200, jsonPlaceHolderStatus.getUsersStatusCode(ENDPOINT_GET_USERS_FROM_JSONPLACEHOLDER));
    }

    @When("we POST valid user information")
    public void wePOSTValidUserInformation() {
        PlaceholderUsers.postNewUsers(ENDPOINT_GET_USERS_FROM_JSONPLACEHOLDER);
    }

    @And("we GET user information")
    public void weGETUserInformation() {
        PlaceholderUsers.getNewUsers(ENDPOINT_GET_USERS_FROM_JSONPLACEHOLDER);

    }

    @Then("we DELETE the user information")
    public void weDELETETheUserInformation() {
        jsonPlaceHolderUsers.deleteNewUsers(ENDPOINT_GET_NEW_USERS_FROM_JSONPLACEHOLDER);
    }

    @When("we GET users")
    public void weGETUsers() {
        responseGETusers = PlaceholderUsers.getNewUsers(ENDPOINT_GET_USERS_FROM_JSONPLACEHOLDER);
    }

    @Then("we Assert that all users are returned")
    public void weAssertThatAllUsersAreReturned() {
        responseGETusers.then().assertThat().contentType(ContentType.JSON).and().body("size()", equalTo(10));
    }
}
