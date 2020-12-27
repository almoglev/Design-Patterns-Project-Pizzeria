public class MenuItem extends MenuComponent {

    public MenuItem(String context) {
        super(context);
    }

    @Override
    public void displayMenu() {
        this.output.printMessage(getContent());
    }
}