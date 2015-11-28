package fr.univsmb.isc;



public class EtatCommandePrête implements EtatsCommande  {

	public EtatCommandePrête(commande C) {
		if(null == C)
		{
            throw new IllegalArgumentException("L'etat d'une commande est necessairement associe a la commande qu'il represente");
		}
		this.commande=C;
	}
	
	
	
	public void AjouterPlatCommande(plats P) {
		throw new IllegalArgumentException("La commande est prête, on n'a plus de plats à y ajouter");
	}

	
	public void AjouterMenuCommande(menu M) {		
		throw new IllegalArgumentException("La commande est prête, on n'a plus de menus à y ajouter");
	}

	
	public void PrixCommande() {
		int prixtotal=0;
		for (int i = 0; i<commande.getMenus().size();i++)
		{
			prixtotal = prixtotal + commande.getMenus().get(i).prix;
		}
		for (int j = 0; j<commande.getPlats().size();j++)
		{
			prixtotal = prixtotal + commande.getPlats().get(j).prix;
		}
	}

	
	public void CommandeEnRemplissage() {
		throw new IllegalArgumentException("La commande est prête, elle est déjà remplie");
		
	}

	
	public void CommandePrête() {
			throw new IllegalArgumentException("La commande est déjà prête");
		
	}

	
	public void CommandeEnCoursDeService() {
		commande.setEtat(new EtatCommandeEnCoursDeService(commande));
		
	}

	
	public void CommandeServie() {
		throw new IllegalArgumentException("La commande est déjà prête, mais elle n'est pas encore servie");
		
	}

	
	public void PréparationTicket() {
		throw new IllegalArgumentException("La commande est déjà prête, elle a déjà été préparée");
		
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
