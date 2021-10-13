package happybit.command;

import happybit.exception.HBCommandException;
import happybit.goal.GoalList;
import happybit.storage.Storage;
import happybit.ui.Ui;

public class HelpCommand extends Command {

    @Override
    public void runCommand(GoalList goalList, Ui ui, Storage storage) throws HBCommandException {
        ui.printCommandList();
    }

}
