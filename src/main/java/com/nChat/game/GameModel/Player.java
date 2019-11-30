package com.nChat.game.GameModel;

import java.util.LinkedList;

import com.nChat.game.CardModel.UNOCard;

public class Player {
	
	private String id = null;
	private boolean isMyTurn = false;
	private boolean saidUNO = false;
	private LinkedList<UNOCard> myCards;
	
	private int playedCards = 0;
	
	public Player(){
		myCards = new LinkedList<UNOCard>();
	}
	
	public Player(String player){
		setId(player);
		myCards = new LinkedList<UNOCard>();
	}
	
	public void setId(String newName){
		id = newName;
	}
	
	public String getId(){
		return this.id;
	}

	public void obtainCard(UNOCard card){
		myCards.add(card);
	}
	
	public LinkedList<UNOCard> getAllCards(){
		return myCards;
	}
	
	public int getTotalCards(){
		return myCards.size();
	}
	
	public boolean hasCard(UNOCard thisCard){
		return myCards.contains(thisCard);		
	}
	
	public void removeCard(UNOCard thisCard){
		myCards.remove(thisCard);
		playedCards++;
	}
	
	public int totalPlayedCards(){
		return playedCards;
	}
	
	public void toggleTurn(){
		isMyTurn = !isMyTurn;
	}
	
	public boolean isMyTurn(){
		return isMyTurn;
	}
	
	public boolean hasCards(){
		return !myCards.isEmpty();
	}
	
	public boolean getDidNotSaidUNO(){
		return !saidUNO;
	}
	
	public void saysUNO(){
		saidUNO = true;
	}
	
	public void setSaidUNOFalse(){
		saidUNO = false;
	}
	
	public void setCards(){
		myCards = new LinkedList<UNOCard>();
	}
}