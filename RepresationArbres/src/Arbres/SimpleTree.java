package Arbres;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;


import java.awt.*;
import java.io.*;

public class SimpleTree extends JPanel {
	JTree tree;
	NodeFile root;

	public SimpleTree(NodeFile root) {
		this.root = root;

		//construction de l'affichage
		setLayout(new BorderLayout());
		DefaultTreeModel dtm = new DefaultTreeModel(root);
		dtm.setAsksAllowsChildren(true);
		tree = new JTree(dtm);
		tree.setRootVisible(false);
		add(new JScrollPane((JTree) tree), "Center");
	}
/*
	public static void main(String s[]) {
		JFrame frame = new JFrame("Gestionnaire de fichiers");
		frame.add(new SimpleTree(new NodeFile(".")), BorderLayout.CENTER);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/
}

