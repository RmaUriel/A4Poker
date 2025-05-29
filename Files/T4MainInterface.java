import javax.swing.*;
import java.awt.*;
/*
 * This class is for the mainframe where frames will be shown together
 * Just setting main space with quick mockup of other 3 frames
 * 
 * @author Uriel Hernandez-vega
 * @version 1
 * 
 */

public class T4MainInterface extends JFrame {

    public T4MainInterface(){
      setLayout(new BorderLayout());
      setTitle("Main Interface");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);

      T4ACardsPanel cardsPanel = new T4ACardsPanel();
      add(cardsPanel, BorderLayout.CENTER);

      T4ASouthPanel t4ASouthPanel = new T4ASouthPanel();
      add(t4ASouthPanel, BorderLayout.SOUTH);

      JPanel utilitiesPanel = new T4AUtilitiesPanel(new T4AUtilitiesNanny(this));
      add(utilitiesPanel, BorderLayout.EAST);

    }
  @Override
  public Dimension getPreferredSize(){
    return new Dimension(T4ABlackboard.getInstance().MAIN_WINDOW_WIDTH, T4ABlackboard.getInstance().MAIN_WINDOW_HEIGHT);
  }

}
