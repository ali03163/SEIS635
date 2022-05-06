import java.util.Scanner;

public class Board {
	Scanner scan = new Scanner(System.in);
	private int[] board = {4,4,4,4,4,4,0,4,4,4,4,4,4,0};
	private char[] labels = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N'};
	private void printSolidLine(int dots, boolean newLine) {
		for(int i = 0; i < dots; i++) {
			System.out.print('*');
		}
		if(newLine) System.out.println();
	}
	private void printDottedLine(int dots, boolean newLine) {
		for(int i = 0; i < dots; i++) {
			System.out.print("*   ");
		}
		if(newLine) System.out.println();
	}
	private void printTopPlayer() {
		for(int i = 13; i > 6; i--) {
			System.out.printf("*  %c", labels[i]);
		}
		printDottedLine(1, false);
		printSolidLine(1, true);
		for(int i = 13; i > 6; i--) {
			System.out.printf("* %2d", board[i]);
		}
		printDottedLine(1, false);
		printSolidLine(1, true);
	}
	private void printBottomPlayer() {
		printDottedLine(1, false);
		for(int i = 0; i <= 6; i++) {
			System.out.printf("* %2d", board[i]);
		}
		printSolidLine(1, true);
		printDottedLine(1, false);	
		for(int i = 0; i <= 6; i++) {
			System.out.printf("*  %c", labels[i]);
		}
		printSolidLine(1, true);
	}
	public void printBoard() {
		printSolidLine(33, true);
		printDottedLine(8, false);
		printSolidLine(1, true);
		printTopPlayer();
		printDottedLine(8, false);
		printSolidLine(1, true);
		printSolidLine(33, true);
		printDottedLine(8, false);
		printSolidLine(1, true);
		printBottomPlayer();
		printDottedLine(8, false);
		printSolidLine(1, true);
		printSolidLine(33, true);
	}
	
	private int findIndex(char letter) {
		int retVal = -1;
		int index = -1;
		while (index < labels.length-1) {
			index++;
			if(letter == labels[index]) {
				retVal = index;
				break;
			}
		}
		return retVal;
	}
	
	private boolean isGameOver(Player p) {
		if (p.getPlayer() == 1) {
			for (int i = 0; i < 6; i++) {
				if (board[i] != 0) {
					return false;
				}
		}
	}
		else if(p.getPlayer() == 2) {
			for (int i = 7; i < 13; i++) {
				if (board[i] != 0) {
					return false;
				}
		}
		}
		for (int i = 0; i < 6; i++) {
			board[6]+=board[i];
			board[i] = 0;
		}
		for (int i = 7; i < 13; i++) {
			board[13]+=board[i];
			board[i] = 0;
		}
		printBoard();
		return true;
		}
	public String getScore(Player p1, Player p2) {
		return "Score: " + p1.getName() + ": " + board[p1.getMancala()] + " | " + p2.getName() + ": " + board[p2.getMancala()];
	}
	public String getWinner(Player p1, Player p2) {
		if(board[p1.getMancala()] < board[p2.getMancala()]) {
			return p2.getName() +" won!";
		} else {
			return p1.getName() +" won!";
		}
	}
	public int playerMove(Player player) {
		int retVal = 0;
		int index = -1;
		boolean loop = true;
		char letter = 'Z';
		printBoard();
		do {
			if(isGameOver(player)) {
				loop = false;
				System.out.println(player.getName() + "'s side is empty, the game is over");
				index = -1;
			} else {
			System.out.print("Hello " + player.getName() + ", choose a pit between " + labels[player.getStart()] + " and " + labels[player.getEnd()] + ": ");
			loop = true;
			try {
				letter = scan.nextLine().toUpperCase().charAt(0);
			} catch (StringIndexOutOfBoundsException e) {
				letter = 'Z';
			}
			index = findIndex(letter);
			if (index != -1 && index >= player.getStart() && index <= player.getEnd() && board[index] > 0) {
				loop = false;
			} else {
				System.out.println("Select a pit on your side that contains stones");
				
			}
		}} while (loop);
		if (index == -1) {
			retVal = 0;
		}
		else {
			int stones = board[index];
			board[index] = 0;
			while (stones > 0) {
				index++;
				if ((player.getPlayer() == 1 && index ==13) || (player.getPlayer() == 2 && index == 6)) {
					index++;
				}
				if (index == 14) {
					index = 0;
				}
				board[index]++;
				stones--;
			}
			if (player.getPlayer() == 1 && player.getMancala() == index) {
				retVal = 1;
			} else if (player.getPlayer() == 2 && player.getMancala() == index) {
				retVal = 2;
			} else if (player.getPlayer() == 1) {
				if (board[index] == 1 && board[12 - index] > 0 && index >= 0 && index <= 5) {
					board[player.getMancala()] += board[index] + board[12 - index];
					board[index] = 0;
					board[12 - index] = 0;
				}
				retVal = 2;
			} else {
				if (board[index] == 1 && board[-1 * index + 12] > 0 && index >= 7 && index <= 12) {
					board[player.getMancala()] += board[index] + board[-1 * index + 12];
					board[index] = 0;
					board[-1 * index + 12] = 0;
				}
				retVal = 1;
			}
		}
		return retVal;
	}
}
