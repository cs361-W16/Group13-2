package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Trevor Hammock on 2/18/16.
 */
public class Deck{

    public java.util.List<Card> deck = new ArrayList<>();


    public Deck() {}

    //returns the top card in the deck
    public Card getTop() {
        return deck.get(deck.size()-1);
    }

    //removes the top card from the deck
    public void removeTop() {
        deck.remove(deck.size()-1);
    }

    //gets the card at the specific position in the list
    public Card getAt(int pos) {
        return deck.get(pos);
    }

    //removes a card at the specific position in the list
    public void removeAt(int pos) {
        deck.remove(pos);
    }

    //randomly shuffles the deck of cards
    public void shuffle() {
        long seed = System.nanoTime();
        Collections.shuffle(deck, new Random(seed));
    }

    //return the number of cards in the deck
    public int size() {
        return deck.size();
    }

    //this currently replaces buildDeck() in Game.java
    public void build() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }
}