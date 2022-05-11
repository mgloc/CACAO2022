package abstraction.eq7Distributeur2;

import abstraction.eq8Romu.clients.ClientFinal;
import abstraction.eq8Romu.filiere.IDistributeurChocolatDeMarque;
import abstraction.eq8Romu.produits.ChocolatDeMarque;


public class Distributeur2ChocolatDeMarque extends Distributeur2Achat implements IDistributeurChocolatDeMarque  {
	
	private double capaciteDeVente;

	public Distributeur2ChocolatDeMarque() {
		super();
		//TODO
	}
	
	
	public double prix(ChocolatDeMarque choco) {
		return 10.0;
	}

	public double quantiteEnVente(ChocolatDeMarque choco, int crypto) {
		// TODO Auto-generated method stub
		if (crypto!=this.cryptogramme) {
			journal.ajouter("Quelqu'un essaye de me pirater !");
			return 0.0;
		} else {
			return Math.min(capaciteDeVente, this.stock.getQuantite(choco));
		}
	}

	public double quantiteEnVenteTG(ChocolatDeMarque choco, int crypto) {
		// TODO Auto-generated method stub
		if (crypto!=this.cryptogramme) {
			journal.ajouter("Quelqu'un essaye de me pirater !");
			return 0.0;
		} else {
			return Math.min(capaciteDeVente, this.stock.getQuantite(choco))/10.0;
			}
	}
	
	public void vendre(ClientFinal client, ChocolatDeMarque choco, double quantite, double montant, int crypto) {
		// TODO Auto-generated method stub
		this.stock.remove(choco, quantite);
		
	}

	public void notificationRayonVide(ChocolatDeMarque choco, int crypto) {
		// TODO Auto-generated method stub
		if (crypto!=this.cryptogramme) {
			journal.ajouter("Quelqu'un essaye de me pirater !");
		} else {
			journal.ajouter("Je n'ai pas assez mis en vente de "+choco);
		}
	}


}