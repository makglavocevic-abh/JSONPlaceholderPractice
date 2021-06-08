Feature: API tests for /users endpoint

  Description: User feature is an endpoint that allows us to create, edit and delete users.
  There are also three nested routes that allow users to view their posts, albums and todos.

  Background: User checks if the endpoint is online
    Given the rest endpoint is online

  @user_regression @regression
  Scenario: Verify that a new user can be created using valid information and deleted
    When user creates a new user
    And new user id is returned
    Then delete the new user

  @user_regression @regression
  Scenario: Verify that the user can access users information
    When user sends GET request to users endpoint
    Then all users are returned

  @user_regression @regression
  Scenario: Verify that the user can access users albums
    When user sends GET request to users albums endpoint
    Then all albums are returned

  @user_regression @regression
  Scenario: Verify that the user can access users posts
    When user sends GET request to users posts endpoint
    Then all posts are returned

  @user_regression @regression
  Scenario: Verify that the user can access users todos
    When user sends GET request to users todos endpoint
    Then all todos are returned
