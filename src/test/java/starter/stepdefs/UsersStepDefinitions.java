package starter.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import starter.objects.users.PlaceholderUsers;

import java.io.IOException;


public class UsersStepDefinitions {

    PlaceholderUsers jsonPlaceHolder = new PlaceholderUsers();

    @Given("The rest endpoint is online")
    public void theRestEndpointIsOnline() {
        Assert.assertEquals(200, jsonPlaceHolder.getUsersStatusCode());
    }

    @When("we POST valid user information")
    public void wePOSTValidUserInformation() throws IOException {
        jsonPlaceHolder.postNewUsers();
    }

    @And("we GET user information")
    public void weGETUserInformation() {
        jsonPlaceHolder.getNewUsers();
    }

    @Then("we DELETE the user information")
    public void weDELETETheUserInformation() {
        jsonPlaceHolder.deleteNewUsers();
    }

}
