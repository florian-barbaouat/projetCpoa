package fr.univ_amu.iut.reseauferre.traitement.trains;

import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.positions.Position;
import fr.univ_amu.iut.reseauferre.traitement.wagons.Wagon;

import java.util.Collection;

/**
 * class abstraite pour des trains avec options a partir d'un train Existant
 * @see Train
 */
public abstract class TrainAvecOptions extends Train{
    // train allant être optionné
    private Train train;

    /**
     * constructeur par défaut d'un train avec options
     * @param vitesseMax  la vitesse macimale du  train
     * @param prix          le prix du train
     * @param proprietaire  propriétaire du train
     * @param composition   Composition du train
     */
    private TrainAvecOptions(int vitesseMax, int prix, EntrepriseFerroviaire proprietaire, Collection<Wagon> composition) {
        super(vitesseMax, prix, proprietaire, composition);
    }

    /**
     * construceur par recopie
     * @param train le train a recopier
     * @see Train
     */
    public TrainAvecOptions(Train train){
        this(train.getVitesseMax(), train.getCout(), train.getProprietaire(), train.getComposition());
       this.train = train;
    }

    @Override
    public void deplacer(Position position) {
        train.deplacer(position);

        //TODO Beau message précisant que le trains est un trains avec options !
    }


}
