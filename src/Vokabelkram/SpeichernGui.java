package Vokabelkram;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class SpeichernGui extends JFrame {

	private SpeichernGui() throws IOException {

		initUI();
	}

	public void initUI() throws IOException {
		JButton speichern = new JButton("Speichern");
		JButton zurueck = new JButton("Zurück");
		JTextField de = new JTextField("Deutsches Wort");
		JTextField en = new JTextField("Englisches Wort");
		JTextField kat = new JTextField("Kategorie");

		speichern.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Speicher s = new Speicher(de.getText(), en.getText(), kat.getText());
				StartGui.speicher.add(s);
			}
		});

		zurueck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
				DateiverwaltungGui.invoke();
			}
		});

		createLayout(de, en, kat, speichern, zurueck);

		setTitle("Wort Speichern");
		setSize(450, 120);
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
				.addGroup(gl.createSequentialGroup().addComponent(arg[0]).addComponent(arg[1]).addComponent(arg[2]))
				.addGroup(gl.createSequentialGroup().addComponent(arg[3]).addComponent(arg[4])));
		gl.setVerticalGroup(gl.createSequentialGroup()
				.addGroup(gl.createParallelGroup().addComponent(arg[0]).addComponent(arg[1]).addComponent(arg[2]))
				.addGroup(gl.createParallelGroup().addComponent(arg[3]).addComponent(arg[4])));

	}

	public static void invoke() {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					SpeichernGui ex = new SpeichernGui();
					ex.setVisible(true);
				} catch (IOException e) {
					System.out.println("Nix da");
				}
			}
		});
	}
}