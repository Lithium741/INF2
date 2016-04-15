package Vokabelkram;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DateiverwaltungGui extends JFrame {

	private DateiverwaltungGui() throws IOException {

		initUI();
	}

	public void initUI() throws IOException {
		JButton eintragen = new JButton("Vokabeln eintragen");
		JButton loeschen = new JButton("Wort Löschen");
		JButton laden = new JButton("Dateien Bearbeiten");
		JButton testausgabe = new JButton("Testausgabe");
		JButton zurueck = new JButton("Zurück");

		eintragen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
				SpeichernGui.invoke();
			}
		});

		loeschen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
				LoeschenGui.invoke();
			}
		});

		laden.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
				DLadenGui.invoke();
			}
		});
		
		testausgabe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, StartGui.speicher.toString());
			}
		});

		zurueck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
				StartGui.invoke();
			}
		});

		createLayout(eintragen, loeschen, laden, testausgabe, zurueck);

		setTitle("Dateiverwaltung");
		setSize(300, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createLayout(JComponent... arg) {

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
				gl.createSequentialGroup().addGroup(gl.createParallelGroup().addComponent(arg[0]).addComponent(arg[1]))
						.addGroup(gl.createParallelGroup().addComponent(arg[2]).addComponent(arg[3]))
						.addGroup(gl.createParallelGroup().addComponent(arg[4])));

	}

	public static void invoke() {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					DateiverwaltungGui ex = new DateiverwaltungGui();
					ex.setVisible(true);
				} catch (IOException e) {
					System.out.println("Nix da");
				}
			}
		});
	}
	
	public static void main(String args[]){
		invoke();
	}
}