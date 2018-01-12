package fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire;

/**
 * La classe abstraite EntrepriseFerroviairePassagers represente une entreprise ferroviaire spécialisé dans le transport de passagers
 *
 * @see EntrepriseFerroviaire
 */

public class EntrepriseFerroviairePassagers extends EntrepriseFerroviaire  {
    /**
     * Constructeur de l'entreprise ferroviaire spécialisé dans le transport de passagers
     * @param nom Le nom de l'entreprise ferroviaire spécialisé dans le transport de passagers
     * @param siren Le numéro de l'entreprise ferroviaire spécialisé dans le transport de passagers
     *
     * @see EntrepriseFerroviaire#nom
     * @see EntrepriseFerroviaire#siren
     * @see EntrepriseFerroviaire#EntrepriseFerroviaire(String, int)
     */
    public EntrepriseFerroviairePassagers(String nom, int siren) {
        super(nom, siren);
    }


}
