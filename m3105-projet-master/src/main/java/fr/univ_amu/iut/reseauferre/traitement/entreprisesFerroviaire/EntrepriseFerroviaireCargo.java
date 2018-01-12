package fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire;

/**
 * La classe abstraite EntrepriseFerroviaireCargo represente une entreprise ferroviaire spécialisé dans le transport de cargo
 *
 * @see EntrepriseFerroviaire
 */
public class EntrepriseFerroviaireCargo extends EntrepriseFerroviaire {
    /**
     * Constructeur de l'entreprise ferroviaire spécialisé dans le transport de cargo
     * @param nom Le nom de l'entreprise ferroviaire spécialisé dans le transport de cargo
     * @param siren Le numéro de l'entreprise ferroviaire spécialisé dans le transport de cargo
     *
     * @see EntrepriseFerroviaire#nom
     * @see EntrepriseFerroviaire#siren
     * @see EntrepriseFerroviaire#EntrepriseFerroviaire(String, int)
     */
    public EntrepriseFerroviaireCargo(String nom, int siren) {
        super(nom, siren);
    }


}
