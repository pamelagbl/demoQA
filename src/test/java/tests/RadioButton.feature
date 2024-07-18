Feature: Verificar la funcionalidad de los Radio Button - Yes

  Scenario: Seleccionar radio button Yes
    Given I open the browser and navigate to "https://demoqa.com/radio-button"
    When I select the "Yes" radio button
    Then the selected radio button should be "Yes"
    And I should see a message saying "You have selected: Yes"

Feature: Verificar la funcionalidad de los Radio Button - Impressive

  Scenario: Seleccionar radio button Impressive
    Given I open the browser and navigate to "https://demoqa.com/radio-button"
    When I select the "Impressive" radio button
    Then the selected radio button should be "Impressive"
    And I should see a message saying "You have selected: Impressive"
