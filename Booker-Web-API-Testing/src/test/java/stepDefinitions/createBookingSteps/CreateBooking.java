package stepDefinitions.createBookingSteps;

import io.cucumber.java.en.Given;
import static io.restassured.RestAssured.given;
import java.io.IOException;

import io.restassured.specification.RequestSpecification;
import resources.TestDataBuild;
import resources.Utils;
import stepDefinitions.commonSteps.CommonSteps;

public class CreateBooking {
	private RequestSpecification request;
	private Utils utils = new Utils();
	private TestDataBuild data = new TestDataBuild();
	private CommonSteps commonSteps;

	public CreateBooking(CommonSteps commonSteps) {
		this.commonSteps = commonSteps;
	}

	@Given("test data for creating a booking")
	public void test_data_for_creating_a_booking() throws IOException {
		request = given().spec(utils.requestSpecification()).body(data.createBookingRequestDetails());
		commonSteps.setRequest(request);
	}
}
