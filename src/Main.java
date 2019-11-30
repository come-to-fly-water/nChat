import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import GameModel.Game;
import Interfaces.GameConstants;
import View.MainFrame;
import View.UNOCard;

public class Main {
	
	public static void main(String[] args) {
		// Game game = new Game(GameConstants.MANUAL);
		// Stack<UNOCard> playedCards = new Stack<UNOCard>();
		// UNOCard firstCard = game.getCard();

		//Create Frame and invoke it.
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new MainFrame();
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setLocation(200, 100);
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		});
	}
}
