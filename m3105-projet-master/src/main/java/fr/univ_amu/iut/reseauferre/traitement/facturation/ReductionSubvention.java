package fr.univ_amu.iut.reseauferre.traitement.facturation;
import fr.univ_amu.iut.reseauferre.traitement.positions.Gare;
import fr.univ_amu.iut.reseauferre.traitement.Trajet;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;

/**
 * La classe ReductionSubvention permet d'obtenir les reductions qu'une entreprise ferroviaire peut obtenir
 * si ses trains passent par des gares subventionnées
 *
 * @author edouardlebeau
 * @see Reduction
 * @see Reduction#getReduction(EntrepriseFerroviaire)
 */
public class ReductionSubvention implements Reduction {


    /**
     * reduction correspond à la somme qu'obtiendra une entreprise ferroviaire
     * @see ReductionSubvention#getReduction(EntrepriseFerroviaire)
     */
    private double reduction;

    /**
     * Donne une reduction de 500 à une entreprise ferroviaire pour chacun des trains passant
     * par une gare subventionnée
     *
     * @param entrepriseFerroviaire L'entreprise ferroviaire recevant la reduction
     * @return La reduction
     *
     * @see ReductionSubvention#reduction
     * @see Reduction#getReduction(EntrepriseFerroviaire)
     */
    @Override
    public double getReduction(EntrepriseFerroviaire entrepriseFerroviaire) {
            for (Trajet trajet : entrepriseFerroviaire.getListeTrajet()) {
                for (Gare gare : trajet.getGaresTraversees()) {
                    if (gare.getSubvention())
                        reduction += 500;
                }
            }

        return reduction;
    }
}
