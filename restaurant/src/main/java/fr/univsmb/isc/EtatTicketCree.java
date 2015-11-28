package fr.univsmb.isc;


public class EtatTicketCree implements EtatsTicket {

	public EtatTicketCree(ticket ticket) {
		if(null == ticket)
		{
            throw new IllegalArgumentException("L'etat d'un ticket est necessairement associe au ticket qu'il represente");
		}
		this.ticket=ticket;
	}
	
	public void AjouterPlatTicket(plats p) {
		ticket.getPlats().add(p);
		ticket.setEtat(new EtatTicketAvecPlats(ticket));
	}

	
	public void EnvoyerTicket() {
		throw new IllegalStateException("Le ticket est vide, il n'y a rien à envoyer");
	}
	
	public void PreparationTicket() {
		throw new IllegalStateException("Le ticket est vide, il n'y a rien à préparer");
	}
	
	public void FinPreparationTicket() {
		throw new IllegalStateException("Le ticket est vide, il n'y a rien à finir de préparer");
	}
	
	public void TicketEmporte() {
		throw new IllegalStateException("Le ticket est vide, il n'y a rien à emporter");
	}
	
	private final ticket ticket;
}
