import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();
        MoviesBarchartLoader loader = new MoviesBarchartLoader();
        mainFrame.put("toggle", new ToggleStatisticCommand(mainFrame.getBarchartDisplay(), loader));
        mainFrame.getBarchartDisplay().show(loader.load(0));
        mainFrame.setVisible(true);
    }
}