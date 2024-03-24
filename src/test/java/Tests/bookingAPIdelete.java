package Tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import Utils.BaseTest;
import Utils.PropertiesFile;
import io.restassured.response.Response;

public class bookingAPIdelete extends BaseTest
{
	Response response;
	bookingAPIpost bpost = new bookingAPIpost();
	tokenGeneration tg = new tokenGeneration();
	
	public void endpoint_delete_booking()
	{
		response =
				given()
				.spec(getRequestSpec())
				.header("Cookie", "token="+tg.bookingapitoken) 
				.when()
				.delete(PropertiesFile.getProperty("endpoint")+"/{bpost.bookingId}", bpost.bookingId)
				.then()//.log().all()
				.extract().response();
	}
	
	public void delete_response_body()
	{
		response.getBody().prettyPrint();
	}
	
	public void delete_validate()
	{
		Assert.assertEquals(response.getStatusCode(), 201);	
	}
}
