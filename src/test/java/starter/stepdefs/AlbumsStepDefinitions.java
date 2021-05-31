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


public class AlbumsStepDefinitions {

    private Response response;

    @Steps
    PlaceholderEndpoints placeholderEndpoints;

    @Steps
    VerifyEndpoint JSONPlaceholderCheck;

    @Given("the albums rest endpoint is online")
    public void theRestPostsEndpointIsOnline() {
        response = placeholderEndpoints.getRequest(albumsEndpoint);
        JSONPlaceholderCheck.validateHttpStatusCode(200, response);
    }

    @When("user sends GET request to albums endpoint")
    public void userGetAlbums() {
        response = placeholderEndpoints.getRequest(albumsEndpoint);
    }

    @Then("all Albums are returned")
    public void allAlbumsAreReturned() {
        JSONPlaceholderCheck.validateResponseSize(100, response);
    }

    @When("user creates new album")
    public void userCreatesAlbum() {
        response = placeholderEndpoints.postRequest(albumsEndpoint, albumsBody);
    }

    @Then("new album id is returned")
    public void newAlbumIdIsPosted() {
        response.then().assertThat().body("id", equalTo(101));
    }

    @When("user updates an album")
    public void userUpdateAlbum() {
        response = placeholderEndpoints.putSpecificRequest(specificAlbum, JsonBodyRandomData.TITLE_PUT_BODY(), 1);
    }

    @Then("the album update is successful")
    public void theAlbumUpdateIsSuccessful() {
        response.then().assertThat().body("title", equalTo(JsonBodyRandomData.randomString));
    }

    @When("user deletes an album")
    public void userDeleteAlbum() {
        response = placeholderEndpoints.deleteRequest(specificAlbum, 101);
    }

    @Then("the albums is deleted successfully")
    public void theAlbumIsDeletedSuccessfully() {
        response.then().assertThat().body("isEmpty()", Matchers.is(true));
    }

    @When("user sends GET request to (\\d+) albums photos endpoint$")
    public void userGetPhotos(int albums) {
        response = placeholderEndpoints.getSpecificRequest(photosPOST, albums);
    }

    @Then("all photos are returned")
    public void allPhotosAreReturned() {
        JSONPlaceholderCheck.validateResponseSize(50, response);
    }

    @When("user creates a new photo within an album")
    public void userCreatesNewPhoto() {
        response = placeholderEndpoints.postSpecificRequest(photosPOST, photosBody, 1);
    }

    @Then("new photo id is returned")
    public void newPhotoIdReturned() {
        response.then().assertThat().body("id", equalTo(5001));
    }

    @When("user deletes a photo")
    public void userDeletesPhoto() {
        response = placeholderEndpoints.deleteRequest(specificPhoto, 5001);
    }

    @Then("the photo is deleted successfully")
    public void photoIsRemovedSuccessfully() {
        response.then().assertThat().body("isEmpty()", Matchers.is(true));
    }
}
