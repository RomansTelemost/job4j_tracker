package ru.job4j.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.tracker.actions.*;
import ru.job4j.tracker.repository.MemTracker;

import java.util.Arrays;
import java.util.List;

public class StartUI {

    private final Output out;

    private static final Logger LOG = LoggerFactory.getLogger(StartUI.class.getName());

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        LOG.info("init startUI Tracker");
        boolean run = true;
        while (run) {
            showMenu(actions);
            LOG.info("Before select menu item Tracker");
            int select = input.askInt("Select: ");
            LOG.info(String.format("Select menu item Tracker. Selected menu item: %s", select));
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        LOG.info("Show menu Tracker");
        out.println("Menu.");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        try (Store tracker = new MemTracker()) {
            List<UserAction> actions = Arrays.asList(
                    new CreateManyItemsAction(output),
                    new EditAction(output),
                    new ShowAllAction(output),
                    new DeleteAllItemsAction(output),
                    new FindByIdAction(output),
                    new FindByNameAction(output),
                    new ExitAction(output)
            );
            new StartUI(output).init(input, tracker, actions);
        } catch (Exception e) {
            LOG.error("Error", e);
        }
    }
}
