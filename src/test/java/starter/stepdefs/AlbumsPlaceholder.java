package starter.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import starter.objects.VerifyEndpoint;
import starter.objects.EndpointPath;
import starter.objects.JsonBodyRandomData;
import starter.objects.PlaceholderEndpoints;

import static org.hamcrest.Matchers.equalTo;

public class AlbumsPlaceholder {

    private Response response;

    VerifyEndpoint JSONPlaceholderCheck = new VerifyEndpoint();

    @Given("The albums rest endpoint is online")
    public void theRestPostsEndpointIsOnline() {
        response = PlaceholderEndpoints.getRequest(EndpointPath.ALBUMS_ENDPOINT);
        JSONPlaceholderCheck.validateHttpStatusCode(200, response);
    }

    @When("User sends GET request to albums endpoint")
    public void GETAlbums() {
        response = PlaceholderEndpoints.getRequest(EndpointPath.ALBUMS_ENDPOINT);
    }

    @Then("Assert that all Albums are returned")
    public void AssertThatAllAlbumsAreReturned() {
        JSONPlaceholderCheck.validateResponseSize(100, response);
    }

    @When("User posts valid albums body")
    public void POSTValidAlbumBody() {
        response = PlaceholderEndpoints.postRequest(EndpointPath.ALBUMS_ENDPOINT, EndpointPath.NEW_ALBUM_BODY);
    }

    @Then("Assert that new album id is posted")
    public void AssertThatNewAlbumIdIsPosted() {
        response.then().assertThat().body("id", equalTo(101));
    }

    @When("User sends PUT request with valid albums body")
    public void PUTAlbumsWithNewChanges() {
        response = PlaceholderEndpoints.putSpecificRequest(EndpointPath.ALBUM_ENDPOINT, JsonBodyRandomData.TITLE_PUT_BODY(), 1);
    }

    @Then("Assert that the albums update was successful")
    public void AssertThatTheUpdateWasSuccessful() {
        response.then().assertThat().body("title", equalTo(JsonBodyRandomData.randomString));
    }

    @When("User sends DELETE request to albums endpoint")
    public void DELETEAlbums() {
        response = PlaceholderEndpoints.deleteRequest(EndpointPath.NEW_ALBUM_ENDPOINT, 101);
    }

    @Then("Assert that the Album is deleted")
    public void AssertThatTheAlbumIsDeleted() {
        response.then().assertThat().body("isEmpty()", Matchers.is(true));
    }

    @When("User sends GET request to (\\d+) photos$")
    public void GETPhotosNestedRoute(int albums) {
        response = PlaceholderEndpoints.getSpecificRequest(EndpointPath.ALBUMS_PHOTOS_ENDPOINT, albums);
    }

    @Then("Assert that all photos are returned")
    public void AssertThatAllPhotosAreReturned() {
        JSONPlaceholderCheck.validateResponseSize(50, response);
    }

    @When("User posts valid photo body")
    public void POSTPhotosNestedRoute() {
        response = PlaceholderEndpoints.postSpecificRequest(EndpointPath.ALBUMS_PHOTOS_ENDPOINT, EndpointPath.NEW_PHOTOS_BODY, 1);
    }

    @Then("Assert that the new photo was posted")
    public void AssertThatTheNewPhotoWasPosted() {
        response.then().assertThat().body("id", equalTo(5001));
    }

    @When("User sends DELETE request to photos endpoint")
    public void DELETEPhotosNestedRoute() {
        response = PlaceholderEndpoints.deleteRequest(EndpointPath.NEW_PHOTOS_ENDPOINT, 5001);
    }

    @Then("Assert that the photo was deleted")
    public void AssertThatThePhotoWasDeleted() {
        response.then().assertThat().body("isEmpty()", Matchers.is(true));
    }
}
