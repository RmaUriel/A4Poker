import java.awt.*;
import javax.swing.*;

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

    // URIEL NANNY

    public static void addName(String name){
        if(!name.isEmpty()){
            System.out.println(name);
            SwingUtilities.invokeLater(() -> new MainInterface().setVisible(true));
        }
    }

    public static void addRoom(String name, String modes, String description){
        if(!name.isEmpty()){
            System.out.println(name +" " +"Mode:" + modes + " " + "Desc: "+ description);
        }
    }

    //MICHAEL NANNY
/*
    private Main main;
    public static List<String> activeStory = new ArrayList<>();


    public void saveAndAddNew(String text) {
        System.out.println(text);
        this.activeStory.add(text);
        // add functionality to save the story and add a new one
    }

    public void saveAndClose(String text) {
        System.out.println(text);
        this.activeStory.add(text);
        Blackboard.addStory(text);
        switchGUI();
    }

    public void importStories() {
        System.out.println("importing stories...");
    }

    public void cancel() {
        System.out.println("canceling...");
    }

    private void switchGUI() {
        main.setTitle("dashboard");
        DashboardNanny dashboardNanny = new DashboardNanny(main);
        DashboardPanel dashboardPanel = new DashboardPanel(dashboardNanny);
        main.setContentPane(dashboardPanel);
        main.setSize(800, 600);
        main.setLocationRelativeTo(null);
        main.revalidate();
        main.repaint();
    }

    public static List<String> getActive(){
        return activeStory;
    }

 */
}
