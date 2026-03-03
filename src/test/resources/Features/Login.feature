Feature: User Login Test


    Scenario Outline: Successful Login with Valid Credentials
        Given the user is on the login page
        When the user enters a valid email "<email>" and password "<password>"
        And clicks the login button
        Then the user should be redirected to the dashboard

        Examples:
            | email       | password   |
            | cucumber@gmail.com| Cucumber@123 |
