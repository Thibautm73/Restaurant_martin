package fr.univsmb.isc;

public class table {
    public int nbClients;

    public commande commande;

    public table(int nbClients, commande com) {
        super();
        this.nbClients=nbClients;
        this.commande=com;
}
    
    public void creerCommande() {
    	this.commande = new commande();
    }

    public void ajoutPlat(plats pl) {
    	this.commande.AjoutPlats(pl);
    }

    public void ajoutMenu(menu men) {
    	this.commande.AjoutMenu(men);
    }

    public void preparerTickets() {
    }

}
