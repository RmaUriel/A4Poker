import javax.swing.*;
import java.awt.*;

/**
 * GUI for managing the general control of the application.
 * Features include opening the add story panel and showing/hiding results.
 *
 * @author Owen McManus
 * @version 1
 */
public class T4AUtilitiesPanel extends JPanel {
    public T4AUtilitiesPanel(T4AUtilitiesNanny t4AUtilitiesNanny){
        JButton viewResults = new JButton("View Results");
        JButton nextStory = new JButton("Next Story");
        JButton addStory = new JButton("Add Story");
        JLabel playersTitle = new JLabel("Players:");
        JLabel username = new JLabel(T4ABlackboard.getUser());

        setLayout(new GridLayout(11, 1));
        add(viewResults);
        add(nextStory);
        add(addStory);
        add(playersTitle);
        add(username);

        addStory.addActionListener(e -> t4AUtilitiesNanny.openNewStoryWindow());
        viewResults.addActionListener(e -> t4AUtilitiesNanny.showResults());
        nextStory.addActionListener(e -> t4AUtilitiesNanny.switchToNextStory());
    }
}
