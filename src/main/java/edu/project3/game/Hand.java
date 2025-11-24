package edu.project3.game;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Hand implements Serializable {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final long serialVersionUID = 1L;

    private final List<Card> cards;

    private final List<Rank> ranks;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public Hand(Deck deck) throws NullPointerException {
        if (deck == null) {
            throw new NullPointerException("\"deck\" cannot be null");
        }

        // Draw three cards at random from the deck
        this.cards = new ArrayList<>(3);
        for (int i = 0; i < 3; ++i) {
            this.cards.add(deck.draw());
        }

        this.ranks = this.cards.stream()
                .map(Card::getRank)
                .sorted()
                .collect(Collectors.toList());
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */
    public Card getHighCard() { return this.cards.stream().max(Card::compareTo).orElse(null); }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    // Two cards are of the same rank
    public boolean isPair() {
        return this.ranks.get(0).equals(this.ranks.get(1)) ||
               this.ranks.get(1).equals(this.ranks.get(2)) ||
               this.ranks.get(0).equals(this.ranks.get(2));
    }

    // All cards are of the same suit
    public boolean isFlush() { return this.cards.stream().map(Card::getSuit).distinct().count() == 1; }

    // All cards are in sequence
    public boolean isStraight() {
        int a = this.ranks.get(0).value;
        int b = this.ranks.get(1).value;
        int c = this.ranks.get(2).value;

        // Normal straight
        boolean normal = (c - b == 1) && (b - a == 1);

        // Special A-2-3 straight
        boolean aceLow = (a == Rank.TWO.value &&
                b == Rank.THREE.value &&
                c == Rank.ACE.value);

        return normal || aceLow;
    }

    // Add cards are of the same rank
    public boolean isThreeOfAKind() {
        return this.ranks.get(0).equals(this.ranks.get(1)) && this.ranks.get(1).equals(this.ranks.get(2));
    }

    // Add cards are in sequence and are of the same suit
    public boolean isStraightFlush() { return this.isFlush() && this.isStraight(); }

}
