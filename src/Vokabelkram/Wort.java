package Vokabelkram;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Wort {
	private static final int WIDTH = 50;
	private static final int HIGHT = 15;
	int y = 0;
	int x;
	private Catch game;

	public Wort(){
		
	}
	
	public Wort(Catch game) {
		this.game = game;
	}

	void move() {
		y++;
		//System.out.println(y);
		if (collision()) {
			game.testPopup();
		}
	}

	public void paint(Graphics2D g, String wort, int x) {
		this.x = x;
		g.drawString(wort, x+5, y + 12);
		g.drawRect(x, y, WIDTH, HIGHT);
	}

	public boolean collision() {
		return game.bar.getBounds().intersects(getBounds(x));
	}

	public Rectangle getBounds(int x) {
		return new Rectangle(x, y, WIDTH, HIGHT);
	}
}