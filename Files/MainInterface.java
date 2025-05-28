import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.util.*;
/*
 * This class is for the mainframe where frames will be shown together
 * Just setting main space with quick mockup of other 3 frames
 * 
 * Author Uriel Hernandez-vega
 * Version 1 
 * 
 */

public class MainInterface extends JFrame {

    public MainInterface(){
      Blackboard blackBoard = Blackboard.getInstance();

      setLayout(new BorderLayout());
      setTitle("Main Interface");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);

      CardsPanel cardsPanel = new CardsPanel();
      add(cardsPanel, BorderLayout.CENTER);

      SouthPanel southPanel = new SouthPanel();
      add(southPanel, BorderLayout.SOUTH);

      MockMain mockMainInstance = new MockMain();
      JPanel utilitiesPanel = new UtilitiesPanel(new UtilitiesNanny(mockMainInstance));
      add(utilitiesPanel, BorderLayout.EAST);

    }
  @Override
  public Dimension getPreferredSize(){
    return new Dimension(Blackboard.getInstance().MAIN_WINDOW_WIDTH, Blackboard.getInstance().MAIN_WINDOW_HEIGHT);
  }

}
