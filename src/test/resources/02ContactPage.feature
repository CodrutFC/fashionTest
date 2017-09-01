Feature: Contact Us Page
  As an end user
  I want a contact us page
  So that I can find out more about QAWorks exciting services!!

  Scenario: Valid Submission
    Given I am on the QAWorks Site
    Then I should be able to contact QAWorks with the following information
      | name    | j.Bloogs                                  |
      | email   | j.Bloogs@qaworks.com                      |
      | message | please contact me I want to find out more |

  Scenario: Invalid Submission
    Given I am on the QAWorks Site
    Then I should receive warning message when trying to send a blank form

    Scenario: Invalid e-mail entered
      Given I am on the QAWorks Site
      Then I should receive warning message when entering an invalid e-mail

      Scenario: Invalid e-mail submit
        Given I am on the QAWorks Site
        Then I wait for 5000 miliseconds
        Then I should not be able to submit with an invalid e-mail address