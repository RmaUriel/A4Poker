import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Panel that displays the cards used for estimating.
 *
 * Changed the panel so that when the cards are clicked, the result of the vote is shown
 * @author javiergs
 */

public class T4ACardsPanel extends JPanel {
	private Map<String, String[]> CARD_VALUES = new HashMap<>();
	private JButton selectedButton = null;

	private final Color baseColor = new Color(172, 248, 199);
	private final Color selectedColor = new Color(248, 172, 199);


	public T4ACardsPanel() {
		CARD_VALUES.put("Standard", new String[]{"0", "0.5", "1", "2", "3", "5", "8", "20", "40", "80", "200", "500"});
		CARD_VALUES.put("Increasing", new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"});
		CARD_VALUES.put("Fibonacci", new String[]{"0", "1", "2", "3", "5", "8", "13", "21", "34", "55", "89", "144"});

		setLayout(new GridLayout(4, 3, 10, 10));
		for (String value : CARD_VALUES.get(T4ABlackboard.getInstance().getCardLayout())) {
			JButton card = new JButton(value);
			card.setBackground(baseColor);
			card.setFont(new Font("SansSerif", Font.BOLD, 20));

			card.addActionListener(e -> handleCardClick(card));
			add(card);
		}
	}

	private void handleCardClick(JButton card) {
		if (selectedButton != null) selectedButton.setBackground(baseColor);

		card.setBackground(selectedColor);
		selectedButton = card;
		T4ABlackboard.getInstance().setSelected(Float.parseFloat(card.getText()));
	}
}



