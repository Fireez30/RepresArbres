package Arbres;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;



public class Vue extends JPanel implements MouseListener, MouseMotionListener{
	Color bgColor;
	Color fgColor; 
	int width, height;
	private ArrayList<Noeud> points = new ArrayList<Noeud>();
		
	public Vue(int width, int height, String fileName, boolean modelCoordinates) {
		super();
		Couleur.forPrinter(true);
		this.bgColor = Couleur.bg; 
		this.fgColor = Couleur.fg; 
		this.width = width;
		this.height = height;	
		this.setBackground(Couleur.bg);
		this.setPreferredSize(new Dimension(width, width));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		//initFromLog(fileName, modelCoordinates); 
		//if(!modelCoordinates)export("trio-hypo-2.csv");
		ArrayList<Noeud> arbre = new ArrayList<Noeud>();
		Noeud origine = new Noeud(0,300,"Univers");
		Noeud a = new Noeud("Matiere");
		Noeud b = new Noeud("Anti-matiere");
		a.addFils(new Noeud("Hydrogene"));
		a.addFils(new Noeud("Helium"));
		b.addFils(new Noeud("Anti-Hydrogene"));
		b.addFils(new Noeud("Anti-Helium"));
		b.addFils(new Noeud("Anti-Oxygene"));
		origine.addFils(a);
		origine.addFils(b);
		this.setNoeuds(arbre);
	}

	
	
	public void setNoeuds(ArrayList<Noeud> points) {
		this.points = points;
	}	
			
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setPaintMode(); 
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,	RenderingHints.VALUE_ANTIALIAS_ON);	
		g2d.setColor(fgColor);
		
		for (Noeud v: points) {
			v.drawNoeud(g2d);
		}		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}
	

