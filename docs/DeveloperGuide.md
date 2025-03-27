# Developer Guide

## Acknowledgements

This application was developed as part of a university software engineering module CS2113. Some ideas were adapted from:
1. Duke Java Project
2. JavaFX Documentation
3. Official Java 17 Documentation

## Design & implementation
### Overall Architecture

HealthBud is structured following a Command-based architecture.
Key components:
1. Main class – Starts the application.
2. Parser – Interprets user input and returns the appropriate Command object. 
3. Command classes – Each user command (e.g., AddLogCommand, BMICommand, RecommendCommand) is encapsulated in its own class. 
4. LogList – Maintains lists for each log type (Meal, Workout, Water, etc.). 
5. Storage – Handles saving and loading of logs from a local text file. 
6. Ui – Responsible for displaying messages to the user.

### Features
{@everyone i think this is where u add the week 10 DG stuff??? tbh i think this is chattable - kin}
#### Recommend

1. Feature overview
The RecommendCommand feature allows users to receive workout recommendations tailored to a specific muscle group. The 
command takes the form recommend <muscle_group> and responds with a set of 3 recommended exercises. This feature is 
intended for fitness enthusiasts who may need guidance or variety in their training routines.

2. Implementation details
The RecommendCommand class extends the base Command class and overrides the execute method. The command supports inputs 
like recommend biceps, recommend legs, and so on. The logic of selecting which recommendation to print is 
encapsulated in a helper method getRecommendation(String input) which parses the input and returns a corresponding 
string. The execute method is kept clean and only responsible for printing this result to the console. This 
separation also makes the logic more testable, as the string-producing logic in getRecommendation() can be unit 
tested independently without checking the output stream.

3. Why this design 
- Separation of concerns: By moving the recommendation content generation to a separate method, we improve readability 
and testability.
- Scalability: Adding new muscle groups or modifying messages is centralized in getRecommendation(), making it easier to 
extend.
- Robustness: Proper input validation and informative error messages ensure a good user experience.

4. Alternatives considered
- Using Enums for muscle groups: Initially considered using an enum with mappings to lists of exercises. While this 
improves type-safety, it adds overhead and less flexibility for user input variations.
- Reading recommendations from a file: Considered storing recommendations in a file, but added unnecessary I/O for a 
static set of data.

5. Sequence Diagrams
- {to be updated using plantUML}

6. Future Improvements
- Store recommendations in a config file or JSON for easier modification.

#### command uw to talk about jason
1. Feature overview:
   FindCommand enables users to search for log entries that contain a specific keyword within a particular category (e.g., meal, workout, water). 
Users invoke the command with the format: `find` <log_type> <keyword>. 
Upon execution, the command traverses the corresponding log list and prints out any log entries that contain the specified keyword. 
This feature is particularly useful for quickly retrieving relevant logs based on user-provided search terms.

2. Implementation details:
Input Parsing & Validation:
The command begins by trimming and splitting the input string into parts. It expects at least three tokens (the command word, the log type, and the keyword).
Type-Based Delegation:
A switch-case statement directs the search to the appropriate `LogList` (e.g., mealLogs, workoutLogs, waterLogs) based on the provided log type.
Delegated Search Logic:
The actual keyword search is handled by the `findLog` method within each `LogList`. This method iterates over the logs and prints matching entries using the UI helper methods.
Error Handling: 
If the input is improperly formatted or the log type is invalid, a custom `InvalidFindException` is thrown, ensuring that the user receives clear feedback on what went wrong.

3. Why this design:
Separation of Concerns:
By delegating the keyword search logic to the findLog method within the LogList, the FindCommand class remains focused solely on input parsing and routing. This separation improves readability and testability.
Modularity and Maintainability:
The design allows for easy updates. For example, if new log types are added or the search logic needs enhancement, changes are isolated to the relevant LogList or the switch-case structure in FindCommand.
Robustness:
Input validation and exception handling ensure that the command fails gracefully, providing clear error messages when users supply invalid inputs.

4. Alternatives considered:
Centralized Search in the Parser:
An alternative was to perform the search directly within the Parser class. However, this approach would have mixed command routing with business logic, reducing modularity and making unit testing more difficult.
Advanced Search Techniques:
Using more sophisticated filtering techniques (e.g., regular expressions or fuzzy matching) was considered. Ultimately, a simple keyword search was chosen to keep the implementation straightforward while meeting current requirements.

5. Sequence Diagrams:


6. Future Improvements:
Enhanced Search Capabilities:
Incorporate multi-keyword search, case-insensitive matching, or fuzzy search to better capture user intent.
UI Feedback Enhancements:
Improve user feedback by highlighting the keyword in the matching results or providing suggestions when no matches are found.
Support for Additional Log Types:
As the application evolves, extend the command to support searching in other log categories (e.g., cardio or pb).
Configuration Options:
Allow users to customize search parameters or filter results based on date ranges or other log attributes.

#### command uw to talk about ahmish
1. Feature overview
2. Implementation details
3. Why this design
4. Alternatives considered
5. Sequence Diagrams
6. Future Improvements

#### command uw to talk about travis
1. Feature overview
2. Implementation details
3. Why this design
4. Alternatives considered
5. Sequence Diagrams
6. Future Improvements

#### command uw to talk about keane
1. Feature Overview

The Goals feature allows users to set and view personalized health goals within the chatbot. These include:
Daily Water Intake Goal (/w), Daily Calorie Intake Goal (/c), Weight Goal (/m)
Additionally, users can check their progress using the progress command or exit the goal setting interface with exit.

2. Implementation Details

The goal command is implemented as part of a switch statement in the main command handling logic. Here's how it works:
Upon entering the goal command, the user is greeted and shown their current goals from the singleton Goals class 
instance. The chatbot enters a loop where it listens for specific goal-editing commands:
/w [value] updates the daily water goal, /c [value] updates the daily calorie goal, /m [value] updates the target
weight progress prompts the user to select a day to view progress data from waterLogs, mealLogs, and weight history 
exit terminates the loop and exits the goal setting mode. The user inputs are parsed with Scanner, and exceptions 
such as InvalidDateException and InvalidGoalException are handled gracefully.

3. Why This Design
Simplicity: Using a command-line loop with conditionals provides clear control flow and is easy to debug.
Singleton Pattern: Goals.getInstance() ensures consistent access and modification of user goals.
User-Friendly Prompts: Each interaction provides guidance on valid inputs and current status.
Separation of Concerns: Goal logic is kept distinct from log retrieval (waterLogs, mealLogs), enabling modular testing.

4. Alternatives Considered
Command Pattern: We considered implementing a command design pattern to encapsulate each action 
(e.g., update water goal), but deemed it too complex for the scope.
GUI-based input: Given the chatbot nature and CLI interaction, we opted not to build a graphical interface.
Database-backed goal storage: For now, data is likely held in-memory for simplicity; persistent storage could 
be added later.

5. Sequence Diagrams

6. Future Improvements
Input validation: Add regex or parsing to ensure valid numeric inputs.
Persistent Storage: Save goals and logs to a file or database for state retention across sessions.
Multi-user support: Refactor to support multiple user profiles.
Goal recommendations: Suggest goals based on user history or health data.
GUI/Web Interface: Build a frontend to visualize progress and make goal-setting more intuitive.

## Product scope
### Target user profile

1. Fitness-conscious individuals 
2. Users who prefer CLI-based tools 
3. Individuals who want to log workouts, meals, water intake, and progress 
4. Java users with basic terminal skills

### Value proposition

HealthBud provides a simple and effective CLI solution to track health logs including workouts, meals, water intake, 
and personal bests. Unlike complex mobile apps, it runs offline and keeps data lightweight and easily exportable.

## User Stories

|Version| As a ...           | I want to ...                                         | So that I can ...                                        |
|--------|-------------------|--------------------------------------------------------|-----------------------------------------------------------|
|v1.0   | new user           | see usage instructions                                | refer to them when I forget how to use the app           |
|v1.1   | user               | add workout logs                                      | track my workout progress                                |
|v1.2   | user               | record meal entries                                   | track calorie intake                                     |
|v1.3   | user               | input water logs                                      | ensure I stay hydrated                                   |
|v1.4   | user               | record my personal bests                              | see strength improvements over time                      |
|v2.0   | fitness enthusiast | get workout recommendations by muscle group          | try targeted exercises for specific body parts           |
|v2.1   | user               | calculate BMI                                         | know if I’m in a healthy weight range                    |
|v2.2   | user               | summarize daily intake                                | get a quick overview of my calories and hydration        |
|v2.3   | user               | view logs by date                                     | track my daily progress easily                           |
|v2.4   | user               | clear logs by category                                | declutter and keep only relevant data                    |
|v2.5   | user               | set fitness goals                                     | stay motivated and focused on my targets                 |


## Non-Functional Requirements

1. Should work on any platform with Java 17 or above 
2. CLI response time under 1 second 
3. Saves data locally in .txt file format 
4. Commands should follow a consistent, predictable format 
5. Lightweight and offline-capable (no external database or network dependency)

## Glossary

1. CLI – Command Line Interface 
2. SUT – System Under Test 
3. BMI – Body Mass Index 
4. PB – Personal Best 
5. Log – A record of user data (e.g., workout, meal, water)
6. Command – A user-triggered action that HealthBud performs 
7. Parser – Component that interprets user input and returns a corresponding command

## Instructions for manual testing
### Prerequisites

1. Java 17 or later installed 
2. HealthBud.jar built or downloaded

### Running the Program

1. Ensure that you have Java 17 or above installed.
2. Download the latest version of HealthBud from here.
3. Open a terminal and navigate to the folder where the application is located.
4. Run java -jar HealthBud.jar to start the application.
5. Start entering commands to log your fitness activities!
