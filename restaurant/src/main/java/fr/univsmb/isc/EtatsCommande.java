package fr.univsmb.isc;


public interface EtatsCommande  {

	public void AjouterPlatCommande(plats P);
	
	public void AjouterMenuCommande(menu M);

	public void PrixCommande();
	
	public void PréparationTicket();
	
	public void ConsultationTicketAServir();

	public void CommandeEnRemplissage();
	
	public void CommandePrête();

	public void CommandeEnCoursDeService();
	
	public void CommandeServie();
	
}
