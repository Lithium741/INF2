package Vokabelkram;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Catch extends JPanel {

	int yIncrease = 1;
	int y = 0;
	int x = 5;
	Wort wort1 = new Wort(this);
	Wort wort2 = new Wort(this);
	Wort wort3 = new Wort(this);
	Wort wort4 = new Wort(this);
	Bar bar = new Bar(this);

	public Catch() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				bar.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				bar.keyPressed(e);
			}
		});
		setFocusable(true);
	}

	public void moveWord() {
		y = y + (1 * yIncrease);
		
	}

	public void move() {
		wort1.move();
		wort2.move();
		wort3.move();
		wort4.move();
		bar.move();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		wort1.paint(g2d, "Wort1", 5);
		wort2.paint(g2d, "Wort2", 105);
		wort3.paint(g2d, "Wort3", 205);
		wort4.paint(g2d, "Wort4", 305);
		bar.paint(g2d);
	}

	public void testPopup() {
		JOptionPane.showMessageDialog(this, "test", "test", JOptionPane.YES_NO_CANCEL_OPTION);
		System.exit(0);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Catch");
		Catch game = new Catch();

		frame.add(game);
		frame.setSize(360, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}