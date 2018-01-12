package fr.univ_amu.iut.reseauferre.traitement.facturation;
import com.sun.org.apache.regexp.internal.RE;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;
import org.omg.IOP.ENCODING_CDR_ENCAPS;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe Facturation permet de calculer le prix de la facture qui sera attribuée à une Entreprise Ferroviaire
 * @author edouardlebeau
 * @see EntrepriseFerroviaire
 * @see Tarification
 * @see Reduction
 */
public class Facturation {

    /**
     * Le coût final de la facture
     * @see Tarification#getCout(EntrepriseFerroviaire)
     * @see Reduction#getReduction(EntrepriseFerroviaire)
     */
    private double coutTotal;

    /**
     * L'entreprise ferroviaire qui sera facturée
     * @see EntrepriseFerroviaire
     */
    private EntrepriseFerroviaire entrepriseFerroviaire;

    /**
     * La liste des différentes tarifications attribuées à l'entreprise ferroviaire
     * @see Tarification
     */
    private List<Tarification> tarifications = new ArrayList<>();

    /**
     * La liste des différentes tarifications attribuées à l'entreprise ferroviaire
     * @see Reduction
     */
    private List<Reduction> reductions = new ArrayList<>();

    /**
     * Constructeur de Facturation
     * @param entrepriseFerroviaire   L'entreprise ferroviaire qui sera facturée
     * @param tarifications           La liste des tarifs attribués
     * @param reductions              La liste des reductions attribuées
     *
     * @see Facturation#entrepriseFerroviaire
     * @see Facturation#tarifications
     * @see Facturation#reductions
     */
    public Facturation(EntrepriseFerroviaire entrepriseFerroviaire, List<Tarification> tarifications, List<Reduction> reductions) {
        this.entrepriseFerroviaire = entrepriseFerroviaire;
        this.tarifications = tarifications;
        this.reductions = reductions;
    }

    /**
     * Constructeur de Facturation
     * @param entrepriseFerroviaire L'entreprise ferroviaire à facturer
     */
    public Facturation(EntrepriseFerroviaire entrepriseFerroviaire) {
        this.entrepriseFerroviaire = entrepriseFerroviaire;
    }

    /**
     * Calcul la facture finale de l'entreprise en y ajoutant le cout des différentes tarifications
     * et en y enlevant les réductions
     *
     * @param tarifications La liste des tarifs attribués
     * @param reductions La liste des réductions attribuées
     * @return coutTotal Le cout total de la facture pour l'entreprise ferroviaire
     *
     * @see Facturation#coutTotal
     */
    public double getCoutTotal(List<Tarification> tarifications, List<Reduction> reductions){
            for(Tarification tarification : tarifications)
                coutTotal += tarification.getCout(this.entrepriseFerroviaire);
            for(Reduction reduction : reductions)
                coutTotal -= reduction.getReduction(this.entrepriseFerroviaire);
            return coutTotal;
    }
}

