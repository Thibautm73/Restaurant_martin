package fr.univsmb.isc;

public class EtatTicketEnPreparation implements EtatsTicket {

	public EtatTicketEnPreparation(ticket ticket) {
		if(null == ticket)
		{
            throw new IllegalArgumentException("L'etat d'un ticket est necessairement associe au ticket qu'il represente");
		}
		this.ticket=ticket;
	}
	
	public void AjouterPlatTicket(plats p) {
		throw new IllegalStateException("Le ticket est en préparation, il n'y a rien à ajouter");

	}

	public void AjouterMenuTicket(menu m) {
		throw new IllegalStateException("Le ticket est en préparation, il n'y a rien à ajouter");
	}

	public void EnvoyerTicket() {
		throw new IllegalStateException("Le ticket est en préparation, il n'y a rien à pas à le renvoyer");	
	}

	public void PreparationTicket() {
		throw new IllegalStateException("Le ticket est déjà en préparation, il n'y a rien à pas à le re-préparer");	
		}

	public void FinPreparationTicket() {
		ticket.setEtat(new EtatTicketAEmporter(ticket));
			}

	public void TicketEmporte() {
		throw new IllegalStateException("Le ticket est en préparation, il ne peut pas être emporté");
	}

	
	private final ticket ticket;
}
