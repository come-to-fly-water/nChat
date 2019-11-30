package com.nChat.game.CardModel;

public class ActionCard extends UNOCard{
	
	private int Function = 0;
	
	//Constructor
	public ActionCard(){
	}
	
	public ActionCard(String cardColor, String cardValue){
		super(cardColor,ACTION, cardValue);		
	}	
}
