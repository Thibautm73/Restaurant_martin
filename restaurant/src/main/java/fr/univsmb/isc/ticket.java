package fr.univsmb.isc;

import java.util.ArrayList;
import java.util.List;

public class ticket {


	public void setPlats(List<plats> plats) {
		this.plats = plats;
	}

	
	public List<plats> getPlats() {
		return plats;
	}

	public void AjoutPlats(plats p) {
		etat.AjouterPlatTicket(p);
	}

	public EtatsTicket getEtat() {
		return etat;
	}

    void setEtat(EtatsTicket etat){
        this.etat = etat;
    }
	
    public void descripticket(){
    	for (int i=0;i<this.getPlats().size();i++){
        	System.out.println(this.getPlats().get(i).nom);
    	}

    }
    
    public ticket(){
    	etat= new EtatTicketCree(this);
    	
    }
    
	private List<plats> plats = new ArrayList<plats> ();
    private EtatsTicket etat;
}
