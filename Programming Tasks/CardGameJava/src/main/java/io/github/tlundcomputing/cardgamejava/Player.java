package io.github.tlundcomputing.cardgamejava;

import java.util.ArrayList;

public class Player {
    
    private final String name;
    private Card currentCard;
    private final ArrayList<Card> winningCards;
    
    public Player(String name){
        this.name = name;
        currentCard = null;
        winningCards = new ArrayList<>();
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public ArrayList<Card> getWinningCards() {
        return winningCards;
    }

    public void setWinningCards(Card card1, Card card2) {
        winningCards.add(card1);
        winningCards.add(card2);
    }
    
    public String getName(){
        return name;
    }
    
}
