import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent {

    private List<MenuComponent> subMenus = new ArrayList<>();

    public Menu(String content) {
        super(content);
    }

    @Override
    public void add(MenuComponent menuComponent) {
        this.subMenus.add(menuComponent);
    }

    @Override
    public void displayMenu() {
        this.output.printMessage(getContent());
        this.subMenus.forEach(MenuComponent::displayMenu);
    }
}