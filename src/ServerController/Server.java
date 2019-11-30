package ServerController;

import CardModel.WildCard;
import GameModel.Game;
import GameModel.Player;
import Interfaces.GameConstants;
import View.UNOCard;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Server implements GameConstants {
	private Game game;
	private Stack<UNOCard> playedCards;
	public boolean canPlay;
	private int mode;

	public Server() {
		mode = GAMEMODES[1];
		game = new Game(mode);
		playedCards = new Stack<>();

		// First Card
		UNOCard firstCard = game.getCard();
		modifyFirstCard(firstCard);

		playedCards.add(firstCard);

		game.whoseTurn();
		canPlay = true;
	}

	//custom settings for the first card
	private void modifyFirstCard(UNOCard firstCard) {
		if (firstCard.getType() == WILD) {
			int random = new Random().nextInt() % 4;
			try {
				((WildCard) firstCard).useWildColor(UNO_COLORS[Math.abs(random)]);
			} catch (Exception ex) {
				System.out.println("something wrong with modify firstCard");
			}
		}
	}

	public List<UNOCard> getHandCards(String id) {
		return Arrays.stream(game.getPlayers())
				.filter(player -> player.getId().equals(id))
				.findFirst()
				.orElseThrow(null)
				.getAllCards();
	}
	
	//request to play a card
	private void playThisCard(UNOCard clickedCard) {

		// Check player's turn
		if (isHisTurn(clickedCard)) {

			// Card validation
			if (isValidMove(clickedCard)) {

				playedCards.add(clickedCard);
				game.removePlayedCard(clickedCard);

				// function cards ??
				switch (clickedCard.getType()) {
					case ACTION:
						performAction(clickedCard);
						break;
					case WILD:
						performWild((WildCard) clickedCard);
						break;
					default:
						break;
				}

				game.switchTurn();
				checkResults();
			}
		}
	}

	//Check if the game is over
	private void checkResults() {

		if (game.isOver()) {
			canPlay = false;
		}
	}
	
	//check player's turn
	private boolean isHisTurn(UNOCard clickedCard) {

		for (Player p : game.getPlayers()) {
			if (p.hasCard(clickedCard) && p.isMyTurn())
				return true;
		}
		return false;
	}

	//check if it is a valid card
	private boolean isValidMove(UNOCard playedCard) {
		UNOCard topCard = peekTopCard();

		if (playedCard.getColor().equals(topCard.getColor())
				|| playedCard.getValue().equals(topCard.getValue())) {
			return true;
		}

		else if (playedCard.getType() == WILD) {
			return true;
		} else if (topCard.getType() == WILD) {
			String color = ((WildCard) topCard).getWildColor();
			return color.equals(playedCard.getColor());
		}
		return false;
	}

	// ActionCards
	private void performAction(UNOCard actionCard) {

		// Draw2PLUS
		if (actionCard.getValue().equals(DRAW2PLUS))
			game.drawPlus(2);
		else if (actionCard.getValue().equals(REVERSE))
			game.switchTurn();
		else if (actionCard.getValue().equals(SKIP))
			game.switchTurn();
	}

	private void performWild(WildCard functionCard) {		

		//System.out.println(game.whoseTurn());
		if(mode==1 && game.isPCsTurn()){			
			int random = new Random().nextInt() % 4;
			functionCard.useWildColor(UNO_COLORS[Math.abs(random)]);
		}
		else{
			
			ArrayList<String> colors = new ArrayList<>();
			colors.add("RED");
			colors.add("BLUE");
			colors.add("GREEN");
			colors.add("YELLOW");
			
			String chosenColor = (String) JOptionPane.showInputDialog(null,
					"Choose a color", "Wild Card Color",
					JOptionPane.PLAIN_MESSAGE, null, colors.toArray(), null);

			functionCard.useWildColor(UNO_COLORS[colors.indexOf(chosenColor)]);
		}
		
		if (functionCard.getValue().equals(W_DRAW4PLUS))
			game.drawPlus(4);
	}
	
	private void requestCard() {
		game.drawCard(peekTopCard());
	}

	private UNOCard peekTopCard() {
		return playedCards.peek();
	}

	private void submitSaidUNO() {
		game.setSaidUNO();
	}
}
