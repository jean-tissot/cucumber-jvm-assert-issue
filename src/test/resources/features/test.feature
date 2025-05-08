Feature: call my service

  Scenario: call my service with a parameterized object
    When I list the persons:
      | # | name  |
      | 1 | John  |
      | 2 | Peter |