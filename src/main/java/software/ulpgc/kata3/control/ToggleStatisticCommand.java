package software.ulpgc.kata3.control;

import software.ulpgc.kata3.io.BarchartLoader;
import software.ulpgc.kata3.view.BarchartDisplay;

import java.io.IOException;

public class ToggleStatisticCommand implements Command {
    private final BarchartDisplay display;
    private final BarchartLoader loader;
    private int id = 1;

    public ToggleStatisticCommand(BarchartDisplay display, BarchartLoader loader) {
        this.display = display;
        this.loader = loader;
    }

    @Override
    public void execute() throws IOException {
        display.show(loader.load(id++%2));
    }
}