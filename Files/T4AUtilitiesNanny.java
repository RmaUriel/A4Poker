import java.awt.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Contains handlers for managing the general control of the application.
 * Features include opening the add story panel and showing/hiding results.
 *
 * @author Owen McManus
 * @version 1
 */
public class T4AUtilitiesNanny {
    T4MainInterface window;
    T4AUtilitiesNanny(T4MainInterface window){
       this.window = window;
    }

    public void openNewStoryWindow(){
        NewStoryWindow newStoryWindow = new NewStoryWindow();
        newStoryWindow.showWindow();
    }

    public void showResults(){
        Blackboard.getInstance().addCompletedStory(Blackboard.getInstance().getActiveStory(), Float.parseFloat(Blackboard.getInstance().getSelection()));
        switchToResultsGUI();
    }

    public void switchToNextStory(){
        Blackboard.getInstance().setActiveStory(Blackboard.getInstance().dequeueNewStory());
        Blackboard.getInstance().setSelected(-1);
        switchToCardsGUI();
    }

    private void switchToResultsGUI() {
        T4APieChartPanel resultsPanel = new T4APieChartPanel(new String[]{Blackboard.getInstance().getSelection()}, new int[]{1});
        Component center = ((BorderLayout) window.getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER);
        if (center != null)
            window.remove(center);

        window.add(resultsPanel, BorderLayout.CENTER);
        window.revalidate();
        window.repaint();
    }

    private void switchToCardsGUI() {
        CardsPanel cardsPanel = new CardsPanel();
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
            SwingUtilities.invokeLater(() -> {
                T4MainInterface t4MainInterface = new T4MainInterface();
                t4MainInterface.pack();
                t4MainInterface.setVisible(true);
            });
        }
    }

    public static void addRoom(String name, String modes, String description){
        if(!name.isEmpty()){
            System.out.println(name +" " +"Mode:" + modes + " " + "Desc: "+ description);
        }
    }

    //MICHAEL NANNY


    public static List<String> activeStory = new ArrayList<>();


    public void saveAndAddNew(String text) {
        System.out.println(text);
        this.activeStory.add(text);
        // add functionality to save the story and add a new one
    }

    public void saveAndClose(String text) {
        System.out.println(text);
        this.activeStory.add(text);
        Blackboard.getInstance().addNewStory(text);
        //switchGUI();
    }

    public void importStories() {
        System.out.println("importing stories...");
    }

    public void cancel() {
        System.out.println("canceling...");
    }

/*    private void switchGUI() {
        window.setTitle("dashboard");
        DashboardNanny dashboardNanny = new DashboardNanny(window);
        DashboardPanel dashboardPanel = new DashboardPanel(dashboardNanny);
        window.setContentPane(dashboardPanel);
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.revalidate();
        window.repaint();
    }


 */
    public static List<String> getActive(){
        return activeStory;
    }


}
