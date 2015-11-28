package fr.univsmb.isc;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EtatCommandeEnRemplissage implements EtatsCommande  {

	public EtatCommandeEnRemplissage(commande C) {
		if(null == C)
		{
            throw new IllegalArgumentException("L'etat d'une commande est necessairement associe a la commande qu'il represente");
		}
		this.commande=C;
	}
	
	
	public void AjouterPlatCommande(plats P) {
		commande.getPlats().add(P);
	}

	public void AjouterMenuCommande(menu M) {
		commande.getMenus().add(M);		
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
		throw new IllegalStateException("La commande est en déjà en remplissage");
		
	}
	
	public void CommandePrête() {
		commande.setEtat(new EtatCommandePrête(commande));
		
	}
	
	public void CommandeEnCoursDeService() {
		throw new IllegalStateException("La commande est en remplissage");
	}
	
	public void CommandeServie() {
		throw new IllegalStateException("La commande est en remplissage");
		
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


	@SuppressWarnings("resource")
	public void PréparationTicket() {

			java.util.List<plats> tempP = new ArrayList<plats>();
			tempP.addAll(commande.getPlats());
			
			for (int j=0;j<commande.getMenus().size();j++){
				
				List<plats> Pdemenus = new ArrayList<plats>();
				Pdemenus.addAll(commande.getMenus().get(j).getP());
				tempP.addAll(Pdemenus);
			}
			
			ticket nouvticket = new ticket();
			boolean fin = false;
			System.out.printf("\nprocédure de préparation des tickets\n");
			System.out.printf("Entrez le numéro du/des plats/menu à ajouter au ticket ou appuyez sur o pour valider le ticket actuel et en créer un nouveau et f pour finir la préparation\n");
			
			while (!fin)
			{
				for (int i = 0; i<tempP.size();i++)
				{	
					
					System.out.printf(i+" "+tempP.get(i).nom+"\n");	
					
				}
		    	Scanner sc;
				sc = new Scanner(System.in);
				String choix=sc.nextLine();
				if (choix.matches("\\d+")){
					int choixserveur = Integer.parseInt(choix);
					if(choixserveur >= tempP.size()){
						System.out.println("choix invalide");
					}
					else{
						nouvticket.AjoutPlats(tempP.get(choixserveur));
						tempP.remove(choixserveur);
						System.out.println("plat ajouté au ticket");
					}
				}else if(choix.equalsIgnoreCase("o"))
				{	
					System.out.printf("Nouveau ticket créé\n\n");	
					commande.AjoutTicket(nouvticket);
					nouvticket = new ticket();

				}else if(choix.equals("f"))
				{
					commande.AjoutTicket(nouvticket);
					fin =true;
				}
				else
				{
					System.out.printf("Entrée non reconnue.");	
				};
			}
			this.CommandePrête();
			
		}
	
	private final commande commande;

		
	}
