package fr.univ_amu.iut.reseauferre.affichage.simplifie.vue;

import fr.univ_amu.iut.reseauferre.affichage.simplifie.modele.Donnees;
import fr.univ_amu.iut.reseauferre.traitement.positions.Gare;

public class EtatActuel implements Vue {

    @Override
    public void afficher(Donnees donnees) {
        System.out.println("Les différentes gares du réseaux");
        for (Gare gare : Donnees.getGares()) {
            System.out.println("- "+gare.getName());
        }

        System.out.println("Les trains parcourants le réseaux");
        System.out.println(Donnees.getTrains());
    }
}
