package fr.univ_amu.iut.reseauferre.traitement.trains.trainsOptions;


import fr.univ_amu.iut.reseauferre.traitement.positions.Position;
import fr.univ_amu.iut.reseauferre.traitement.trains.Train;
import fr.univ_amu.iut.reseauferre.traitement.trains.TrainAvecOptions;

/**
 * Classe fille de TrainsAvecOptions
 * Train avec option de streaming
 * @see TrainAvecOptions
 *
 */
public class TrainAvecStreaming extends TrainAvecOptions {
    /**
     * Constructeur par recopie de TrainAvecStreaming
     * @param train train recopié
     */
    public TrainAvecStreaming(Train train){
        super(train);
    }
    @Override
    public void deplacer(Position position) {
        super.deplacer(position);
        System.out.println("Option Streaming activé");
    }


}
