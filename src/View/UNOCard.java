package View;
import java.awt.Color;

import Interfaces.CardInterface;
import Interfaces.UNOConstants;

public abstract class UNOCard implements CardInterface, UNOConstants {
	
	private String cardColor = null;
	private String value = null;
	private int type = 0;

	public UNOCard(){
	}
	
	public UNOCard(String cardColor, int cardType, String cardValue){
		this.cardColor = cardColor;
		this.type = cardType;
		this.value = cardValue;
	}


	public void setColor(String newColor) {
		this.cardColor = newColor;
	}

	public String getColor() {
		return cardColor;
	}

	@Override
	public void setValue(String newValue) {
		this.value = newValue;		
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setType(int newType) {
		this.type = newType;
	}

	@Override
	public int getType() {
		return type;
	}
}
