package fr.univ_amu.iut.reseauferre.traitement.trains;

import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaireCargo;
import fr.univ_amu.iut.reseauferre.traitement.wagons.Wagon;
import fr.univ_amu.iut.reseauferre.traitement.wagons.WagonDechetLiquides;
import fr.univ_amu.iut.reseauferre.traitement.wagons.WagonDechetNucleaire;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Train de déchet instance de train
 */
public class TrainDechets extends Train {

    /**
     * constructeur de la class Trains dechets
     * @param vitesseMax  la vitesse macimale du  train
     * @param prix          le prix du train
     * @param proprietaire  propriétaire du train
     * @param composition   Composition du train
     */
    private TrainDechets(int vitesseMax, int prix, EntrepriseFerroviaire proprietaire, Collection<Wagon> composition) {
        super(vitesseMax, prix, proprietaire, composition);
    }


    /**
     * Builder de la classe Train déchet
     */
    public static class BuilderTrainDechet implements BuilderTrain {
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
         * @return le train Dechet construit
         */
        public BuilderTrainDechet addProprietaire(EntrepriseFerroviaireCargo proprietaire){
            this.proprietaire = proprietaire;
            return this;
        }

        /**
         * Ajout d'un wagon de déchet nucléaire au train
         * @param wagon le wagon de déchet nucléaire
         * @return Le train dechet construit
         */
        public BuilderTrainDechet addWagon(WagonDechetNucleaire wagon){
            composition.add(wagon);
            return this;
        }
        /**
         * Ajout d'un wagon de déchet liquides au train
         * @param wagon le wagon de déchet liquides
         * @return Le train dechet construit
         */
        public BuilderTrainDechet addWagon(WagonDechetLiquides wagon){
            composition.add(wagon);
            return this;
        }

        /**
         * Ajout d'une collection de wagons de déchets liquides au train
         * @param wagonDechetLiquides la collection de wagons
         * @return le train déchet construit
         */
        public BuilderTrainDechet addWagons(Collection<WagonDechetLiquides> wagonDechetLiquides){
            composition.addAll(wagonDechetLiquides);
            return this;
        }

        @Override
        public BuilderTrainDechet addPrix(int prix) {
            this.prix = prix;
            return this;
        }

        @Override
        public BuilderTrainDechet addVitesseMax(int vitesseMax) {
            this.vitesseMax = vitesseMax;
            return this;
        }

        @Override
        public TrainDechets construire() {
            return new TrainDechets(this.vitesseMax,this.prix,this.proprietaire,this.composition);
        }
    }
}
