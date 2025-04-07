# Overview

HealthBud is a CLI-based fitness logging assistant designed to help users track and improve their personal health goals.
It supports logging of meals, workouts, water intake, cardio sessions, and personal bests, while also offering
intelligent features such as progress status and workout recommendations.

# Summary of Contributions
Added the AddWorkoutParser, AddCardioParser to parse the input for the user in the relevant classes.
Added the DateParser to be able to parse the users date input to a standard format.
Edited the ParserParameters to be able to take in date inputs with '/' format as well.
Contributed to the development of the search parser and its functionalities.

## Code contributed
[Team Dashboard](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/#/widget/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2025-02-21&chartGroupIndex=40&chartIndex=4)

## Enhancements implemented
Initially, user-provided date formats were directly appended to the LogList without standardization. While this approach preserved the raw input, it proved suboptimal for functionalities such as search, which relied on consistent date formatting to accurately retrieve entries. To address this, I implemented a standardized date parser, ensuring that all dates are uniformly processed, stored, and displayed, thereby improving reliability across date-dependent operations.
Additionally, I enhanced the parsing logic for workout and cardio entries by introducing dedicated parsers (addworkout and addcardio) to accurately interpret user inputs for their respective commands.
A critical improvement was made to the ParserParameters module, which originally split inputs at every / delimiter, interpreting subsequent segments as key-value pairs. This posed a significant limitation, as dates formatted with slashes (e.g., 22/12/2025) would be incorrectly fragmented, corrupting the intended values. To resolve this, I refined the parsing logic to intelligently distinguish between command delimiters and embedded date formats, allowing dates to be flexibly entered in various structures without disrupting parameter extraction.
Before the search command was finalised, its function was initially split into 2 other commands(list and find). However, I felt that the 
naming and the usage of those functions were similar, so I went to modify the list command to take in a commands that are more flexible,
this list command was finally refined further into the search command we have implemented in the end. 
These modifications collectively strengthened input robustness, ensuring seamless compatibility with diverse date formats while maintaining precise command interpretation.

## Contributions to the UG
I went to describe the functions I did like add workout and add cardio.
Added the display code segment for each of the commands
Added the summary of commands table

## Contributions to the DG
For the developer guide, I provided detailed explanations and diagrams to communicated both the feature and system level
design decisions.I was responsible for writing the class and sequence diagrams for the AddLogCommand feature, as well as
explaining its logic and integration with the rest of the system. Beyond feature-specific documentation, I contributed to
broader sections such as the drawing up the class diagram for Command interface and its hierarchy to define executable actions in HealthBud's fitness tracker.
I also contributed to the user stories section by drafting realistic
user scenarios based on the personas we envisioned. AddWorkoutCommand and AddLog command sequence diagram was also contributed by me.

## Contributions to team-based tasks

I played a role to ensure that the testing framework was robust. 
- Writing comprehensive tests for add workout, add cardio and delete features, ensuring >80% coverage in all aspects.
- Following the format set to ensure that the test cases align with our new parser-logic separation

In terms of project management: 
- I followed the issues tagged to me diligently.
- Ensured that my branch was properly committed with clear comments 

## Review/mentoring contributions
Throughout the project, I helped my team in several ways:
- Help resolving common IntelliJ issues
- Support in debugging logic errors

I reviewed my teammates’ PRs and provided constructive feedback to maintain code quality and consistency across the project.

List of PRs approved by me:
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/1
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/20
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/109

## Contributions beyond the project team:

