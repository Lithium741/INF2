package Vokabelkram;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.bind.Marshaller.Listener;

@SuppressWarnings("serial")
public class Catch extends JPanel {

	int yIncrease = 1;
	int y = 0;
	int x = 5;
	Racquet racquet = new Racquet(this);

	public Catch() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
	}

	public void moveWord() {
		y = y + (1 * yIncrease);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLACK);
		g2d.drawString("test1", 10, y);
		g2d.drawString("test2", 80, y);
		g2d.drawString("test3", 150, y);
		g2d.drawString("test4", 220, y);
		g2d.fillRect(x, 350, 50, 10);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Catch");
		Catch game = new Catch();
		
		frame.add(game);
		frame.setSize(300, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			if 
				
			}
			game.moveWord();
			game.repaint();
			Thread.sleep(10);
		}
	}
}