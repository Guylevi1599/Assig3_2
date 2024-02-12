//Assig3_2 Guy Levi 209439306 and Gal Suissa 316581180
package assig3_2;

public class Main {

	public static void main(String[] args) {
		// Create a new game
		GamePlay game = new GamePlay(); 
		
		// Create two players and the judge
		Gamer player1 = new Gamer(game);
		Gamer player2 = new Gamer(game);
		Judge judge = new Judge(game);
		
		// Start the judge and players
		judge.start();
		player1.start();
		player2.start();
	
		try {
			// Wait for both players to finish playing
			player1.join();
			player2.join();
			
			// Interrupt the judge after the players finish
			judge.interrupt();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
		// Determine the winner based on players' scores
		int score1 = player1.getScore();
		int score2 = player2.getScore();
		
		if (score1>score2) {
			System.out.println("Player 1 win with " + player1.getScore() + " successful coin tosses.");
		}
		else if (score1<score2) {
			System.out.println("Player 2 win with " + player2.getScore() + " successful coin tosses.");
		}
		else {
			System.out.println("Tie");
		}
	}

}
