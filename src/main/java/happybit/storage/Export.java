package happybit.storage;

import happybit.exception.HaBitStorageException;
import happybit.goal.Goal;
import happybit.habit.Habit;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Export {
    private static final String NEWLINE = System.lineSeparator();
    private static final String DELIMITER = "##";
    private static final String GOAL_TYPE = "G";
    private static final String HABIT_TYPE = "H";

    protected String filePath;

    public Export(String filePath) {
        this.filePath = filePath;
    }

    protected void exportStorage(ArrayList<Goal> goalList) throws HaBitStorageException {
        try {
            clearFile();
            writeToFile(goalList);
        } catch (IOException e) {
            throw new HaBitStorageException(e.toString());
        }
    }

    protected void clearFile() throws IOException {
        FileWriter fileWriter = new FileWriter(this.filePath);

        fileWriter.write("");
        fileWriter.close();
    }

    protected void writeToFile(ArrayList<Goal> goalList) throws IOException {
        FileWriter fileWriter = new FileWriter(this.filePath, true);

        for (Goal goal : goalList) {
            int index = goalList.indexOf(goal);
            ArrayList<Habit> habits = goal.getHabitList();
            String goalToWrite = index + DELIMITER
                    + GOAL_TYPE + DELIMITER
                    + goal.getGoalTypeCharacter() + DELIMITER
                    + goal.getGoalName() + DELIMITER
                    + goal.getStartDate() + DELIMITER
                    + goal.getEndDate() + NEWLINE;

            fileWriter.write(goalToWrite);

            for (Habit habit : habits) {
                int doneValue = habit.getDone() ? 1 : 0;
                String habitToWrite = index + DELIMITER
                        + HABIT_TYPE + DELIMITER
                        + doneValue + DELIMITER
                        + habit.getHabitName() + DELIMITER
                        + habit.getHabitDateString() + DELIMITER
                        + habit.getInterval() + NEWLINE;

                fileWriter.write(habitToWrite);
            }
        }
        fileWriter.close();
    }

    protected void exportGoal(Goal goal, int index) throws HaBitStorageException {
        try {
            FileWriter fileWriter = new FileWriter(this.filePath, true);

            String goalToWrite = index + DELIMITER
                    + GOAL_TYPE + DELIMITER
                    + goal.getGoalTypeCharacter() + DELIMITER
                    + goal.getGoalName() + DELIMITER
                    + goal.getStartDate() + DELIMITER
                    + goal.getEndDate() + NEWLINE;

            fileWriter.write(goalToWrite);
            fileWriter.close();
        } catch (IOException e) {
            throw new HaBitStorageException(e.getMessage());
        }
    }

    protected void exportHabit(Habit habit, int index) throws HaBitStorageException {
        try {
            FileWriter fileWriter = new FileWriter(this.filePath, true);

            int doneValue = habit.getDone() ? 1 : 0;
            String habitToWrite = index + DELIMITER
                    + HABIT_TYPE + DELIMITER
                    + doneValue + DELIMITER
                    + habit.getHabitName() + DELIMITER
                    + habit.getHabitDateString() + DELIMITER
                    + habit.getInterval() + NEWLINE;

            fileWriter.write(habitToWrite);
            fileWriter.close();
        } catch (IOException e) {
            throw new HaBitStorageException(e.getMessage());
        }
    }
}
