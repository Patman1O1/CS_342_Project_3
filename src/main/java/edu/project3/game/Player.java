package edu.project3.game;

import java.io.Serializable;
import java.math.*;

public class Player implements Serializable {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private double anteWager, plusPairWager;

    private final Hand hand;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Player(Deck deck) throws IllegalArgumentException {
        this.anteWager = this.plusPairWager = 0.00;
        this.hand = new Hand(deck);
    }

    /* -------------------------------------------------Setters------------------------------------------------------ */
    public void setAnteWager(double anteWager) throws IllegalArgumentException {
        if (anteWager < 5.00 || anteWager > 25.00) {
            throw new IllegalArgumentException("\"anteWage\" must be between $5.00 and $25.00");
        }

        this.anteWager = anteWager;
    }

    public void setPlusPairWager(double plusPairWager) throws IllegalArgumentException {
        if (plusPairWager < 5.00 || plusPairWager > 25.00) {
            throw new IllegalArgumentException("\"plusPairWage\" must be between $5.00 and $25.00");
        }

        this.plusPairWager = plusPairWager;
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */


    /* -------------------------------------------------Methods------------------------------------------------------ */


}
