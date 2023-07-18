Feature: Generate an authentication Token

  @auth
  Scenario: Verify if token is generated with valid credentials
   Given the API endpoint for generating auth tokens "https://restful-booker.herokuapp.com/auth"
    And the request body contains valid username and password
    When a POST request is sent to the endpoint
    Then the response status code should be 200
    And the response body should contain a valid auth token