Feature: Form Submissions

  Scenario Outline: Successful form submission
    Given User is on the form submission page
    When User enters "<First Name>" and "<Last Name>" and "<Phone>" and "<Email>"
    Then User should be redirected to the secure area

    Examples:
      | First Name | Last Name | Phone         | Email              |
      | John       | Doe       | 1234567890    | john.doe@test.com  |
     

       Scenario: Form submission with missing required fields
    Given User is on the form submission page
    When User enters "John" and "" and "1234567890" and "john.doe@test.com"
    Then An error message should be displayed for the missing fields
     
       Scenario: Form submission with invalid email
    Given User is on the form submission page
    When User enters "Jane" and "Smith" and "9876554321" and "invalid-email"
    Then An error message should be displayed for the invalid email
