package models;

import java.util.ArrayList;

/**
 * Created by michaelhilton on 1/25/16.
 */
public class Game {

    public Deck deck = new Deck();

    public java.util.List<java.util.List<Card>> cols = new ArrayList<>();

    public int Score;


    public Game(){
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        cols.add(new ArrayList<Card>());
        Score = 0;
    }

    public void buildDeck() {
        //later on we will override build for the different decks
        deck.build();
    }

    /*

    //Will need to create child classes of spanish and english that implement the following decks respectively
    //If we are parsing out what to name the cards (as I suspect we are) that will have to be changed
    //or we will have to do major refactoring to the code

    public void buildSpanishDeck() {
        for(int i = 1; i < 12; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }

    public void buildEnglishDeck() {
        for(int i = 2; i < 15; i++){
            deck.add(new Card(i,Suit.Clubs));
            deck.add(new Card(i,Suit.Hearts));
            deck.add(new Card(i,Suit.Diamonds));
            deck.add(new Card(i,Suit.Spades));
        }
    }


     */

    public void shuffle() {
        deck.shuffle();
    }

    public void dealFour() {
        for(int i = 0; i < 4; i++){
            cols.get(i).add(deck.getTop());
            deck.removeTop();
        }
    }

    //customDeal to setup game for testing purposes
    public void customDeal(int c1, int c2, int c3, int c4) {
        cols.get(0).add(deck.getAt(c1));
        deck.removeAt(c1);
        cols.get(1).add(deck.getAt(c2));
        deck.removeAt(c2);
        cols.get(2).add(deck.getAt(c3));
        deck.removeAt(c3);
        cols.get(3).add(deck.getAt(c4));
        deck.removeAt(c4);
    }

    public void remove(int columnNumber) {
        if(colHasCards(columnNumber)) {
            Card c = getTopCard(columnNumber);
            boolean removeCard = false;
            for (int i = 0; i < 4; i++) {
                if (i != columnNumber) {
                    if (colHasCards(i)) {
                        Card compare = getTopCard(i);
                        if (compare.getSuit() == c.getSuit()) {
                            if (compare.getValue() > c.getValue()) {
                                removeCard = true;
                            }
                        }
                    }
                }
            }
            if (removeCard) {
                this.cols.get(columnNumber).remove(this.cols.get(columnNumber).size() - 1);
                Score = Score + 1;
            }
        }
    }

    private boolean colHasCards(int colNumber) {
        if(this.cols.get(colNumber).size()>0){
            return true;
        }
        return false;
    }

    private Card getTopCard(int columnNumber) {
        return this.cols.get(columnNumber).get(this.cols.get(columnNumber).size()-1);
    }


    public void move(int colFrom, int colTo) {
        Card cardToMove = getTopCard(colFrom);
        this.removeCardFromCol(colFrom);
        this.addCardToCol(colTo,cardToMove);
    }

    private void addCardToCol(int colTo, Card cardToMove) {
        cols.get(colTo).add(cardToMove);
    }

    private void removeCardFromCol(int colFrom) {
        this.cols.get(colFrom).remove(this.cols.get(colFrom).size()-1);


    }
}
