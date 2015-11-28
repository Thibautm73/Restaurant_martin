package fr.univsmb.isc;


public class EtatTicketAvecPlats implements EtatsTicket {
	
	public EtatTicketAvecPlats(ticket ticket) {
		if(null == ticket)
		{
            throw new IllegalArgumentException("L'etat d'un ticket est necessairement associe au ticket qu'il represente");
		}
		this.ticket=ticket;
	}
	
	public void AjouterPlatTicket(plats p) {
			ticket.getPlats().add(p);
	}

	public void EnvoyerTicket() {
		ticket.setEtat(new EtatTicketAttentePreparation(ticket));
		
	}
	
	public void PreparationTicket() {
		throw new IllegalStateException("Le ticket est n'a pas été envoyé, il n'y a rien à préparer");
	}
	
	public void FinPreparationTicket() {
		throw new IllegalStateException("Le ticket est n'a pas été envoyé, il n'y a rien à finir de préparer");
	}
	
	public void TicketEmporte() {
		throw new IllegalStateException("Le ticket est n'a pas été envoyé, il n'y a rien à emporter");
	}
	
	private final ticket ticket;
}
