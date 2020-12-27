package OutputHandler;

// gui factory- creates and returns the desired gui
public class OutputFactory {
    public IOutputHandler createOutput(String option) {
        switch(option) {
            case "Console Application":
                return new ConsoleApplication();
            case "Light Mode":
                return new LightModeGUI();
            case "Dark Mode":
                return new DarkModeGUI();
            default:
                return null;
        }
    }
}
