Feature: API tests for /posts endpoint

  Description: Purpose of these tests is to cover the /posts endpoint happy paths and its nested routes

  Background: User checks if the endpoint is online
    Given The rest endpoint is online

  @posts_regression @regression
  Scenario: Posts GET endpoint
    When we GET Posts
    Then we Assert that all Posts are returned

  @posts_regression @regression
  Scenario: Posts POST endpoint
    When we POST valid Post body
    Then we Assert that new post id is posted

  @posts_regression @regression
  Scenario: Posts PUT endpoint
    When we PUT Posts with new changes
    Then we Assert that the update was successful

  @posts_regression @regression
  Scenario: Posts DELETE endpoint
    When we DELETE Posts
    Then we Assert that the post is deleted

  @posts_regression @regression
  Scenario: Posts GET comments endpoint
    When we GET comments nested route
    Then we Assert that all comments are returned

  @posts_regression @regression
  Scenario: Posts POST comment endpoint
    When we POST comments nested route
    Then we Assert that the new comment was posted

  @posts_regression @regression
  Scenario: Posts DELETE comment endpoint
    When we DELETE comments nested route
    Then we Assert that the comments was deleted