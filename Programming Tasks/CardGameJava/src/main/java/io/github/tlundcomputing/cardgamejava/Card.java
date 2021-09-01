package io.github.tlundcomputing.cardgamejava;

public class Card {
    
    private final String colour;
    private final int value;
    
    public Card(String theColour, int theValue){
        colour = theColour;
        value = theValue;
    }

    public String getColour() {
        return colour;
    }

    public int getValue() {
        return value;
    }
    
    
    
}
