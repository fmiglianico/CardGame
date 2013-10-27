package common;

public class Main {

	public static void main(String[] args) {
		
		Battle battle = new Battle();
		battle.deal();
		Player winner = battle.play(200);
		if(winner != null)
			System.out.println(winner.getName() + " WINS !");
		else
			System.out.println("It's a draw.");
	}

}
