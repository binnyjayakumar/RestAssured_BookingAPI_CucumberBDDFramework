package Tests;

import org.testng.Assert;

import Utils.BaseTest;
import Utils.PropertiesFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class bookingAPIget extends BaseTest
{
	static Response response;
	public void fetch_bookings()
	{
		response = RestAssured
				.given()
				.spec(getRequestSpec())
				.when()
				.get(PropertiesFile.getProperty("endpoint"));
	}
	
	public void get_request()
	{
		response.getBody().prettyPrint();
	}
	
	public void validate_response()
	{
		Assert.assertEquals(response.getStatusCode(), 200);	
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");	
		Assert.assertTrue(response.getBody().asString().contains("bookingid"));
	}
}
