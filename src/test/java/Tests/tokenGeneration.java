package Tests;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.json.simple.JSONObject;
import org.testng.Assert;

import Utils.BaseTest;
import Utils.PropertiesFile;
import io.restassured.response.Response;

public class tokenGeneration extends BaseTest
{
	Response response;
	JSONObject credentials;
	public static String bookingapitoken;
	
	public void generate_token(String username, String password)
	{
		JSONObject credentials = new JSONObject();
		credentials.put("username", username);
		credentials.put("password", password);
		response = 
				given()
				.spec(getRequestSpec())
				.body(credentials.toString())
				.when()
				.post(PropertiesFile.getProperty("authEndpoint"))
				.then()//.log().all()
				.extract().response();
		
		bookingapitoken = response.path("token");
		
		System.out.println("The token is: "+bookingapitoken);
	}
	
	public void get_token()
	{
		response.getBody().prettyPrint();
	}
	
	public void validate_response(String schemaFileName)
	{
		Assert.assertEquals(response.getStatusCode(), 200);
		
		response
		.then()
	    .assertThat().body(matchesJsonSchemaInClasspath("Schemas/"+schemaFileName));
	}
}
