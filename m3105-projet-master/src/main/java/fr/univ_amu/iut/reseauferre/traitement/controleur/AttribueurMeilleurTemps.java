package fr.univ_amu.iut.reseauferre.traitement.controleur;

import fr.univ_amu.iut.reseauferre.traitement.positions.LigneFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.Sillon;
import fr.univ_amu.iut.reseauferre.traitement.Trajet;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * La classe AttribueurMeilleurTemps permet d'attribuer les sillons disponible les plus proche les uns des autres pour un temps de trajet le plus court possible
 * @author kevinColombani
 * @see Trajet
 * @see Sillon
 * @see LigneFerroviaire
 */

public class AttribueurMeilleurTemps extends AttribueurDeSillon {

    /**
     * Constructeur de AttribueurMeilleurTemps
     * @param tousLesSillons Collection de tous les sillons du réseau
     */
    public AttribueurMeilleurTemps(Collection tousLesSillons) { super(tousLesSillons); }

    /**
     *
     * @param trajet Trajet à comparer avec le trajet le plus court actuellement
     * @param temp Trajet le plus court actuellement
     * @return True si le trajet passé en paramètre est plus court que temp
     */
    public boolean estTempPlusCourt(List<Sillon> trajet, List<Sillon> temp) {
        if (temp.isEmpty())
            return true;
        return trajet.get(trajet.size() - 1).getHeure().minusHours(trajet.get(0).getHeure().getHour()).getHour()
                < temp.get(temp.size() - 1).getHeure().minusHours(temp.get(0).getHeure().getHour()).getHour();
    }

    /**
     * Méthode qui attribut les sillons que le trajet demande en les groupant le plus possible
     * @param trajet Le trajet souhaité
     */
    @Override
    public void attribuerSillon(Trajet trajet) {
        AttribueurGlouton attribueurGlouton = new AttribueurGlouton(getTousLesSillons());
        List<Sillon> temp = new ArrayList<>();
        for (LocalTime heure = LocalTime.of(0, 0); heure.isBefore(LocalTime.of(23, 0)); heure = heure.plusHours(1)) {
            List<Sillon> current = new ArrayList<>();
            for (LigneFerroviaire lignes : trajet.getLigneFerroviairesDemande()) {
                ArrayList<Sillon> sillonsPourCetteLigne = new ArrayList<>();
                sillonsPourCetteLigne.addAll(getTousLesSillonsPourUneLigne(lignes));
                Sillon premierDispo = getFirstDisponible(sillonsPourCetteLigne, current.isEmpty() ? heure : current.get(current.size() - 1).getHeure().plusHours(1));
                current.add(premierDispo);
            }

            if (temp.isEmpty() || estTempPlusCourt(current, temp))
                temp = current;
        }
        for (Sillon s : temp) {
            s.setDisponible(false);
            trajet.addSillonEmprunte(s);
        }


    }
}