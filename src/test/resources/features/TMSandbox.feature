@API
Feature: API testing

  Scenario: Verify JSON response
    When  API Call has been made "https://api.tmsandbox.co.nz/v1/Categories/6329/Details.json?catalogue=false "
    Then  Verify Response
      | Name      | Home & garden               |
      | CanRelist | true                        |
      | desc      | Better position in category |
    And   Name "Feature Combo" has description "Better position in category"
