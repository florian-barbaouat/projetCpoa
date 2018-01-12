package fr.univ_amu.iut.reseauferre.traitement.controleur;

import fr.univ_amu.iut.reseauferre.traitement.positions.LigneFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.Sillon;
import fr.univ_amu.iut.reseauferre.traitement.Trajet;

import java.util.*;


/**
 * La classe AttribueurMoinsCher permet d'attribuer les sillons disponible les moins cher qu'un trajet a besoin
 * @author kevinColombani
 * @see Trajet
 * @see Sillon
 * @see LigneFerroviaire
 */
public class AttribueurMoinsCher extends AttribueurDeSillon {

    /**
     * Constructeur de AttribueurMoinsCher
     * @param tousLesSillons Collection de tous les sillons du réseau
     */
    public AttribueurMoinsCher(Collection tousLesSillons) {
        super(tousLesSillons);
    }

    /**
     * Méthode qui renvoie une liste de tous les sillons par ordre de coût d'une ligne ferroviaire passé en paramètre
     * @param ligneFerroviaire Ligne ferroviaire dont on veux avoir tout les sillons
     * @return tous les sillons par ordre de coût
     */
    @Override
    protected ArrayList<Sillon> getTousLesSillonsPourUneLigne(LigneFerroviaire ligneFerroviaire) {
        ArrayList<Sillon> resultat = new ArrayList<>();
        for (Sillon sillon : getTousLesSillons())
            if (sillon.getLigneFerroviaire().equals(ligneFerroviaire))
                resultat.add(sillon);
        Collections.sort(resultat, new Comparator<Sillon>() {
            @Override
            public int compare(Sillon o1, Sillon o2) {
                return o1.getCoutUtilisation() - o2.getCoutUtilisation();
            }
        });
        return resultat;
    }

    private  Sillon getMoinsCher(Collection<Sillon> listeTousLesSillons){
        for (Sillon sillon : listeTousLesSillons) {
            if (sillon.getDisponible())
                return sillon;
        }
        throw new NoSuchElementException("Pas de sillons disponible !");
    }

    /**
     * Méthode qui attribut les sillons que le trajet demande en prenant le moins cher disponible
     * @param trajet Le trajet souhaité
     */
    @Override
    public void attribuerSillon(Trajet trajet) {
        for (LigneFerroviaire ligneFerroviaire : trajet.getLigneFerroviairesDemande()) {
            ArrayList<Sillon> sillonsPourCetteLigne = new ArrayList<>();
            sillonsPourCetteLigne.addAll(getTousLesSillonsPourUneLigne(ligneFerroviaire));
            Sillon moinsCher = getMoinsCher(sillonsPourCetteLigne);
            trajet.addSillonEmprunte(moinsCher);
            moinsCher.setDisponible(false);
        }
    }
}
