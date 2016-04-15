package Vokabelkram;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DLadenGui extends JFrame {

	private DLadenGui() throws IOException {

		initUI();
	}

	public void initUI() throws IOException {
		JButton laden = new JButton("Laden");
		JButton zurueck = new JButton("Zurück");
		JButton speichern = new JButton("Speichern");

		laden.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Object[] options = { "JA", "NEIN" };
				int b = JOptionPane.showOptionDialog(null, "Vorrige Einträge Löschen?", "Warnung!",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (b == 0) {
					StartGui.speicher.clear();
					laden();
				} else if (b == 1) {
					laden();
				} else {
					return;
				}
			}
		});

		speichern.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					JFileChooser fc = new JFileChooser();
					int a = fc.showOpenDialog(null);
					if (a == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						FileWriter writer = new FileWriter(file);
						for (Speicher temp : StartGui.speicher) {
							writer.write(temp.deutsch + "," + temp.english + "," + temp.kategorie);
							writer.write("\r\n");
						}
						writer.close();
					} else {
						return;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Gespeichert");
			}
		});

		zurueck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
				DateiverwaltungGui.invoke();
			}
		});

		createLayout(laden, speichern, zurueck);

		setTitle("Datei Bearbeiten");
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
						.addGroup(gl.createSequentialGroup().addComponent(arg[2])));
		gl.setVerticalGroup(
				gl.createSequentialGroup().addGroup(gl.createParallelGroup().addComponent(arg[0]).addComponent(arg[1]))
						.addGroup(gl.createParallelGroup().addComponent(arg[2])));

	}

	public void laden() {
		JFileChooser fc = new JFileChooser();
		int a = fc.showOpenDialog(null);
		Scanner s = null;
		if (a == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try {
				s = new Scanner(file);
				s.useDelimiter("\n");
			} catch (FileNotFoundException e) {
				System.out.println("FileNotFoundException: ");
				e.printStackTrace();
			}
		} else {
			return;
		}
		while (s.hasNext()) {
			try {
				String[] x = s.next().split(",");
				Speicher temp = new Speicher(x[0], x[1], x[2]);
				StartGui.speicher.add(temp);
			} catch (NoSuchElementException e) {
				System.out.println("NoSuchElementException: ");
				System.out.println(e.getCause());
			}
		}
		fc.getName(f)
		s.close();
		JOptionPane.showMessageDialog(null, "Geladen");
	}

	public static void invoke() {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					DLadenGui ex = new DLadenGui();
					ex.setVisible(true);
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}

			}
		});
	}
}