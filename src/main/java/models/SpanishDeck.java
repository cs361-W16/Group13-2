package models;

public class SpanishDeck extends Deck {

    public SpanishDeck(){}

    public void build(){
        for(int i = 1; i < 11; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Coins));
            deck.add(new Card(i,Suit.Cups));
            deck.add(new Card(i,Suit.Swords));
        }
    }
}