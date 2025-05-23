import java.util.LinkedList;

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
}
