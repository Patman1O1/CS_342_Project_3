package edu.project3.gui;

import edu.project3.game.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardView extends ImageView {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private final Card card;

    private Image frontImage;

    private final Image backImage;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public CardView(Card card) throws NullPointerException {
        // Set the card
        if (card == null) {
            throw new NullPointerException("\"card cannot be null\"");
        }
        this.card = card;

        // Set the back image
        this.backImage = new Image("/png/back.png");

        // Set the front image
        if (this.card.getClass() == FaceCard.class) {
            FaceCard.Face face = ((FaceCard) this.card).getFace();
            switch (this.card.getSuit()) {
                case Clubs:
                    switch (face) {
                        // King Of Clubs
                        case King:
                            this.frontImage = new Image("/png/king-of-clubs.png");
                            break;

                        // Queen of Clubs
                        case Queen:
                            this.frontImage = new Image("/png/queen-of-clubs.png");
                            break;

                        // Jack of Clubs
                        case Jack:
                            this.frontImage = new Image("/png/jack-of-clubs.png");
                            break;
                    }
                    break;

                case Diamonds:
                    switch (face) {
                        // King of Diamonds
                        case King:
                            this.frontImage = new Image("/png/king-of-diamonds.png");
                            break;

                        // Queen of Diamonds
                        case Queen:
                            this.frontImage = new Image("/png/queen-of-diamonds.png");
                            break;

                        // Jack of Diamonds
                        case Jack:
                            this.frontImage = new Image(("/png/jack-of-diamonds.png"));
                            break;
                    }
                    break;

                case Hearts:
                    switch (face) {
                        // King of Hearts
                        case King:
                            this.frontImage = new Image("/png/king-of-hearts.png");
                            break;

                        // Queen of Hearts
                        case Queen:
                            this.frontImage = new Image("/png/queen-of-hearts.png");
                            break;

                        // Jack of Hearts
                        case Jack:
                            this.frontImage = new Image("/png/jack-of-hearts.png");
                            break;
                    }
                    break;

                case Spades:
                    switch (face) {
                        // King of Spades
                        case King:
                            this.frontImage = new Image("/png/king-of-spades.png");
                            break;

                        // Queen of Spades
                        case Queen:
                            this.frontImage = new Image("/png/queen-of-spades.png");
                            break;

                        // Jack of Spades
                        case Jack:
                            this.frontImage = new Image("/png/jack-of-spades.png");
                            break;
                    }
                    break;
            }
        } else {
            int number = ((NumberCard) this.card).getNumber();
            switch (card.getSuit()) {
                case Clubs:
                    switch (number) {
                        // Ace of Clubs
                        case 1:
                            this.frontImage = new Image("/png/ace-of-clubs.png");
                            break;

                        // Two of Clubs
                        case 2:
                            this.frontImage = new Image("/png/two-of-clubs.png");
                            break;

                        // Three of Clubs
                        case 3:
                            this.frontImage = new Image("/png/three-of-clubs.png");
                            break;

                        // Four of Clubs
                        case 4:
                            this.frontImage = new Image("/png/four-of-clubs.png");
                            break;

                        // Five of Clubs
                        case 5:
                            this.frontImage = new Image("/png/five-of-clubs.png");
                            break;

                        // Six of Clubs
                        case 6:
                            this.frontImage = new Image("/png/six-of-clubs.png");
                            break;

                        // Seven of Clubs
                        case 7:
                            this.frontImage = new Image("/png/seven-of-clubs.png");
                            break;

                        // Eight of Clubs
                        case 8:
                            this.frontImage = new Image("/png/eight-of-clubs.png");
                            break;

                        // Nine of Clubs
                        case 9:
                            this.frontImage = new Image("/png/nine-of-clubs.png");
                            break;

                        // Ten of Clubs
                        case 10:
                            this.frontImage = new Image("/png/ten-of-clubs.png");
                            break;
                    }
                    break;

                case Diamonds:
                    switch (number) {
                        // Ace of Diamonds
                        case 1:
                            this.frontImage = new Image("/png/ace-of-diamonds.png");
                            break;

                        // Two of Diamonds
                        case 2:
                            this.frontImage = new Image("/png/two-of-diamonds.png");
                            break;

                        // Three of Diamonds
                        case 3:
                            this.frontImage = new Image("/png/three-of-diamonds.png");
                            break;

                        // Four of Diamonds
                        case 4:
                            this.frontImage = new Image("/png/four-of-diamonds.png");
                            break;

                        // Five of Diamonds
                        case 5:
                            this.frontImage = new Image("/png/five-of-diamonds.png");
                            break;

                        // Six of Diamonds
                        case 6:
                            this.frontImage = new Image("/png/six-of-diamonds.png");
                            break;

                        // Seven of Diamonds
                        case 7:
                            this.frontImage = new Image("/png/seven-of-diamonds.png");
                            break;

                        // Eight of Diamonds
                        case 8:
                            this.frontImage = new Image("/png/eight-of-diamonds.png");
                            break;

                        // Nine of Diamonds
                        case 9:
                            this.frontImage = new Image("/png/nine-of-diamonds.png");
                            break;

                        // Ten of Diamonds
                        case 10:
                            this.frontImage = new Image("/png/ten-of-diamonds.png");
                            break;
                    }
                    break;

                case Hearts:
                    switch (number) {
                        // Ace of Hearts
                        case 1:
                            this.frontImage = new Image("/png/ace-of-hearts.png");
                            break;

                        // Two of Hearts
                        case 2:
                            this.frontImage = new Image("/png/two-of-hearts.png");
                            break;

                        // Three of Hearts
                        case 3:
                            this.frontImage = new Image("/png/three-of-hearts.png");
                            break;

                        // Four of Hearts
                        case 4:
                            this.frontImage = new Image("/png/four-of-hearts.png");
                            break;

                        // Five of Hearts
                        case 5:
                            this.frontImage = new Image("/png/five-of-hearts.png");
                            break;

                        // Six of Hearts
                        case 6:
                            this.frontImage = new Image("/png/six-of-hearts.png");
                            break;

                        // Seven of Hearts
                        case 7:
                            this.frontImage = new Image("/png/seven-of-hearts.png");
                            break;

                        // Eight of Hearts
                        case 8:
                            this.frontImage = new Image("/png/eight-of-hearts.png");
                            break;

                        // Nine of Hearts
                        case 9:
                            this.frontImage = new Image("/png/nine-of-hearts.png");
                            break;

                        // Ten of Hearts
                        case 10:
                            this.frontImage = new Image("/png/ten-of-hearts.png");
                            break;
                    }
                    break;

                case Spades:
                    switch (number) {
                        // Ace of Spades
                        case 1:
                            this.frontImage = new Image("/png/ace-of-spades.png");
                            break;

                        // Two of Spades
                        case 2:
                            this.frontImage = new Image("/png/two-of-spades.png");
                            break;

                        // Three of Spades
                        case 3:
                            this.frontImage = new Image("/png/three-of-spades.png");
                            break;

                        // Four of Spades
                        case 4:
                            this.frontImage = new Image("/png/four-of-spades.png");
                            break;

                        // Five of Spades
                        case 5:
                            this.frontImage = new Image("/png/five-of-spades.png");
                            break;

                        // Six of Spades
                        case 6:
                            this.frontImage = new Image("/png/six-of-spades.png");
                            break;

                        // Seven of Spades
                        case 7:
                            this.frontImage = new Image("/png/seven-of-spades.png");
                            break;

                        // Eight of Spades
                        case 8:
                            this.frontImage = new Image("/png/eight-of-spades.png");
                            break;

                        // Nine of Spades
                        case 9:
                            this.frontImage = new Image("/png/nine-of-spades.png");
                            break;

                        // Ten of Spades
                        case 10:
                            this.frontImage = new Image("/png/ten-of-spades.png");
                            break;
                    }
                    break;
            }
        }

        // Set the initial image to the back image
        this.setImage(this.frontImage);
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */
    public Card getCard() { return this.card; }


    /* -------------------------------------------------Methods------------------------------------------------------ */
    public void showFront() { this.setImage(this.frontImage); }

    public void showBack() { this.setImage(this.backImage); }

    public void flip() {
        if (this.getImage() == this.backImage) {
            this.setImage(this.frontImage);
        } else {
            this.setImage(this.backImage);
        }
    }
}
