package Utils;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseTest 
{
	private static RequestSpecification requestSpecification;
	@BeforeMethod
	public void beforeMethod()
	{
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}
	
	@BeforeClass
	public static RequestSpecification getRequestSpec()
	{
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setContentType(PropertiesFile.getProperty("content.type"));
		builder.setAccept(PropertiesFile.getProperty("content.type"));
		builder.setBaseUri(PropertiesFile.getProperty("baseURL"));
		RequestSpecification requestSpec = builder.build();
		return requestSpec;
	}
	
	@BeforeClass
	public static ResponseSpecification getResponseSpec()
	{
		ResponseSpecBuilder builder1 = new ResponseSpecBuilder();
		builder1.expectHeader("contentType", PropertiesFile.getProperty("content.type"));
		builder1.expectContentType(PropertiesFile.getProperty("content.type"));
		ResponseSpecification responseSpec = builder1.build();
		return responseSpec;
	}

}
