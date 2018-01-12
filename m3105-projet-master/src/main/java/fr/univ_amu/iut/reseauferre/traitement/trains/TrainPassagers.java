package fr.univ_amu.iut.reseauferre.traitement.trains;

import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviairePassagers;
import fr.univ_amu.iut.reseauferre.traitement.wagons.Wagon;
import fr.univ_amu.iut.reseauferre.traitement.wagons.WagonPassagers;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Train de passagers : type de train
 */
public class TrainPassagers extends Train{
    /**
     * Constructeur de la classe TrainPassagers
     * @param vitesseMax  la vitesse macimale du  train
     * @param prix          le prix du train
     * @param proprietaire  propriétaire du train
     * @param composition   Composition du train
     */
    private TrainPassagers(int vitesseMax, int prix, EntrepriseFerroviaire proprietaire, Collection<Wagon> composition) {
        super(vitesseMax, prix, proprietaire, composition);
    }


    /**
     * Builder de la classe TrainsPassagers
     */
    public static class BuilderTrainPassagers implements BuilderTrain {
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
         * @return le train de passagers construit
         */
        public BuilderTrainPassagers addProprietaire(EntrepriseFerroviairePassagers proprietaire){
            this.proprietaire = proprietaire;
            return this;
        }

        /**
         * Ajout de plusieurs wagon de passagers au train
         * @param wagonPassagers la liste des wagons a ajouter
         * @return le train de passagers construits
         */
        public BuilderTrainPassagers addWagons(Collection<WagonPassagers> wagonPassagers){
            composition.addAll(wagonPassagers);
            return this;
        }

        /**
         * Ajout d'un wagon de passager
         * @param wagonPassagers le wagon a ajouter
         * @return le train de passager construit
         */
        public BuilderTrainPassagers addWagon(WagonPassagers wagonPassagers){
            composition.add(wagonPassagers);
            return this;
        }

        @Override
        public BuilderTrainPassagers addPrix(int prix) {
            this.prix = prix;
            return this;
        }

        @Override
        public BuilderTrainPassagers addVitesseMax(int vitesseMax) {
            this.vitesseMax = vitesseMax;
            return this;
        }

        @Override
        public TrainPassagers construire() {
            return new TrainPassagers(this.vitesseMax,this.prix,this.proprietaire,this.composition);
        }
    }
}
