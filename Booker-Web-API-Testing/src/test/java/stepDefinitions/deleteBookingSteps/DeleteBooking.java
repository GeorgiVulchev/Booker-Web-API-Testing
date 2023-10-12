package stepDefinitions.deleteBookingSteps;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.Utils;
import stepDefinitions.Hooks;
import stepDefinitions.commonSteps.CommonSteps;
import stepDefinitions.loginSteps.GenerateToken;

public class DeleteBooking {
	private int id;
	private RequestSpecification request;
	private Utils utils = new Utils();
	private CommonSteps commonSteps;
	private String token;

	public DeleteBooking(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}

	@Given("the id of the booking that should be deleted")
	public void the_id_of_the_booking_that_should_be_deleted() {
		id = commonSteps.getId();
	}

	@Given("a valid authentication token for delete a booking")
	public void a_valid_authentication_token_for_delete_a_booking() throws IOException {
		token = GenerateToken.getToken();

		request = given().spec(utils.requestSpecificationWithToken(token));
		commonSteps.setRequest(request);
	}

	@When("user calls deleteBooking with DELETE http request and id specified")
	public void user_calls_delete_booking_with_delete_http_request_and_id_specified() {
		APIResources resourceAPI = APIResources.valueOf("deleteBookingAPI");
		resourceAPI.getResource();

		System.out.println(resourceAPI.getResource() + id);
		commonSteps.setResponse(request.when().delete(resourceAPI.getResource() + id));
	}

}
