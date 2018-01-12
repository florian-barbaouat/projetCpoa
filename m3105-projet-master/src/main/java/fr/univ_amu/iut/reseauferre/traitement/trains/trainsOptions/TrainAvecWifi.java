package fr.univ_amu.iut.reseauferre.traitement.trains.trainsOptions;

import fr.univ_amu.iut.reseauferre.traitement.positions.Position;
import fr.univ_amu.iut.reseauferre.traitement.trains.Train;
import fr.univ_amu.iut.reseauferre.traitement.trains.TrainAvecOptions;

/**
 * Classe fille de TrainsAvecOptions
 * Train avec option Wifi
 * @see TrainAvecOptions
 *
 */
public class TrainAvecWifi extends TrainAvecOptions {
    /**
     * Constructeur par recopie de la classe TrainAvecWifi
     * @param train train recopié
     */
    public TrainAvecWifi(Train train){
        super(train);
    }

    @Override
    public void deplacer(Position position) {
        super.deplacer(position);
        System.out.println("Option Wifi activé");
    }



}
