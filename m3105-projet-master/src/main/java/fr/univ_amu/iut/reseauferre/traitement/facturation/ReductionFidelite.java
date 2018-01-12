package fr.univ_amu.iut.reseauferre.traitement.facturation;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.trains.Train;

/**
 * La classe ReductionFidelite permet d'obtenir les reductions qu'une entreprise ferroviaire peut obtenir
 * si elle fait plus de 10 trajets
 *
 * @author edouardlebeau
 * @see Reduction
 * @see Reduction#getReduction(EntrepriseFerroviaire)
 */
public class ReductionFidelite implements Reduction {

    /**
     * reduction correspond à la somme qu'obtiendra une entreprise ferroviaire
     * @see ReductionFidelite#getReduction(EntrepriseFerroviaire)
     */
    private double reduction;

    /**
     * Donne une reduction de 1000 à une entreprise ferroviaire
     * @param entrepriseFerroviaire L'entreprise ferroviaire recevant la reduction
     * @return La reduction
     *
     * @see ReductionFidelite#reduction
     * @see Reduction#getReduction(EntrepriseFerroviaire)
     *
     */
    @Override
    public double getReduction(EntrepriseFerroviaire entrepriseFerroviaire) {
            if (entrepriseFerroviaire.getNbTrajet() > 10)
                reduction += 1000;


        return reduction;
    }
}
