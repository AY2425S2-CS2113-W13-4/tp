package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidWorkoutException;
import seedu.healthbud.log.WorkoutLog;

public class AddWorkout extends Command {

    @Override
    public void execute(LogList logs, String input) {
        try {
            // Parse the input
            String[] parts = input.split(" /e | /r | /s ");
            if (parts.length < 4) {
                throw new InvalidWorkoutException("Invalid workout format. " +
                        "Use: add <date> /e <exercise> /r <reps> /s <sets>");
            }

            String date = parts[0].replace("add ", "").trim();
            String exercise = parts[1].trim();
            int reps = Integer.parseInt(parts[2].trim());
            int sets = Integer.parseInt(parts[3].trim());

            // Create a Workout object
            WorkoutLog workout = new WorkoutLog(date, exercise, reps, sets);

            // Add the workout to the static list in Workout class
            WorkoutLog.addWorkout(workout);
            System.out.println("Workout added: " + workout);

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format for reps or sets. Please enter valid integers.");
        } catch (InvalidWorkoutException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
