package Vokabelkram;

import java.util.ArrayList;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ConcurrentModificationException;
import javax.swing.*;

public class Dateiverwaltung extends JFrame {

	public static ArrayList<Speicher> speicher = new ArrayList<Speicher>();

	public static String loeschen(JTextField wort, int b) {
		for (Speicher temp : StartGui.speicher) {
			if (temp.deutsch.equals(wort.getText()) || temp.english.equals(wort.getText())) {
				if (b == 0) {
					speicher.remove(temp);
					return temp.deutsch + " = " + temp.english + " gelöscht!";
				} else {

				}
			} else {
				return "Wort nicht gefunden!";
			}
		}
		return "test";
	}

	public static String speichern(JTextField wortA, JTextField wortB, JTextField wortC) {
		Speicher s = new Speicher(wortA.getText(), wortB.getText(), wortC.getText());
		speicher.add(s);
		return "Gespeichert!";
	}
}