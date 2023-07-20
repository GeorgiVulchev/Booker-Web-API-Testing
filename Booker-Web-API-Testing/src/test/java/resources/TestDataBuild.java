package resources;

import pojo.LoginRequest;

public class TestDataBuild {

	public LoginRequest loginRequestDetails() {
		LoginRequest requestDetails = new LoginRequest();
		requestDetails.setUsername("admin");
		requestDetails.setPassword("password123");

		return requestDetails;
	}
}
