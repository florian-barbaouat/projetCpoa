package fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire;

/**
 * La classe abstraite EntrepriseFerroviaireAnimaux represente une entreprise ferroviaire spécialisé dans le transport des animaux
 *
 * @see EntrepriseFerroviaire
 */
public class EntrepriseFerroviaireAnimaux extends EntrepriseFerroviaire {
    /**
     * Constructeur de l'entreprise ferroviaire spécialisé dans le transport des animaux
     * @param nom Le nom de l'entreprise ferroviaire spécialisé dans le transport des animaux
     * @param siren Le numéro de l'entreprise ferroviaire spécialisé dans le transport des animaux
     *
     * @see EntrepriseFerroviaire#nom
     * @see EntrepriseFerroviaire#siren
     * @see EntrepriseFerroviaire#EntrepriseFerroviaire(String, int)
     */
    public EntrepriseFerroviaireAnimaux(String nom, int siren) {

        super(nom, siren);
    }


}
