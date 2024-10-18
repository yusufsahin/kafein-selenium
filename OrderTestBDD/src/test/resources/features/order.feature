Feature: Placing order on SportsStore

  Scenario Outline: User places an order
    Given User is on sportsstore homepage
    When User clicks on category
    And User adds product to the cart
    And User proceeds to checkout
    And User fills order information with <name>, <line1>, <line2>, <line3>, <city>, <state>, <zip>, <country>
    Then User should see order confirmation message
    Then Return To Store

    Examples:
      | name      | line1      | line2       | line3  | city      | state | zip    | country |
      | John Doe  | ABC Bulv.  | 996677 Str. | No:10  | New York  | NY    | 456677 | USA     |
      | Jane Roe  | XYZ Ave.   | 543 St.     | Apt 3B | Chicago   | IL    | 654322 | USA     |
      | Alice Lee | Oak St.    | 9876 Blvd   | No:45  | Austin    | TX    | 987123 | USA     |
