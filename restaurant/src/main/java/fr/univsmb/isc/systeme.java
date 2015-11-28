package fr.univsmb.isc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class systeme {

	public carte carte;

	public List<table> listable = new ArrayList<table>();

	public void demandecarte() {
		this.carte.constructioncarte();
	}

	public void ajoutcarte(carte c) {
		this.carte = c;
	}

	public void affecteTable(int numtable, int nbClient) {

		if (this.listable.get(numtable - 1).nbClients == 0) {
			this.listable.get(numtable - 1).nbClients = nbClient;
			System.out.println(this.listable.get(numtable - 1).nbClients
					+ " client(s) ont été affecté la table " + numtable);
		} else if (nbClient == 0) {
			this.listable.get(numtable - 1).nbClients = nbClient;
			System.out.println("table libérée");
		} else {
			System.out
					.println("Des clients sont déjà présent à cette table. Affectation annulée.");
		}

	}

	// décalez vers les autres fonctions de classes, qu'on n'ait pas un systeme
	// tout puissant.
	public void gestionCommande(table t, menu m) {
		if (t.commande == null) {
			t.creerCommande();
		}
		t.ajoutMenu(m);

	}

	public void gestionCommande(table t, plats p) {
		if (t.commande == null) {
			t.creerCommande();
		}
		t.ajoutPlat(p);
	}

	public void preparationCommande() {

	}

	public static void main(String[] args) {
		// procédure de création du systeme
		systeme S = new systeme();
		carte c = new carte();
		menu m1 = new menu("Etudiant", 6);

		// ajout de quelques plats à la carte
		c.ajoutplat(new plats(typePlat.Entree, "Salade", 3));
		c.ajoutplat(new plats(typePlat.PlatPrincipal, "steak-frite", 4));
		c.ajoutplat(new plats(typePlat.Dessert, "glace", 3));
		c.ajoutplat(new plats(typePlat.PlatPrincipal, "kebab", 3));
		c.ajoutplat(new plats(typePlat.Dessert, "gaufre", 5));
		c.ajoutplat(new plats(typePlat.Boisson, "ice tea", 2));
		c.ajoutplat(new plats(typePlat.Boisson, "coca", 2));

		// ajout des plats à un menu
		m1.ajoutplat(new plats(typePlat.Entree, "Salade", 3));
		m1.ajoutplat(new plats(typePlat.PlatPrincipal, "steak-frite", 4));
		m1.ajoutplat(new plats(typePlat.Dessert, "gaufre", 5));
		c.ajoutmenu(m1);

		// ajout de table aux systeme
		table table1 = new table(0, null);
		table table2 = new table(0, null);
		table table3 = new table(0, null);
		S.listable.add(table1);
		S.listable.add(table2);
		S.listable.add(table3);
		S.ajoutcarte(c);

		List<ticket> listeticketenvoyé = new ArrayList<ticket>(); // pile des
																	// ticket en
																	// attente
																	// dans la
																	// cuisine
		List<ticket> listeticketaservir = new ArrayList<ticket>(); // pile des
																	// ticket en
																	// attente
																	// de
																	// service
		System.out.println("\nInterface de gestion de commande 1.0");
		boolean fin = false;
		Scanner sc;
		sc = new Scanner(System.in);
		while (!fin) {
			
			System.out.println("sélectionnez la commande que vous souhaitez exécuter");
			System.out.println("1) Afficher carte");
			System.out.println("2) Affecter table");
			System.out.println("3) Prendre la commande d'une table");
			System.out.println("4) Préparer les tickets d'une table");
			System.out.println("5) Envoyer le(s) ticket(s) d'une table");
			System.out.println("6) Cuisine: préparation les tickets envoyé");
			System.out.println("7) Service: Service des Ticket préparé");
			System.out
					.println("8) Consultation des tickets encore en attente d'une table");
			System.out.println("9) Paiement");
			System.out.println("10) déconnexion");

			System.out.println("Entrez votre choix");

			int choix = sc.nextInt();
			switch (choix) {

			case 1:
				S.demandecarte();
				System.out.println("\n");
				break;
			case 2:
				System.out.println(S.listable.size() + " tables enregistrées");
				System.out
						.println("\nquelle table est à affecter/désaffecter ?");
				int numtable = sc.nextInt();
				System.out.println("combien de clients ?");
				int nbclient = sc.nextInt();
				S.affecteTable(numtable, nbclient);
				break;

			case 3:
				System.out.println("entrez le numero de table à gérer");
				int numtable2 = sc.nextInt();
				table temp = S.listable.get(numtable2 - 1);
				System.out
						.println("procedure d'ajout. entrez 0 pour finir, 1 pour ajouter un menu, et 2 pour ajouter un plat");
				int choixajout = sc.nextInt();
				while (choixajout != 0) {
					if (choixajout == 1) {
						S.carte.listemenu();
						System.out
								.println("Choisissez le numéro du menu à ajouter à la commande");
						int select = sc.nextInt();
						menu majout = S.carte.m.get(select);
						S.gestionCommande(temp, majout);
					} else if (choixajout == 2) {
						S.carte.listeplats();
						;
						System.out
								.println("Choisissez le numéro du plat à ajouter à la commande");
						int select2 = sc.nextInt();
						plats plajout = S.carte.p.get(select2);
						S.gestionCommande(temp, plajout);
					}
					System.out
							.println("choix ajouté. entrez 0 pour finir, 1 pour ajouter un menu, et 2 pour ajouter un plat");
					choixajout = sc.nextInt();
				}
				System.out.println("\n la commande est composé de:");
				temp.commande.listemenu();
				temp.commande.listeplat();
				break;

			case 4:
				System.out.println("entrez le numero de table à gérer");
				int numtabe2 = sc.nextInt();
				table tempp = S.listable.get(numtabe2 - 1);
				if (tempp.commande != null) {
					tempp.commande.PreparationTicket();
				} else {
					System.out.println("Aucune commande affecté à la table");
				}

				break;

			case 5:
				System.out
						.println("entrez le numero de table dont il faut envoyer les tickets");
				numtabe2 = sc.nextInt();
				tempp = S.listable.get(numtabe2 - 1);
				System.out
						.println("Affichage de le liste des tickets de la table");
				if (tempp.commande.getTicket().size() == 0
						|| tempp.commande == null) {

					System.out.println("La table n'a pas de ticket à envoyer");
				} else {

					for (int j = 0; j < tempp.commande.getTicket().size(); j++) {
						ticket tickettemp = tempp.commande.getTicket().get(j);
						String[] parts = tickettemp.getEtat().toString()
								.split("@");
						String etat = parts[0];
						if (etat.equals("EtatTicketAvecPlats")
								|| etat.equals("EtatAttentePrepation")) {
							System.out.println("\nticket n°" + j);
							tickettemp.descripticket();
						}
					}
					System.out
							.println("entrez le numero du ticket à envoyer\n");
					numtabe2 = sc.nextInt();
					tempp.commande.getTicket().get(numtabe2).getEtat()
							.EnvoyerTicket();
					listeticketenvoyé.add(tempp.commande.getTicket().get(
							numtabe2));
					System.out.println("\n ticket envoyé");
					tempp.commande.getEtat().CommandeEnCoursDeService();
				}
				break;

			case 6:
				if (listeticketenvoyé.size() == 0) {
					System.out.println("aucun ticket à emporter");
				} else {
					System.out.println("liste des tickets à faire en cuisine");
					for (int i = 0; i < listeticketenvoyé.size(); i++) {

						System.out.println("ticket n°" + i);
						listeticketenvoyé.get(i).descripticket();
						System.out.println("\n");
					}

					System.out
							.println("entrez le numero du ticket pris en charge");
					int numtic = sc.nextInt();
					listeticketenvoyé.get(numtic).getEtat().PreparationTicket();
					System.out
							.println("Preparation du ticket. Entrez \"ok\" une fois le ticket prêt à être emporté\n");
					String attentefin = sc.next();
					listeticketenvoyé.get(numtic).getEtat()
							.FinPreparationTicket();
					listeticketaservir.add(listeticketenvoyé.get(numtic));
					listeticketenvoyé.remove(numtic);
				}
				break;

			case 7:
				if (listeticketaservir.size() == 0) {
					System.out.println("aucun ticket à emporter");
				} else {

					for (int i = 0; i < listeticketaservir.size(); i++) { // listing
																			// des
																			// ticket
																			// à
																			// servir
						System.out.println("ticket n°" + i);
						listeticketaservir.get(i).descripticket();
					}
					System.out.println("entrez le numero du ticket emporté");
					int numticc = sc.nextInt();
					listeticketaservir.get(numticc).getEtat().TicketEmporte();
					listeticketaservir.remove(numticc);
				}
				break;

			case 8:
				System.out.println("entrez le numero de table à consulter");
				numtabe2 = sc.nextInt();
				tempp = S.listable.get(numtabe2 - 1);
				tempp.commande.ConsultationTicket();
				break;

			case 9:

				System.out.println("entrez le numero de table à facturer");
				numtabe2 = sc.nextInt();
				tempp = S.listable.get(numtabe2 - 1);
				tempp.commande.getEtat().CommandeServie();
				tempp.commande.getEtat().PrixCommande();
				tempp.commande = null; // on libère la table de sa commande
										// précédente
				break;

			case 10:
				fin = true;
				break;
			}
		}
		sc.close();
	}
}
