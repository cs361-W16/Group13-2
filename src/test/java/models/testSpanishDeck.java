package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testSpanishDeck{

    @Test
    public void testSpanishBuildDeck(){
        SpanishDeck d = new SpanishDeck();
        d.build();
        assertEquals(40,d.deck.size());
    }
}