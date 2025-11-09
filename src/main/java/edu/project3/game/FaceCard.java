package edu.project3.game;

public class FaceCard extends Card {
    /* --------------------------------------------------Faces------------------------------------------------------- */
    public enum Face { King, Queen, Jack }

    /* --------------------------------------------------Fields------------------------------------------------------ */
    private Face face;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public FaceCard(Suit suit, Face face) throws NullPointerException { super(suit); this.setFace(face); }

    /* -------------------------------------------------Setters------------------------------------------------------ */
    public void setFace(Face face) throws NullPointerException {
        if (face == null) {
            throw new NullPointerException("\"face\" cannot be null");
        }
        this.face = face;
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */
    public Face getFace() { return this.face; }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public String toString() {
        switch (super.suit) {
            case Clubs:
                switch (this.face) {
                    case King: return "King of Clubs";

                    case Queen: return "Queen of Clubs";

                    case Jack: return "Jack of Clubs";
                }

            case Diamonds:
                switch (this.face) {
                    case King: return "King of Diamonds";

                    case Queen: return "Queen of Diamonds";

                    case Jack: return "Jack of Diamonds";
                }

            case Hearts:
                switch (this.face) {
                    case King: return "King of Hearts";

                    case Queen: return "Queen of Hearts";

                    case Jack: return "Jack of Hearts";
                }

            case Spades:
                switch (this.face) {
                    case King: return "King of Spades";

                    case Queen: return "Queen of Spades";

                    case Jack: return "Jack of Spades";
                }
        }

        return "";
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof FaceCard)) {
            return false;
        }
        FaceCard other = (FaceCard) object;

        return (this.suit == other.suit) && (this.face == other.face);
    }

    @Override
    public int compare(Card card) {
        if (card instanceof FaceCard) {
            FaceCard other = (FaceCard) card;

            switch (this.face) {
                case King:
                    switch (other.face) {
                        case King: return 0; // King equals King

                        case Queen: return 1; // King beats Queen

                        case Jack: return 1; // King beats Jack
                    }

                case Queen:
                    switch (other.face) {
                        case King: return -1; // Queen is beaten by King

                        case Queen: return 0; // Queen equals Queen

                        case Jack: return 1; // Queen beats Jack
                    }
                case Jack:
                    switch (other.face) {
                        case King: return -1; // Jack is beaten by King

                        case Queen: return -1; // Jack is beaten by Queen

                        case Jack: return 0; // Jack equals Jack
                    }
            }
        } else {
            return ((NumberCard) card).getNumber() > 1
                    ? -1 // Any face card beats any number card that's not an Ace
                    : 1; // An Ace beats any card (number or face)
        }

        return 0; // This is an unreachable line of code (only implemented to silence an error)
    }

}
