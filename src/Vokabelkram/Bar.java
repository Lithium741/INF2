package Vokabelkram;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Bar {
	int x = 0;
	int xa = 0;
	private Catch game;

	public Bar(Catch game) {
		this.game= game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth()-60)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, 430, 45, 10);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -3;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 3;
	}
}  