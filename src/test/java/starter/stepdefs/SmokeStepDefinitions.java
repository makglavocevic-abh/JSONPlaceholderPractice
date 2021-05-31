package starter.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;
import starter.objects.PlaceholderEndpoints;


import static org.hamcrest.Matchers.equalTo;
import static starter.objects.EndpointPath.*;

public class SmokeStepDefinitions {

    private Response response;

    @Steps
    PlaceholderEndpoints placeholderEndpoints;

    @Given("end user creates a new user")
    public void endUserCreatesANewUser() {
        response = placeholderEndpoints.postRequest(usersEndpoint, userBody);
    }

    @And("user id is returned")
    public void userIdIsReturned() {
        response.then().assertThat().body("id", equalTo(11));
    }

    @When("user creates a to do list")
    public void userCreatesAToDoList() {
        response = placeholderEndpoints.postRequest(todosEndpoint, todosBody);
    }

    @And("to do list id is returned")
    public void toDoListIdIsReturned() {
        response.then().assertThat().body("id", equalTo(201));
    }

    @And("changes its status to completed")
    public void changesItsStatusToCompleted() {
        response = placeholderEndpoints.putSpecificRequest(specificTodos, todosChangeStatusBody, 201);
    }

    @And("the status update was successful")
    public void theStatusUpdateWasSuccessful() {
        response.then().assertThat().body("completed", equalTo(true));
    }

    @Then("user deletes the list")
    public void userDeletesTheList() {
        response = placeholderEndpoints.deleteRequest(specificTodos, 201);
    }

    @And("the list is deleted successfully")
    public void theListIsDeletedSuccessfully() {
        response.then().assertThat().body("isEmpty()", Matchers.is(true));
    }

    @And("deletes the new user")
    public void deletesTheNewUser() {
        response = placeholderEndpoints.deleteRequest(specificUser, 11);
    }

    @And("the user is deleted successfully")
    public void theUserIsDeletedSuccessfully() {
        response.then().assertThat().body("isEmpty()", Matchers.is(true));

    }

}
