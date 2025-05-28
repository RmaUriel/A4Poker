import javax.swing.*;
import java.awt.*;


public class MainTasks{
    
    public static void main(String[] args){
        
        JFrame joinRoom = new joinRoom();
        joinRoom.setVisible(true);
        joinRoom.setLocation(500,100);

        JFrame createRoom = new CreateRoom();
        createRoom.setVisible(true);    

    }
}
