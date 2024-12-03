Feature: Compose an email in Gmail

  Background: User logs into Gmail
    Given the user opens the Gmail login page
    When the user enters valid credentials and clicks login
    Then the user should see their Gmail inbox

  Scenario: Send a valid email
    Given the user is on the Gmail compose page
    When the user enters a valid recipient, subject, and body
    And clicks the send button
    Then the email should be sent successfully

  Scenario: Send an email without a recipient
    Given the user is on the Gmail compose page
    When the user leaves the recipient field empty and enters the subject and body
    And clicks the send button
    Then an error message should be displayed

  Scenario: Send an email with an invalid recipient email
    Given the user is on the Gmail compose page
    When the user enters an invalid recipient email and enters the subject and body
    And clicks the send button
    Then an error message should be displayed