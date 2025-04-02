# Overview
HealthBud is a CLI-based fitness logging assistant designed to help users track and improve their personal health goals.
It enables users to log various health metrics—such as meals, workouts, water intake, personal bests, and cardio sessions—using an intuitive command interface. 
The application incorporates robust command parsing, in-memory log management, and persistent storage via text files, all structured in a modular design to support easy maintenance and future enhancements.


# Summary of Contributions
## Code contributed

[Team Dashboard](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/#/widget/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2025-02-21&chartGroupIndex=40&chartIndex=1)

## Enhancements implemented

I laid the groundwork of the project by implementing the base log classes, which provide a foundation for meal, workout, and other log types to be extended. I also implemented the LogList class to manage the collection of logs in memory. Additionally, I developed the storage system that reads from and writes to a text file, ensuring data persistence across sessions.

On the user interface side, I implemented the Ui component to display information to users in a clean and organized manner. In terms of feature development, I contributed to the meal log functionalities by implementing delete, list, and clear commands, as well as a find feature that was later merged into the search functionality.

Furthermore, I created the ParserParameters utility, which utilizes hashing to allow users to input parameters (e.g., /t, /d) in any order, improving the flexibility of the command parsing process.

In addition to these individual contributions, I continuously sought ways to make the codebase less messy and more concise. I have actively contributed to refining both my own code and that of my teammates, ensuring that the overall quality of our project remains high.

## Contributions to the UG

Which sections did you contribute to the UG?

## Contributions to the DG

Which sections did you contribute to the DG? Which UML diagrams did you add/updated?

## Contributions to team-based tasks

## Review/mentoring contributions
Links to PRs reviewed, instances of helping team members in other ways.

## Contributions beyond the project team:
Evidence of helping others e.g. responses you posted in our forum, bugs you reported in other team's products,
Evidence of technical leadership e.g. sharing useful information in the forum