package happybit.command;

import happybit.exception.HaBitCommandException;
import happybit.goal.GoalList;
import happybit.storage.Storage;
import happybit.ui.PrintManager;

public class DeleteHabitCommand extends DeleteCommand {

    protected int goalIndex;
    protected int habitIndex;

    public DeleteHabitCommand(int goalIndex, int habitIndex) {
        this.goalIndex = goalIndex;
        this.habitIndex = habitIndex;
    }

    @Override
    public void runCommand(GoalList goalList, PrintManager printManager, Storage storage) throws HaBitCommandException {
        goalList.deleteHabitFromGoal(goalIndex, habitIndex, printManager);
    }

}
