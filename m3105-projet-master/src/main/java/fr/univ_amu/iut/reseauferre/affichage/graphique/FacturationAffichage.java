package fr.univ_amu.iut.reseauferre.affichage.graphique;


import fr.univ_amu.iut.reseauferre.affichage.simplifie.modele.Donnees;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.facturation.Facturation;
import fr.univ_amu.iut.reseauferre.traitement.trains.Train;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.HashSet;


public class FacturationAffichage {
    private Donnees donnees = new Donnees();
    @FXML
    private TableView<EntrepriseFerroviaire> facturation;

    @FXML
    private TableColumn<EntrepriseFerroviaire, EntrepriseFerroviaire> facturationEntreprise;

    @FXML
    private TableColumn<EntrepriseFerroviaire, Double> facturationMontant;

    @FXML
    private void initialize() {
        ObservableList<EntrepriseFerroviaire> entrepriseFerroviaires = FXCollections.observableArrayList();
        HashSet<EntrepriseFerroviaire> entrepriseFerroviaireHashSet = new HashSet<>();
        for (Train train : Donnees.getTrains()) {
            entrepriseFerroviaireHashSet.add(train.getProprietaire());
        }
        entrepriseFerroviaires.setAll(entrepriseFerroviaireHashSet);
        facturation.setItems(entrepriseFerroviaires);

        facturationEntreprise.setCellValueFactory(new PropertyValueFactory<>("nom"));
        facturationMontant.setCellValueFactory(cell -> {
            Facturation facturation = new Facturation(cell.getValue());
            Double result = facturation.getCoutTotal(donnees.getTarifications(), donnees.getReductions());
            return new ReadOnlyObjectWrapper<>(result);
        });

    }

}
