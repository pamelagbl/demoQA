Feature: Verificar la funcionalidad de los Text Box

  Scenario: Rellenar y enviar el formulario de Text Box con datos válidos
    Given I open the browser and navigate to "https://demoqa.com/text-box"
    When I fill in the text box form with the following details:
      | Field          | Value             |
      | Full Name      | Pamela Brito          |
      | Email          | name@example.com |
      | Current Address| Bogotá   |
      | Permanent Address | Suba |
    And I click on the "Submit" button
    Then I should see the submitted information displayed correctly
