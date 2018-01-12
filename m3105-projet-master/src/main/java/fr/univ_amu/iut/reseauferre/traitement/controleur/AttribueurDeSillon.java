package fr.univ_amu.iut.reseauferre.traitement.controleur;

import fr.univ_amu.iut.reseauferre.traitement.positions.LigneFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.Sillon;
import fr.univ_amu.iut.reseauferre.traitement.Trajet;

import java.time.LocalTime;
import java.util.*;


/**
 * La classe abstraite AttribueurDeSillon permet d'attribuer les sillons qu'un trajet a besoin
 * @author kevinColombani
 * @see Trajet
 * @see Sillon
 * @see LigneFerroviaire
 */
public abstract class AttribueurDeSillon {

    /**
     * La Collection contenant tous les sillons du réseau
     * @see AttribueurDeSillon#getTousLesSillons()
     */
    private Collection<Sillon> tousLesSillons;

    /**
     * Méthode abstaite attribuerSillon
     * @param trajet tarjet recevant le sillon
     */
    abstract void attribuerSillon(Trajet trajet);

    /**
     * Constructeur de AttribueurDeSillon
     * @param tousLesSillons Collection de tous les sillons du réseau
     */
    public AttribueurDeSillon(Collection tousLesSillons) {
        this.tousLesSillons = tousLesSillons;
    }

    /**
     * Méthode qui renvoie tout les sillons du réseau
     * @return tout les sillons du réseau
     */
    protected Collection<Sillon> getTousLesSillons() {
        return tousLesSillons;
    }

    /**
     * Méthode qui renvoie une liste de tous les sillons par ordre chronologique d'une ligne ferroviaire passé en paramètre
     * @param ligneFerroviaire Ligne ferroviaire dont on veux avoir tout les sillons
     * @return tous les sillons par ordre chronologique
     */
    protected ArrayList<Sillon> getTousLesSillonsPourUneLigne(LigneFerroviaire ligneFerroviaire) {
        ArrayList<Sillon> resultat = new ArrayList<>();
        for (Sillon sillon : getTousLesSillons())
            if (sillon.getLigneFerroviaire().equals(ligneFerroviaire))
                resultat.add(sillon);
        Collections.sort(resultat, new Comparator<Sillon>() {
            @Override
            public int compare(Sillon o1, Sillon o2) {
                return o1.getHeure().compareTo(o2.getHeure());
            }
        });
        return resultat;
    }

    /**
     * Méthode qui renvoie le premier sillon disponible pour une ligne ferroviaire
     * @param listeTousLesSillons Liste de tous les sillons d'une ligne ferroviaire
     * @param horaire Horaire du sillon précédent (null si il s'agit de la première ligne ferroviaire) (sert à ne pas parcourir deux lignes ferroviaire dans la même heure)
     * @return Le premier Sillon disponible
     */
    protected Sillon getFirstDisponible(Collection<Sillon> listeTousLesSillons, LocalTime horaire) {

        for (Sillon sillon : listeTousLesSillons) {
            if (sillon.getDisponible() && (horaire == null || sillon.getHeure().compareTo(horaire) > 0))
                return sillon;
        }
        for (Sillon sillon : listeTousLesSillons) {
            if (sillon.getDisponible())
                return sillon;
        }
        throw new NoSuchElementException("Pas de sillons disponible !");
    }
}