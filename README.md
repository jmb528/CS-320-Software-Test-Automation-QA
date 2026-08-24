# CS-320-Software-Test-Automation-QA

How can I ensure that my code, program, or software is functional and secure?

I can ensure that my software is functional by testing it throughout development instead of waiting until the end. In this project, I used JUnit to test the Contact, Task, and Appointment classes and their service classes. I tested valid inputs, invalid inputs, null values, duplicate IDs, boundary values, and exceptions. This helped confirm that the program worked as expected and also rejected data that did not meet the requirements. I also learned that code coverage is useful, but a high percentage does not automatically mean the tests are effective. The tests still need to verify meaningful behavior. From a security standpoint, validating input and making sure unexpected or invalid data is rejected helps reduce errors and makes the software more reliable.

How do I interpret user needs and incorporate them into a program?

I interpret user needs by first breaking the requirements down into specific behaviors that the program must support. For example, the Contact, Task, and Appointment features each had their own rules for IDs, field lengths, phone numbers, dates, and other information. I used those requirements to guide both the code and the tests. This helped me make sure that I was building what the user actually needed instead of only focusing on what I thought the program should do. Turning requirements into clear conditions and test cases also makes it easier to confirm that the finished program meets those needs.

How do I approach designing software?

I approach software design by breaking a larger problem into smaller parts with clear responsibilities. In this project, Contact, Task, and Appointment were handled separately, along with their service classes. This made the program easier to test and maintain because each part could be checked independently. I also try to think about possible problems while I am designing the software, not just the normal path where everything works correctly. Considering invalid input, missing records, duplicate IDs, and boundary values early helps me build software that is easier to test, maintain, and improve later.
