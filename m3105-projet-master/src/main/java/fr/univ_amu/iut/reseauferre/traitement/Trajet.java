package fr.univ_amu.iut.reseauferre.traitement;


import fr.univ_amu.iut.reseauferre.traitement.positions.Gare;
import fr.univ_amu.iut.reseauferre.traitement.positions.LigneFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.positions.Position;
import fr.univ_amu.iut.reseauferre.traitement.trains.Train;

import java.time.LocalTime;
import java.util.*;

/**
 * La classe Trajet  est composée d'une collection de sillons empruntés , d'un train , et d'une collection de ligne ferrovière demandées
 *
 * elle représente le parcours qu'effectueras le train
 *
 * @see Train
 * @see Sillon
 * @see LigneFerroviaire
 */
public class Trajet {
    /**
     *  une collection des sillons empruntés pendant le trajet
     *
     *  @see Sillon
     *
     *  */
    private Collection<Sillon> sillonsEmprunte;
    /**
     * Le train qui empruntera ce trajet
     *
     * @see Train
     */
    private Train train;

    /**
     * Une collection des Lignes Ferrovières demandées par le trajet
     *
     * @see LigneFerroviaire
     */
    private Collection<LigneFerroviaire> ligneFerroviairesDemande;


    /**
     * Constructeur  par défaut de la classe Trajet
     * @param ligneFerroviaires liste des lignes utilisées par le trajet
     * @param train train parcourant le trajet
     */
    public Trajet( Collection<LigneFerroviaire>  ligneFerroviaires, Train train) {

        this.sillonsEmprunte = new ArrayList<>();
        this.ligneFerroviairesDemande = ligneFerroviaires;
        this.train = train;
        train.getProprietaire().addTrajet(this);
    }


    public void setSillonsEmprunte(Collection<Sillon> sillonsEmprunte) {
        this.sillonsEmprunte = sillonsEmprunte;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public void setLigneFerroviairesDemande(Collection<LigneFerroviaire> ligneFerroviairesDemande) {
        this.ligneFerroviairesDemande = ligneFerroviairesDemande;
    }


    /**
     * Constructeur par recopie de la classe Trajet
     * @param trajet     le trajet qu'on copie
     */
    public Trajet(Trajet trajet) {
        this(trajet.ligneFerroviairesDemande, trajet.train);
        sillonsEmprunte = trajet.sillonsEmprunte;
    }

    /**
     * Méthode retournant la position  du train dans le trajet
     *
     * @param horaire  L'horaire auquel on souhaite connaitre la position
     *
     * @return une gare ou une ligne étant la position du train
     *
     * @see Sillon#getLigneFerroviaire()
     * @see Sillon#getHeure()
     * @see Position
     */
    private Position getPositionAUnMoment(LocalTime horaire) {
        Position resultat;
        LocalTime lastTime;
        ArrayList<Sillon> sillons = new ArrayList<>();
        if(sillonsEmprunte.isEmpty()){
            throw new NullPointerException("Pas de sillons");
        }
        for (Sillon sillon : sillonsEmprunte) {
            if (horaire.getHour() == sillon.getHeure().getHour())
                return sillon.getLigneFerroviaire();
            sillons.add(sillon);
        }
        Collections.sort(sillons, (o1, o2) -> o1.getHeure().compareTo(o2.getHeure()));
        Sillon last = null;
        for (Sillon sillon : sillons) {
            if (horaire.isBefore(sillon.getHeure())){
                if (last == null )
                    return sillons.get(sillons.size()-1).getLigneFerroviaire().getArrive();
                return last.getLigneFerroviaire().getArrive();
            }
            last = sillon;
        }
        return sillons.get(sillons.size()-1).getLigneFerroviaire().getArrive();
    }

    /**
     * méthode permettant de déplacer un train en fonction de l'horaire
     *
     * @param horaire horaire en fonction duquel le train doit etre déplacer
     *
     */
    public void deplacer(LocalTime horaire){
        train.deplacer(getPositionAUnMoment(horaire));
    }

    /**
     *  Getter de l'attribut LigneFerroviaireDemande
     * @return La liste des lignes ferrovières demandées
     */
    public Collection<LigneFerroviaire> getLigneFerroviairesDemande() {
        return ligneFerroviairesDemande;
    }

    /**
     * Getter de l'attribut sillonsEmprunter
     * @return La collection de sillons empruntés
     */
    public Collection<Sillon> getSillonsEmprunte() { return sillonsEmprunte; }

    /**
     * Méthode permettant d'ajouter un sillon dans la collection des sillons empruntés
     * @param sillon
     *              sillon a ajouter dans la collection
     * @see Sillon
     */
    public void addSillonEmprunte(Sillon sillon){
        sillonsEmprunte.add(sillon);
    }

    /**
     * Getter des gares traversées pendant le trajet , utilisé pour l'affichage
     * @return la liste des gares traversées
     *
     *@see Sillon#getLigneFerroviaire()
     *@see LigneFerroviaire#getDepart()
     *
     */
    public Set<Gare> getGaresTraversees() {
        HashSet<Gare> gares = new HashSet<>();
        for (Sillon sillon : sillonsEmprunte) {
            gares.add(sillon.getLigneFerroviaire().getDepart());
            gares.add(sillon.getLigneFerroviaire().getArrive());
        }
        return gares;
    }

    /**
     * getter de la première gare des lignes ferrovières demandées
     * @return La première gare de la première ligne
     */
    public Gare getDepart() {
        ArrayList<LigneFerroviaire> ligneFerroviaires = new ArrayList<>(getLigneFerroviairesDemande());

        return ligneFerroviaires.get(0).getDepart();
    }

    /**
     * getter de l'attribut Train
     * @return l'attribut train du trajet
     */
    public Train getTrain() {
        return train;
    }

    /**
     * Getter de la gare de destination du trajet
     * @return La dernière gare de la liste des Lignes ferrovières demandées
     */
    public Gare getDestination() {
        ArrayList<LigneFerroviaire> ligneFerroviaires = new ArrayList<>(getLigneFerroviairesDemande());

        return ligneFerroviaires.get(ligneFerroviaires.size() - 1).getArrive();
    }
}