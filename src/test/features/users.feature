Feature: API tests for /users endpoint

  Description: Purpose of these tests is to cover the /users endpoint happy paths and its nested routes

  Background:
    Given The rest endpoint is online

  Scenario: Users endpoint smoke test
    When we POST valid user information
    And we GET user information
    Then we DELETE the user information


