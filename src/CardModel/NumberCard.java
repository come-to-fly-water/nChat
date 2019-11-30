package CardModel;
import java.awt.Color;

import View.UNOCard;

public class NumberCard extends UNOCard {

	public NumberCard(){
	}
	
	public NumberCard(String cardColor, String cardValue){
		super(cardColor, NUMBERS, cardValue);		
	}

}
