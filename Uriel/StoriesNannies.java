import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import java.awt.*;

public class StoriesNannies {
    private MainInterface main;

    public StoriesNannies(MainInterface main){
        this.main = main;
    }

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
 }

