package com.nChat.game.Interfaces;

public interface GameConstants extends UNOConstants {
	
	int TOTAL_CARDS = 108;
	int FIRSTHAND = 8;
	
	String[] UNO_COLORS = {RED, BLUE, GREEN, YELLOW};
	String WILD_CARDCOLOR = BLACK;
	
	int[] UNO_NUMBERS =  {0,1,2,3,4,5,6,7,8,9};	
	String[] ActionTypes = {REVERSE,SKIP,DRAW2PLUS};	
	String[] WildTypes = {W_COLORPICKER, W_DRAW4PLUS};

	int MANUAL = 2;
	
	int[] GAMEMODES = {1, MANUAL};
	
}
