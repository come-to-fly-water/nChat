package com.nChat.game;

import java.util.List;

import com.nChat.game.CardModel.UNOCard;

public class Main {
	
	public static void main(String[] args) {
		// Game game = new Game(GameConstants.MANUAL);
		// Stack<UNOCard> playedCards = new Stack<UNOCard>();
		// UNOCard firstCard = game.getCard();

		Server server = new Server();
		List<UNOCard> cards = server.getHandCards("123");
		cards.forEach(unoCard -> System.out.print(unoCard.getValue() + " "));
		System.out.println();
		cards.forEach(unoCard -> System.out.print(unoCard.getColor() + " "));
		System.out.println();

		UNOCard card = cards.get(0);
		UNOCard topCard = server.peekTopCard();
		boolean res = server.playThisCard(card);
		System.out.println(card.getValue() + " " + card.getColor());
		System.out.println(topCard.getValue() + " " + topCard.getColor());
		System.out.println(res);
	}
}
