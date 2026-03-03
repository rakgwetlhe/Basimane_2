Feature: New User Registration Test
    Registration feature to test the user registration functionality and approval of the user by the admin.

    Background:
        Given the user is on the login page for registration

    Scenario Outline: Successful Registration with Valid Details
        When the user clicks on the sign up here button
        And the user enters first name "<firstName>"
        And the user enters last name "<lastName>"
        And the user enters a valid registration email "<email>"
        And the user enters a valid passcode "<passcode>"
        And the user confirms the passcode "<confirmPasscode>"
        And the user selects a valid group "<group>"
        And clicks the create account button
        Then the user should see a registration success message

        Examples:
           |firstName |lastName | email            | passcode       | confirmPasscode |group     |
           |User      |Six     |userSix@gmail.com| Testing@1234   | Testing@1234    |Group T   |

    Scenario: Login as admin, approve the user and promote the user to admin
        When the user logs in using stored credentials
        Then the user should be logged in successfully as admin
        When the user navigates to the admin panel
        And approves the newly registered user
        And promotes the approved user to admin
        Then the user should see a confirmation message for approval and promotion

    Scenario: Promoted user logs in as Admin
        Given a user has been promoted to Admin
        When the user logs in using stored credentials
        Then the user should see the admin dashboard
