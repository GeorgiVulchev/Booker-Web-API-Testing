package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;
import io.restassured.response.Response;
import pojo.LoginResponse;
import stepDefinitions.loginSteps.GenerateToken;

public class Hooks {
	private static GenerateToken generateToken = new GenerateToken();

	//These methods will be used whenever a request requires a token.
	@Before("UpdateBooking")
	public void beforeScenario() throws IOException {
		generateToken.valid_user_credentials();
		generateToken.user_calls_with_http_request("authAPI", "POST");
	}

	public static String getToken() {
		Response response = generateToken.response;
		String token = response.as(LoginResponse.class).getToken();
		return token;
	}
}