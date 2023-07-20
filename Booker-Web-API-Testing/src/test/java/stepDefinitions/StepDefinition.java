package stepDefinitions;

import org.junit.Assert;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequest;

import resources.Utils;

public class StepDefinition {
	Utils utils = new Utils();
	RequestSpecification request;
	RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com")
			.setContentType(ContentType.JSON).build();
	Response response;
	JsonPath js;
	
	@Given("valid user credentials")
	public void valid_user_credentials() {
	    LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUsername("admin");
		loginRequest.setPassword("password123");
		request = given().spec(requestSpec).body(loginRequest);
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
		Assert.assertNotNull(utils.getJsonPath(response, "token"));
	}
}
