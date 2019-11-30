package CardModel;

import java.awt.Color;

import View.UNOCard;

public class WildCard extends UNOCard {
	
	private int Function = 0;
	private String chosenColor;
	
	public WildCard() {
	}
	
	public WildCard(String cardValue){
		super(BLACK, WILD, cardValue);		
	}
	
	public void useWildColor(String wildColor){
		chosenColor = wildColor;
	}
	
	public String getWildColor(){
		return chosenColor;
	}

}
