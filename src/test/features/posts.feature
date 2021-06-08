Feature: API tests for /posts endpoint

  Description: Posts feature is an endpoint that allows us to create, edit and delete posts.
  There are also comments nested route that allow users to view add and delete comments on their posts.

  Background: User checks if the endpoint is online
    Given the posts rest endpoint is online

  @posts_regression @regression
  Scenario: Verify that the user can access posts information
    When user sends GET request to posts endpoint
    Then all Posts are returned

  @posts_regression @regression
  Scenario: Verify that the user can post new posts with valid information
    When user creates new post
    Then new post id is returned

  @posts_regression @regression
  Scenario: Verify that the user can edit information on their posts
    When user updates a post
    Then the post update is successful

  @posts_regression @regression
  Scenario: Verify that the user can delete their posts
    When user deletes a post
    Then the post is deleted successfully

  @posts_regression @regression
  Scenario Outline: Verify that the user can access their post comments
    When user sends GET request to <postsId> posts comments endpoint
    Then all comments are returned

  Examples:
    |postsId|
    |1      |
    |2      |
    |3      |

  @posts_regression @regression
  Scenario: Verify that users can post comments using valid information
    When user creates a new comment within a post
    Then new comment id is returned

  @posts_regression @regression
  Scenario: Verify that the user can delete comments from their posts
    When user deletes a comment
    Then the comment is deleted successfully