package stepDefinitions.updateBookingSteps;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import stepDefinitions.Hooks;
import stepDefinitions.commonSteps.CommonSteps;

public class UpdateBooking {
	private int id;
	private RequestSpecification request;
	private Utils utils = new Utils();
	private TestDataBuild data = new TestDataBuild();
	private CommonSteps commonSteps;
	private String token;

	public UpdateBooking(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}

// This is a temporary solution for testing purposes
	@Given("the id of the booking that should be updated")
	public void the_id_of_the_booking_that_should_be_updated() throws IOException {
		id = 1802;
	}

	@Given("a valid authentication token")
	public void a_valid_authentication_token() {
		token = Hooks.getToken();
		System.out.println(token);
	}

	@Given("test data for updating a booking")
	public void test_data_for_updating_a_booking() throws IOException {
		request = given().spec(utils.requestSpecificationWithToken(token)).body(data.updateBookingRequestDetails());
		commonSteps.setRequest(request);
	}

	@When("user calls updateBookingAPI with PUT http request and id specified")
	public void user_calls_with_http_request_and_id_specified() {
		APIResources resourceAPI = APIResources.valueOf("updateBookingAPI");
		resourceAPI.getResource();

		System.out.println(resourceAPI.getResource() + id);
		commonSteps.setResponse(request.when().put(resourceAPI.getResource() + id));
	}
}
