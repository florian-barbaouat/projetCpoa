package fr.univ_amu.iut.reseauferre.traitement.facturation;

import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.trains.Train;

import java.util.List;

/**
 * La classe TarificationLongueurTrain permet de déterminer la somme que doit payer une entreprise ferroviaire
 * en fonction de la taille de ses trains
 *
 * @author edouardlebeau
 * @see Tarification
 * @see Tarification#getCout(EntrepriseFerroviaire)
 */
public class TarificationLongueurTrain implements Tarification {

    /**
     * cout correspond à la somme que devra payer une entreprise ferroviaire
     * @see TarificationLongueurTrain#getCout(EntrepriseFerroviaire)
     */

    private double cout;

    /**
     * Donne le cout qu'une entreprise ferroviaire doit payer en fonction de la taille de ses trains
     * @param entrepriseFerroviaire L'entreprise ferroviaire pour laquelle on calcule le cout
     * @return Le cout
     *
     * @see TarificationLongueurTrain#cout
     * @see Tarification#getCout(EntrepriseFerroviaire)
     */

    @Override
    public double getCout(EntrepriseFerroviaire entrepriseFerroviaire) {
        for(Train train : entrepriseFerroviaire.getListeTrain()) {
            if (train.getDimensions() < 5)
                cout += 500;
            else if (train.getDimensions() > 5)
                cout += 250;
        }
        return cout;
    }

}
