import java.util.LinkedList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Location for shared app data
 *
 * @author Owen McManus
 * @version 1
 */
public class Blackboard {
    private static LinkedList<String> storyQueue = new LinkedList<>();
    private static String activeStory = "";
    private static int selectedCard = -1;
    private static String user = "Default User";

    // Uriel
    private static LinkedList<String> members = new LinkedList<>();
    private static Map<String, String[]> rooms = new HashMap<>();

    // NEW
    public final int ROOM_WINDOW_WIDTH = 500;
    public final int ROOM_WINDOW_HEIGHT = 500;
    public final int MAIN_WINDOW_WIDTH = 1000;
    public final int MAIN_WINDOW_HEIGHT = 800;

    private static Blackboard instance;

    private Blackboard(){
        super();
    }
    public static Blackboard getInstance(){
        if(instance == null)
            instance = new Blackboard();
        return instance;
    }

    public static void addNewStory(String story){
        storyQueue.add(story);
        System.out.print("Story added: ");
        System.out.println(story);
    }

    public static String dequeueNewStory(){
        String story = storyQueue.poll();
        return story != null ? story : "" ;
    }

    public static void setActiveStory(String story){
        activeStory = story;
        System.out.print("New active story: ");
        System.out.println(activeStory);
    }

    public static void setSelected(int value){
        selectedCard = value;
    }

    public static String getUser(){
        return user;
    }

    // THIS IS ADDING URIEL BLACKBOARD

    public static void addUser(String name){
        members.add(name.trim());
    }

    public static void addNewRoom(String name, String mode, String description){
        if (!name.isEmpty()){
            String[] roomInfo = {mode, description};
            rooms.put(name,roomInfo);
        }
    }

}
