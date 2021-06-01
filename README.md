# JSONplaceholder Practice

This is the first task for my probation period at Atlantbh,
JSONplaceholder API Automation testing using REST Assured, Cucumber and Serenity.

---
###How to run tests
Via terminal go to the test folder and type command
```python
mvn clean verify
```
---
###Dependencies used
- REST Assured
- Cucumber
- Serenity BDD
- Mockneat
- Hamcrest

---
###Run with @tags
```python
mvn clean verify -Dcucumber.options="--tags @user"
```

Tags |  | 
--- | --- | 
@smoke | Runs smoke test which is an e2e test with following flow: user creation > user creates to do list > user completes to do item > user deletes to do list > user deletes account  |
@regression | Runs all of the regression tests, test are made so that they contain all of the basic methods, GET, POST, PUT, DELETE and assertions|
@posts_regression  | Runs only posts endpoint regression suit |
@albums_regression  | Runs only albums endpoint regression suit |
@users_regression  | Runs only users endpoint regression suit |

