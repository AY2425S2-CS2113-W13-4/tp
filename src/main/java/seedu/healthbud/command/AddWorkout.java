package seedu.healthbud.command;

import seedu.healthbud.LogList;
import seedu.healthbud.exception.InvalidWorkoutException;
import seedu.healthbud.log.Workout;


public class AddWorkout extends Command {

    @Override
    public void execute(LogList logs, String input) throws InvalidWorkoutException {
        // Parse the input
        String[] parts = input.split(" /e | /r | /s ");
        if (parts.length < 4) {
            throw new InvalidWorkoutException();
        }

        String date = parts[0].replace("add ", "").trim();
        String exercise = parts[1].trim();
        int reps = Integer.parseInt(parts[2].trim());
        int sets = Integer.parseInt(parts[3].trim());

        // Create a Workout object
        Workout workout = new Workout(date, exercise, reps, sets);

        // Add the workout to LogList
        logs.addWorkout(workout);
        System.out.println("Workout added: " + workout);

    }

}
