Feature: User Account management


  Scenario: Successful user registration
    Given User is on the registration page
    When User enters "<Email>", "<Name>", and "<Password>"
    And User clicks the Register button
    Then A confirmation message should be displayed and logged in
    And User should logout

    Examples:
      | Email                 | Name        | Password          |
      | john.doe@test.com     | John Doe    | SecurePassword123!|
      
      
  Scenario: Login with valid credentials
    Given User is on the login page
    When User enters "<Email>" and "<Password>"
    And User clicks the Login button
    Then User should be redirected to their profile page
    And User should logout
      
     Examples:
      | Email                 |  Password          |
      | john.doe@test.com     |  SecurePassword123!|

	Scenario: Login with invalid credentials
    Given User is on the login page
    When User enters "<Email>" and "<Password>"
    And User clicks the Login button
    Then An error message should be displayed
    
    	Examples:
      | Email                 |  Password          |
      | john.doe@test.com     |  WrongPassword123! |
	
	Scenario: Password update
    Given User is on the login page
   	When User enters "<Email>" and "<Password>"
    And User clicks the Login button
		Then User should be redirected to their profile page and update password and logout
		
			Examples:
      | Email                 | Name        | Password          |
      | john.doe@test.com     | John Doe    | SecurePassword123!|
		