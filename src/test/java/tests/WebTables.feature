Feature: Verificar la funcionalidad de los Web Tables

  Scenario: Añadir una nueva entrada en la tabla
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

Feature: Verificar la funcionalidad de los Web Tables

  Scenario: Editar una nueva entrada en la tabla
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

Feature: Verificar la funcionalidad de los Web Tables

  Scenario: Eliminar una nueva entrada en la tabla
    Given I open the browser and navigate to "https://demoqa.com/webtables"
    When I click on the "Delete" button
    Then the new entry should be displayed in the table with the correct details
