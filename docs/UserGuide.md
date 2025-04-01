# User Guide

## Introduction

HealthBud is a fitness tracking application that helps users manage their workout routines, meal logs, water intake, and
personal bests (PBs). With an easy-to-use command-line interface, users can log, view, and manage their fitness data
efficiently.

## Quick Start

1. Ensure that you have Java 17 or above installed.
2. Download the latest version of HealthBud from here.
3. Open a terminal and navigate to the folder where the application is located.
4. Run java -jar HealthBud.jar to start the application.
5. Start entering commands to log your fitness activities!

## Features

### Help
Display this list of commands

Format: `help`

Example of usage: `help`
```
    Here are the commands you can use:
     1. help - Display this list of commands
     2. bye - Exit the program
     3. recommend <muscle_group> - Get workout recommendations
     4. bmi /w <weight_in_kg> /h <height_in_m> - Calculate your BMI
     5. add workout <exercise> /w <weight in kg> /r <reps> /s <sets> /d <date> - Add a workout log
     6. add meal <meal_name> /cal <calories> /d <date> /t <time> - Add a meal log
     7. add water /ml <volume> /d <date> /t <time> - Add a water log
     8. add pb <exercise> /w <weight_in_kg> /d <date> - Record a personal best
     9. sum <cal|vol> /d <date> - Sum up the total calories/water for the day
     10. clear <pb|meal|workout|water> - Clear the respective log
     11. view /m <logtype> /d <date>, at least one must be provided. OR view /m all
     12. add cardio <exercise> /s <speed> /i <incline> /t <duration> /d <date> - Add a cardio log
     13. add goals - to enter goal setting mode
     13.1  /w <waterGoals /c <calorieGoals> /m <weightGoals> - to edit personal goals
     14. status change <cutting/bulking> - Update your cutting/bulking status.
     15. status report - View your current cutting/bulking progress
``` 

### Bye
Exit the program

Format: `bye`

Example of usage: `bye`

### Recommend
Get workout recommendations

Format: `recommend <muscle_group>`

Example of usage: `recommend biceps`
```
    Here are some recommended biceps exercises:
     1. Barbell Bicep Curls
     2. Hammer Curls
     3. Cable Curls
``` 

### BMI
Calculate your BMI

Format: `bmi /w <weight_in_kg> /h <height_in_m>`

Example of usage: `bmi /w 75 /h 1.8`
```
   Your BMI is: 23.15, you are of normal weight.
``` 

### Add workout
Add a workout log

Format: `add workout <exercise> /w <weight in kg> /r <reps> /s <sets> /d <date>`

Example of usage: `add workout bench /w 100 /r 8 /s 3 /d 02/02/2025`
```
     Got it. I've added this log:workout
      bench (3 sets of 100 kg for 8 reps) on 02 Feb 2025
     Now you have 22 workout logs in the list.
``` 

### Add meal
Adds a meal log

Format: `add meal <meal_name> /cal <calories> /d <date> /t <time>`

Example of usage: `add meal chicken rice /cal 200 /d 02/02/2025 /t 1700`
```
     Got it. I've added this log:meal
      chicken rice (200 cal) on: 02 Feb 2025 at: 1700
     Now you have 1 meal logs in the list.
``` 
### Add water
Adds a water log

Format: `add water /ml <volume> /d <date> /t <time>`

Example of usage: `add water /ml 1000 /d 02/02/2025 /t 1700`
```
     Got it. I've added this log:water
      4.0 glass of water on (02 Feb 2025) at 1700
     Now you have 1 water logs in the list.
``` 

### Add Personal best
Record a personal best

Format: `add pb <exercise> /w <weight_in_kg> /d <date>`

Example of usage: `add pb bench /w 120 /d 02/02/2025`
```
     Got it. I've added this log:pb
       bench 120 kg on (02 Feb 2025)
     Now you have 1 pb logs in the list.
``` 
### Add Cardio
Add a cardio log

Format: `add cardio <exercise> /s <speed> /i <incline> /t <duration> /d <date>`

Example of usage: `add cardio run /s 8 /i 5 /t 30 /d 02/02/2025`
```
     Got it. I've added this log:cardio
      run (speed: 8, incline: 5, duration: 30 mins) on 02 Feb 2025
     Now you have 1 cardio logs in the list.
``` 
### Add goals
Enter goal setting mode

Format: `add goals`

Example of usage: `add goals`

### Edit goals
Edit personal fitness goals

Format: `/w <waterGoals> /c <calorieGoals> /m <weightGoals>`

Example of usage: `/w 3000 /c 2500 /m 70`

### Sum
Sum up the total calories/water for the day

Format: `sum <cal|vol> /d <date>`

Example of usage: `sum cal /d 02/02/2025`

### Clear
Clear the respective log

Format: `clear <pb|meal|workout|water>`

Example of usage: `clear meal`


### View
View logs for a specific date or log type

Format: `view /m <logtype> /d <date> or view /m all`

Example of usage: `view /m workout /d 02/02/2025`
Example of usage: `view /m all`

### Status Change
Update your cutting/bulking status

Format: `status change <cutting|bulking>`

Example of usage: `status change bulking`

### Status report
View your current cutting/bulking progress

Format: `status report`

Example of usage: `status report`

### Search Keywords/date
Search for logs by keywords or date

Format: `search <loglist> /k <keyword>` OR `search <loglist> /d <date>`

Example of usage: `search workout /k bench` OR `search meal /d 6/5/2025`(search for all meals on 5th June 2025)

## Command Summary
1. `help` - Display this list of commands
2. `bye` - Exit the program
3. `recommend <muscle_group>` - Get workout recommendations
4. `bmi /w <weight_in_kg> /h <height_in_m>` - Calculate your BMI
5. `add workout <exercise> /w <weight in kg> /r <reps> /s <sets> /d <date>` - Add a workout log
6. `add meal <meal_name> /cal <calories> /d <date> /t <time>` - Add a meal log
7. `add water /ml <volume> /d <date> /t <time>` - Add a water log
8. `add pb <exercise> /w <weight_in_kg> /d <date>` - Record a personal best
9. `sum <cal|vol> /d <date>` - Sum up the total calories/water for the day
10. `clear <pb|meal|workout|water>` - Clear the respective log
11. `add cardio <exercise> /s <speed> /i <incline> /t <duration> /d <date>` - Add a cardio log
12. `add goals` - to enter goal setting mode
    13.1  `/w <waterGoals /c <calorieGoals> /m <weightGoals>` - to edit personal goals
13. `status change <cutting/bulking>` - Update your cutting/bulking status
14. `status report` - View your current cutting/bulking progress
15.   `search <logType> /d <date>` OR `search <logType> /k <keyword>`- Search for logs by keywords or date

