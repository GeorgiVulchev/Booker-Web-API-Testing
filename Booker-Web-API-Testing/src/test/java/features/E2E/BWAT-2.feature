Feature: BWAT-2

  @E2E
  Scenario: User authenticates himself, Creates and Deletes a Booking

   Given valid user credentials
    When user makes an authentication attempt
    Then the API call is successful with status code 200
    And the response body contains an authorization token
    
   Given test data for creating a booking
    When user calls "createBookingAPI" with "POST" http request
    Then the API call is successful with status code of 200

   Given the id of the booking that should be deleted
   And a valid authentication token for delete a booking
    When user calls deleteBooking with DELETE http request and id specified
    Then the API call is successful with status code of 201