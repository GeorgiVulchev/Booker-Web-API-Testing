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
import resources.TestDataBuild;
import resources.Utils;

public class GenerateToken {
	Utils utils = new Utils();
	TestDataBuild data = new TestDataBuild();
	RequestSpecification request;
	Response response;
	LoginResponse loginResponse;

	@Given("valid user credentials")
	public void valid_user_credentials() throws IOException {
		request = given().spec(utils.requestSpecification()).body(data.loginRequestDetails());
	}

	@When("user sends a POST request to restful-booker authentication api")
	public void user_sends_a_post_request_to_restful_booker_authentication_api() {
		response = request.when().post("/auth");
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
}
