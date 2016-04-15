package Vokabelkram;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.GroupLayout.*;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class StartGui extends JFrame {

	public static ArrayList<Speicher> speicher = new ArrayList<Speicher>();

	public StartGui() throws IOException {

		initUI();
	}

	private void initUI() throws IOException {
		JButton dateiverwaltung = new JButton("Dateiverwaltung");
		JButton beenden = new JButton("Beenden");
		JButton spielen = new JButton("Spielen");

		dateiverwaltung.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				DateiverwaltungGui.invoke();
				setVisible(false);
			}
		});

		spielen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("comming soon");
			}
		});

		beenden.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		createLayout(dateiverwaltung, spielen, beenden);

		setTitle("Start");
		setSize(340, 90);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createLayout(JComponent... arg) {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateGaps(true);

		gl.setAutoCreateContainerGaps(true);

		SequentialGroup horizontalGroup = gl.createSequentialGroup();
		ParallelGroup verticalGroup = gl.createParallelGroup();

		gl.setHorizontalGroup(horizontalGroup);

		horizontalGroup.addComponent(arg[0]);
		verticalGroup.addComponent(arg[0]);

		horizontalGroup.addComponent(arg[1]);
		verticalGroup.addComponent(arg[1]);

		horizontalGroup.addComponent(arg[2]);
		verticalGroup.addComponent(arg[2]);

		gl.setVerticalGroup(verticalGroup);
		gl.setHorizontalGroup(horizontalGroup);

	}

	public static void invoke() {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					StartGui ex = new StartGui();
					ex.setVisible(true);
				} catch (IOException e) {
					System.out.println("Nix da");
				}
			}
		});
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					StartGui ex = new StartGui();
					ex.setVisible(true);
				} catch (IOException e) {
					System.out.println("Nix da");
				}
			}
		});
	}
}