Feature: QKart Login Functionality

  Scenario Outline: Verify user is able to login successfully with valid credentials
    Given Launch the qKart url and user is at login page
    When User logs in with valid credentials "<valid_username>" and "<valid_password>"
    Then User should logged in successfully

    Examples:
      | valid_username               | valid_password  |
      | mhdfarhan2611@gmail.com      | Acc0@mf#7       |



  Scenario Outline: Verify user is unable to login with invalid credentials
    Given Launch the qKart url and user is at login page
    When User logs in with invalid credentials "<invalid_username>" and "<invalid_password>"
    Then User should verify the error message

    Examples:
      | invalid_username    | invalid_password |
      | mhdfarhan@gmail.com | Acc0@mf#7       |


