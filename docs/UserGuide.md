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

Format: `add goal`

Example of usage: `add goal`
``` 
Welcome to goal setting! Here are your current goals: 
Daily Water Goal: 1500 ml
Daily Calorie Goal: Not set yet
Weight Goal: Not set yet

What goal would you like to add today?

Goal has been updated:
Daily Water Goal: 1500 ml
Daily Calorie Goal: Not set yet
Weight Goal: Not set yet
``` 

### Edit goals
Edit personal fitness goals

Format: `/w <waterGoals> /c <calorieGoals> /m <weightGoals>`

Example of usage: `/w 3000 /c 2500 /m 70`

``` 
adasdad
``` 

### Sum
Sum up the total calories/water for the day

Format: `sum <cal|vol> /d <date>`

Example of usage: `sum cal /d 02/02/2025`
``` 
Total calories consumed: 0
``` 
### Clear
Clear the respective log

Format: `clear <pb|meal|workout|water>`

Example of usage: `clear meal`
``` 
Noted. I've removed all logs.
``` 
### Status Change
Update your cutting/bulking status

Format: `status change <cutting|bulking>`

Example of usage: `status change bulking`
``` 
Status updated to: bulking
``` 
### Status report
View your current cutting/bulking progress

Format: `status report <date>`

Example of usage: `status report 26/12/2023`
``` 
Total calories consumed: 2300
Total calories burned: 790
Current Status: bulking
Your intake does not align with your goal. Net calories: 500
``` 

### Search Keywords/date
Search for logs by keywords or date

Format: `search <loglist> /k <keyword>` OR `search <loglist> /d <date>`

Example of usage: `search workout /k bench` OR `search meal /d 6/5/2025`(search for all meals on 5th June 2025)
``` 
Showing logs containing keyword: bench
1. bench press (4 sets of 60 kg for 8 reps) on 26 Dec 2023
3. bench press (4 sets of 65 kg for 9 reps) on 31 Dec 2023
5. bench press (4 sets of 69 kg for 4 reps) on 10 Jan 2024
``` 

## Command Summary
| Command      |                                                          Format, Example                                                          |
|--------------|:---------------------------------------------------------------------------------------------------------------------------------:|
| ```help```        |                                                               ```help```                                                                |
| ```bye```         |                                                               ``` bye```                                                                |
| ```reccommend```   |                                        recommend [muscle_group] <br/> e.g ```recommend biceps```                                        |
| ```bmi```          |                                 bmi /w [weight_in_kg] /h [height_in_m] <br/> e.g ```bmi /w 75 /h 1.8```                                 |
| ```add workout```  | add workout [exercise] /w [weight in kg] /r [reps] /s [sets] /d [date] <br/> e.g ```add workout bench /w 100 /r 8 /s 3 /d 02/02/2025``` |
| ```add meal```     |      add meal [meal_name] /cal [calories] /d [date] /t [time] <br/> e.g ```add meal chicken rice /cal 200 /d 02/02/2025 /t 1700```      |
| ```add water```    |                  add water /ml [volume] /d [date] /t [time]  <br/> e.g ```add water /ml 1000 /d 02/02/2025 /t 1700```                   |
| ```add pb```       |                     add pb [exercise] /w [weight_in_kg] /d [date] <br/> e.g ```add pb bench /w 120 /d 02/02/2025```                     |
| ```add cardio```   |   add cardio [exercise>] /s [speed] /i [incline] /t [duration] /d [date] <br/> e.g ```add cardio run /s 8 /i 5 /t 30 /d 02/02/2025```   |
| ```add goal```     |                                                             ```add goal```                                                              |
| ```add goal```     |               add goal /w [waterGoals] /c [calorieGoals] /m [weightGoals] <br/> e.g ```add goal /w 2000 /c 3000 /m 70```                |
| ```sum```          |                                      sum [cal/vol] /d [date] <br/> e.g ```sum cal /d 02/02/2025```                                      |
| ```clear```        |                                      clear [pb\|meal\|workout\|water] <br> e.g., ```clear meal```                                       |
| ```status change``` |                                 status change [cutting\|bulking] <br> e.g.,``` staus change bulking```                                  |
| ```status report```      |                                      status report [date] <br> e.g.,```status report 12/13/2023```       |
| ```search```|     search [loglist] /k [keyword]  OR search [loglist] /d [date] <br> e.g., ```search workout bench OR search meal /d 02/04/200```1     |

