import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player[] players = new Player[2];
		Scanner input = new Scanner(System.in);
		System.out.print("Welcome to Mancala. Select an option: 1- Local Play ");
		int selection = input.nextInt();
		input.nextLine();
		if(selection == 1) {
			System.out.print("What is the name of the first player? ");
			players[0] = new Player(input.nextLine());
			System.out.print("What is the name of the second player? ");
			players[1] = new Player(input.nextLine());
		}
	}

}
