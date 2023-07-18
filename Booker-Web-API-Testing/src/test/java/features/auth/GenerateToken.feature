Feature: Generate an authentication Token

  @auth
  Scenario: Verify if token is generated with valid credentials
   Given valid user credentials
    When user sends a POST request to restful-booker authentication api
    Then the API call is successful with status code 200
    And the response body contains an authorization token