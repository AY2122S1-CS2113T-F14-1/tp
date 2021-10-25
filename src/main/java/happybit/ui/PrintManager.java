package happybit.ui;

import happybit.goal.Goal;
import happybit.habit.Habit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PrintManager {
    private static final String COMMAND_LIST_GREETING =
            "Hello! These are all the possible commands for this habit tracker :)"
                    + " (flags within {} brackets are optional)";
    private static final String SET_GOAL_COMMAND =
            "- set a goal: set n/<goal name> { t/<goal type> s/<start date> } e/<end date>";
    private static final String GOAL_TYPE_INFO =
            "   -> Goal types include: default[df], sleep[sl], food[fd], exercise[ex] and study[sd]";
    private static final String UPDATE_GOAL_COMMAND =
            "- update a goal: update g/<goal index> n/<new goal name>";
    private static final String REMOVE_GOAL_COMMAND =
            "- remove a goal: remove g/<goal index>";
    private static final String LIST_GOAL_COMMAND =
            "- list all goals for that habit: list";
    private static final String ADD_HABIT_COMMAND =
            "- add a habit to a goal: add g/<goal index> n/<habit name> i/<interval>";
    private static final String DELETE_HABIT_COMMAND =
            "- delete a habit from a goal: delete g/<goal index> h/<habit index>";
    private static final String DONE_HABIT_COMMAND =
            "- indicate a habit as done: done g/<goal index> h/<habit index>";
    private static final String LIST_HABIT_COMMAND =
            "- View all the habits user has under a goal: view g/<goal index>";
    private static final String BYE_COMMAND = "- Exit habit tracker program: bye";

    private static final String NEWLINE = System.lineSeparator();
    private static final String DASHES = "______________________________________________________________"
            + "__________________________________________________________";
    public static final String HORIZONTAL_SYMBOL = "-";
    public static final String VERTICAL_BAR = "|";
    public static final String WHITE_SPACE = " ";

    public void printCommandList() {
        printDashes();
        System.out.print(COMMAND_LIST_GREETING + NEWLINE
                + SET_GOAL_COMMAND + NEWLINE
                + GOAL_TYPE_INFO + NEWLINE
                + UPDATE_GOAL_COMMAND + NEWLINE
                + REMOVE_GOAL_COMMAND + NEWLINE
                + LIST_GOAL_COMMAND + NEWLINE
                + ADD_HABIT_COMMAND + NEWLINE
                + DELETE_HABIT_COMMAND + NEWLINE
                + DONE_HABIT_COMMAND + NEWLINE
                + LIST_HABIT_COMMAND + NEWLINE
                + BYE_COMMAND + NEWLINE
        );
        printDashes();
    }

    public void printGoalList(ArrayList<Goal> goals, int numOfGoals) {
        String[] headers = {"Index", "Name", "Type", "Start Date", "End Date", "Habit Count"};
        String[][] data = populateGoalData(goals, numOfGoals, headers.length);
        System.out.println("There are " + numOfGoals + " goals currently being tracked:");
        printTable(headers, data);
    }

    public void printHabitList(String goalDescription, ArrayList<Habit> habits, int numOfHabits) {
        int index = 1;
        printDashes();
        assert (numOfHabits > 0) : "List cannot be empty here";
        System.out.println("Here are your " + numOfHabits + " habit(s) under the goal \""
                + goalDescription + "\".");
        for (Habit habit : habits) {
<<<<<<< HEAD
            String currIndex = index + ". ";
            printHabitDetails(habit, currIndex);
=======
            System.out.print(index + ". ");
            String intervalPrint = "(every " + habit.getInterval() + " days)";
            String lastHabitDatePrint = habit.getHabitDateString();
            String nextHabitDatePrint = habit.getNextDateString();
            if (habit.getDone()) {
                prefix = "[X]";
            }
            System.out.println(prefix + WHITE_SPACE + habit.getHabitName() + WHITE_SPACE + intervalPrint);
            System.out.println("Last: " + lastHabitDatePrint + ", " + "Next: " + nextHabitDatePrint);
>>>>>>> 85d0edbae2569effbfe18369fdddc56831b2f999
            index++;
        }
        printDashes();
    }

    public void printAddedGoal(String goalDescription) {
        printDashes();
        System.out.println("Your goal: " + goalDescription + " has been added.");
        printDashes();
    }

    public void printAddedHabit(String habitDescription, String goalDescription) {
        printDashes();
        System.out.println("Your habit: " + habitDescription + " has been added to your goal: " + goalDescription);
        printDashes();
    }

    public void printRemovedGoal(String goalDescription) {
        printDashes();
        System.out.println("Your goal: " + goalDescription + " has been removed.");
        printDashes();
    }

    public void printRemovedHabit(String goalDescription, String habitName) {
        printDashes();
        System.out.println("Your habit of \"" + habitName + "\" under the goal \""
                + goalDescription + "\" has been deleted.");
        printDashes();
    }

    public void printDoneHabit(String goalDescription, Habit habit) {
        printDashes();
        System.out.println("You have completed your habit of \"" + habit.getHabitName() + "\" under the goal \""
                + goalDescription + "\" set for " + habit.getHabitDateString() + ". Well Done!");
        if (habit.getInterval() > 0) {
            System.out.println("Your next date set for this habit is " + habit.getNextHabitDateString());
        } else {
            System.out.println("Update the habit with a regular interval value to make it recurring!");
        }
        printDashes();
    }

    public void printUpdatedGoal(String oldGoalDescription, String goalDescription) {
        printDashes();
        System.out.println("Your goal \"" + oldGoalDescription + "\" has been changed to \"" + goalDescription + "\".");
        printDashes();
    }

    public void showError(String message) {
        printDashes();
        System.out.println(message);
        printDashes();
    }

    public void showGoodbye() {
        printDashes();
        System.out.println("Thanks for using Ha(ppy)Bit, see you in a \033[3mbit\033[0m! (hehe)" + NEWLINE);
        System.out.println("\"We are what we repeatedly do. Excellence, then, is not an act, but a habit.\"" + NEWLINE
                + " — Will Durant");
        printDashes();
    }

    /*
     * NOTE : ==================================================================
     * The following are private methods that are used to implement SLAP for the
     * above public methods. These methods are positioned at the bottom to better
     * visualise the actual methods that can be called from outside this class.
     * =========================================================================
     */

    private void printHabitDetails(Habit habit, String currIndex) {
        String intervalPrint = "";
        int habitIntervals = habit.getInterval();
        if (habitIntervals > 0) {
            intervalPrint ="(every " + habit.getInterval() + " day(s)";
        }
        Date lastHabitDate = habit.getHabitDate();
        Date nextHabitDate = habit.getNextHabitDate();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        String lastHabitDatePrint = dateFormatter.format(lastHabitDate);
        String nextHabitDatePrint = dateFormatter.format(nextHabitDate);
        System.out.println(currIndex + " " + habit.getHabitName() + " " + intervalPrint);
        System.out.println("Last: " + lastHabitDatePrint + ", " + "Next: " + nextHabitDatePrint);
    }

    private void printDashes() {
        System.out.println(DASHES);
    }

    /**
     * Prints data in a tabular format.
     *
     * @param headers 1D string array containing names of headers.
     * @param data    2D string array containing data.
     */
    public void printTable(String[] headers, String[][] data) {
        int numOfRows = data.length;
        int numOfColumns = headers.length;
        int[] columnLengths = getColumnLengths(numOfRows, numOfColumns, headers, data);
        int totalLength = getTotalLength(columnLengths);
        String lineSeparator = HORIZONTAL_SYMBOL.repeat(totalLength);
        printHeaders(lineSeparator, headers, columnLengths, numOfColumns);
        printData(numOfRows, numOfColumns, columnLengths, data, lineSeparator);
    }

    /*
     * NOTE : ==================================================================
     * The following are private methods that are used to implement SLAP for the
     * above public methods. These methods are positioned at the bottom to better
     * visualise the actual methods that can be called from outside this class.
     * =========================================================================
     */

    // The following are sub-methods of the printTable() method.

    /**
     * Get the column lengths for the table.
     *
     * @param numOfRows    Number of data rows.
     * @param numOfColumns Number of data columns.
     * @param headers      1D string array containing names of headers.
     * @param data         2D string array containing data.
     * @return Integer array containing the column lengths.
     */
    private int[] getColumnLengths(int numOfRows, int numOfColumns, String[] headers, String[][] data) {
        int[] columnLengths = new int[numOfColumns];
        int minimumLength;
        for (int columnIndex = 0; columnIndex < numOfColumns; columnIndex++) {
            minimumLength = minimumMultipleOfFive(headers[columnIndex].length());
            columnLengths[columnIndex] = getMinimumLength(minimumLength, columnIndex, numOfRows, data);
        }
        return columnLengths;
    }

    /**
     * Get the minimum length that a column can be from the size of each data entry.
     *
     * @param minimumLength Minimum column length based off the column header.
     * @param columnIndex   Column index of the data.
     * @param numOfRows     Number of data rows.
     * @param data          2D string array containing data.
     * @return Minimum length of a column.
     */
    private int getMinimumLength(int minimumLength, int columnIndex, int numOfRows, String[][] data) {
        for (int rowIndex = 0; rowIndex < numOfRows; rowIndex++) {
            int comparedLength = minimumMultipleOfFive(data[rowIndex][columnIndex].length());
            if (comparedLength > minimumLength) {
                minimumLength = comparedLength;
            }
        }
        return minimumLength;
    }

    /**
     * Get the total length for a row.
     *
     * @param columnLengths 1D array containing all column lengths.
     * @return Total length for a row.
     */
    private int getTotalLength(int[] columnLengths) {
        int totalLength = 1;
        for (int length : columnLengths) {
            totalLength += length + 1;
        }
        return totalLength;
    }

    /**
     * Prints the headers of the table.
     *
     * @param lineSeparator Line that separates the rows of the table.
     * @param headers       1D string array containing names of headers.
     * @param columnLengths 1D array containing all column lengths.
     * @param numOfColumns  Number of data columns.
     */
    private void printHeaders(String lineSeparator, String[] headers, int[] columnLengths, int numOfColumns) {
        System.out.println(lineSeparator);
        System.out.print(VERTICAL_BAR);
        for (int columnIndex = 0; columnIndex < numOfColumns; columnIndex++) {
            System.out.print(headers[columnIndex]);
            System.out.print(WHITE_SPACE.repeat(columnLengths[columnIndex] - headers[columnIndex].length()));
            System.out.print(VERTICAL_BAR);
        }
        System.out.println(NEWLINE + lineSeparator);
    }

    /**
     * Prints the data entries of the table.
     *
     * @param numOfRows     Number of data rows.
     * @param numOfColumns  Number of data columns.
     * @param columnLengths 1D array containing all column lengths.
     * @param data          2D string array containing data.
     * @param lineSeparator Line that separates the rows of the table.
     */
    private void printData(int numOfRows, int numOfColumns, int[] columnLengths, String[][] data,
                           String lineSeparator) {
        for (int rowIndex = 0; rowIndex < numOfRows; rowIndex++) {
            printRow(rowIndex, numOfColumns, columnLengths, data, lineSeparator);
        }
    }

    /**
     * Prints a row of the data entries.
     *
     * @param rowIndex      Column index of the data.
     * @param numOfColumns  Number of data columns.
     * @param columnLengths 1D array containing all column lengths.
     * @param data          2D string array containing data.
     * @param lineSeparator Line that separates the rows of the table.
     */
    private void printRow(int rowIndex, int numOfColumns, int[] columnLengths, String[][] data, String lineSeparator) {
        System.out.print(VERTICAL_BAR);
        for (int columnIndex = 0; columnIndex < numOfColumns; columnIndex++) {
            System.out.print(data[rowIndex][columnIndex]);
            System.out.print(WHITE_SPACE.repeat(columnLengths[columnIndex] - data[rowIndex][columnIndex].length()));
            System.out.print(VERTICAL_BAR);
        }
        System.out.println(NEWLINE + lineSeparator);
    }

    /**
     * Rounds up a number to the closest multiple of 5.
     *
     * @param num Number to be rounded up.
     * @return Multiple of 5 that is rounded up from the input number.
     */
    private int minimumMultipleOfFive(int num) {
        int result = 0;
        while (num > result) {
            result += 5;
        }
        return result;
    }

    // The following are sub-methods of list printing.

    /**
     * Populate a 2D array with goal data.
     *
     * @param goals        Arraylist containing all the goals.
     * @param numOfGoals   Number of goals.
     * @param numOfColumns Number of data columns.
     * @return 2D string array containing goal data.
     */
    private String[][] populateGoalData(ArrayList<Goal> goals, int numOfGoals, int numOfColumns) {
        String[][] data = new String[numOfGoals][numOfColumns];
        for (int goalIndex = 0; goalIndex < numOfGoals; goalIndex++) {
            data[goalIndex][0] = String.valueOf(goalIndex + 1);
            data[goalIndex][1] = goals.get(goalIndex).getGoalName();
            data[goalIndex][2] = goals.get(goalIndex).getGoalType();
            data[goalIndex][3] = goals.get(goalIndex).getPrintableStartDate();
            data[goalIndex][4] = goals.get(goalIndex).getPrintableEndDate();
            data[goalIndex][5] = String.valueOf(goals.get(goalIndex).getHabitListSize());
        }
        return data;
    }

}
