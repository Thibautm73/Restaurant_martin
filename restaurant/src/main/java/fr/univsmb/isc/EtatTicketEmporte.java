package fr.univsmb.isc;

public class EtatTicketEmporte implements EtatsTicket {

	public EtatTicketEmporte(ticket ticket) {
		if(null == ticket)
		{
            throw new IllegalArgumentException("L'etat d'un ticket est necessairement associe au ticket qu'il represente");
		}
		this.ticket=ticket;
	}
	
	
	public void AjouterPlatTicket(plats p) {
		throw new IllegalStateException("Le ticket est emporté, il n'y a rien à ajouter");

	}

	public void AjouterMenuTicket(menu m) {
		throw new IllegalStateException("Le ticket est emporté, il n'y a rien à ajouter");
	}

	public void EnvoyerTicket() {
		throw new IllegalStateException("Le ticket est emporté, il n'y a rien à pas à le renvoyer");	
	}

	public void PreparationTicket() {
		throw new IllegalStateException("Le ticket est emporté, il n'y a rien à pas à le re-préparer");	
		}

	public void FinPreparationTicket() {
		throw new IllegalStateException("Le ticket est emporté, il n'y a rien à pas à le relancer");	
		}

	public void TicketEmporte() {
		throw new IllegalStateException("Le ticket est déjà emporté, il n'y a rien à pas à l'emporter de nouveau");	
		}


	@SuppressWarnings("unused")
	private final ticket ticket;
}
