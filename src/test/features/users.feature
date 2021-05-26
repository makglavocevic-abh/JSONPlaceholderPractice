Feature: API tests for /users endpoint

  Description: User feature is an endpoint that allows us to create, edit and delete users.
  There are also three nested routes that allow users to view their posts, albums and todos.

  Background: User checks if the endpoint is online
    Given The rest endpoint is online

  @smoke
  Scenario: Verify that a new user can be created using valid information and deleted
    When User posts valid user body
    And Assert that new user id is posted
    And GET user information
    Then DELETE the user

  @user_regression @regression
  Scenario: Verify that the user can access users information
    When User sends GET request to users endpoint
    Then Assert that all users are returned

  @user_regression @regression
  Scenario: Verify that the user can access users albums
    When User sends GET request to users albums endpoint
    Then Assert that all albums are returned

  @user_regression @regression
  Scenario: Verify that the user can access users posts
    When User sends GET request to users posts endpoint
    Then Assert that all posts are returned

  @user_regression @regression
  Scenario: Verify that the user can access users todos
    When User sends GET request to users todos endpoint
    Then Assert that all todos are returned
