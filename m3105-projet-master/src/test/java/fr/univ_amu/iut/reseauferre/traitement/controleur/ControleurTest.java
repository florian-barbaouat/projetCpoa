package fr.univ_amu.iut.reseauferre.traitement.controleur;

import fr.univ_amu.iut.reseauferre.traitement.positions.Gare;
import fr.univ_amu.iut.reseauferre.traitement.positions.LigneFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.Sillon;
import fr.univ_amu.iut.reseauferre.traitement.Trajet;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviairePassagers;
import fr.univ_amu.iut.reseauferre.traitement.trains.TrainPassagers;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class ControleurTest {
    private static Collection<Sillon> touslessillons = new ArrayList<>();
    private static Collection<LigneFerroviaire> ligneFerroviairesDemande = new ArrayList<>();
    private static Trajet trajetMeilleurTemps    = new Trajet(ligneFerroviairesDemande, new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(new EntrepriseFerroviairePassagers("SNCF", 564123547)).addVitesseMax(380).construire());
    private static Trajet trajetMoinsCher        = new Trajet(ligneFerroviairesDemande, new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(new EntrepriseFerroviairePassagers("SNCF", 564123547)).addVitesseMax(380).construire());
    private static Trajet trajetGlouton          = new Trajet(ligneFerroviairesDemande, new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(new EntrepriseFerroviairePassagers("SNCF", 564123547)).addVitesseMax(380).construire());

    private static Trajet trajetMeilleurTempsTest = new Trajet(ligneFerroviairesDemande, new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(new EntrepriseFerroviairePassagers("SNCF", 564123547)).addVitesseMax(380).construire());
    private static Trajet trajetMoinsCherTest = new Trajet(ligneFerroviairesDemande, new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(new EntrepriseFerroviairePassagers("SNCF", 564123547)).addVitesseMax(380).construire());
    private static Trajet trajetGloutonTest = new Trajet(ligneFerroviairesDemande, new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(new EntrepriseFerroviairePassagers("SNCF", 564123547)).addVitesseMax(380).construire());

    static {
        Gare marseille = new Gare("Marseille");
        Gare paris = new Gare("Paris");
        Gare bordeaux = new Gare("Bordeaux");
        Gare lille = new Gare("Lille");

        touslessillons.add(new Sillon(100, LocalTime.of(9, 00), new LigneFerroviaire(paris, bordeaux)));
        touslessillons.add(new Sillon(1000, LocalTime.of(14, 00), new LigneFerroviaire(paris, bordeaux)));
        touslessillons.add(new Sillon(200, LocalTime.of(10, 00), new LigneFerroviaire(paris, bordeaux)));
        touslessillons.add(new Sillon(2000, LocalTime.of(13, 00), new LigneFerroviaire(paris, bordeaux)));
        touslessillons.add(new Sillon(300, LocalTime.of(8, 00), new LigneFerroviaire(paris, bordeaux)));
        touslessillons.add(new Sillon(1300, LocalTime.of(15, 00), new LigneFerroviaire(paris, bordeaux)));
        touslessillons.add(new Sillon(500, LocalTime.of(11, 00), new LigneFerroviaire(paris, bordeaux)));
        touslessillons.add(new Sillon(2200, LocalTime.of(12, 00), new LigneFerroviaire(paris, bordeaux)));

        touslessillons.add(new Sillon(2000, LocalTime.of(16, 00), new LigneFerroviaire(bordeaux, marseille)));
        touslessillons.add(new Sillon(1500, LocalTime.of(15, 00), new LigneFerroviaire(bordeaux, marseille)));
        touslessillons.add(new Sillon(700, LocalTime.of(8, 00), new LigneFerroviaire(bordeaux, marseille)));
        touslessillons.add(new Sillon(200, LocalTime.of(18, 00), new LigneFerroviaire(bordeaux, marseille)));
        touslessillons.add(new Sillon(500, LocalTime.of(11, 00), new LigneFerroviaire(bordeaux, marseille)));

        touslessillons.add(new Sillon(500, LocalTime.of(23, 00), new LigneFerroviaire(marseille, lille)));
        touslessillons.add(new Sillon(1200, LocalTime.of(20, 00), new LigneFerroviaire(marseille, lille)));
        touslessillons.add(new Sillon(1000, LocalTime.of(16, 00), new LigneFerroviaire(marseille, lille)));
        touslessillons.add(new Sillon(500, LocalTime.of(21, 00), new LigneFerroviaire(marseille, lille)));
        touslessillons.add(new Sillon(1200, LocalTime.of(18, 00), new LigneFerroviaire(marseille, lille)));
        touslessillons.add(new Sillon(1000, LocalTime.of(14, 00), new LigneFerroviaire(marseille, lille)));

        ligneFerroviairesDemande.add(new LigneFerroviaire(paris, bordeaux));
        ligneFerroviairesDemande.add(new LigneFerroviaire(bordeaux, marseille));
        ligneFerroviairesDemande.add(new LigneFerroviaire(marseille, lille));

        Controleur controleur = new Controleur();

        controleur.attribuerSillon(trajetMeilleurTemps, new AttribueurMeilleurTemps(touslessillons));
        trajetMeilleurTempsTest.addSillonEmprunte(new Sillon(1000, LocalTime.of(14, 00), new LigneFerroviaire(paris, bordeaux)));
        trajetMeilleurTempsTest.addSillonEmprunte(new Sillon(2000, LocalTime.of(16, 00), new LigneFerroviaire(bordeaux, marseille)));
        trajetMeilleurTempsTest.addSillonEmprunte(new Sillon(1200, LocalTime.of(18, 00), new LigneFerroviaire(marseille, lille)));
        for (Sillon sillon:trajetMeilleurTempsTest.getSillonsEmprunte()){
            sillon.setDisponible(false);
        }

        controleur.attribuerSillon(trajetMoinsCher, new AttribueurMoinsCher(touslessillons));
        trajetMoinsCherTest.addSillonEmprunte(new Sillon(100, LocalTime.of(9, 00), new LigneFerroviaire(paris, bordeaux)));
        trajetMoinsCherTest.addSillonEmprunte(new Sillon(200, LocalTime.of(18, 00), new LigneFerroviaire(bordeaux, marseille)));
        trajetMoinsCherTest.addSillonEmprunte(new Sillon(500, LocalTime.of(23, 00), new LigneFerroviaire(marseille, lille)));
        for (Sillon sillon:trajetMoinsCherTest.getSillonsEmprunte()){
            sillon.setDisponible(false);
        }

        controleur.attribuerSillon(trajetGlouton, new AttribueurGlouton(touslessillons));
        trajetGloutonTest.addSillonEmprunte(new Sillon(300, LocalTime.of(8, 00), new LigneFerroviaire(paris, bordeaux)));
        trajetGloutonTest.addSillonEmprunte(new Sillon(500, LocalTime.of(11, 00), new LigneFerroviaire(bordeaux, marseille)));
        trajetGloutonTest.addSillonEmprunte(new Sillon(1000, LocalTime.of(14, 00), new LigneFerroviaire(marseille, lille)));
        for (Sillon sillon:trajetGloutonTest.getSillonsEmprunte()){
            sillon.setDisponible(false);
        }
    }

    @Test
    public void AttribueurMeilleurTemps() throws Exception {
        assertTrue(trajetMeilleurTemps.getSillonsEmprunte().containsAll(trajetMeilleurTempsTest.getSillonsEmprunte()));
    }

    @Test
    public void AttribueurMoinsCher() throws Exception {
        assertTrue(trajetMoinsCher.getSillonsEmprunte().containsAll(trajetMoinsCherTest.getSillonsEmprunte()));
    }

    @Test
    public void AttribueurGlouton() throws Exception {
        assertTrue(trajetGlouton.getSillonsEmprunte().containsAll(trajetGloutonTest.getSillonsEmprunte()));
    }
}