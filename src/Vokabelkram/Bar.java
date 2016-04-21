package Vokabelkram;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Bar {
	private static final int Y = 430;
	private static final int WIDTH = 45;
	private static final int HIGHT = 10;
	private int x = 0;
	private int xa = 0;
	private Catch game;

	public Bar() {
		
	}
	
	public Bar(Catch game) {
		this.game = game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - 60)
			x = x + xa;
		
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, Y, WIDTH, HIGHT);
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

	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HIGHT);
	}

	public int getTopY() {
		return Y;
	}
}