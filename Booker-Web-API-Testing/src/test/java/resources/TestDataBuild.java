package resources;

import pojo.BookingDates;
import pojo.CreateBookingRequest;
import pojo.LoginRequest;

public class TestDataBuild {

	public LoginRequest loginRequestDetails() {
		LoginRequest requestDetails = new LoginRequest();

		requestDetails.setUsername("admin");
		requestDetails.setPassword("password123");

		return requestDetails;
	}

	public CreateBookingRequest createBookingRequestDetails() {
		CreateBookingRequest createBookingRequestDetails = new CreateBookingRequest();

		createBookingRequestDetails.setFirstname("Georgi");
		createBookingRequestDetails.setLastname("Valchev");
		createBookingRequestDetails.setTotalprice(300);
		createBookingRequestDetails.setDepositpaid(false);
		createBookingRequestDetails.setAdditionalneeds("Dinner");

		BookingDates bookingdates = new BookingDates();
		bookingdates.setCheckin("2023-09-01");
		bookingdates.setCheckout("2023-09-10");

		createBookingRequestDetails.setBookingdates(bookingdates);

		return createBookingRequestDetails;
	}
	
	public CreateBookingRequest updateBookingRequestDetails() {
		CreateBookingRequest createBookingRequestDetails = new CreateBookingRequest();

		createBookingRequestDetails.setFirstname("Ivan");
		createBookingRequestDetails.setLastname("Ivanov");
		createBookingRequestDetails.setTotalprice(225);
		createBookingRequestDetails.setDepositpaid(true);
		createBookingRequestDetails.setAdditionalneeds("Breakfast");

		BookingDates bookingdates = new BookingDates();
		bookingdates.setCheckin("2023-09-21");
		bookingdates.setCheckout("2023-09-25");

		createBookingRequestDetails.setBookingdates(bookingdates);

		return createBookingRequestDetails;
	}
}
