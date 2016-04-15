package Vokabelkram;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ConcurrentModificationException;
import javax.swing.*;

public class LoeschenGui extends JFrame {

	private LoeschenGui() throws IOException {

		initUI();
	}

	public void initUI() throws IOException {
		JButton loeschen = new JButton("Löschen");
		JButton zurueck = new JButton("Zurück");
		JTextField wort = new JTextField("Wort eingeben");

		loeschen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					for (Speicher temp : StartGui.speicher) {
						if (temp.deutsch.equals(wort.getText())) {
							int a = JOptionPane.showOptionDialog(null,
									temp.deutsch + temp.english + " wirklich löschen?", "Löschen bestätigen",
									JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
									new String[] { "Ja", "Nein" }, "Nein");
							if (a == 0) {
								StartGui.speicher.remove(temp);
							} else {
							}
						} else if (temp.english.equals(wort.getText())) {
							int a = JOptionPane.showOptionDialog(null,
									temp.deutsch + temp.english + " wirklich löschen?", "Löschen bestätigen",
									JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
									new String[] { "Ja", "Nein" }, "Nein");
							if (a == 0) {
								StartGui.speicher.remove(temp);
							} else {

							}
						}
					}
				} catch (ConcurrentModificationException e) {
					JOptionPane.showMessageDialog(null, "Keine Vokabeln mehr vorhanden");
				}
			}
		});

		zurueck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
				DateiverwaltungGui.invoke();
			}
		});

		createLayout(wort, loeschen, zurueck);

		setTitle("Wort Löschen");
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

		gl.setHorizontalGroup(gl.createParallelGroup().addGroup(gl.createSequentialGroup().addComponent(arg[0]))
				.addGroup(gl.createSequentialGroup().addComponent(arg[1]).addComponent(arg[2])));
		gl.setVerticalGroup(gl.createSequentialGroup().addGroup(gl.createParallelGroup().addComponent(arg[0]))
				.addGroup(gl.createParallelGroup().addComponent(arg[1]).addComponent(arg[2])));

	}

	public static void invoke() {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					LoeschenGui ex = new LoeschenGui();
					ex.setVisible(true);
				} catch (IOException e) {
					System.out.println("Nix da");
				}
			}
		});
	}
}