package Vokabelkram;

import java.awt.Graphics2D;

public class Wort {
	int y = 0;

	public Wort() {
	}

	void move() {
		y++;
	}

	public void paint(Graphics2D g, String wort, int x) {
		g.drawString(wort, x, y);
	}
}