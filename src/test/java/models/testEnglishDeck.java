package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testEnglishDeck{

    @Test
    public void testEnglishBuildDeck(){
        EnglishDeck d = new EnglishDeck();
        d.build();
        assertEquals(52,d.deck.size());
    }
}