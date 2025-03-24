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
1. Feature overview
2. Implementation details
3. Why this design
4. Alternatives considered
5. Sequence Diagrams
6. Future Improvements

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
1. Feature overview
2. Implementation details
3. Why this design
4. Alternatives considered
5. Sequence Diagrams
6. Future Improvements

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
