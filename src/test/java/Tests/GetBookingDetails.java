package Tests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.Assert;

import Utils.BaseTest;
import Utils.PropertiesFile;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingDetails extends BaseTest
{
	Response response;
	bookingAPIpost bpost = new bookingAPIpost();
	
	public void fetch_bookingId_details()
	{
		response = RestAssured
				.given()
				.spec(getRequestSpec())
				.when()
				.get(PropertiesFile.getProperty("endpoint")+"/{bookingId}", bpost.bookingId);
	}
	
	public void get_booking_details()
	{
		response.getBody().prettyPrint();
	}
	
	public void response_body(String schemaFileName)
	{
		Assert.assertEquals(response.getStatusCode(), 200);	
		
		response
		.then()
	    .assertThat().body(matchesJsonSchemaInClasspath("Schemas/"+schemaFileName));
	}
}
