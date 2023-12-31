package stepDefinitions.commonSteps;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CreateBookingResponse;
import resources.APIResources;

public class CommonSteps {
	private Response response;
	private RequestSpecification request;
	private int id;

	public void setRequest(RequestSpecification request) {
		this.request = request;
	}

	public RequestSpecification setRequest() {
		return request;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public Response getResponse() {
		return response;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpMethod) {
		APIResources resourceAPI = APIResources.valueOf(resource);
		resourceAPI.getResource();

		if (httpMethod.equalsIgnoreCase("POST")) {
			response = request.when().post(resourceAPI.getResource());
			id = response.as(CreateBookingResponse.class).getBookingid();
		} else if (httpMethod.equalsIgnoreCase("GET"))
			response = request.when().get(resourceAPI.getResource());
	}

	@Then("the API call is successful with status code of {int}")
	public void the_api_call_is_successful_with_status_code_of(int statusCode) {
		assertEquals(response.getStatusCode(), statusCode);
	}
}
