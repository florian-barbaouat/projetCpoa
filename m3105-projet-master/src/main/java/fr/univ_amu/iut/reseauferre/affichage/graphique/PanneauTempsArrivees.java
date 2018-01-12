package fr.univ_amu.iut.reseauferre.affichage.graphique;

import fr.univ_amu.iut.reseauferre.affichage.graphique.wrapperAffichage.WrapperAffichageTemps;
import fr.univ_amu.iut.reseauferre.affichage.simplifie.modele.Donnees;
import fr.univ_amu.iut.reseauferre.traitement.Sillon;
import fr.univ_amu.iut.reseauferre.traitement.Trajet;
import fr.univ_amu.iut.reseauferre.traitement.positions.Gare;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalTime;


public class PanneauTempsArrivees {
    @FXML
    TableView<WrapperAffichageTemps> tableView;
    @FXML
    TableColumn<WrapperAffichageTemps, Gare> colonneGare;
    @FXML
    TableColumn<WrapperAffichageTemps, LocalTime> colonneDepart;
    @FXML
    TableColumn<WrapperAffichageTemps, Gare> colonneProvenance;
    @FXML
    TableColumn<WrapperAffichageTemps, Gare> colonneDestination;
    private Donnees donnees = new Donnees();
    private ObservableList<Sillon> sillons = FXCollections.observableArrayList();

    private static LocalTime tempsRestant(LocalTime heureGare, LocalTime heureActuelle) {
        return heureGare.minusHours(heureActuelle.getHour()).minusMinutes(heureActuelle.getMinute());
    }

    @FXML
    public void initialize() {

        ObservableList<WrapperAffichageTemps> affichage = FXCollections.observableArrayList();
        Donnees.tempsActuelProperty().addListener((observable, oldValue, newValue) -> {
            generateWrapper(affichage);
            tableView.refresh();
        });

        generateWrapper(affichage);

        tableView.setItems(affichage);
        colonneGare.setCellValueFactory(new PropertyValueFactory<WrapperAffichageTemps, Gare>("gare"));
        colonneDepart.setCellValueFactory(new PropertyValueFactory<>("temps"));
        colonneDestination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        colonneProvenance.setCellValueFactory(new PropertyValueFactory<>("provenance"));
    }

    private void generateWrapper(ObservableList<WrapperAffichageTemps> affichage) {
        affichage.removeAll(affichage);
        for (Trajet trajet : donnees.getAllTrajet()) {
            for (Sillon sillon : trajet.getSillonsEmprunte()) {
                affichage.add(new WrapperAffichageTemps(sillon.getLigneFerroviaire().getArrive(), tempsRestant(sillon.getHeure().plusHours(1), donnees.getHeureActuel()), trajet.getDepart(), trajet.getDestination()));
            }
        }
    }
}
