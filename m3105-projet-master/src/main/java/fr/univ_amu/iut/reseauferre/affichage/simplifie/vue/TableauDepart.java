package fr.univ_amu.iut.reseauferre.affichage.simplifie.vue;

import fr.univ_amu.iut.reseauferre.affichage.simplifie.modele.Donnees;
import fr.univ_amu.iut.reseauferre.traitement.Sillon;
import fr.univ_amu.iut.reseauferre.traitement.Trajet;

import java.time.LocalTime;

public class TableauDepart implements Vue {
    private static String tempsRestant(LocalTime heureGare ,LocalTime heureActuelle){
        return heureGare.minusHours(heureActuelle.getHour()).minusMinutes(heureActuelle.getMinute()).toString();
    }

    @Override
    public void afficher(Donnees donnees) {
        for (Trajet trajet : donnees.getAllTrajet()) {
            for (Sillon sillon : trajet.getSillonsEmprunte()) {
                System.out.println("Départ de la "+ sillon.getLigneFerroviaire().getDepart()
                        + " du train en partance de " + trajet.getDepart().getName()
                        + " et à destination de " + trajet.getDestination().getName()
                        + " dans " + tempsRestant(sillon.getHeure(),donnees.getHeureActuel()));

            }
        }
    }
}
