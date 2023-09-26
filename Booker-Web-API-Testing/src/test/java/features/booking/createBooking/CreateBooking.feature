Feature: Generate an authentication Token

  @CreateBooking
  Scenario: Create a new booking
   Given test data and a valid authentication token
    When user calls "createBookingAPI" with "POST" http request and provide a token
    Then the API call is successful with status code of 200