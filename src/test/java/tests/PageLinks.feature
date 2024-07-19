Feature: Verificar la funcionalidad del link en nueva pestaña

  Scenario: Click on the 'Home' link
    Given I open the browser and navigate to "https://demoqa.com/links"
    When I select the "Home" link
    Then the selected link must open a new tab
    And I should see the new tab in the browser should be "https://demoqa.com/"

Feature: Verificar la funcionalidad del link estático - Created

  Scenario: Click on the 'Created' link
    Given I open the browser and navigate to "https://demoqa.com/links"
    When I select the "Created" link
    Then The selected link should not open a new page
    And I should see a message saying "Link has responded with staus 201 and status text Created"

Feature: Verificar la funcionalidad del link estático - No-Content

  Scenario: Click on the 'No-Content' link
    Given I open the browser and navigate to "https://demoqa.com/links"
    When I select the "Created" link
    Then The selected link should not open a new page
    And I should see a message saying "Link has responded with staus 204 and status text No Content"

Feature: Verificar la funcionalidad del link estático - Unauthorized

  Scenario: Click on the 'Unauthorized' link
    Given I open the browser and navigate to "https://demoqa.com/links"
    When I select the "Created" link
    Then The selected link should not open a new page
    And I should see a message saying "Link has responded with staus 401 and status text Unauthorized"

Feature: Verificar la funcionalidad del link estático - Not Found

  Scenario: Click on the 'Not Found' link
    Given I open the browser and navigate to "https://demoqa.com/links"
    When I select the "Created" link
    Then The selected link should not open a new page
    And I should see a message saying "Link has responded with staus 404 and status text Not Found"

