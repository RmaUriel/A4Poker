
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Stories organized in tabs.
 * The first tab contains the active stories, and the second one contains the completed stories.
 *
 * After a vote, the completed story is updated and the story voted on is removed from active story
 *
 * Active stories is now based on user inputed stories
 *
 * Created a button to remove the top active story
 */

public class SouthPanel extends JPanel implements PropertyChangeListener {
	private JTextArea completedStoriesArea;
	private JTextArea activeStoriesArea;
	private JTextArea upcomingStoriesArea;
	//private List<String> active = three.StoriesNanny.getActive();
    private List<String> active = UtilitiesNanny.getActive();

	public SouthPanel() {
		setBackground(new Color(161, 190, 239));
		setLayout(new BorderLayout());

		JTabbedPane storyTabs = new JTabbedPane();

		StringBuilder actString = new StringBuilder();
		for (String s : active) {
			actString.append(s).append("\n");
		}
		activeStoriesArea = new JTextArea(String.valueOf(actString));
		activeStoriesArea.setEditable(false);

		completedStoriesArea = new JTextArea();
		completedStoriesArea.setEditable(false);

		upcomingStoriesArea = new JTextArea();
		upcomingStoriesArea.setEditable(false);

		storyTabs.addTab("Active Stories", new JScrollPane(activeStoriesArea));
		storyTabs.addTab("Completed Stories", new JScrollPane(completedStoriesArea));
		storyTabs.addTab("Upcoming Stories", new JScrollPane(upcomingStoriesArea));

		// Create the remove button
		JButton removeTopButton = new JButton("Remove Top Story");
		removeTopButton.addActionListener(e -> removeTopStory());

		// Create a panel for the button
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(removeTopButton);

		// Add tabs and button to layout
		add(storyTabs, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		Blackboard.getInstance().addPropertyChangeListener(this);
	}

	public String topStory() {
		return active.isEmpty() ? "(No stories)" : active.getFirst();
	}

	public void addCompletedStory(String story) {
		String existing = completedStoriesArea.getText();
		StringBuilder fin = new StringBuilder();

		if (!active.isEmpty()) {
			active.removeFirst();
		}

		if (!existing.isEmpty()) {
			existing += "\n";
		}

		for (String s : active) {
			fin.append(s).append("\n");
		}

		completedStoriesArea.setText(existing + story);
		activeStoriesArea.setText(fin.toString());
	}

	// Helper to remove just the top story manually
	private void removeTopStory() {
		if (active.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No more active stories to remove.");
			return;
		}

		active.removeFirst();

		// Rebuild the activeStoriesArea text
		StringBuilder updated = new StringBuilder();
		for (String s : active) {
			updated.append(s).append("\n");
		}
		activeStoriesArea.setText(updated.toString());
	}

	@Override
	public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
		if(Objects.equals(propertyChangeEvent.getPropertyName(), "newStory")){
			Queue<String> storiesQueue = (Queue<String>) propertyChangeEvent.getNewValue();
			StringBuilder builder = new StringBuilder();
			for(String story : storiesQueue){
				builder.append(story);
				builder.append("\n");
			}
			upcomingStoriesArea.setText(builder.toString());
		}
		if(Objects.equals(propertyChangeEvent.getPropertyName(), "completedStory")){
			List<String[]> storiesList = (List<String[]>) propertyChangeEvent.getNewValue();
			StringBuilder builder = new StringBuilder();
			for(String[] story : storiesList){
				builder.append(story[0]);
				builder.append(": ");
				builder.append(story[1]);
				builder.append("\n");
			}
			completedStoriesArea.setText(builder.toString());
		}
		if(Objects.equals(propertyChangeEvent.getPropertyName(), "activeStory")){
			String activeStory = (String) propertyChangeEvent.getNewValue();
			activeStoriesArea.setText(activeStory);
		}

	}
}
