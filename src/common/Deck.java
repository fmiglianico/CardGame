package common;
import java.util.Collections;
import java.util.LinkedList;


public class Deck {
	private LinkedList<Card> deck;
	
	private int nbVals;
	
	public Deck(int nbVals) {
		
		this.setNbVals(nbVals);
		
		deck = new LinkedList<Card>();
		for(int ci = 0; ci < nbVals*4; ci++)
			deck.add(new Card((ci%nbVals), (ci/nbVals)));
	}

	public int getNbVals() {
		return nbVals;
	}

	public void setNbVals(int nbVals) {
		this.nbVals = nbVals;
	}
	
	public Card draw() {
		return deck.pop();
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public int size() {
		return  deck.size();
	}

	@Override
	public String toString() {
		String ret = "Deck :\n";
		for(int hi = 0; hi < deck.size(); hi++)
			ret += deck.get(hi).toString() + "\n";
		return ret;
	}
}
