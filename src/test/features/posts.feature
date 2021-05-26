Feature: API tests for /posts endpoint

  Description: Posts feature is an endpoint that allows us to create, edit and delete posts.
  There are also comments nested route that allow users to view add and delete comments on their posts.

  Background: User checks if the endpoint is online
    Given The posts rest endpoint is online

  @posts_regression @regression
  Scenario: Verify that the user can access posts information
    When User sends GET request to posts endpoint
    Then Assert that all Posts are returned

  @posts_regression @regression
  Scenario: Verify that the user can post new posts with valid information
    When User posts valid posts body
    Then Assert that new post id is posted

  @posts_regression @regression
  Scenario: Verify that the user can edit information on their posts
    When User send PUT request with valid body
    Then Assert that the posts update was successful

  @posts_regression @regression
  Scenario: Verify that the user can delete their posts
    When User sends DELETE request to posts endpoint
    Then Assert that the post is deleted

  @posts_regression @regression
  Scenario Outline: Verify that the user can access their post comments
    When User sends GET request to <posts> comments
    Then Assert that all comments are returned

  Examples:
    |posts|
    |1    |
    |2    |
    |3    |

  @posts_regression @regression
  Scenario: Verify that users can post comments using valid information
    When User posts valid comment body to a post
    Then Assert that the new comment was posted

  @posts_regression @regression
  Scenario: Verify that the user can delete comments from their posts
    When User sends DELETE request to comments endpoint
    Then Assert that the comment was deleted