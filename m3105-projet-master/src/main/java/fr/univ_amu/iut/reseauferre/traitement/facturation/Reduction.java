package fr.univ_amu.iut.reseauferre.traitement.facturation;


import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;

/**
 * Interface Reduction
 * @author edouardlebeau
 *
 * @see ReductionFidelite
 * @see ReductionSubvention
 * @see ReductionFidelite#getReduction(EntrepriseFerroviaire)
 * @see ReductionSubvention#getReduction(EntrepriseFerroviaire)
 */
public interface Reduction {
    /**
     * La méthode permettant d'obtenir les réductions d'une Entreprise Ferroviaire
     * @param entrepriseFerroviaire L'entreprise qui recevra les reductions
     *
     * @see ReductionFidelite#getReduction(EntrepriseFerroviaire)
     * @see ReductionSubvention#getReduction(EntrepriseFerroviaire)
     */
    public double getReduction(EntrepriseFerroviaire entrepriseFerroviaire);
}
