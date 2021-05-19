package starter.stepdefs;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import starter.objects.EndpointStatus;

public class PostsStepDefinitions {

    private final String POSTS_ENDPOINT = "https://jsonplaceholder.typicode.com/posts";

    EndpointStatus jsonPlaceHolderStatus = new EndpointStatus();

    @Given("The rest posts endpoint is online")
    public void theRestPostsEndpointIsOnline() {
        Assert.assertEquals(200, jsonPlaceHolderStatus.getStatusCode(POSTS_ENDPOINT));
    }
}



