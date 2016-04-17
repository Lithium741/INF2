package Vokabelkram;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ConcurrentModificationException;
import javax.swing.*;

public class GUI extends JFrame {

	private static int depth = 1;

	private GUI() throws IOException {

		initUI();
	}

	public void initUI() throws IOException {

		JTextField wort = new JTextField("test");
		JTextField deutsch = new JTextField("Deutsches Wort");
		JTextField englisch = new JTextField("Englisches Wort");
		JTextField kategorie = new JTextField("Kategorie");
		JButton speichern = new JButton("Speichern");
		JButton speichernButton = new JButton("Speichern");
		JButton loeschen = new JButton("Löschen");
		JButton loeschenButton = new JButton("Löschen");
		JButton fileLaden = new JButton("Aus Datei laden");
		JButton fileSpeichern = new JButton("In Datei speichern");
		JButton dateiverwaltung = new JButton("Dateiverwaltung");
		JButton spiel = new JButton("Spiele");
		JButton zurueck = new JButton("Zurück");
		JButton AIDatei = new JButton("Aus/In Datei");
		JButton datei = new JButton("Datei");

		dateiverwaltung.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				depth = 2;
				createLayout(depth, speichern, loeschen, AIDatei, zurueck);
			}
		});

		spiel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
			}
		});

		zurueck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
			}
		});

		loeschen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				depth = 3;
				createLayout(depth, wort, loeschenButton, zurueck);
			}
		});

		loeschenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				int a = JOptionPane.showOptionDialog(null, wort.getText() + " wirklich löschen?", "Löschen bestätigen",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] { "Ja", "Nein" },
						"Nein");
				System.out.println(a);
				System.out.println(Dateiverwaltung.loeschen(wort, a));
			}
		});

		speichern.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				depth = 4;
				createLayout(depth, deutsch, englisch, kategorie, speichernButton, zurueck);
			}
		});

		speichernButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println(Dateiverwaltung.speichern(deutsch, englisch, kategorie));
			}
		});

		AIDatei.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println(Dateiverwaltung.speichern(deutsch, englisch, kategorie));
			}
		});

		speichernButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println(Dateiverwaltung.speichern(deutsch, englisch, kategorie));
			}
		});

		fileLaden.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JFileChooser fc = new JFileChooser();
				int a = fc.showOpenDialog(null);
				System.out.println(Dateiverwaltung.fileLaden(a, fc));
			}
		});

		fileSpeichern.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JFileChooser fc = new JFileChooser();
				int a = fc.showOpenDialog(null);
				System.out.println(Dateiverwaltung.fileSpeichern(a, fc));
			}
		});

		createLayout(depth, dateiverwaltung, spiel);

		setTitle("Wort Löschen");
		setSize(350, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createLayout(Integer a, JComponent... arg) {

		switch (a) {
		case 1:
			Container pane = getContentPane();
			GroupLayout gl = new GroupLayout(pane);
			pane.removeAll();
			pane.setLayout(gl);
			gl.setAutoCreateGaps(true);
			gl.setAutoCreateContainerGaps(true);
			gl.setHorizontalGroup(gl.createParallelGroup()
					.addGroup(gl.createSequentialGroup().addComponent(arg[0]).addComponent(arg[1])));
			gl.setVerticalGroup(gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup().addComponent(arg[0]).addComponent(arg[1])));
			break;

		case 2:
			pane = getContentPane();
			gl = new GroupLayout(pane);
			pane.removeAll();
			setSize(150, 100);
			pane.setLayout(gl);
			gl.setAutoCreateGaps(true);
			gl.setAutoCreateContainerGaps(true);
			gl.setHorizontalGroup(gl.createParallelGroup()
					.addGroup(gl.createSequentialGroup().addComponent(arg[0]).addComponent(arg[1]))
					.addGroup(gl.createSequentialGroup().addComponent(arg[2]).addComponent(arg[3])));
			gl.setVerticalGroup(gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup().addComponent(arg[0]).addComponent(arg[1]))
					.addGroup(gl.createParallelGroup().addComponent(arg[2]).addComponent(arg[3])));
			break;

		case 3:
			pane = getContentPane();
			gl = new GroupLayout(pane);
			pane.removeAll();
			setSize(350, 120);
			pane.setLayout(gl);
			gl.setAutoCreateGaps(true);
			gl.setAutoCreateContainerGaps(true);
			gl.setHorizontalGroup(gl.createParallelGroup()
					.addGroup(gl.createSequentialGroup().addComponent(arg[0]).addComponent(arg[1]))
					.addGroup(gl.createSequentialGroup().addComponent(arg[2])));
			gl.setVerticalGroup(gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup().addComponent(arg[0]).addComponent(arg[1]))
					.addGroup(gl.createParallelGroup().addComponent(arg[2])));
			break;

		case 4:
			pane = getContentPane();
			gl = new GroupLayout(pane);
			pane.removeAll();
			setSize(350, 160);
			pane.setLayout(gl);
			gl.setAutoCreateGaps(true);
			gl.setAutoCreateContainerGaps(true);
			gl.setHorizontalGroup(gl.createParallelGroup()
					.addGroup(gl.createSequentialGroup().addComponent(arg[0]).addComponent(arg[3]))
					.addGroup(gl.createSequentialGroup().addComponent(arg[1]).addComponent(arg[4]))
					.addGroup(gl.createSequentialGroup().addComponent(arg[2])));
			gl.setVerticalGroup(gl.createSequentialGroup()
					.addGroup(gl.createParallelGroup().addComponent(arg[0]).addComponent(arg[3]))
					.addGroup(gl.createParallelGroup().addComponent(arg[1]).addComponent(arg[4]))
					.addGroup(gl.createParallelGroup().addComponent(arg[2])));
			break;
		}
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					GUI ex = new GUI();
					ex.setVisible(true);
				} catch (IOException e) {
					System.out.println("Nix da");
				}
			}
		});
	}
}
