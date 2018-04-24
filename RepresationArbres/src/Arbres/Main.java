package Arbres;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class Main {

	public static void main(String s[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		int x = 10, y = 10, w = 800, h = 600;
		String fileName = "data/Trioker/trio-hypo-2.csv";
		JFrame frame = new JFrame("Repr�sentations d'arbres");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Vue v1;
		v1 = new Vue(w, h, fileName, false);
		v1.setBorder(BorderFactory.createLineBorder(Couleur.fg) );
		frame.add(v1);
		frame.pack();
		frame.setLocation(x, y);
		frame.setVisible(true);
			}});
	}
}
