package fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire;

import fr.univ_amu.iut.reseauferre.traitement.Trajet;
import fr.univ_amu.iut.reseauferre.traitement.trains.Train;

import java.util.ArrayList;
import java.util.Collection;
/**
 * La classe abstraite EntrepriseFerroviaire represente une entreprise ferroviaire
 *
 * @see Trajet
 * @see Train
 */
public abstract class EntrepriseFerroviaire {
    /**
     * Le nom de l'entreprise ferroviaire
     *
     * @see EntrepriseFerroviaire#getNom()
     */
    private String nom;

    /**
     * Le numéro de l'entreprise ferroviaire
     *
     * @see EntrepriseFerroviaire#getSiren()
     */
    private int siren;

    /**
     * La liste des trajets que propose l'entreprise ferroviaire
     *
     * @see EntrepriseFerroviaire#getListeTrajet()
     */
    private Collection<Trajet> listeTrajet = new ArrayList<>();

    /**
     * La liste des trains que possède l'entreprise ferroviaire
     *
     * @see EntrepriseFerroviaire#getListeTrain()
     */
    private Collection<Train> listeTrain = new ArrayList<>();

    /**
     * Constructeur de l'entreprise ferroviaire
     * @param nom Le nom de l'entreprise ferroviaire
     * @param siren Le numéro de l'entreprise ferroviaire
     *
     * @see EntrepriseFerroviaire#nom
     * @see EntrepriseFerroviaire#siren
     */

    public EntrepriseFerroviaire(String nom, int siren) {
        this.nom = nom;
        this.siren = siren;
    }

    /**
     * Renvoie le nom de l'entreprise ferroviaire
     * @return le nom
     *
     * @see EntrepriseFerroviaire#nom
     */
    public String getNom() {
        return nom;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSiren(int siren) {
        this.siren = siren;
    }

    public void setListeTrajet(Collection<Trajet> listeTrajet) {
        this.listeTrajet = listeTrajet;
    }

    public void setListeTrain(Collection<Train> listeTrain) {
        this.listeTrain = listeTrain;
    }


    /**
     * Renvoie le numéro de l'entreprise ferroviaire
     * @return le numéro
     *
     * @see EntrepriseFerroviaire#siren
     */

    public int getSiren() {
        return siren;
    }

    /**
     * Renvoie la liste de train de l'entreprise ferroviaire
     * @return la liste de train
     *
     * @see EntrepriseFerroviaire#listeTrain
     */
    public Collection<Train> getListeTrain() {
        return listeTrain;
    }

    /**
     * Renvoie la liste de trajet de l'entreprise ferroviaire
     * @return la liste de trajet
     *
     * @see EntrepriseFerroviaire#listeTrajet
     */
    public Collection<Trajet> getListeTrajet() {
        return listeTrajet;
    }

    /**
     * Renvoie le nombre de trajet de l'entreprise ferroviaire
     * @return le nombre de trajet
     *
     * @see EntrepriseFerroviaire#listeTrajet
     */
    public int getNbTrajet(){ return listeTrajet.size(); }

    /**
     * Renvoie le nombre de train de l'entreprise ferroviaire
     * @return le nombre de train
     *
     * @see EntrepriseFerroviaire#listeTrain
     */

    public int getNbTrain(){ return listeTrain.size(); }

    /**
     * Ajoute un train dans la liste de train de l'entreprise ferroviaire
     *
     * @see EntrepriseFerroviaire#listeTrain
     * @param train le train qu'on ajoute à la liste de train de l'entreprise ferroviaire
     */
    public void addTrain(Train train){ listeTrain.add(train);}


    /**
     * Ajoute un train dans la liste de trajet de l'entreprise ferroviaire
     *
     * @see EntrepriseFerroviaire#listeTrajet
     * @param trajet trajet qu'on ajoute à la liste de trajet de l'entreprise ferroviaire
     */
    public void addTrajet(Trajet trajet){ listeTrajet.add(trajet);}


    /**
     * Affiche une chaîne de caractères avec tous les attributs d'une entreprise ferroviaire
     * @return la chaîne de caractères
     */
    @Override
    public String toString() {
        return nom + " (" + siren + ")";
    }
}
