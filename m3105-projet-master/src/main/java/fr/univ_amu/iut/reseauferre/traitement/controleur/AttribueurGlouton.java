package fr.univ_amu.iut.reseauferre.traitement.controleur;

import fr.univ_amu.iut.reseauferre.traitement.positions.LigneFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.Sillon;
import fr.univ_amu.iut.reseauferre.traitement.Trajet;

import java.util.ArrayList;
import java.util.Collection;

/**
 * La classe AttribueurGlouton permet d'attribuer les premiers sillons disponible q'un trajet a besoin
 * @author kevinColombani
 * @see Trajet
 * @see Sillon
 * @see LigneFerroviaire
 */
public class AttribueurGlouton extends AttribueurDeSillon {

    /**
     * Constructeur de AttribueurGlouton
     * @param tousLesSillons Collection de tous les sillons du réseau
     */
    public AttribueurGlouton(Collection tousLesSillons) { super(tousLesSillons); }

    /**
     * Méthode qui attribut les sillons que le trajet demande en prenant le premier disponible
     * @param trajet Le trajet souhaité
     */
    @Override
    public void attribuerSillon(Trajet trajet) {
        Sillon derniersillon = null;
        for (LigneFerroviaire ligneFerroviaire : trajet.getLigneFerroviairesDemande()) {
            ArrayList<Sillon> sillonsPourCetteLigne = new ArrayList<>();
            sillonsPourCetteLigne.addAll(getTousLesSillonsPourUneLigne(ligneFerroviaire));
            Sillon premierDispo = getFirstDisponible(sillonsPourCetteLigne,(derniersillon == null ? null : derniersillon.getHeure()));
            trajet.addSillonEmprunte(premierDispo);
            derniersillon = premierDispo;
            premierDispo.setDisponible(false);
        }
    }
}
