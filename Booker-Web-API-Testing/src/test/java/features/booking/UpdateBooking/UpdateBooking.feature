Feature: Update a booking

  @UpdateBooking
  Scenario: Update a booking with specific id
   Given the id of the booking that should be updated
   And a valid authentication token
   And test data for updating a booking
    When user calls updateBookingAPI with PUT http request and id specified
    Then the API call is successful with status code of 200