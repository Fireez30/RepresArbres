package Arbres;

import java.io.File;

import javax.swing.tree.DefaultMutableTreeNode;

public class NodeFile extends DefaultMutableTreeNode{
	File userObject;
	
	public NodeFile (String path){
		this.userObject = new File(path);
		this.connectDescendant();
	}
	
	public String toString(){
		return userObject.getName();
	}

	//construction recursive de l'arborescence de fichiers � partir de this
	public void connectDescendant() {
		NodeFile child;
		if (userObject.isDirectory()) {
			setAllowsChildren(true);
			File fList[] = userObject.listFiles();
			if (fList != null) {
				for (int i = 0; i < fList.length; i++){
					child = new NodeFile(fList[i].getPath());
					child.setAllowsChildren(false); // false par d�faut, sera mis � true si c'est un r�pertoire
					add(child);
					child.connectDescendant();
				}
			}
		}
	}
}
