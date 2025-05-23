import javax.swing.*;
import java.awt.*;

/**
 * Mockup main window
 *
 * @author Owen McManus
 * @version 1
 */
public class MockMain extends JFrame {
    public static void main(String[] args) {
        MockMain app = new MockMain();
        app.setSize(600,400);
        app.setTitle("Plan-it Poker");
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setVisible(true);
    }

    public MockMain(){
        JPanel utilitiesPanel = new UtilitiesPanel(new UtilitiesNanny(this));
        JPanel cardPanel = new MockCardPanel();
        setLayout(new BorderLayout());
        add(utilitiesPanel, BorderLayout.EAST);
        add(cardPanel, BorderLayout.CENTER);
    }
}
