import java.awt.*;

/**
 * Contains handlers for managing the general control of the application.
 * Features include opening the add story panel and showing/hiding results.
 *
 * @author Owen McManus
 * @version 1
 */
public class UtilitiesNanny {
    MockMain window;
    UtilitiesNanny(MockMain window){
       this.window = window;
    }

    public void openNewStoryWindow(){
        NewStoryWindow newStoryWindow = new NewStoryWindow();
        newStoryWindow.showWindow();
    }

    public void showResults(){
        switchToResultsGUI();
    }

    public void switchToNextStory(){
        Blackboard.setActiveStory(Blackboard.dequeueNewStory());
        Blackboard.setSelected(-1);
        switchToCardsGUI();
    }

    private void switchToResultsGUI() {
        MockResultsPanel resultsPanel = new MockResultsPanel();
        Component center = ((BorderLayout) window.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER);
        if (center != null)
            window.remove(center);

        window.add(resultsPanel, BorderLayout.CENTER);
        window.revalidate();
        window.repaint();
    }

    private void switchToCardsGUI() {
        MockCardPanel cardsPanel = new MockCardPanel();
        Component center = ((BorderLayout) window.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER);
        if (center != null)
            window.remove(center);

        window.add(cardsPanel, BorderLayout.CENTER);
        window.revalidate();
        window.repaint();
    }
}
