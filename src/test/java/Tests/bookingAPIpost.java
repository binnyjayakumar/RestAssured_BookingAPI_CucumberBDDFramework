package Tests;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.Assert;

import Utils.BaseTest;
import Utils.JsonReader;
import Utils.PropertiesFile;
import io.restassured.response.Response;

public class bookingAPIpost extends BaseTest 
{
	Response response;
	public static int bookingId;
	
	public void create_new_booking(String dataKey, String JSONFile)
	{
		response = 
				given()
				.spec(getRequestSpec())
				.body(JsonReader.getRequestBody(JSONFile,dataKey))
				.when()
				.post(PropertiesFile.getProperty("endpoint"))
				.then()//.log().all()
				.extract().response();
		
	    bookingId = response.path("bookingid");
		
		System.out.println("The booking id is: "+bookingId);
		
		String data = JsonReader.getRequestBody(JSONFile,dataKey);
		System.out.println(data);
		System.out.println("----------------------------");
	}
	
	public void booking_using_JSON()
	{
		System.out.println("******"+response.asPrettyString());
	}
	
	public void validate(String schemaFileName)
	{
		Assert.assertEquals(response.getStatusCode(), 200);	
		
		response
		.then()
	    .assertThat().body(matchesJsonSchemaInClasspath("Schemas/"+schemaFileName));
	}
}
