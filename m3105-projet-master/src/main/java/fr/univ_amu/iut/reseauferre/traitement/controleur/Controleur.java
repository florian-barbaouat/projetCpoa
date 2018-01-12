package fr.univ_amu.iut.reseauferre.traitement.controleur;

import fr.univ_amu.iut.reseauferre.traitement.Trajet;

/**
 * La class Controleur permet d'attribuer des sillons à un trajet
 * @author kevinColombani
 * @see Trajet
 * @see AttribueurDeSillon
 */
public class Controleur {

    /**
     * Methode qui appelle l'attribueur de sillon passé en paramètre pour attribuer les sillons demandé par le trajet
     * @param trajet                Le trajet souhaité
     * @param attribueurDeSillon    L'attribueur de sillon souhaité
     */
    public void attribuerSillon(Trajet trajet,AttribueurDeSillon attribueurDeSillon){
        attribueurDeSillon.attribuerSillon(trajet);
    }
}
