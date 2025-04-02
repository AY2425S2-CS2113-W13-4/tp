# Overview

HealthBud is a CLI-based fitness logging assistant designed to help users track and improve their personal health goals.
It supports logging of meals, workouts, water intake, cardio sessions, and personal bests, while also offering 
intelligent features such as progress status and workout recommendations.

# Summary of Contributions
## Code contributed

[Team Dashboard](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/#/widget/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2025-02-21&chartGroupIndex=40&chartIndex=3)


## Enhancements implemented

I was in charge of the implementation of several features in our application, including the recommend, status, and 
add pb commands. These features were thoughtfully designed and executed to enhance user interaction and provide 
meaningful insights into fitness progress. 

In addition, I led a major revamp of the parser and logic architecture. This involved decoupling parsing logic from 
command execution, resulting in a much cleaner separation of concerns. Each command class now handles only its respective 
logic, while parsing is delegated to dedicated parser classes. This not only improved readability and maintainability, 
but also aligned our codebase with sound OOP principles. To ensure consistency, I systematically refactored all existing
command and parser classes to follow this design pattern, improving the modularity and extensibility of our codebase.

## Contributions to the UG

I contributed significantly to the User Guide to ensure that it was both accessible and comprehensive to new users. 
I created the structural layout of the guide by introducing proper sectioning and headings for each of our features. 
I then went on to describe each of the features I implemented — such as recommend, status, and add pb — with clear and 
concise explanations, usage syntax, and example inputs/outputs.

## Contributions to the DG

For the Developer Guide, I provided detailed explanations and diagrams to communicate both feature-level and system-level 
design decisions. I was responsible for writing the class and sequence diagrams for the recommend feature, as well as 
explaining its logic and integration with the rest of the system. Beyond feature-specific documentation, I contributed to 
broader sections such as the Overall Architecture, Design and Implementation, Glossary, Non-Functional Requirements, 
Prerequisites, and Instructions for Manual Testing. I also contributed to the user stories section by drafting realistic 
user scenarios based on the personas we envisioned.

## Contributions to team-based tasks

I played a key role in ensuring that our testing framework was robust. Specifically:
- Revamped the structure of our JUnit test file
- Wrote comprehensive tests for add pb, recommend, and status features, ensuring 100% code coverage
- Reviewed and refactored existing test cases to align with our new parser-logic separation

In terms of project management:
- I took ownership of creating, assigning, and tracking issues
- Ensured that branches were properly linked to their respective issues
- Maintained up-to-date milestone tracking
- Reviewed and linked all PRs to relevant issues and milestones for clarity and traceability

## Review/mentoring contributions

Throughout the project, I actively mentored teammates, especially when they faced challenges with logic, parsing, or OOP structure. I provided:
- Guidance on how to structure commands and parsers
- Help resolving common IntelliJ issues and Git conflicts
- Support in debugging logic errors and writing cleaner, more modular code

I regularly reviewed my teammates’ PRs and provided constructive feedback to maintain code quality and consistency across the project.

List of PRs approved by me:
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/112
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/111
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/108
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/106
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/105
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/103
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/95
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/92
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/91
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/89
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/86
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/78
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/77
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/74
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/72
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/71
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/61
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/56
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/54
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/48
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/45
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/42
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/39
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/36
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/35
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/31
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/23
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/21
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/18
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/16
https://github.com/AY2425S2-CS2113-W13-4/tp/pull/5

## Contributions beyond the project team:

Beyond technical contributions, I took on a coordination and leadership role within the team:
- Consistently reminded teammates of upcoming deadlines and sprint goals
- Provided summaries of progress and outstanding tasks to keep everyone aligned
- Acted as the liaison between our team and the TAs and professors, regularly seeking clarifications and relaying them clearly to the group
- Offered to help teammates who were particularly busy in certain weeks, ensuring we stayed on track as a team
I also made an effort to foster a collaborative decision-making environment — instead of making decisions 
unilaterally, I encouraged discussions and collective agreement on key directions.

Evidence of technical leadership e.g. sharing useful information in the forum
- Reported bugs and inconsistencies during integration testing phases
- Provided detailed, helpful responses to peers’ queries in the discussion forum
- Shared useful insights from consultations with the TAs/Prof to help other teams as well
- Took initiative in proposing architecture improvements and code standards
Overall, I strived not only to contribute technically, but also to uplift the team through mentorship, leadership, and collaboration.




