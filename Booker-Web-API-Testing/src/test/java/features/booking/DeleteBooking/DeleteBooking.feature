Feature: Delete a booking

  @DeleteBooking
  Scenario: Delete a booking with specific id
   Given the id of the booking that should be deleted
   And a valid authentication token for delete a booking
    When user calls deleteBooking with DELETE http request and id specified
    Then the API call is successful with status code of 201