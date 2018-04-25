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
		int length = 100;
		if (!fils.isEmpty()) {
			boolean aSwitch = true;
			for (int i = 0; i < fils.size(); i++) {
				if (aSwitch)
				{
					fils.get(i).point.x = point.x;
					fils.get(i).point.y = point.y + length;
				}
				else 
				{
					fils.get(i).point.x = point.x;
					fils.get(i).point.y = point.y - length;
				}
				
				if (i != 0)
					for (int j = 0; j < i; j++) {
					if (aSwitch) {
						fils.get(j).point.x = fils.get(j).point.x - length/fils.size();
						fils.get(j).point.y = fils.get(j).point.y;
						aSwitch = false;
					}
					else
					{
						fils.get(j).point.x = fils.get(j).point.x + length/fils.size();
						fils.get(j).point.y = fils.get(j).point.y;
						aSwitch = true;
					}
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
		
		for (Noeud n : fils) {
			n.drawNoeud(g2d);
		}
	}
}
