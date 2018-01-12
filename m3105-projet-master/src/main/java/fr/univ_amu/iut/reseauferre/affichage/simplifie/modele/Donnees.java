package fr.univ_amu.iut.reseauferre.affichage.simplifie.modele;

import fr.univ_amu.iut.reseauferre.traitement.Sillon;
import fr.univ_amu.iut.reseauferre.traitement.Trajet;
import fr.univ_amu.iut.reseauferre.traitement.controleur.AttribueurGlouton;
import fr.univ_amu.iut.reseauferre.traitement.controleur.AttribueurMeilleurTemps;
import fr.univ_amu.iut.reseauferre.traitement.controleur.Controleur;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaireAnimaux;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaireCargo;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviairePassagers;
import fr.univ_amu.iut.reseauferre.traitement.facturation.*;
import fr.univ_amu.iut.reseauferre.traitement.positions.Gare;
import fr.univ_amu.iut.reseauferre.traitement.positions.LigneFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.trains.Train;
import fr.univ_amu.iut.reseauferre.traitement.trains.TrainBetails;
import fr.univ_amu.iut.reseauferre.traitement.trains.TrainDechets;
import fr.univ_amu.iut.reseauferre.traitement.trains.TrainPassagers;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalTime;
import java.util.*;

public class Donnees {



    private static LocalTime heureActuel = LocalTime.of(0, 0);
    private static Property tempsActuel = new SimpleObjectProperty(heureActuel);

    public static Object getTempsActuel() {
        return tempsActuel.getValue();
    }

    public static Property tempsActuelProperty() {
        return tempsActuel;
    }

    private static Collection<Sillon> touslessillons = new ArrayList<>();
    private static Gare marseille = new Gare("Marseille");
    private static Gare paris = new Gare("Paris");
    private static Gare bordeaux = new Gare("Bordeaux");
    private static Gare clermontFerrand = new Gare("Clermont-Ferrand", true);
    private static Gare lille = new Gare("Lille");
    private static LigneFerroviaire parisBordeaux = new LigneFerroviaire(paris, bordeaux);
    private static LigneFerroviaire bordeauxMarseille = new LigneFerroviaire(bordeaux, marseille);
    private static LigneFerroviaire marseilleClermont = new LigneFerroviaire(marseille, clermontFerrand);
    private static LigneFerroviaire marseilleParis = new LigneFerroviaire(marseille, paris);
    private static LigneFerroviaire clermontParis = new LigneFerroviaire(clermontFerrand, paris);
    private static LigneFerroviaire parisLille = new LigneFerroviaire(paris, lille);
    private static EntrepriseFerroviairePassagers SNCF = new EntrepriseFerroviairePassagers("SNCF", 412280737);
    private static EntrepriseFerroviaireCargo Areva = new EntrepriseFerroviaireCargo("Areva", 305207169);
    private static EntrepriseFerroviaireAnimaux EquiTrain = new EntrepriseFerroviaireAnimaux("EquiTrain", 456123582);
    private static Collection<LigneFerroviaire> ligneFerroviairesDemandeMarseilleLille = new ArrayList<>();
    private static TrainPassagers tgv = new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(SNCF).addVitesseMax(380).construire();
    private static Trajet trajetMeilleurTemps = new Trajet(ligneFerroviairesDemandeMarseilleLille, tgv);
    private static Collection<LigneFerroviaire> ligneFerroviairesDemandeMarseilleParis = new ArrayList<>();
    private static TrainDechets trainDechets = new TrainDechets.BuilderTrainDechet().addPrix(5000).addProprietaire(Areva).addVitesseMax(380).construire();
    private static Trajet trajetMoinsCher = new Trajet(ligneFerroviairesDemandeMarseilleParis, trainDechets);
    private static Collection<LigneFerroviaire> ligneFerroviairesDemandeBordeauxClermont = new ArrayList<>();
    private static TrainBetails trainBetails = new TrainBetails.BuilderTrainBetail().addPrix(5000).addProprietaire(EquiTrain).addVitesseMax(380).construire();
    private static Trajet trajetGlouton = new Trajet(ligneFerroviairesDemandeBordeauxClermont, trainBetails);
    private static List<Trajet> allTrajet = new LinkedList<>();

    private static List<Tarification> tarifications = new ArrayList<>();
    private static List<Reduction> reductions = new ArrayList<>();
    private static ObservableList<Sillon> observableTousLesSillons = FXCollections.observableArrayList();
    private static ObservableList<Train> observableTrains = FXCollections.observableArrayList();
    private static ObservableList<Gare> observableGare = FXCollections.observableArrayList();
    private static ObservableList<EntrepriseFerroviaire> observableEntreprises = FXCollections.observableArrayList();

    static {
        touslessillons.addAll(parisBordeaux.genererSillonsParDefault(1000));
        touslessillons.addAll(parisLille.genererSillonsParDefault(500));
        touslessillons.addAll(bordeauxMarseille.genererSillonsParDefault(800));
        touslessillons.addAll(marseilleClermont.genererSillonsParDefault(700));
        touslessillons.addAll(marseilleParis.genererSillonsParDefault(1300));
        touslessillons.addAll(clermontParis.genererSillonsParDefault(500));

        allTrajet.add(trajetGlouton);
        allTrajet.add(trajetMeilleurTemps);
        allTrajet.add(trajetMoinsCher);

        ligneFerroviairesDemandeMarseilleLille.add(marseilleParis);
        ligneFerroviairesDemandeMarseilleLille.add(parisLille);

        ligneFerroviairesDemandeMarseilleParis.add(marseilleClermont);
        ligneFerroviairesDemandeMarseilleParis.add(clermontParis);

        ligneFerroviairesDemandeBordeauxClermont.add(bordeauxMarseille);
        ligneFerroviairesDemandeBordeauxClermont.add(marseilleClermont);

        Controleur controleur = new Controleur();
        controleur.attribuerSillon(trajetMeilleurTemps, new AttribueurMeilleurTemps(touslessillons));
        controleur.attribuerSillon(trajetMoinsCher, new AttribueurGlouton(touslessillons));
        controleur.attribuerSillon(trajetGlouton, new AttribueurGlouton(touslessillons));


        for (Trajet trajet : allTrajet) {
            trajet.deplacer(heureActuel);
        }
    }

    public LocalTime getHeureActuel() {
        return heureActuel;
    }

    static {
        tarifications.add(new TarificationLongueurTrain());
        tarifications.add(new TarificationNbTrain());
        tarifications.add(new TarificationSillon());

    }

    static {
        reductions.add(new ReductionFidelite());
        reductions.add(new ReductionSubvention());

    }

    public List<Trajet> getAllTrajet() {
        return allTrajet;
    }

    static {
        observableTousLesSillons.addAll(getAllSillons());
        observableTrains.addAll(getTrains());
        observableGare.addAll(getGares());
        HashSet<EntrepriseFerroviaire> hashSetEntreprise = new HashSet<>();
        for (Train train : getTrains()) {
            hashSetEntreprise.add(train.getProprietaire());
        }
        observableEntreprises.addAll(hashSetEntreprise);
    }

    public void mouvementSuivant() {
        heureActuel = heureActuel.plusMinutes(10);
        tempsActuel.setValue(heureActuel);
        for (Trajet trajet : allTrajet) {
            trajet.deplacer(heureActuel);
        }
    }

    public static Collection<Gare> getGares() {
        Collection<Gare> lesGares = new HashSet<>();
        for (Trajet trajet : allTrajet) {
            lesGares.addAll(trajet.getGaresTraversees());
        }
        return lesGares;
    }

    public static Collection<Sillon> getAllSillons() {
        return touslessillons;
    }

    public static Collection<Train> getTrains() {
        HashSet<Train> trains = new HashSet<>();
        for (Trajet trajet : allTrajet) {
            trains.add(trajet.getTrain());
        }
        return trains;
    }

    public static ObservableList<Sillon> getObservableTousLesSillons() {
        return observableTousLesSillons;
    }

    public static ObservableList<Train> getObservableTrains() {
        return observableTrains;
    }

    public static ObservableList<EntrepriseFerroviaire> getObservableEntreprises() {
        return observableEntreprises;
    }

    public static ObservableList<Gare> getObservableGare() {
        return observableGare;
    }

    public List<Tarification> getTarifications() {
        return tarifications;
    }

    public List<Reduction> getReductions() {
        return reductions;
    }
}
