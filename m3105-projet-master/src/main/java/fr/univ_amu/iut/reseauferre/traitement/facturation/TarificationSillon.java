package fr.univ_amu.iut.reseauferre.traitement.facturation;

import fr.univ_amu.iut.reseauferre.traitement.Sillon;
import fr.univ_amu.iut.reseauferre.traitement.Trajet;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.trains.Train;

/**
 * La classe TarificationSillon permet de déterminer la somme que doit payer une entreprise ferroviaire
 * en fonction du prix des sillons que ses trajets utilise
 *
 * @author edouardlebeau
 * @see Tarification
 * @see Tarification#getCout(EntrepriseFerroviaire)
 */
public class TarificationSillon implements Tarification {

    /**
     * cout correspond à la somme que devra payer une entreprise ferroviaire
     * @see TarificationSillon#getCout(EntrepriseFerroviaire)
     */
    private double cout;

    /**
     * Donne le cout qu'une entreprise ferroviaire doit payer en fonction du du prix des sillons que ses trajets utilise
     * en plus du prix d'achat de chaque train
     * @param entrepriseFerroviaire L'entreprise ferroviaire pour laquelle on calcule le cout
     * @return Le cout
     *
     * @see TarificationSillon#cout
     * @see Tarification#getCout(EntrepriseFerroviaire)
     */
    @Override
    public double getCout(EntrepriseFerroviaire entrepriseFerroviaire) {
        for (Trajet trajet : entrepriseFerroviaire.getListeTrajet())
            for(Sillon sillon : trajet.getSillonsEmprunte())
                cout += sillon.getCoutUtilisation();
        return cout;
    }
}
