import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
/*
 * This class is for the mainframe where frames will be shown together
 * Just setting main space with quick mockup of other 3 frames
 * 
 * Author Uriel Hernandez-vega
 * Version 1 
 * 
 */

public class MainInterface extends JFrame{

    public MainInterface(){
      setLayout(new BorderLayout());
      setTitle("Main Interface");
      setSize(1500,900);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);

      JPanel cardSpace = new JPanel();
      cardSpace.setBackground(Color.RED);
      cardSpace.setLayout(new GridLayout(4,3,10,10));
      for(int i = 0; i < 5; i++){
        JButton card = new JButton("Card" + i);
        card.setBackground(Color.BLACK);
        cardSpace.add(card);
      }
      add(cardSpace, BorderLayout.CENTER);

      JPanel storyTable = new JPanel();
      storyTable.setBackground(new Color(0,100,255));
      storyTable.setLayout(new GridLayout(3,2));
      String[] columnName = {"Active Story","Completed Story"};
      Object [][] data = {{1,"Story 1"}, {2, "S2"}, {3, "Stor 3"}};
      DefaultTableModel tab = new DefaultTableModel(data, columnName);
      JTable table = new JTable(tab);
      storyTable.add(table, BorderLayout.CENTER);
      add(storyTable, BorderLayout.SOUTH);

      JPanel controls = new JPanel();
      controls.setBackground(Color.DARK_GRAY);
      controls.setLayout(new GridLayout(3,1));
      controls.add(new JLabel("Vote"));
      controls.add(new JButton("SELECT"));
      controls.add(new JLabel("TWO"));
      add(controls, BorderLayout.EAST);

    }
}
