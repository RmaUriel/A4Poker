
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


/**
 * CreateRoom is the frame that will pop up when you want to create a room.
 * Extends JFrame and uses ActionListener to save room options in a dictionary.
 * 
 * Author Uriel Hernandez-Vega
 * Version 1 
 */

public class CreateRoom extends JFrame{
    
    public CreateRoom(){
        setLayout(null);
        setSize(500,500);
        setTitle("Create a Room");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);


        JLabel room = new JLabel("Create a Room");
        room.setFont(new Font("Courier",Font.BOLD,30));
        room.setBounds(125,0,300,50);
        add(room);

        JLabel name= new JLabel ("Room Name:");
        name.setFont(new Font("Courier", Font.BOLD, 30));
        name.setBounds(5,100, 300,50);
        add(name);

        JTextField enterName = new JTextField();
        enterName.setBounds(200,110,200,40);
        enterName.setFont(new Font("Courier", Font.PLAIN, 15));
        add(enterName);
    
        JLabel mode = new JLabel("Select Mode:");
        mode.setFont(new Font("Courier", Font.BOLD, 30));
        mode.setBounds(5, 200, 300, 50);
        add(mode);
        String[] modes = {
            "Standard", "Increasing", "Fibonacci"
        };
        JComboBox<String> modesMenu = new JComboBox<>(modes);
        modesMenu.setBounds(200,215,200,30);
        add(modesMenu);

        JLabel desc = new JLabel("Description:");
        desc.setFont(new Font("Courier", Font.BOLD, 30));
        desc.setBounds(5,300,300,30);
        add(desc);

        JTextArea description = new JTextArea();
        description.setFont(new Font("Courier", Font.PLAIN, 15));
        description.setBounds(200,300,250,75);
        add(description);

        JButton create = new JButton("Create");
        create.setBounds(200,400, 100,50);
        add(create);

        create.addActionListener(e -> UtilitiesNanny.addRoom(enterName.getText(),(String) modesMenu.getSelectedItem(), description.getText()));
    }

}
