package fr.univ_amu.iut.reseauferre.traitement;

import fr.univ_amu.iut.reseauferre.traitement.positions.LigneFerroviaire;

import java.time.LocalTime;

/**
 * Un sillon représente une plage horaire sur une ligne ferrovière
 *
 * Il est composé d'un coût d'utilisation , D'une heure dédiée , d'une ligne ferrovière (uen gare d'arrivée et de départ) et d'un attribut déterminant si le sillon est disponible
 *
 * @see LigneFerroviaire
 *
 * Created by l16000440 on 13/11/17.
 */
public class Sillon {
    /**
     * attribut représentant le cout d'utilisation du sillon
     */
    private int coutUtilisation;
    /**
     * L'heure sur laquelle le sillon est attribué
     */
    private LocalTime heure;
    /**
     * la ligne ferrovière du sillon
     */
    private LigneFerroviaire ligneFerroviaire;
    /**
     * attribut indiquant si le sillon est disponible
      */
    private boolean disponible = true;


    /**
     * Constructeur de la classe Sillon
     * @param coutUtilisation cout d'utilisation du sillon
     * @param heure  heure attribuée au sillon
     * @param ligneFerroviaire ligne ferrovière du sillon
     */
    public Sillon(int coutUtilisation, LocalTime heure, LigneFerroviaire ligneFerroviaire) {
        this.coutUtilisation = coutUtilisation;
        this.heure = heure;
        this.ligneFerroviaire = ligneFerroviaire;
    }


    public void setCoutUtilisation(int coutUtilisation) {
        this.coutUtilisation = coutUtilisation;
    }

    public void setLigneFerroviaire(LigneFerroviaire ligneFerroviaire) {
        this.ligneFerroviaire = ligneFerroviaire;
    }

    public boolean isDisponible() {
        return disponible;
    }


    /**
     * getter de l'attribut heure
     * @return l'attribut heure du sillon / l'heure de commencement du sillon
     */

    public LocalTime getHeure() {
        return heure;
    }


    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }


    /**
     * getter de l'attribut coutUtilisation
     * @return le cout d'utilisation du sillon
     */

    public int getCoutUtilisation() {
        return coutUtilisation;
    }

    /**
     * getter de l'attribut ligneFerrovière
     * @return la ligne ferrovière associée au sillon
     * @see LigneFerroviaire
     */
    public LigneFerroviaire getLigneFerroviaire() {
        return ligneFerroviaire;
    }

    /**
     * getter de l'attribut disponible
     * @return si le sillon est disponible ou pas
     */
    public boolean getDisponible() {
        return disponible;
    }

    /**
     * fonction permettant de changer la disponibilité du sillon
     * @param disponible true/false pour changer l'attribut disponible
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }


    @Override
    public String toString() {
        return "Sillon{" +
                "coutUtilisation=" + coutUtilisation +
                ", heure=" + heure +
                ", ligneFerroviaire=" + ligneFerroviaire +
                ", disponible=" + disponible +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sillon sillon = (Sillon) o;

        if (coutUtilisation != sillon.coutUtilisation) return false;
        if (disponible != sillon.disponible) return false;
        if (heure != null ? !heure.equals(sillon.heure) : sillon.heure != null) return false;
        return ligneFerroviaire != null ? ligneFerroviaire.equals(sillon.ligneFerroviaire) : sillon.ligneFerroviaire == null;
    }

    @Override
    public int hashCode() {
        int result = coutUtilisation;
        result = 31 * result + (heure != null ? heure.hashCode() : 0);
        result = 31 * result + (ligneFerroviaire != null ? ligneFerroviaire.hashCode() : 0);
        result = 31 * result + (disponible ? 1 : 0);
        return result;
    }
}
