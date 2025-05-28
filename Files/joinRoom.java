import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * joinRoom is the frame that will pop up when you want to join a room.
 * Extends JFramea and uses ActionListener to close frame and open main interface
 * 
 * Author Uriel Hernandez-Vega
 * Version 1 
 */


public class joinRoom extends JFrame{

    public joinRoom(){
        setTitle("Join a room");
        setSize(500,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JLabel join = new JLabel("Join a Room");
        join.setFont(new Font("Courier",Font.BOLD,30));
        join.setBounds(125,0,300,50);
        add(join);

        JLabel account = new JLabel ("Have an Account?");
        account.setFont(new Font("Courier", Font.BOLD, 30));
        account.setBounds(100,300, 300,50);
        add(account);


        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Courier", Font.BOLD, 30));
        name.setBounds(50, 100, 300, 50);
        add(name);

        JTextField enterName = new JTextField();
        enterName.setBounds(150,110,200,40);
        add(enterName);

        JButton joinButton = new JButton("Join");
        joinButton.setBounds(180, 175,100,50);
        add(joinButton);

        joinButton.addActionListener(e -> UtilitiesNanny.addName(enterName.getText()));

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(180, 365, 100,50);
        add(loginButton);
        //loginButton.addActionListener(e -> StoriesNannies.addName(enterName.getText()));


    }

}
    
