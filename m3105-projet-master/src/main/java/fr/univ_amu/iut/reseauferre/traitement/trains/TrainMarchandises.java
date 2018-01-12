package fr.univ_amu.iut.reseauferre.traitement.trains;

import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaireCargo;
import fr.univ_amu.iut.reseauferre.traitement.wagons.Wagon;
import fr.univ_amu.iut.reseauferre.traitement.wagons.WagonLiquides;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Train de marchandises : type de train
 */
public class TrainMarchandises extends Train {
    /**
     * constructeur de la classe TrainMarchandises
     * @param vitesseMax  la vitesse macimale du  train
     * @param prix          le prix du train
     * @param proprietaire  propriétaire du train
     * @param composition   Composition du train
     */
    private TrainMarchandises(int vitesseMax, int prix, EntrepriseFerroviaire proprietaire, Collection<Wagon> composition) {
        super(vitesseMax, prix, proprietaire, composition);
    }


    /**
     * Builder de la classe TrainMarchandises
     */
    public static class BuilderTrainMarchandise implements BuilderTrain {
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
         * @return le train de marchandises construit
         */
        public BuilderTrainMarchandise addProprietaire(EntrepriseFerroviaireCargo proprietaire){
            this.proprietaire = proprietaire;
            return this;
        }
        /**
         * Ajout d'un wagon de  liquides au train
         * @param wagon le wagon de  liquides
         * @return Le train de marchandise construit
         */
        public BuilderTrainMarchandise addWagon(WagonLiquides wagon){
            composition.add(wagon);
            return this;
        }

        /**
         * Ajout de plusieurs wagon liquides au train
         * @param wagonLiquides
         * @return
         */
        public BuilderTrainMarchandise addWagons(Collection <WagonLiquides> wagonLiquides){
            composition.addAll(wagonLiquides);
            return this;
        }

        @Override
        public BuilderTrainMarchandise addPrix(int prix) {
            this.prix = prix;
            return this;
        }

        @Override
        public BuilderTrainMarchandise addVitesseMax(int vitesseMax) {
            this.vitesseMax = vitesseMax;
            return this;
        }

        @Override
        public TrainMarchandises construire() {
            return new TrainMarchandises(this.vitesseMax,this.prix,this.proprietaire,this.composition);
        }
    }
}
