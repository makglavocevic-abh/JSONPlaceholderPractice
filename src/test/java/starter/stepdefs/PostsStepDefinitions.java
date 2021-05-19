package starter.stepdefs;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import starter.objects.PlaceholderPosts;

public class PostsStepDefinitions {

    PlaceholderPosts jsonPlaceHolder = new PlaceholderPosts();

    @Given("The rest posts endpoint is online")
    public void theRestPostsEndpointIsOnline() {
        Assert.assertEquals(200, jsonPlaceHolder.getPoststatusCode());
    }
}



