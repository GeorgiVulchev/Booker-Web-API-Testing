package stepDefinitions.loginSteps;

import org.junit.Assert;

import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.LoginResponse;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class GenerateToken {
	Utils utils = new Utils();
	TestDataBuild data = new TestDataBuild();
	RequestSpecification request;
	public static Response response;
	LoginResponse loginResponse;

	@Given("valid user credentials")
	public void valid_user_credentials() throws IOException {
		request = given().spec(utils.requestSpecification()).body(data.loginRequestDetails());
	}

	@When("user makes an authentication attempt")
	public void user_makes_an_authentication_attempt() {
		APIResources resourceAPI = APIResources.valueOf("authAPI");
		resourceAPI.getResource();

		response = request.when().post(resourceAPI.getResource());
	}

	@Then("the API call is successful with status code {int}")
	public void the_api_call_is_successful_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("the response body contains an authorization token")
	public void the_response_body_contains_an_authorization_token() {
		loginResponse = response.as(LoginResponse.class);
		Assert.assertNotNull(loginResponse.getToken());
	}
	
	public static String getToken() {
		String token = response.as(LoginResponse.class).getToken();
		return token;
	}
}
