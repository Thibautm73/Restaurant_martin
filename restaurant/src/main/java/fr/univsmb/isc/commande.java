package fr.univsmb.isc;


import java.util.ArrayList;
import java.util.List;

public class commande {
	


    public commande() {
    	this.etat = new EtatCommandeCréé(this);
	}
	
    
    public void listemenu(){
    	System.out.println("\n Menus:");
    	for(int i = 0; i < this.m.size(); i++)
        {
          System.out.println("menu n°"+i+" "+this.m.get(i).nom);
        }
    }
    
    public void listeplat(){
    	System.out.println("\n Plats:");
    	for(int i = 0; i < this.p.size(); i++)
        {
          System.out.println("plat n°"+i+" "+this.p.get(i).nom);
        }
    }


	public List<ticket> getTicket() {
		return ticket;
	}

	public void setTicket(List<ticket> ticket) {
		this.ticket = ticket;
	}

	public List<menu> getMenus() {
		return m;
	}

	public void AjoutMenu(menu m) {
		etat.AjouterMenuCommande(m);
	}
	
	
	public List<plats> getPlats() {
		return p;
	}

	public void AjoutPlats(plats p) {
		etat.AjouterPlatCommande(p);
	}

	public EtatsCommande getEtat() {
		return etat;
	}
	
    public void setEtat(EtatsCommande etat) {
		this.etat = etat;
	}

    public void PreparationTicket(){
    	etat.PréparationTicket();
    }
    
    public void ConsultationTicket(){
    	etat.ConsultationTicketAServir();
    }
    
    public void AjoutTicket(ticket t){
    	this.getTicket().add(t);
    }

    private List<ticket> ticket = new ArrayList<ticket> ();
    private List<menu> m= new ArrayList<menu> ();
	private List<plats> p = new ArrayList<plats> ();
	private EtatsCommande etat;
}
