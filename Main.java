import java.util.*;
public class Main {

	public static void main(String[] args) {
		Board b = new Board();
		boolean finished = false;
		// TODO Auto-generated method stub
		while(!finished) {
		Player[] players = new Player[2];
		Scanner input = new Scanner(System.in);
		System.out.print("Welcome to Mancala. Select an option: 1- Local Play 2- How to Play 3- Quit ");
		int selection = input.nextInt();
		input.nextLine();
		if(selection == 1) {
			System.out.print("What is the name of the first player? ");
			players[0] = new Player(input.nextLine(), 1);
			System.out.print("What is the name of the second player? ");
			players[1] = new Player(input.nextLine(), 2);
			Random rand = new Random();
			int current = rand.nextInt(2);
			boolean loop = true;
			do {
				System.out.println("It is " + players[current].getName() + "'s turn");
				System.out.println(b.getScore(players[0], players[1]));
				current = b.playerMove(players[current]);
				if (current == 0) {
					loop = false;
					System.out.println(b.getWinner(players[0], players[1]));
				} else {
					current--;
				}
			} while(loop);
			
		}
		else if(selection == 2) {
			System.out.println("The game board is made of 2 rows of 6 small holes known as “pockets”, and large holes on opposite ends called “mancalas”");
			System.out.println("Each player has 6 pockets directly in front of them and a store to their right.");
			System.out.println("One player will start the game by picking any pocket containing stones from their own side. The player will remove all the stones from that pocket, and deposit one stone at a time into neighboring pockets going counter-clockwise until the stones run out.");
			System.out.println("If a player encounters their own store, a stone is deposited in it. However, if they encounter the other player’s store, that store is skipped over.");
			System.out.println("If the last stone is deposited in the player’s own store, the player gets another turn.");
			System.out.println("If the last stone is placed in an empty pocket on the player’s own side, the player takes this stone as well as the other player’s stones across from the empty pocket landed in, and places them in their own store.");
			System.out.println("When all six pockets on one side are emptied the game ends. The player who has the most stones in their store wins.");
		} else {
			finished = !finished;
		}
	}
	}
}
