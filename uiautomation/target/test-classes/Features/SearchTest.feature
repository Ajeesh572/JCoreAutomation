@Run
Feature: SearchTest

  Background: Launcg Applicatin
    Given I Launched application

  Scenario Outline: Adding a <searchItem1> item in cart and verifying sub total
    Then I Verify Page Title is "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
    When I Fill in field "Search Box" by value "<searchItem1>" on Navigation Bar
    And I Hit enter in "Search Box" on Navigation Bar
    Then I Verify "Search Results" are for "<resultText1>" on home page
    When I Note "<chooseItem1>" name from Search list and save by key "choosenItem" on home page
    And I Choose Item "<chooseItem1>" of search result on home page
    And I Switch to tab "1"
    And I Note price of product by key "productPrice" on Products page
    Then I Verify Product name is "choosenItem" on Products page
    When I Click "Add to Cart" Button on Products page
    And I close Accessory Pane if displayed
    And I Click "Cart" Button on Navigation Bar
    Then I Verify "Price" is same as "productPrice" on shopping cart

    Examples: 
      | searchItem1 | resultText1 | chooseItem1 |
      | Monitor     | Monitor     |           2 |
      | Laptop      | Laptop      |           1 |

  Scenario Outline: Adding a two items in cart and verifying sub total
    Then I Verify Page Title is "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
    #Headphones
    When I Fill in field "Search Box" by value "<searchItem1>" on Navigation Bar
    Then I Verify Field "Search Box" has value "<searchItem1>" for attribute "value" on Navigation Bar
    When I Hit enter in "Search Box" on Navigation Bar
    #Then I Verify "Search Results" are for "<searchItem1>" on home page
    When I Choose Item "<chooseItem1>" of search result on home page
    And I Switch to tab "1"
    And I Note price of product by key "productPriceHeadphones" on Products page
    When I Click "Add to Cart" Button on Products page
    And I close Accessory Pane if displayed
    #KeyBoard
    When I Fill in field "Search Box" by value "<searchItem2>" on Navigation Bar
    Then I Verify Field "Search Box" has value "<searchItem2>" for attribute "value" on Navigation Bar
    When I Hit enter in "Search Box" on Navigation Bar
    Then I Verify "Search Results" are for "<searchItem2>" on home page
    When I Choose Item "<chooseItem2>" of search result on home page
    And I Switch to tab "2"
    And I Note price of product by key "productPriceKeyboard" on Products page
    When I Click "Add to Cart" Button on Products page
    And I close Accessory Pane if displayed
    And I Click "Cart" Button on Navigation Bar
    Then I Verify Sub Total price displayed is sum of below on shopping cart
      | productPriceHeadphones |
      | productPriceKeyboard   |

    Examples: 
      | searchItem1 | resultText1 | chooseItem1 | searchItem2 | chooseItem2 |
      | Headphones  | Headphone   |           1 | Keyboard    |           2 |
