Feature: API tests for /users endpoint

  Description: Purpose of these tests is to cover the /users endpoint happy paths, its nested routes and smoke test

  Background: User checks if the endpoint is online
    Given The rest endpoint is online

  @smoke
  Scenario: Users endpoint smoke test
    When we POST valid user information
    And we GET user information
    Then we DELETE the user information

  @user_regression @regression
  Scenario: Users GET endpoint
    When we GET users
    Then we Assert that all users are returned

  @user_regression @regression
  Scenario: Users GET albums nested route
    When we GET users/albums
    Then we Assert that all albums are returned

  @user_regression @regression
  Scenario: Users GET posts nested route
    When we GET users/posts
    Then we Assert that all posts are returned

  @user_regression @regression
  Scenario: Users GET todos nested route
    When we GET users/todos
    Then we Assert that all users are returned

  @user_regression @regression
  Scenario: Users POST invalid body endpoint
    When we POST with invalid body
    Then we Assert that the POST was unsuccessful





