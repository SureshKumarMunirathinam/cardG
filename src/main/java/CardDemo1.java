// File   : GUI-lowlevel/cards1/cards/CardDemo1
// Purpose: Basic GUI to show dragging cards.
//          Illustrates how to load images from files.
// Author : Fred Swartz - 2007-02-19 - Placed in public domain.
//
// Enhancements:
//        * This really doesn't have a user interface beyond dragging.
//          It doesn't do anything, and therefore has no model.
//          Make it play a game.
//        * Needs to have a Deck class to shuffle, deal, ... Cards.
//          Persumably based on ArrayList<Card>.
//        * Perhaps a Suit and Face class would be useful.
//        * Like Deck, there would also be a class for Hand.
//        * May need Player class too.

import java.net.URL;
import javax.swing.*;

////////////////////////////////////////////////////////////// class CardDemoGUI

class CardDemo1 extends JFrame {
    //=================================================================== fields
    
    private static Card_Demo[] _deck = new Card_Demo[52];
    
    //===================================================================== main
    public static void main(String[] args) {
        CardDemo1 window = new CardDemo1();
        window.setTitle("Card Demo 1");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new CardTable(_deck));
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
    
    //============================================================== constructor
    public CardDemo1() {
        //... ClassLoader is where to get images from this .jar file.
        ClassLoader cldr = this.getClass().getClassLoader();
        
        int n = 0;         // Which card.
        int xPos = 0;      // Where it should be placed initially.
        int yPos = 0;
        
        //... Read in the cards using particular file name conventions.
        //    Images for the backs and Jokers are ignored here.
        String suits = "shdc";
        String faces = "a23456789tjqk";
        for (int suit=0; suit < suits.length(); suit++) {
            for (int face=0; face < faces.length(); face++) {
                //... Get the image from the images subdirectory.
                String imagePath = "cards/images/" + faces.charAt(face) +
                        suits.charAt(suit) + ".gif";
                System.out.println("imagePath :::::" +imagePath);
                URL imageURL = cldr.getResource(imagePath);
                System.out.println("------Here is yoru card :::"+faces.charAt(face) +
                        suits.charAt(suit) + ".gif");
                ImageIcon img = new ImageIcon(imageURL);
                
                //... Create a card and add it to the deck.
                Card_Demo card = new Card_Demo(img);
                card.moveTo(xPos, yPos);
                _deck[n] = card;
                
                //... Update local vars for next card.
                xPos += 5;
                yPos += 4;
                n++;
            }
        }
    }
}

