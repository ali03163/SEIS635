
public class Player {
	private String name;
	private int player, start, end, mancala;
	public Player() {
		
	};
	public Player(String n, int p) {
		setName(n);
		setPlayer(p);
		if(p == 1) {
			start = 0;
			end = 5;
			setMancala(6);
		} else if (p == 2) {
			start = 7;
			end = 12;
			setMancala(13);
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPlayer() {
		return player;
	}
	public void setPlayer(int player) {
		this.player = player;
	}
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	public int getMancala() {
		return mancala;
	}
	public void setMancala(int mancala) {
		this.mancala = mancala;
	}
}
