package fr.univsmb.isc;

import java.util.ArrayList;
import java.util.List;

public class menu {
    
    public String nom;

    public int prix;
    
    public List<plats> p = new ArrayList<plats> ();

    public menu(String nom, int prix) {
                super();
                this.nom = nom;
                this.prix = prix;
        }
    
    public String identitemenu() {
    	String identi = ("Menu \""+this.nom+"\" au prix de "+this.prix+" €\nComposé de:");
        identi = (identi+"\n");
        for(int i = 0; i < this.p.size(); i++)
        {
          identi = (identi+this.p.get(i).nom+"\n");
          
        } 
        identi = (identi+"\n");
        return identi;
    }
    

        public void ajoutplat(plats pl){
        this.p.add(pl);
    }

		public List<plats> getP() {
			return p;
		}

		public void setP(List<plats> p) {
			this.p = p;
		}
}