Feature: User Login Test

  Scenario Outline: Successful Login with Valid Credentials
    Given User on the login page
    When User enters a valid username <username>
    And User enters a valid password <password>
    And User clicks on the login button
    Then User should be redirected to the dashboard

    Examples:
      | username              | password     |
      | cucumber@gmail.com | Cucumber@123 |

