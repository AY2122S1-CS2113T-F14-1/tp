package happybit.command;

import happybit.exception.HaBitCommandException;
import happybit.exception.HaBitStorageException;
import happybit.goal.GoalList;
import happybit.storage.Storage;
import happybit.ui.PrintManager;

public class DeleteHabitCommand extends DeleteCommand {

    protected int goalIndex;
    protected int habitIndex;

    /**
     * Constructor of DeleteHabitCommand.
     *
     * @param goalIndex  Index of goal in goalList, where a habit is to be deleted.
     * @param habitIndex Index of habit in goal to be deleted.
     */
    public DeleteHabitCommand(int goalIndex, int habitIndex) {
        this.goalIndex = goalIndex;
        this.habitIndex = habitIndex;
    }

    /**
     * Executes delete habit command and removes goal from goalList.
     *
     * @param goalList     List that stores all the goals.
     * @param printManager Prints messages to the console.
     * @param storage      Reference to the file where data is stored.
     * @throws HaBitCommandException If the goalIndex and/or habitIndex provided is invalid.
     */
    @Override
    public void runCommand(GoalList goalList, PrintManager printManager, Storage storage) throws HaBitCommandException {
        goalList.deleteHabitFromGoal(goalIndex, habitIndex, printManager);

        try {
            storage.export(goalList.getGoalList());
        } catch (HaBitStorageException e) {
            printManager.showError(e.getMessage());
        }
    }

}
