import java.util.*;
import java.io.*;

/**
 * Class to demonstrate Array Assignment #1: COunting Cards
 *
 * @author     Theodore Preduta
 * @author     Larry Yuan
 *
 * @version    1, 2019-04-03
 */
public class CountingCards {
	private String hand;
	private int[][] cards;
	private boolean isValid;

	/**
	 * Method that transforms the suit of the card into a number that can be
	 * stored in our cards array
	 *
	 * @param      suit  The suit of the card taken from the original String
	 *
	 * @return     An integer, the suit's column in the cards array, -1 if
	 *             invalid
	 */
	public static int charToSuit(char suit) {
		switch (suit) {
		case 'S':
			return 0;
		case 'H':
			return 1;
		case 'D':
			return 2;
		case 'C':
			return 3;
		}
		return -1;
	}

	/**
	 * Method that transforms the face value symbol of a card to an integer
	 *
	 * @param      value  The face value of the card
	 *
	 * @return     TThe value's row in the cards array, -1 if invalid
	 */
	public static int charToValue(char value) {
		switch (value) {
		case '2':
			return 0;
		case '3':
			return 1;
		case '4':
			return 2;
		case '5':
			return 3;
		case '6':
			return 4;
		case '7':
			return 5;
		case '8':
			return 6;
		case '9':
			return 7;
		case 'T':
			return 8;
		case 'J':
			return 9;
		case 'Q':
			return 10;
		case 'K':
			return 11;
		case 'A':
			return 12;
		}
		return -1;
	}

	/**
	 * Method that decodes the suit id into a readable format
	 *
	 * @param      suit  The suit id
	 *
	 * @return     A string containing the name of the suit, first letter is
	 *             capitalized
	 */
	public static String suitToText(int suit) {
		switch (suit) {
		case 0:
			return "Spades";
		case 1:
			return "Hearts";
		case 2:
			return "Diamonds";
		case 3:
			return "Clubs";
		}
		return "";
	}

	/**
	 * Method that transforms the card id into readable text
	 *
	 * @param      value  The value id of the card
	 *
	 * @return     A string containing the value of the card, in text form
	 */
	public static String valueToText(int value) {
		switch (value) {
		case 0:
			return "Two";
		case 1:
			return "Three";
		case 2:
			return "Four";
		case 3:
			return "Five";
		case 4:
			return "Six";
		case 5:
			return "Seven";
		case 6:
			return "Eight";
		case 7:
			return "Nine";
		case 8:
			return "Ten";
		case 9:
			return "Jack";
		case 10:
			return "Queen";
		case 11:
			return "King";
		case 12:
			return "Ace";
		}
		return "";
	}

	/**
	 * Constructor, takes in a hand and decodes it into the card array. A this
	 * happens the hand is also validated to make sure it's valid;
	 *
	 * @param      hand  The hand input
	 */
	public CountingCards(String hand) {
		// initialize variables
		cards = new int[4][13];
		isValid = true;
		this.hand = hand;

		// set the cards array
		if (hand.length() != 26) // validate length
			isValid = false;
		else
			for (int i = 0; i < 26; i += 2) { // validate each card 
				// translate each card to an integer
				int suit = CountingCards.charToSuit(hand.charAt(i + 1));
				int value = CountingCards.charToValue(hand.charAt(i));
				if (suit == -1 || value == -1) { // if one bad card is found, no further operations are required
					isValid = false;
					break; 
				}
				// update the cards array
				cards[suit][value]++;
				if (cards[suit][value] > 1) { // check to see if there is more then one of the same card in one hand
					isValid = false;
					break;
				}
			}
	}

	/**
	 * Totals the value of each hand, and outputs it in the proper format as
	 * specified in the assignment
	 *
	 * @return     Formatted String representation hand
	 */
	public String toString() {
		if (!isValid)
			return hand + " is an invalid hand.";
		// output hand data and collect points
		String out = "";
		int totalPoints = 0;
		for (int suit = 0; suit < 4; suit++) {
			// loop over every value and add to output string
			int numberInCurrentSuit = 0;
			out += CountingCards.suitToText(suit) + ": ";
			for (int value = 12; value >= 0; value--)
				if (cards[suit][value] == 1) { // if that card exists
					numberInCurrentSuit++;
					out += CountingCards.valueToText(value) + " ";
					// check for any points
					if (value == 12) // ace
						totalPoints += 4;
					else if (value == 11) // king
						totalPoints += 3;
					else if (value == 10) // queen
						totalPoints += 2;
					else if (value == 9) // jack
						totalPoints++;
				}
			out += "\n";
			// count points for voids doubeltons and singletons
			if (numberInCurrentSuit == 0)
				totalPoints += 3;
			else if (numberInCurrentSuit == 1)
				totalPoints += 2;
			else if (numberInCurrentSuit == 2)
				totalPoints++;
		}
		out += "Total Points: " + totalPoints; // add point to system
		return out; // return result
	}

	/**
	 * Reads from `input.in` and validates all hands in that file
	 *
	 * @param      args         The command line arguments (not used)
	 *
	 * @throws     IOException  Throws an IOException if the file is not found
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("input.in"));
		ArrayList<String> hands = new ArrayList<String>();
		while (in.hasNextLine())
			hands.add(in.nextLine());
		in.close();
		for (String hand : hands)
			System.out.println(new CountingCards(hand));
	}
}