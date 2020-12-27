import OutputHandler.*;

public abstract class MenuComponent {

    private String content;
    private OutputFactory outputFactory;
    protected IOutputHandler output;

    public MenuComponent(String content) {
        this.content = content;
        this.outputFactory = new OutputFactory();
        this.output = outputFactory.createOutput("Console Application");
    }

    public String getContent() {
        return content;
    }

    public void add(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public abstract void displayMenu();
}