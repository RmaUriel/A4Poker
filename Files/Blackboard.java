import java.beans.PropertyChangeSupport;
import java.util.LinkedList;

import java.util.HashMap;
import java.util.Map;


/**
 * Location for shared app data
 *
 * @author Owen McManus
 * @version 1
 */
public class Blackboard extends PropertyChangeSupport {
    private static LinkedList<String> storyQueue = new LinkedList<>();
    private static LinkedList<String[]> completedStory = new LinkedList<>();
    private static String activeStory = "";
    private static float selectedCard = -1;
    private static String user = "Default User";

    // Uriel
    private static LinkedList<String> members = new LinkedList<>();
    private String[] activeRoom = {"", ""};
    private Map<String, String> rooms = new HashMap<>();

    // NEW
    public final int ROOM_WINDOW_WIDTH = 500;
    public final int ROOM_WINDOW_HEIGHT = 500;
    public final int MAIN_WINDOW_WIDTH = 1000;
    public final int MAIN_WINDOW_HEIGHT = 800;

    private static Blackboard instance;

    private Blackboard(){
        super(new Object());
    }
    public static Blackboard getInstance(){
        if(instance == null)
            instance = new Blackboard();
        return instance;
    }

    public void addNewStory(String story){
        storyQueue.add(story);
        firePropertyChange("newStory", null, storyQueue);
    }

    public String dequeueNewStory(){
        String story = storyQueue.poll();
        firePropertyChange("newStory", null, storyQueue);
        return story != null ? story : "" ;
    }

    public void addCompletedStory(String story, float score){
        completedStory.add(new String[]{story, Float.toString(score)});
        firePropertyChange("completedStory", null, completedStory);
    }

    public void setActiveStory(String story){
        activeStory = story;
        firePropertyChange("activeStory", null, activeStory);
    }

    public void setSelected(float value){
        selectedCard = value;
    }

    public static String getUser(){
        return user;
    }

    // THIS IS ADDING URIEL BLACKBOARD

    public void addUser(String name){
        members.add(name.trim());
    }

    public void addNewRoom(String name, String mode){
        activeRoom[0] = name;
        activeRoom[1] = mode;
    }

    public void joinRoom(String name){
        activeRoom[0] = name;
        activeRoom[1] = "Standard";
    }

    public String getCardLayout(){
        return activeRoom[1];
    }

    public String getSelection(){
        return Float.toString(selectedCard);
    }

    public String getActiveStory(){
        return activeStory;
    }
}
