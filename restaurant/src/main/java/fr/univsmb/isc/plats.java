package fr.univsmb.isc;

public class plats {
   
    public typePlat type;

    public String nom;

    public int prix;
    
    public plats(typePlat type, String nom, int prix) {
                super();
                this.type = type;
                this.nom = nom;
                this.prix = prix;
        }

        public String identiteplat() {
    return this.nom+" au prix de "+this.prix + " €";
    }

}