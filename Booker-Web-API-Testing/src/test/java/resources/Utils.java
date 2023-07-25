package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	RequestSpecification requestSpec;

	public RequestSpecification requestSpecification() throws IOException {
		PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
		requestSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();

		return requestSpec;
	}

	public String getJsonPath(Response response, String key) {
		String res = response.asString();
		JsonPath js = new JsonPath(res);

		return js.get(key);
	}

	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				"C:\\Users\\GValchev\\git\\Booker-Web-API-Testing\\Booker-Web-API-Testing\\src\\test\\java\\resources\\global.properties");
		prop.load(file);

		return prop.getProperty(key);
	}
}
