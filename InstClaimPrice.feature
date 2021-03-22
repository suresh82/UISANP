@Inst
Feature: This Feature File Explains the Claim Price and Validation in PAR SANP

  Scenario Outline: Price and Validate the Claims in PAR SANP
    Given User access the PAR SANP application and successfully logs into SANP
    When User navigates to Claims Page
    Then User creates new Institutional Claim "<rowCount>"
    Then User enters the Claim Information details
    Then User enters the Diagnosis details
    Then User enters the LineItem details
    Then User enters the Patient Insured details
    #Then User enters the Miscellaneous details
    And User clicks on Price and Save
    #Then User Validates the Pricing details

    Examples: 
      | rowCount |
      |       66 |
