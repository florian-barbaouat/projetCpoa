package fr.univ_amu.iut.reseauferre.traitement.positions;

import fr.univ_amu.iut.reseauferre.traitement.Sillon;

import java.time.LocalTime;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Classe décrivant une ligne ferrovière , représentant une position
 * @see Gare
 * @see Position
 */
public class LigneFerroviaire implements Position{
    /**
     * Gare de départ de la ligne
     * @see Gare
     */
    private Gare depart;
    /**
     * Gare d'arrivée de la ligne
     * @see Gare
     */
    private Gare arrive;

    /**
     * Constructeur de la classe LigneFerrovière
     * @param depart Gare de départ de la ligne
     * @param arrive Gare d'arrivée de la ligne
     * @see Gare
     */
    public LigneFerroviaire(Gare depart, Gare arrive) {
        this.depart = depart;
        this.arrive = arrive;
    }

    /**
     * Getter de la gare de départ
     * @return gare de déoart de la ligne
     * @see Gare
     */
    public Gare getDepart() {
        return depart;
    }

    /**
     * Getter de la gare d'arrivée
     * @return la gare d'arrivée de la ligne
     *
     * @see Gare
     */
    public Gare getArrive() {
        return arrive;
    }

    /**
     * Methode générant 24 sillons par défaut
     * @param prix prix associé aux sillons
     * @return une collection de 24 sillons
     * @see Sillon
     */
    public Collection<Sillon> genererSillonsParDefault(int prix) {
        Collection<Sillon> resultat = new LinkedList<>();
        for (int i = 0; i < 24; ++i) {
            resultat.add(new Sillon(prix, LocalTime.of(i, 0), this));
        }
        return resultat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LigneFerroviaire that = (LigneFerroviaire) o;

        if (depart != null ? !depart.equals(that.depart) : that.depart != null) return false;
        return arrive != null ? arrive.equals(that.arrive) : that.arrive == null;
    }

    @Override
    public int hashCode() {
        int result = depart != null ? depart.hashCode() : 0;
        result = 31 * result + (arrive != null ? arrive.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return depart + "-->" + arrive;
    }

    @Override
    public String getName() {
        return "En transit entre " + depart.getName() + " et " + arrive.getName();
    }
}
