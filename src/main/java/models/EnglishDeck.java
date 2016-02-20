package models;

public class EnglishDeck extends Deck {

        public EnglishDeck(){}

        public void build(){
            for(int i = 2; i < 15; i++){
                deck.add(new Card(i,Suit.Clubs));
                deck.add(new Card(i,Suit.Hearts));
                deck.add(new Card(i,Suit.Diamonds));
                deck.add(new Card(i,Suit.Spades));
            }
        }
}