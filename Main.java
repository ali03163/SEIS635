import java.util.*;
public class Main {

	public static void main(String[] args) {
		Board b = new Board();
		b.printBoard();
		boolean finished = false;
		// TODO Auto-generated method stub
		while(!finished) {
		Player[] players = new Player[2];
		Scanner input = new Scanner(System.in);
		System.out.print("Welcome to Mancala. Select an option: 1- Local Play 2- How to Play ");
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
				loop = !loop;
			} while(loop);
			finished = !finished;
		}
		else if(selection == 2) {
			System.out.println("Objective: To collect as many seeds in your store as possible. The player with the most seeds in \r\n"
					+ "his/her store at the end of the game wins.");
		}
	}
	}
}
