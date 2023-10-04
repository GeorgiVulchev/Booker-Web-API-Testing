Feature: Create a new booking

  @CreateBooking
  Scenario: Create a new booking
   Given test data for creating a booking
    When user calls "createBookingAPI" with "POST" http request
    Then the API call is successful with status code of 200