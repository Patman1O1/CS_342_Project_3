package edu.project3.game;

public class NumberCard extends Card {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private int number;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public NumberCard(Suit suit, int number) throws NullPointerException, IllegalArgumentException {
        super(suit);
        this.setNumber(number);
    }

    /* -------------------------------------------------Setters------------------------------------------------------ */
    public void setNumber(int number) throws IllegalArgumentException {
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("\"number\" must be between 1 and 10 (inclusive)");
        }
        this.number = number;
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */
    public int getNumber() { return this.number; }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public String toString() {
        switch (super.suit) {
            case Clubs:
                switch (this.number) {
                    case 1: return "Ace of Clubs";

                    case 2: return "Two of Clubs";

                    case 3: return "Three of Clubs";

                    case 4: return "Four of Clubs";

                    case 5: return "Five of Clubs";

                    case 6: return "Six of Clubs";

                    case 7: return "Seven of Clubs";

                    case 8: return "Eight of Clubs";

                    case 9: return "Nine of Clubs";

                    case 10: return "Ten of Clubs";
                }

            case Diamonds:
                switch (this.number) {
                    case 1: return "Ace of Diamonds";

                    case 2: return "Two of Diamonds";

                    case 3: return "Three of Diamonds";

                    case 4: return "Four of Diamonds";

                    case 5: return "Five of Diamonds";

                    case 6: return "Six of Diamonds";

                    case 7: return "Seven of Diamonds";

                    case 8: return "Eight of Diamonds";

                    case 9: return "Nine of Diamonds";

                    case 10: return "Ten of Diamonds";
                }

            case Hearts:
                switch (this.number) {
                    case 1: return "Ace of Hearts";

                    case 2: return "Two of Hearts";

                    case 3: return "Three of Hearts";

                    case 4: return "Four of Hearts";

                    case 5: return "Five of Hearts";

                    case 6: return "Six of Hearts";

                    case 7: return "Seven of Hearts";

                    case 8: return "Eight of Hearts";

                    case 9: return "Nine of Hearts";

                    case 10: return "Ten of Hearts";
                }

            case Spades:
                switch (this.number) {
                    case 1: return "Ace of Spades";

                    case 2: return "Two of Spades";

                    case 3: return "Three of Spades";

                    case 4: return "Four of Spades";

                    case 5: return "Five of Spades";

                    case 6: return "Six of Spades";

                    case 7: return "Seven of Spades";

                    case 8: return "Eight of Spades";

                    case 9: return "Nine of Spades";

                    case 10: return "Ten of Spades";
                }
        }

        return "";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof NumberCard)) {
            return false;
        }
        NumberCard other = (NumberCard) object;

        return (this.suit == other.suit) && (this.number == other.number);
    }

    @Override
    public int compare(Card card) {
        return card instanceof NumberCard
                ? Integer.compare(this.number, ((NumberCard) card).number) // The card with the highest number wins
                : this.number > 1
                    ? -1 // An Ace beats any card (number or face)
                    : 1; // A face card beats any number card that's not an Ace
    }

}
