# User Guide

## Introduction

Welcome to HealthBud, your personal fitness companion! Whether you're tracking workouts, logging meals, monitoring water
intake, or recording personal bests (PBs), HealthBud makes fitness management simple and effective. With an intuitive 
command-line interface, you can easily log, view, and organize your fitness data.

HealthBud goes beyond basic tracking by helping you set and monitor fitness goals, calculate BMI, track your cutting 
or bulking progress, and even receive workout recommendations. Stay motivated and in control of your health journey with
HealthBud!

## Quick start
1. Ensure you have Java 17 or above installed in your Computer. You can download the latest version of Java from here.


2. Download the latest .jar file from [here](https://github.com/AY2425S2-CS2113-W13-4/tp/releases).


3. Copy the file to the folder you want to use as the home folder for HealthBud.


4. Open a command terminal, cd into the folder you put the jar file in, and use the `java -jar tp.jar` command to run the application.


5. Your command terminal should show the following:

<img src="images/CS2113TpLogo.png.jpg" alt="CS2113TpLogo" width="250"/>


6. Type the command in the command terminal and press Enter to execute it.


   Some example commands you can try:

- `add meal` chicken rice `/cal` 200 `/d` 02/02/2025 `/t` 1700: Adds a meal type task with description chicken rice, calories 200, date 02/02/2025 and time 1700 to the task tracker.


- `list workout`: Lists all workout logs.


- `delete water 1`: Deletes the water log with index 1.


- `bye`: Exits the app.



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
 11. add cardio <exercise> /s <speed> /i <incline> /t <duration> /d <date> - Add a cardio log
 13. view goals - to view all goals
 14  add goal /w <waterGoals /cal <calorieGoals> /kg <weightGoals> - to edit personal goals
 15. track goal /d <date> - to track personal goals
 16. status report - View your current cutting/bulking progress
 17. search <logType> /d <DD/MM/YYYY> OR search <logType> /k <keyword> - Search for logs
 18. list <logType> - List all logs for that specific log type
 19. delete <logType> <index> - Delete specific index in the log
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
Updates your list of Goals, not necessary for all parameters to be inputted at once!

Format: `add goal /w <waterGoals> | /cal <calorieGoals> | /kg <weightGoals>`

Example of usage: `add goal /w 1500 /cal 2000 /kg 70`
``` 
Goal has been updated:
Daily Water Goal: 1500 ml
Daily Calorie Goal: 2000 cal
Weight Goal: 70 kg 
``` 

### View goals
Edit personal fitness goals

Format: `view goals`

Example of usage: `view goals`

``` 
    Here are your current goals: 
    Daily Water Goal: Not set yet
    Daily Calorie Goal: Not set yet
    Weight Goal: Not set yet

    What goal would you like to add today?
``` 

### Track goals
Track personal fitness by giving you a summary of your status on the given date

Format: `track goals /d <date>`

Example of usage: `track goals /d 02/02/2025`
``` 
    Here is your goal progress for 2 Feb 2025: 

    Total water consumed: 4000ml
    Total calories consumed: 2000cal
```

### Sum
Sum up the total calories/water for the day

Format: `sum <cal|vol> /d <date>`

Example of usage: `sum cal /d 02/02/2025`
``` 
Total calories consumed: 500
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

### Search Keywords / Date
Search for logs by keywords or date

Format: `search <loglist> /k <keyword>` OR `search <loglist> /d <date>`

Example of usage: `search workout /k bench` OR `search meal /d 6/5/2025`(search for all meals on 5th June 2025)
``` 
Showing logs containing keyword: bench
1. bench press (4 sets of 60 kg for 8 reps) on 26 Dec 2023
3. bench press (4 sets of 65 kg for 9 reps) on 31 Dec 2023
5. bench press (4 sets of 69 kg for 4 reps) on 10 Jan 2024
``` 

### List
List a specific log

Format: `list <logType>`

Example of usage: `list pb`
```
Got it, here are your logs:
1.  bench 80 kg on (21 Mar 2025)
2.  squat 140 kg on (21 Mar 2025)
```

### Delete
Delete specific index in the log

Format: `delete <logType> <index>`

Example of usage: `delete pb 2`
```
Noted. I've removed this log:
bench 80 kg on (21 Mar 2025)
Now you have 6 logs in the list.
```

## Command Summary
| Command             |                                                             Format, Example                                                             |
|---------------------|:---------------------------------------------------------------------------------------------------------------------------------------:|
| ```help```          |                                                               ```help```                                                                |
| ```bye```           |                                                               ``` bye```                                                                |
| ```recommend```     |                                        recommend [muscle_group] <br/> e.g ```recommend biceps```                                        |
| ```bmi```           |                                 bmi /w [weight_in_kg] /h [height_in_m] <br/> e.g ```bmi /w 75 /h 1.8```                                 |
| ```add workout```   | add workout [exercise] /w [weight in kg] /r [reps] /s [sets] /d [date] <br/> e.g ```add workout bench /w 100 /r 8 /s 3 /d 02/02/2025``` |
| ```add meal```      |      add meal [meal_name] /cal [calories] /d [date] /t [time] <br/> e.g ```add meal chicken rice /cal 200 /d 02/02/2025 /t 1700```      |
| ```add water```     |                  add water /ml [volume] /d [date] /t [time]  <br/> e.g ```add water /ml 1000 /d 02/02/2025 /t 1700```                   |
| ```add pb```        |                     add pb [exercise] /w [weight_in_kg] /d [date] <br/> e.g ```add pb bench /w 120 /d 02/02/2025```                     |
| ```add cardio```    |   add cardio [exercise>] /s [speed] /i [incline] /t [duration] /d [date] <br/> e.g ```add cardio run /s 8 /i 5 /t 30 /d 02/02/2025```   |
| ```view goals```    |                                                  view goals <br/> e.g ```view goals```                                                  |
| ```add goal```      |            add goal /w [waterGoals] /cal [calorieGoals] /kg [weightGoals] <br/> e.g ```add goal /w 2000 /cal 3000 /kg 70```             |
| ```track goals```   |                                                 track goals <br/> e.g ```track goals```                                                 |
| ```sum```           |                                      sum [cal/vol] /d [date] <br/> e.g ```sum cal /d 02/02/2025```                                      |
| ```clear```         |                                      clear [pb\|meal\|workout\|water] <br> e.g., ```clear meal```                                       |
| ```status change``` |                                 status change [cutting\|bulking] <br> e.g.,``` staus change bulking```                                  |
| ```status report``` |                                      status report [date] <br> e.g.,```status report 12/13/2025```                                      |
| ```search```        |   search [logType] /k [keyword]  OR search [logType] /d [date] <br> e.g., ```search workout /k bench OR search meal /d 02/04/2025```    |
| ```list```          |                                                   list [logType] e.g., ```list pb```                                                    |
| ```delete```        |                                            delete [logType] [index] e.g., ```delete pb 2```                                             |
