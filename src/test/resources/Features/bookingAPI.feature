Feature: Test Booking api with rest assured and cucumber BDD framework
	
  Scenario: create an authentication token
    Given the valid endpoint with credentials "admin" & "password123"
    When user creates a token and gets the response
    Then user validates the status code with JSON schema "tokenSchema.json"

  Scenario: Booking API GET test
    Given the valid endpoint to fetch bookings
    When the request is send to the server to get the bookings
    Then validate the response
	
  Scenario Outline: Create new booking using JSON data
    Given the valid endpoint to create new booking using JSON data "<dataKey>" from JSON file "<JSONFile>"
    When user creates a booking and prints the response
    Then validate the status code with JSON schema "createBookingSchema.json"

    Examples: 
      | dataKey      | JSONFile            |
      | postBooking1 | bookingAPIBody.json |
      | postBooking2 | bookingAPIBody.json |
	
  Scenario: Get booking details of a bookingId
    Given the valid endpoint to fetch bookingId details
    When the request is send to the server to get the booking details
    Then validate the response body with JSON schema "getBookingSchema.json"
	
  Scenario Outline: Update a booking using JSON data
    Given the valid endpoint to update a booking using data "<dataKey>" from JSON file "<JSONFile>"
    When user updates the booking details and prints the response
    Then user should validate the status code with JSON schema "updateBookingSchema.json"

    Examples: 
      | dataKey     | JSONFile            |
      | putBooking1 | bookingAPIBody.json |
      | putBooking2 | bookingAPIBody.json |

  Scenario Outline: Update booking details using JSON data
    Given the valid endpoint to update booking details using data "<dataKey>" from JSON file "<JSONFile>"
    When user updates the firstname and lastname in booking details and prints the response
    Then user must validate the status code with JSON schema "updateBookingSchema.json"

    Examples: 
      | dataKey       | JSONFile            |
      | patchBooking1 | bookingAPIBody.json |
      | patchBooking2 | bookingAPIBody.json |

  Scenario: To delete a booking
    Given the valid endpoint to delete booking
    When user makes a request to delete booking and prints response body
    Then user validates the response
