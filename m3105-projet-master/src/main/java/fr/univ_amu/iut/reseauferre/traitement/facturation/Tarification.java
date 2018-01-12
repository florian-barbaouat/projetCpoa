package fr.univ_amu.iut.reseauferre.traitement.facturation;


import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;

/**
 * Interface Reduction
 * @author edouardlebeau
 *
 * @see TarificationLongueurTrain
 * @see TarificationNbTrain
 * @see TarificationSillon
 * @see TarificationNbTrain#getCout(EntrepriseFerroviaire)
 * @see TarificationSillon#getCout(EntrepriseFerroviaire)
 * @see TarificationLongueurTrain#getCout(EntrepriseFerroviaire)
 */
public interface Tarification {

    /**
     * La méthode permettant d'obtenir les coûts d'une Entreprise Ferroviaire
     * @param entrepriseFerroviaire L'entreprise qui devra payer les différents coûts
     *
     * @see TarificationNbTrain#getCout(EntrepriseFerroviaire)
     * @see TarificationSillon#getCout(EntrepriseFerroviaire)
     * @see TarificationLongueurTrain#getCout(EntrepriseFerroviaire)
     */
    public double getCout(EntrepriseFerroviaire entrepriseFerroviaire);

}
