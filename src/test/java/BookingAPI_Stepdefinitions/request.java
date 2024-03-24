package BookingAPI_Stepdefinitions;

import Tests.GetBookingDetails;
import Tests.bookingAPIdelete;
import Tests.bookingAPIget;
import Tests.bookingAPIpatch;
import Tests.bookingAPIpost;
import Tests.bookingAPIput;
import Tests.tokenGeneration;
import Utils.BaseTest;
import io.cucumber.java.en.*;

public class request extends BaseTest
{
	bookingAPIget bg = new bookingAPIget();
	bookingAPIpost bp = new bookingAPIpost();
	GetBookingDetails gbd = new GetBookingDetails();
	tokenGeneration tg = new tokenGeneration();
	bookingAPIput bput = new bookingAPIput();
	bookingAPIpatch bpatch = new bookingAPIpatch();
	bookingAPIdelete bdelete = new bookingAPIdelete();
	
	@Given("the valid endpoint with credentials {string} & {string}")
	public void the_valid_endpoint_with_credentials(String username, String password) 
	{
	    tg.generate_token(username, password);
	}
	@When("user creates a token and gets the response")
	public void user_creates_a_token_and_gets_the_response()
	{
	   tg.get_token();
	}
	@Then("user validates the status code with JSON schema {string}")
	public void user_validates_the_status_code(String schemaFileName)
	{
	    tg.validate_response(schemaFileName);
	}
	
	@Given("the valid endpoint to fetch bookings")
	public void the_valid_endpoint_to_fetch_bookings() 
	{
	    bg.fetch_bookings();
	}

	@When("the request is send to the server to get the bookings")
	public void the_request_is_send_to_server() 
	{
	    bg.get_request();
	}

	@Then("validate the response")
	public void validate_the_response() 
	{
	   bg.validate_response();
	}
	
	@Given("the valid endpoint to create new booking using JSON data {string} from JSON file {string}")
	public void the_valid_endpoint_to_create_new_booking(String dataKey, String JSONFile) 
	{
	   bp.create_new_booking(dataKey, JSONFile);
	}

	@When("user creates a booking and prints the response")
	public void user_creates_a_booking_and_prints_the_response() 
	{
	    bp.booking_using_JSON();
	}

	@Then("validate the status code with JSON schema {string}")
	public void validate_the_status_code(String schemaFileName) 
	{
	    bp.validate(schemaFileName);
	}
	
	@Given("the valid endpoint to fetch bookingId details")
	public void the_valid_endpoint_to_fetch_booking_id_details() 
	{
	    gbd.fetch_bookingId_details();
	}
	@When("the request is send to the server to get the booking details")
	public void the_request_is_send_to_the_server_to_get_the_booking_details() 
	{
	    gbd.get_booking_details();
	}
	@Then("validate the response body with JSON schema {string}")
	public void validate_the_response_body(String schemaFileName) 
	{
	    gbd.response_body(schemaFileName);
	}
	
	@Given("the valid endpoint to update a booking using data {string} from JSON file {string}")
	public void the_valid_endpoint_to_update_a_booking_using_data_from_json_file(String dataKey, String JSONFile)
	{
	    bput.update_booking(dataKey, JSONFile);
	}
	@When("user updates the booking details and prints the response")
	public void user_updates_the_booking_details_and_prints_the_response() 
	{
	    bput.update_booking_Json();
	}
	@Then("user should validate the status code with JSON schema {string}")
	public void user_should_validate_the_status_code(String schemaFileName) 
	{
	    bput.update_validation(schemaFileName);
	}
	
	@Given("the valid endpoint to update booking details using data {string} from JSON file {string}")
	public void the_valid_endpoint_to_update_booking_details_using_data_from_json_file(String dataKey, String JSONFile) 
	{
	    bpatch.update_booking_details(dataKey, JSONFile);
	}
	@When("user updates the firstname and lastname in booking details and prints the response")
	public void user_updates_the_firstname_and_lastname_in_booking_details_and_prints_the_response() 
	{
	    bpatch.patch_booking_using_JSON();
	}
	@Then("user must validate the status code with JSON schema {string}")
	public void user_must_validate_the_status_code(String schemaFileName)
	{
	   bpatch.patch_validate(schemaFileName);
	}
	
	@Given("the valid endpoint to delete booking")
	public void the_valid_endpoint_to_delete_booking() 
	{
	    bdelete.endpoint_delete_booking();
	}
	@When("user makes a request to delete booking and prints response body")
	public void user_makes_a_request_to_delete_booking_and_prints_response_body() 
	{
	    bdelete.delete_response_body();
	}
	@Then("user validates the response")
	public void user_validates_the_response() 
	{
	    bdelete.delete_validate();
	}
}
