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
	int makeMove(Player p) {
		System.out.print(p.getName() + " choose from pits " + labels[p.getStart()] + " and " + labels[p.getEnd()] + ": ");
		char chose = scan.next().toUpperCase().charAt(0);
		return 0;
	}
}
