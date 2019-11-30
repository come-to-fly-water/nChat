package CardModel;
import java.awt.Color;

import View.UNOCard;

public class ActionCard extends UNOCard{
	
	private int Function = 0;
	
	//Constructor
	public ActionCard(){
	}
	
	public ActionCard(String cardColor, String cardValue){
		super(cardColor,ACTION, cardValue);		
	}	
}
