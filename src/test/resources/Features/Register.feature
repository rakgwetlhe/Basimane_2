Feature: User registration and admin promotion

  Scenario: Register, approve, promote and delete user

    Given the user is on the login page for registration
    When the user clicks on the sign up here button
    And the user enters first name "User"
    And the user enters last name "Six"
    And the user enters a valid registration email
    And the user enters a valid passcode "Testing@1234"
    And the user confirms the passcode "Testing@1234"
    And the user selects a valid group "Group T"
    And clicks the create account button
    Then the user should see a registration success message

    When the admin logs in
    And the admin navigates to the admin panel
    And approves the newly registered user
    And promotes the approved user to admin
    And the admin logs out

    When the promoted user logs in
    Then the user should see the admin dashboard
    And deletes a user from the user list