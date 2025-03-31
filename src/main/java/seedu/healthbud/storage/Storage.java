package seedu.healthbud.storage;

import seedu.healthbud.LogList;
import seedu.healthbud.log.Meal;
import seedu.healthbud.log.WorkOUT;
import seedu.healthbud.log.Water;
import seedu.healthbud.log.Log;
import seedu.healthbud.log.PB;
import seedu.healthbud.log.Cardio;
import seedu.healthbud.log.Goals;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Storage {

    public static final String DATA_DIRECTORY = "data";
    public static final String DATA_FILE = "HealthBud.txt";
    public static final Path DATA_PATH = Paths.get(DATA_DIRECTORY, DATA_FILE);

    /**
     * Loads logs from the storage file into the provided LogLists.
     * If the file or directory does not exist, they are created.
     *
     * @param mealLogs the LogList to load meal logs into
     * @param workoutLogs the LogList to load workout logs into
     * @param waterLogs the LogList to load water logs into
     */
    public static void loadLogs(LogList mealLogs, LogList workoutLogs, LogList waterLogs,
                                LogList pbLogs, LogList cardioLogs, LogList goalLogs) {
        try {
            Files.createDirectories(Paths.get(DATA_DIRECTORY));

            if (!Files.exists(DATA_PATH)) {
                Files.createFile(DATA_PATH);
                System.out.println("Created new text file in " +
                        DATA_PATH.toString().replace("\\", "/"));
                return;
            }

            List<String> lines = Files.readAllLines(DATA_PATH);
            for (String line : lines) {
                try {
                    Log log = parseStringToLog(line);
                    // Distribute log based on its type
                    if (log instanceof Meal) {
                        mealLogs.loadLog(log);
                    } else if (log instanceof WorkOUT) {
                        workoutLogs.loadLog(log);
                    } else if (log instanceof Water) {
                        waterLogs.loadLog(log);
                    } else if (log instanceof PB){
                        pbLogs.loadLog(log);
                    } else if (log instanceof Cardio){
                        cardioLogs.loadLog(log);
                    } else if (log instanceof Goals){
                        goalLogs.loadLog(log);
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Warning: Ignoring invalid log in file: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Warning: Error loading logs from file. Starting with empty lists.");
        }
    }

    public static Log parseStringToLog(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid log format");
        }
        String type = parts[0];

        switch (type) {
        case "M":
            if (parts.length != 5) {
                throw new IllegalArgumentException("Invalid meal format");
            }
            return new Meal(parts[1], parts[2], parts[3], parts[4]);
        case "WO":
            if (parts.length != 6) {
                throw new IllegalArgumentException("Invalid workout format");
            }
            return new WorkOUT(parts[1], parts[2], parts[3], parts[4], parts[5]);
        case "WA":
            if (parts.length != 4) {
                throw new IllegalArgumentException("Invalid water format");
            }
            return new Water(parts[1], parts[2], parts[3]);
        case "P":
            if (parts.length != 4) {
                throw new IllegalArgumentException("Invalid pb format");
            }
            return new PB(parts[1], parts[2], parts[3]);
        case "C":
            if (parts.length != 6) {
                throw new IllegalArgumentException("Invalid cardio format");
            }
            return new Cardio(parts[1], parts[2], parts[3], parts[4], parts[5]);
        case "G":
            if (parts.length != 4) {
                throw new IllegalArgumentException("Invalid goal format");
            }
            Goals goals = Goals.getInstance();
            goals.setDailyWaterGoal(parts[1]);
            goals.setDailyCalorieGoal(parts[2]);
            goals.setWeightGoal(parts[3]);
            return goals;
        default:
            throw new IllegalArgumentException("Unknown log type: " + type);
        }
    }

    public static void appendLogToFile(Log log) {
        try (FileWriter fw = new FileWriter(DATA_PATH.toString(), true)) {
            fw.write(parseLogToString(log) + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error appending log to file: " + e.getMessage());
        }
    }

    public static void rewriteLogsToFile(LogList logs) {
        try (FileWriter fw = new FileWriter(DATA_PATH.toString())) {
            for (int i = 0; i < logs.getSize(); i++) {
                fw.write(parseLogToString(logs.getLog(i)) + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error rewriting logs to file: " + e.getMessage());
        }
    }

    public static String parseLogToString(Log log) {
        if (log instanceof Meal) {
            Meal meal = (Meal) log;
            return "M | " + meal.getName() + " | " + meal.getCalories()
                    + " | " + meal.getDate() + " | " + meal.getTime();
        } else if (log instanceof WorkOUT) {
            WorkOUT workout = (WorkOUT) log;
            return "WO | " + workout.getName() + " | " + workout.getReps()
                    + " | " + workout.getSets() + " | " + workout.getDate()
                    + " | " + workout.getWeight();
        } else if (log instanceof Water) {
            Water water = (Water) log;
            return "WA | " + water.getAmount() + " | " + water.getDate() + " | " + water.getTime();
        } else if (log instanceof PB) {
            PB pb = (PB) log;
            return "P | " + pb.getExercise() + " | " + pb.getWeight() + " | " + pb.getDate();
        } else if (log instanceof Cardio) {
            Cardio cardio = (Cardio) log;
            return "C | " + cardio.getName() + " | " + cardio.getDuration() + " | " + cardio.getIncline() +
                    " | " + cardio.getSpeed() + " | " + cardio.getDate();
        } else if (log instanceof Goals) {
            Goals goals = (Goals) log;
            return "G | " + goals.getDailyWaterGoal() + " | " + goals.getDailyCalorieGoal()
                    + " | " + goals.getWeightGoal();
        }else {
            throw new IllegalArgumentException("Unknown log type");
        }
    }
}
