package fr.univsmb.isc;


public class EtatTicketAttentePreparation implements EtatsTicket {

	public EtatTicketAttentePreparation(ticket ticket) {
		if(null == ticket)
		{
            throw new IllegalArgumentException("L'etat d'un ticket est necessairement associe au ticket qu'il represente");
		}
		this.ticket=ticket;
	}
	
	public void AjouterPlatTicket(plats p) {
		throw new IllegalStateException("Le ticket a été envoyé, il n'y a rien à ajouter");

	}

	public void AjouterMenuTicket(menu m) {
		throw new IllegalStateException("Le ticket a été envoyé, il n'y a rien à ajouter");
	}

	public void EnvoyerTicket() {
		throw new IllegalStateException("Le ticket a déjà été envoyé, il n'y a rien à pas à le renvoyer");	
	}

	public void PreparationTicket() {
		ticket.setEtat(new EtatTicketEnPreparation(ticket));
	}

	public void FinPreparationTicket() {
		throw new IllegalStateException("Le ticket est n'est pas en préparation, il vient juste d'être envoyé");
	}

	public void TicketEmporte() {
		throw new IllegalStateException("Le ticket est n'est pas à emporter, il vient juste d'être envoyé");
	}

	private final ticket ticket;
}
