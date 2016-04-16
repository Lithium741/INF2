package Vokabelkram;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ConcurrentModificationException;
import javax.swing.*;

public class GUI extends JFrame {

	private GUI() throws IOException {

		initUI();
	}

	public void initUI() throws IOException {

		JTextField wort = new JTextField("test");
		JTextField deutsch = new JTextField("Deutsches Wort");
		JTextField englisch = new JTextField("Englisches Wort");
		JTextField kategorie = new JTextField("Kategorie");
		JButton speichern = new JButton("Speichern");
		JButton loeschen = new JButton("Löschen");
		JButton fileLaden = new JButton("Aus Datei laden");
		JButton fileSpeichern = new JButton("In Datei speichern");
		JButton dateiverwaltung = new JButton("Dateiverwaltung");
		JButton spiel = new JButton("Spiele");
		JButton zurueck = new JButton("Zurück");

		dateiverwaltung.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				createLayoutDateiverwaltung(speichern, loeschen, fileLaden, fileSpeichern, zurueck);
				System.out.println("test");
			}
		});

		spiel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("test");
			}
		});

		zurueck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("test");
			}
		});

		loeschen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				int a = JOptionPane.showOptionDialog(null, wort.getText() + " wirklich löschen?", "Löschen bestätigen",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[] { "Ja", "Nein" },
						"Nein");
				System.out.println(Dateiverwaltung.loeschen(wort, a));
			}
		});

		speichern.addActionListener(new ActionListener() {
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

		createLayout(dateiverwaltung, spiel);

		setTitle("Wort Löschen");
		setSize(700, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createLayout(JComponent... arg) {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateGaps(true);

		gl.setAutoCreateContainerGaps(true);

		gl.setHorizontalGroup(gl.createParallelGroup()
				.addGroup(gl.createSequentialGroup().addComponent(arg[0]).addComponent(arg[1])));
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup().addComponent(arg[0]).addComponent(arg[0])));

	}

	private void createLayoutDateiverwaltung(JComponent... arg) {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateGaps(true);

		gl.setAutoCreateContainerGaps(true);

		gl.setHorizontalGroup(
				gl.createParallelGroup().addGroup(gl.createSequentialGroup().addComponent(arg[0]).addComponent(arg[1]))
						.addGroup(gl.createSequentialGroup().addComponent(arg[2]).addComponent(arg[3]))
						.addGroup(gl.createSequentialGroup().addComponent(arg[4])));
		gl.setVerticalGroup(
				gl.createSequentialGroup().addGroup(gl.createParallelGroup().addComponent(arg[0]).addComponent(arg[0]))
						.addGroup(gl.createParallelGroup().addComponent(arg[2]).addComponent(arg[3]))
						.addGroup(gl.createParallelGroup().addComponent(arg[4])));

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
