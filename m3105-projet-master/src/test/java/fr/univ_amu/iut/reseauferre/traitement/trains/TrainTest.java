package fr.univ_amu.iut.reseauferre.traitement.trains;

import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviairePassagers;
import fr.univ_amu.iut.reseauferre.traitement.wagons.WagonPassagers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

public class TrainTest {

    private static Collection<WagonPassagers> wagonPassagers = new ArrayList<>();
    static {
        wagonPassagers.add(new WagonPassagers());
        wagonPassagers.add(new WagonPassagers());
    }
    private static Train train = new TrainPassagers.BuilderTrainPassagers().addPrix(5000)
            .addProprietaire(new EntrepriseFerroviairePassagers("SNCF",564123547))
            .addWagons(wagonPassagers)
            .addVitesseMax(380)
            .construire();


    @Test
    public void deplacer() throws Exception {
        //Todo a proper test
    }

    @Test
    public void getDimensions() throws Exception {
        assertTrue(train.getDimensions() == 2);
    }

    @Test
    public void getCout() throws Exception {
        assertTrue(train.getCout() == 5000);
    }

    @Test
    public void getVitesseMax() throws Exception {
        assertTrue(train.getVitesseMax() == 380);
    }

    @Test
    public void getProprietaire() throws Exception {
        assertTrue(train.getProprietaire().getNom().equals("SNCF") &&
                            train.getProprietaire().getSiren() == 564123547);
    }

    @Test
    public void getComposition() throws Exception {
        assertTrue(train.getComposition().equals(wagonPassagers));
    }

}