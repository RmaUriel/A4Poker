import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/*
 * Blackboard has a Linked list that saves all usernames
 * A Hashmap which stores mode and description of room. Name of room is key
 * 
 * Author Uriel Hernandez-Vega
 * Version 1
 */
public class Blackboard {

    private static LinkedList<String> members = new LinkedList<>();
    private static Map<String, String[]> rooms = new HashMap<>();
 
    public static void userName(String name){
        members.add(name.trim());
    }

    public static void newRoom(String name, String mode, String description){
        if (!name.isEmpty()){
            String[] roomInfo = {mode, description};
            rooms.put(name,roomInfo);
        }
    }

}
