Feature: API tests for /albums endpoint

  Description: Albums feature is an endpoint that allows us to create, edit and delete albums.
  There are also photos nested route that allow users to view add and delete photos on their albums.

  Background: User checks if the endpoint is online
    Given The albums rest endpoint is online

  @albums_regression @regression
  Scenario: Verify that the user can access albums information
    When User sends GET request to albums endpoint
    Then Assert that all Albums are returned

  @albums_regression @regression
  Scenario: Verify that the user can post new album with valid information
    When User posts valid albums body
    Then Assert that new album id is posted

  @albums_regression @regression
  Scenario: Verify that the user can edit information on their albums
    When User sends PUT request with valid albums body
    Then Assert that the albums update was successful

  @albums_regression @regression
  Scenario: Verify that the user can delete their albums
    When User sends DELETE request to albums endpoint
    Then Assert that the Album is deleted

  @albums_regression @regression
  Scenario Outline: Verify that the user can access their post comments
    When User sends GET request to <albums> photos
    Then Assert that all photos are returned

    Examples:
      |albums|
      |1    |
      |2    |
      |3    |

  @albums_regression @regression
  Scenario: Verify that the user can post photos in their albums
    When User posts valid photo body
    Then Assert that the new photo was posted

  @albums_regression @regression
  Scenario: Verify that the user can delete photos from their album
    When User sends DELETE request to photos endpoint
    Then Assert that the photo was deleted