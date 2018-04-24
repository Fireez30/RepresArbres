package Arbres;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Noeud {
	String name;
	PointVisible point;
	ArrayList<Noeud> fils;

	public Noeud(String n) {
		point = new PointVisible(0,0);
		point.setLabel(n);
		fils = new ArrayList<Noeud>();
		name = n;
	}
	public Noeud(int x,int y,String n) {
		point = new PointVisible(x,y);
		point.setLabel(n);
		fils = new ArrayList<Noeud>();
		name = n;
	}
	
	public PointVisible getPoint() {
		return point;
	}

	public void setPoint(PointVisible point) {
		this.point = point;
	}

	public ArrayList<Noeud> getFils() {
		return fils;
	}

	public void setFils(ArrayList<Noeud> fils) {
		this.fils = fils;
	}

	public void addFils(Noeud n) {
		if (!fils.contains(n)) {
			fils.add(n);
		}
	}

	public void updateFilsCoords() {
		if (!fils.isEmpty()) {
			for (int i = 0; i < fils.size(); i++) {
				fils.get(i).point.x = point.x + 50;
				if (i == 0) 
				{
					fils.get(i).point.y = point.y - 50;
				}
				else 
				{
					fils.get(i).point.y = fils.get(i-1).point.y + 100/fils.size();
				}
			}
		}
	}

	public void drawNoeud(Graphics2D g2d) {
		this.point.dessine(g2d);
		updateFilsCoords();
		if (!fils.isEmpty()) {
			ArrayList<Vecteur> aretes = new ArrayList<Vecteur>();

			for(Noeud p : fils) {
				aretes.add(new Vecteur(point,p.getPoint()));
			}
			
			for (Vecteur v: aretes) {
				v.dessine(g2d);
			}		
		}
	}
}
