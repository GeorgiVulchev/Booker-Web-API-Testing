package stepDefinitions.createBookingSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class CreateBooking {
	RequestSpecification request;
	Utils utils = new Utils();
	TestDataBuild data = new TestDataBuild();
	public Response response;

	@Given("test data and a valid authentication token")
	public void test_data_and_a_valid_authentication_token() throws IOException {
		request = given().spec(utils.requestSpecification()).body(data.createBookingRequestDetails());
	}

	@When("user calls {string} with {string} http request and provide a token")
	public void user_calls_with_http_request_and_provide_a_token(String resource, String httpMethod) {
		APIResources resourceAPI = APIResources.valueOf(resource);
		resourceAPI.getResource();

		if (httpMethod.equalsIgnoreCase("POST"))
			response = request.when().post(resourceAPI.getResource());
		else if (httpMethod.equalsIgnoreCase("GET"))
			response = request.when().get(resourceAPI.getResource());
	}

	@Then("the API call is successful with status code of {int}")
	public void the_api_call_is_successful_with_status_code_of(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}
}
