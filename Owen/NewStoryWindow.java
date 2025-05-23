import javax.swing.*;

/**
 * Helper window that holds the NewStoryPanel
 *
 * @author Owen McManus
 * @version 1
 */
public class NewStoryWindow extends JFrame {
    public NewStoryWindow(){
        NewStoryNanny newStoryNanny = new NewStoryNanny(this);
        JPanel newStoryPanel = new NewStoryPanel(newStoryNanny);
        add(newStoryPanel);
    }

    public void showWindow(){
        setSize(600,400);
        setTitle("New Story");
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void hideWindow(){
        setVisible(false);
    }
}
