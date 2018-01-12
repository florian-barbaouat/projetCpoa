package fr.univ_amu.iut.reseauferre.traitement.facturation;

import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.trains.Train;

/**
 * La classe TarificationNbTrain permet de déterminer la somme que doit payer une entreprise ferroviaire
 * en fonction du nombre de trains qu'elle possède
 *
 * @author edouardlebeau
 * @see Tarification
 * @see Tarification#getCout(EntrepriseFerroviaire)
 */
public class TarificationNbTrain implements Tarification {

    /**
     * cout correspond à la somme que devra payer une entreprise ferroviaire
     * @see TarificationNbTrain#getCout(EntrepriseFerroviaire)
     */
    private double cout;

    /**
     * Donne le cout qu'une entreprise ferroviaire doit payer en fonction du nombre de trains qu'elle possède
     * en plus du prix d'achat de chaque train
     * @param entrepriseFerroviaire L'entreprise ferroviaire pour laquelle on calcule le cout
     * @return Le cout
     *
     * @see TarificationNbTrain#cout
     * @see Tarification#getCout(EntrepriseFerroviaire)
     */
    @Override
    public double getCout(EntrepriseFerroviaire entrepriseFerroviaire) {
        for(Train train : entrepriseFerroviaire.getListeTrain()) {
            cout += train.getCout();
            if (train.getProprietaire().getNbTrain() < 5)
                cout += 2000;
            else if (train.getProprietaire().getNbTrain() > 5)
                cout += 1000;

        }
        return cout;
    }
}
