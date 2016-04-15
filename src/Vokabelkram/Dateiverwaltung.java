package Vokabelkram;

import java.util.ArrayList;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.*;

public class Dateiverwaltung extends JFrame {

	public static ArrayList<Speicher> speicher = new ArrayList<Speicher>();

	public static String loeschen(JTextField wort, int b) {
		for (Speicher temp : speicher) {
			if (temp.getDeutsch().equals(wort.getText()) || temp.getEnglish().equals(wort.getText())) {
				if (b == 0) {
					speicher.remove(temp);
					return temp.getDeutsch() + " = " + temp.getEnglish() + " gelöscht!";
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

	public static String laden(int a) {
		Scanner s = null;
		if (a == JFileChooser.APPROVE_OPTION){
			File file = GUI.
			try{
				s = new Scanner(file);
				s.useDelimiter("\n");
			} catch (FileNotFoundException e) {
				return "NoSuchElementException: " + e.getCause();
			}
		} else {
			return "";
		}
		while (s.hasNext()) {
			try {
				String[] x = s.next().split(",");
				Speicher temp = new Speicher(x[0], x[1], x[2]);
				speicher.add(temp);
			} catch (NoSuchElementException e) {
				return "NoSuchElementException: " + e.getCause();
			}
		}
		s.close();
		return GUI.fc.getName(file) + " Geladen";
	}
}