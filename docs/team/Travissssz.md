# Overview

A short overview of your product to provide some context to the reader. The opening 1-2 sentences may be reused by all
team members. If your product overview extends beyond 1-2 sentences, the remainder should be written by yourself.

# Summary of Contributions
Added the AddWorkoutParser, AddCardioParser to parse the input for the user in the relevant classes.
Added the DateParser to be able to parse the users date input to a standard format.
Edited the ParserParameters to be able to take in date inputs with '/' format as well. 

## Code contributed
[Team Dashboard](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/#/widget/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2025-02-21&chartGroupIndex=40&chartIndex=4)

## Enhancements implemented
Initally the date format input by the users were just added to Loglist as it was. But it was not ideal as we had other functions like search that required date to help search for the item. Hence, I created a standardised date parser, so the date read and printed will always be of the same format.
Added the addworkout and addcardio paser so that the users input to the relevant command is read correctly 
Modified ParserParameters which initally read '/' and parsed it as key value pairs after every '/', 
this made it such that input date formats cannot be written like '22/12/2025', as it would affect the values,
hence it was modified in a way such that dates can now be read in any format including '22/12/2025'.

## Contributions to the UG
Added the display code segment for each of the commands 
Added the summary of commands table

## Contributions to the DG
AddWorkoutCommand feature
AddWorkoutCommand sequence and class diagram

## Contributions to team-based tasks

## Review/mentoring contributions
Links to PRs reviewed, instances of helping team members in other ways.

## Contributions beyond the project team:
Evidence of helping others e.g. responses you posted in our forum, bugs you reported in other team's products,
Evidence of technical leadership e.g. sharing useful information in the forum