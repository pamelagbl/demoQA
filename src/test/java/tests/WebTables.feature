Feature: Verify the functionality of Web Tables - Add

  Scenario: Add a new entry to the table
    Given I open the browser and navigate to "https://demoqa.com/webtables"
    When I click on the "Add" button
    And I fill in the form with the following details:
      | Field         | Value         |
      | First Name    | John          |
      | Last Name     | Doe           |
      | Email         | johndoe@example.com |
      | Age           | 30            |
      | Salary        | 100000        |
      | Department    | QA            |
    And I click on the "Submit" button
    Then the new entry should be displayed in the table with the correct details

Feature: Verify the functionality of Web Tables - Button Edit

  Scenario: Edit a new entry in the table
    Given I open the browser and navigate to "https://demoqa.com/webtables"
    When I click on the "edit" button
    And I fill in the form with the following details:
      | Field         | Value         |
      | First Name    | John          |
      | Last Name     | Doe           |
      | Email         | johndoe@example.com |
      | Age           | 30            |
      | Salary        | 100000        |
      | Department    | QA            |
    And I click on the "Submit" button
    Then the new entry should be displayed in the table with the correct details

Feature: Verify the functionality of Web Tables - Button Delete

  Scenario: Delete a new entry in the table
    Given I open the browser and navigate to "https://demoqa.com/webtables"
    When I click on the "Delete" button
    Then the new entry should be displayed in the table with the correct details
