package fr.univ_amu.iut.reseauferre.traitement.trains;


import fr.univ_amu.iut.reseauferre.traitement.Sillon;
import fr.univ_amu.iut.reseauferre.traitement.Trajet;
import fr.univ_amu.iut.reseauferre.traitement.controleur.*;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviairePassagers;
import fr.univ_amu.iut.reseauferre.traitement.facturation.*;
import fr.univ_amu.iut.reseauferre.traitement.positions.Gare;
import fr.univ_amu.iut.reseauferre.traitement.positions.LigneFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.wagons.WagonPassagers;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by edouardlebeau on 16/11/2017.
 */
public class TarificationTest {
    private static Collection<WagonPassagers> wagonPassagers = new ArrayList<>();
    static {
        wagonPassagers.add(new WagonPassagers());
        wagonPassagers.add(new WagonPassagers());

    }
    private static Collection<LigneFerroviaire> lignesDemandes = new ArrayList<>();


    private static Collection<Sillon> touslessillons = new ArrayList<>();

    static {
        Gare marseille = new Gare("Marseille",true);
        Gare paris = new Gare("Paris", false);
        Gare bordeaux = new Gare("Bordeaux", true);
        Gare lille = new Gare("Lille", false);

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

        lignesDemandes.add(new LigneFerroviaire(paris, bordeaux));
        lignesDemandes.add(new LigneFerroviaire(bordeaux, marseille));
        lignesDemandes.add(new LigneFerroviaire(marseille, lille));
    }


    private static  EntrepriseFerroviairePassagers entrepriseFerroviaire = new EntrepriseFerroviairePassagers("SNCF",564123547 );
    private static Train train = new TrainPassagers.BuilderTrainPassagers().addPrix(5000)
            .addProprietaire(entrepriseFerroviaire)
            .addWagons(wagonPassagers)
            .addVitesseMax(380)
            .construire();
    private static Train train1 = new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(entrepriseFerroviaire).construire();
    private static Train train2 = new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(entrepriseFerroviaire).construire();
   /* private static Train train3 = new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(entrepriseFerroviaire).construire();
    private static Train train4 = new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(entrepriseFerroviaire).construire();
    private static Train train5 = new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(entrepriseFerroviaire).construire();
    private static Train train6 = new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(entrepriseFerroviaire).construire();
    private static Train train7 = new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(entrepriseFerroviaire).construire();
    private static Train train8 = new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(entrepriseFerroviaire).construire();
    private static Train train9 = new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(entrepriseFerroviaire).construire();
    private static Train train10 = new TrainPassagers.BuilderTrainPassagers().addPrix(5000).addProprietaire(entrepriseFerroviaire).construire();*/


    private static Controleur controleur = new Controleur();
    private static Trajet trajet = new Trajet(lignesDemandes, train);
    private static Trajet trajet1 = new Trajet(lignesDemandes, train1);
    private static Trajet trajet2 = new Trajet(lignesDemandes, train2);
    /*private static Trajet trajet3 = new Trajet(lignesDemandes, train3);
    private static Trajet trajet4 = new Trajet(lignesDemandes, train4);
    private static Trajet trajet5 = new Trajet(lignesDemandes, train5);
    private static Trajet trajet6 = new Trajet(lignesDemandes, train6);
    private static Trajet trajet7 = new Trajet(lignesDemandes, train7);
    private static Trajet trajet8 = new Trajet(lignesDemandes, train8);
    private static Trajet trajet9 = new Trajet(lignesDemandes, train9);*/


    static {

        controleur.attribuerSillon(trajet, new AttribueurGlouton(touslessillons));
        controleur.attribuerSillon(trajet1, new AttribueurMoinsCher(touslessillons));
        controleur.attribuerSillon(trajet2, new AttribueurMeilleurTemps(touslessillons));
        entrepriseFerroviaire.addTrajet(trajet);
        entrepriseFerroviaire.addTrajet(trajet1);
        entrepriseFerroviaire.addTrajet(trajet2);
        /*entrepriseFerroviaire.addTrajet(trajet3);
        entrepriseFerroviaire.addTrajet(trajet4);
        entrepriseFerroviaire.addTrajet(trajet5);
        entrepriseFerroviaire.addTrajet(trajet6);
        entrepriseFerroviaire.addTrajet(trajet7);
        entrepriseFerroviaire.addTrajet(trajet8);
        entrepriseFerroviaire.addTrajet(trajet9);*/


    }




    private static List<Tarification> tarifications = new ArrayList<>();
    static {
        tarifications.add(new TarificationLongueurTrain());
        tarifications.add(new TarificationNbTrain());
        tarifications.add(new TarificationSillon());

    }

    private static List<Reduction> reductions = new ArrayList<>();
    static {
        reductions.add(new ReductionFidelite());
        reductions.add(new ReductionSubvention());

    }




    @Test
    public void getFactureEntreprise() throws Exception{
        Facturation facturation = new Facturation(entrepriseFerroviaire, tarifications, reductions);

        System.out.println("La facture de " + entrepriseFerroviaire.getNom() + " sera de : " + facturation.getCoutTotal(tarifications,reductions) + " €");
        assertEquals(25100.0, 25100.0);

    }
}
