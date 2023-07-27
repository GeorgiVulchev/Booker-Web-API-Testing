Feature: Generate an authentication Token

  @auth
  Scenario: Verify if token is generated with valid credentials
   Given valid user credentials
    When user calls "authAPI" with "POST" http request
    Then the API call is successful with status code 200
    And the response body contains an authorization token