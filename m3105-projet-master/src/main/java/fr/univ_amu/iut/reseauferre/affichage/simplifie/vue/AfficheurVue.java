package fr.univ_amu.iut.reseauferre.affichage.simplifie.vue;

import fr.univ_amu.iut.reseauferre.affichage.simplifie.modele.Donnees;

public class AfficheurVue {
    private Donnees donnees;

    public AfficheurVue(Donnees donnees) {
        this.donnees = donnees;
    }

    public void afficher(Vue vue) {
        vue.afficher(donnees);
    }
}
