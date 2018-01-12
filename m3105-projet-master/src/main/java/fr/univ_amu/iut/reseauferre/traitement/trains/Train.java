package fr.univ_amu.iut.reseauferre.traitement.trains;

import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.positions.Position;
import fr.univ_amu.iut.reseauferre.traitement.wagons.Wagon;

import java.util.Collection;

/**
 * Classe abstraite représentant un train
 * un train est composé d'une position (gare ou ligne férrovières) , d'une vitesse maximale , d'un prix , d'un propriétaire et surtout d'une collection de wagons composant le train
 *
 * @see Position
 * @see EntrepriseFerroviaire
 * @see Wagon
 */
public abstract class Train {
    /**
     * La position du train (ligne ou gare)
     * @see Position
     */
    private Position position;
    // vitesse maximale du train
    private int vitesseMax;
    // prix du train
    private int prix;
    /**
     * propriétaire du train
     * @see EntrepriseFerroviaire
     */
    private EntrepriseFerroviaire proprietaire;
    /**
     * Collection des wagons composant le train
     * @see Wagon
     */
    private Collection<Wagon> composition;
    private String type = this.getClass().getSimpleName();

    public void setComposition(Collection<Wagon> composition) {
        this.composition = composition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Constructeur de la classe abstraite
     * @param vitesseMax  la vitesse macimale du  train
     * @param prix          le prix du train
     * @param proprietaire  propriétaire du train
     * @param composition   Composition du train
     */
    protected Train(int vitesseMax, int prix, EntrepriseFerroviaire proprietaire, Collection<Wagon> composition) {
        this.vitesseMax = vitesseMax;
        this.prix = prix;
        this.proprietaire = proprietaire;
        this.composition = composition;
        proprietaire.addTrain(this);
    }


    public void setPosition(Position position) {
        this.position = position;
    }

    public void setVitesseMax(int vitesseMax) {
        this.vitesseMax = vitesseMax;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setProprietaire(EntrepriseFerroviaire proprietaire) {
        this.proprietaire = proprietaire;
    }


    /**
     * Méthode déplacant un train (setter de position)
     * @param position position actuelle du train
     */

    public void deplacer(Position position){
        this.position = position;
    }

    /**
     * getter des dimensions du train
     * @return la taille du train en retournant taille de la collection de wagons
     */
    public int getDimensions() {
        return composition.size();
    }

    /**
     * getter de l'attribut prix
     * @return le prix du train
     */
    public int getCout() {
        return this.prix;
    }

    /**
     *  getter de la vitesse du train
     * @return  la vitesse maximale d'un train
     */
    public int getVitesseMax() {
        return vitesseMax;
    }

    /**
     * getter du propriétaire du train
     * @return le propriétaire du train
     * @see EntrepriseFerroviaire
     */
    public EntrepriseFerroviaire getProprietaire() {
        return proprietaire;
    }

    /**
     * getter de la collection des wagons
     * @return la composition du trains
     */
    public Collection<Wagon> getComposition() {
        return composition;
    }

    /**
     * Getter de la position actuelle du  train
     * @return la position du train
     * @see Position
     */
    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + '{' +
                " Localisation: " + position.getName() +
                ", vitesse maximum = " + vitesseMax +
                ", prix=" + prix +
                ", proprietaire =" + proprietaire.getNom() + "(" + proprietaire.getSiren() + ")" +
                ", composition =" + composition +
                "}  \n";
    }

    /**
     * Le builder du train
     */
    public interface BuilderTrain {
        /**
         * méthode pour construire un train
         * @return un train construit
         */
        Train construire();
        // ajoute un attribut prix a un train
        BuilderTrain addPrix(int prix);
        // ajoute une vitesse max a un train
        BuilderTrain addVitesseMax(int vitesseMax);


    }

}




