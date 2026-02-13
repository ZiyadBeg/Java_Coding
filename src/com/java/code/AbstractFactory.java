package src.com.java.code;
interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}
class WindowsButton implements Button {
    public void paint() { System.out.println("Rendering a Button in Windows Style."); }
}
class WindowsCheckbox implements Checkbox {
    public void paint() { System.out.println("Rendering a Checkbox in Windows Style."); }
}

class MacButton implements Button {
    public void paint() { System.out.println("Rendering a Button in Mac Style."); }
}

class MacCheckbox implements Checkbox {
    public void paint() { System.out.println("Rendering a Checkbox in Mac Style."); }
}
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
class WindowsFactory implements GUIFactory {
    public Button createButton() { return new WindowsButton(); }
    public Checkbox createCheckbox() { return new WindowsCheckbox(); }
}
class MacFactory implements GUIFactory {
    public Button createButton() { return new MacButton(); }
    public Checkbox createCheckbox() { return new MacCheckbox(); }
}
// --- Step 6: The Client Class ---
class Application {
    private Button button;
    private Checkbox checkbox;

    // Constructor factory interface leta hai (Loose Coupling)
    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void render() {
        button.paint();
        checkbox.paint();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        Application app;
        GUIFactory factory;


        String osName = "MAC"; // Aap isay "WINDOWS" bhi kar sakte hain

        if (osName.equalsIgnoreCase("WINDOWS")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        // Client code factory ki type se be-khabar hai
        app = new Application(factory);
        app.render();
    }
}
