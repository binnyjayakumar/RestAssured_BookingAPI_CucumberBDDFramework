package Tests;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.Assert;

import Utils.BaseTest;
import Utils.JsonReader;
import Utils.PropertiesFile;
import io.restassured.response.Response;

public class bookingAPIput extends BaseTest
{
	Response response;
	bookingAPIpost bpost = new bookingAPIpost();
	tokenGeneration tg = new tokenGeneration();
	
	public void update_booking(String dataKey, String JSONFile)
	{
		response = 
				given()
				.spec(getRequestSpec())
				.header("Cookie", "token="+tg.bookingapitoken) 
				.body(JsonReader.getRequestBody(JSONFile,dataKey))
				.when()
				.put(PropertiesFile.getProperty("endpoint")+"/{bpost.bookingId}", bpost.bookingId)
				.then()//.log().all()
				.extract().response();
	}
	
	public void update_booking_Json()
	{
		response.getBody().prettyPrint();
	}
	
	public void update_validation(String schemaFileName)
	{
		Assert.assertEquals(response.getStatusCode(), 200);	
		
		response
		.then()
	    .assertThat().body(matchesJsonSchemaInClasspath("Schemas/"+schemaFileName));
	}
}
