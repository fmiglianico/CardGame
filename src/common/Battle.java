package common;
import java.util.ArrayList;
import java.util.LinkedList;


public class Battle {

	private Deck deck;
	private ArrayList<Player> players;
	
	private LinkedList<Card> drawnCards;
	
	public Battle() {

		deck = new Deck(13);
		players = new ArrayList<Player>(2);
		players.add(new Player("Player1"));
		players.add(new Player("Player2"));
		setDrawnCards(new LinkedList<Card>());
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
	
	public LinkedList<Card> getDrawnCards() {
		return drawnCards;
	}

	public void setDrawnCards(LinkedList<Card> drawnCards) {
		this.drawnCards = drawnCards;
	}

	public void deal() {
		deck.shuffle();
		int deckSize = deck.size();
		for(int ci = 0; ci < deckSize; ci++) {
			players.get(ci%2).take(deck.draw());
		}
	}
	
	public Player play(int nRounds) {
		Player winner = null;
		for(int ri = 0; ri < nRounds; ri++) {
			winner = playOneRound();
			if(winner != null)
				return winner;
		}
		return winner;
	}
	
	private Player playOneRound() {
		Player winner = null;
		Card c1 = players.get(0).play();
		if(c1 == null)
			return players.get(0);
		Card c2 = players.get(1).play();
		if(c2 == null)
			return players.get(1);
		drawnCards.add(c1);
		drawnCards.add(c2);
		
		int comp = c1.compareTo(c2);
		if(comp < 0) {
			players.get(1).takeAll(drawnCards);
			drawnCards.clear();
			System.out.println(c1 + " loses to " + c2);
			System.out.println("Player 1 : " + players.get(0).getNbCards() + " cards - Player 2 : " + players.get(1).getNbCards() + " cards.");
		}
		else if(comp > 0) {
			players.get(0).takeAll(drawnCards);
			drawnCards.clear();
			System.out.println(c1 + " beats " + c2);
			System.out.println("Player 1 : " + players.get(0).getNbCards() + " cards - Player 2 : " + players.get(1).getNbCards() + " cards.");
		}
		else {
			System.out.println(c1 + " draws to " + c2);
			Card c = players.get(0).play();
			if(c != null)
				drawnCards.add(c);
			else
				return players.get(1);
			
			c = players.get(1).play();
			if(c != null)
				drawnCards.add(c);
			else
				return players.get(0);
		}
		return winner;
	}

}
