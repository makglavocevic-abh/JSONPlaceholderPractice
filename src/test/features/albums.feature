Feature: API tests for /albums endpoint

  Description: Albums feature is an endpoint that allows us to create, edit and delete albums.
  There are also photos nested route that allow users to view add and delete photos on their albums.

  Background: User checks if the endpoint is online
    Given the albums rest endpoint is online

  @albums_regression @regression
  Scenario: Verify that the user can access albums information
    When user sends GET request to albums endpoint
    Then all Albums are returned

  @albums_regression @regression
  Scenario: Verify that the user can post new album with valid information
    When user creates new album
    Then new album id is returned

  @albums_regression @regression
  Scenario: Verify that the user can edit information on their albums
    When user updates an album
    Then the album update is successful

  @albums_regression @regression
  Scenario: Verify that the user can delete their albums
    When user deletes an album
    Then the albums is deleted successfully

  @albums_regression @regression
  Scenario Outline: Verify that the user can access their post comments
    When user sends GET request to <albumId> albums photos endpoint
    Then all photos are returned

    Examples:
      |albumId|
      |1      |
      |2      |
      |3      |

  @albums_regression @regression
  Scenario: Verify that the user can post photos in their albums
    When user creates a new photo within an album
    Then new photo id is returned

  @albums_regression @regression
  Scenario: Verify that the user can delete photos from their album
    When user deletes a photo
    Then the photo is deleted successfully