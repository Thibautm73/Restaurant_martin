package fr.univsmb.isc;



public class EtatCommandeCréé implements EtatsCommande {

	public EtatCommandeCréé(commande C) {
		if(null == C)
		{
            throw new IllegalArgumentException("L'etat d'un ticket est necessairement associe a la banque qu'il represente");
		}
		this.commande=C;
	}
	
	
	public void AjouterPlatCommande(plats P) {
		commande.getPlats().add(P);
		commande.setEtat(new EtatCommandeEnRemplissage(commande));
		
	}

	public void AjouterMenuCommande(menu M) {
		commande.getMenus().add(M);
		commande.setEtat(new EtatCommandeEnRemplissage(commande));
		
	}

	public void PrixCommande() {
		throw new IllegalStateException("La commande est tout juste créé, elle est encore vide");	
	}

	public void PreparationCommande() {
		throw new IllegalStateException("La commande est tout juste créé, elle est encore vide");
		}

	public void CommandeEnRemplissage() {
		throw new IllegalStateException("La commande est tout juste créé, elle est encore vide");	
	}

	
	public void CommandePrête() {
		throw new IllegalStateException("La commande est tout juste créé, elle est encore vide");	
	}

	public void CommandeEnCoursDeService() {
		throw new IllegalStateException("La commande est tout juste créé, elle est encore vide");	
	}

	public void CommandeServie() {
		throw new IllegalStateException("La commande est tout juste créé, elle est encore vide");	
	}

	public void PréparationTicket() {
		throw new IllegalStateException("La commande est tout juste créé, elle est encore vide");
	}


	public void ConsultationTicketAServir() {
		System.out.println("Ticket En attente de préparation sur la table\n");
		for (int i = 0;i<this.commande.getTicket().size(); i++ ){
			
			ticket temp = this.commande.getTicket().get(i);
			String[] parts = temp.getEtat().toString().split("@");
			String etat = parts[0];
			if (etat.equals("EtatTicketAvecPlats") || etat.equals("EtatAttentePrepation")){
				temp.descripticket();
			}
		}		
	}
	

	private final commande commande;

}
