package fr.univ_amu.iut.reseauferre.traitement.trains;

import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaireAnimaux;
import fr.univ_amu.iut.reseauferre.traitement.wagons.Wagon;
import fr.univ_amu.iut.reseauferre.traitement.wagons.WagonBetails;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Trains de bétail étant un type de train
 */
public class TrainBetails extends Train{
    /**
     * constructeur de la class trainsBétails
     * @param vitesseMax  la vitesse macimale du  train
     * @param prix          le prix du train
     * @param proprietaire  propriétaire du train
     * @param composition   Composition du train
     */
    private TrainBetails(int vitesseMax, int prix, EntrepriseFerroviaire proprietaire, Collection<Wagon> composition) {
        super(vitesseMax, prix, proprietaire, composition);
    }

    /**
     * Builder de la class Train bétail
     */
    public static class BuilderTrainBetail implements Train.BuilderTrain {
        /**
         * propriétaire du train
         * @see EntrepriseFerroviaire
         */
        private EntrepriseFerroviaire proprietaire;
        /**
         * Composition deu trains : les wagons
         */
        private Collection<Wagon> composition = new LinkedList<>();
        /**
         * vitesse maximale du train
         */
        private int vitesseMax;
        /**
         *  prix du train
         */
        private int prix;

        /**
         * Ajout du propriétaire au Builder
         * @param proprietaire le propriétaire a ajouter
         * @return le train Betail construit
         */
        public BuilderTrainBetail addProprietaire(EntrepriseFerroviaireAnimaux proprietaire){
            this.proprietaire = proprietaire;
            return this;
        }

        /**
         * Ajout de wagons dans la composition du train
         * @param wagon Wagon a ajouter
         * @return le train Bétail construit
         */
        public BuilderTrainBetail addWagon(WagonBetails wagon){
            composition.add(wagon);
            return this;
        }

        /**
         * Ajout de plusieurs wagon dans la composition du train
         * @param wagonBetails la liste de wagons a ajouter
         * @return  Le train bétail construit avec les wagons
         */
        public BuilderTrainBetail addWagons(Collection<WagonBetails> wagonBetails){
            composition.addAll(wagonBetails);
            return this;
        }

        @Override
        public TrainBetails construire() {
            return new TrainBetails(this.vitesseMax,this.prix,this.proprietaire,this.composition);
        }

        @Override
        public BuilderTrainBetail addPrix(int prix) {
            this.prix = prix;
            return this;
        }

        @Override
        public BuilderTrainBetail addVitesseMax(int vitesseMax) {
            this.vitesseMax = vitesseMax;
            return this;
        }
    }
}
