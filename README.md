# Language Learning App

## MOLINGO

This app tests its users' English proficiency levels and adjusts their lessons accordingly. Each core lesson is prepared with image, video or audio content. Students must successfully complete the exam before they can move on to the next lesson. Users can improve their pronunciation, writing, listening, speaking, vocabulary and grammar skills. It can be used easily by anyone with its simple and plain interface design.

Technologies such as SpringBoot, PostgreSQL, HTML, CSS, Bootstrap were used in this application.

You can examine the Img folder to see the application screens.

Also, you can use this link(https://egeuni.atlassian.net/wiki/spaces/LLA/overview?homepageId=164022) to access the documentation about the application.

## The implemented use case is:
USE CASE: Taking The End-Of-Course Exam 

Actors: Trainee, Language Learning App 

Inputs: Trainee’s Answers 

Outputs: Trainee Success Status 

Normal Operation: The trainee issues a request to take a level-up exam after finishing the training. Reads the informational text and gives the instruction to start the exam. If the trainee does not give this instruction, the request will be canceled. Questions are displayed and the timer starts. The trainee answers the question appropriately. The answer is saved. If no answer is given within the time limit, no points will be awarded for the question and move on to the next question until there are no questions. When questions are finished, the trainee sees the informational text. The trainee information and his/her written answers such as assays are sent to the language specialist. 

Exception: The trainee’s inability to take the exam, the trainee if offline, system down


## Architectural Model
A new hybrid architectural model has been developed for the language learning app project. MVC-Layered Architecture was chosen because instead of giving all the responsibility to an object, it was more suitable for the software principles and the project to show the data we have in different ways and also divide the data into layers and share it. The main components of the architecture are Controller, View, Model, API layer, Service layer, Repository layer and database.

![image](https://user-images.githubusercontent.com/71715359/210367615-6ae3e0aa-b811-46e3-96f8-a7a4bd67d864.png)

