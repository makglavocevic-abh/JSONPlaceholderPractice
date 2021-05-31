Feature: smoke test for JSONplaceholder API

  Description: This smoke test represent an End-to-End that tests JSONplaceholder API from beginning to end to
  ensure the application flow behaves as expected. The flow consists off end user creating a new user, creating a
  to do list, adding a new to do item, updating it to done, delete the list, delete the new user.

  @smoke
  Scenario: Verify that end user can create a new user, make a to do list, add a new to do item, update its
  status to completed, delete the list, delete the new user
    Given end user creates a new user
    And user id is returned
    When user creates a to do list
    And to do list id is returned
    And changes its status to completed
    Then user deletes the list
    And the list is deleted successfully
    And deletes the new user
    And the user is deleted successfully