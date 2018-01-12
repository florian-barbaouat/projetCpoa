package fr.univ_amu.iut.reseauferre.affichage.graphique;

import fr.univ_amu.iut.reseauferre.affichage.simplifie.modele.Donnees;
import fr.univ_amu.iut.reseauferre.traitement.Sillon;
import fr.univ_amu.iut.reseauferre.traitement.Trajet;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.entreprisesFerroviaire.EntrepriseFerroviaireAnimaux;
import fr.univ_amu.iut.reseauferre.traitement.positions.Gare;
import fr.univ_amu.iut.reseauferre.traitement.positions.LigneFerroviaire;
import fr.univ_amu.iut.reseauferre.traitement.positions.Position;
import fr.univ_amu.iut.reseauferre.traitement.trains.Train;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Optional;

public class EtatGeneral {
    private Donnees donnees = new Donnees();

    @FXML
    private TableView<Gare> tableviewGare;

    @FXML
    private TableColumn<Gare, Gare> viewGareGare;

    @FXML
    private TableColumn<Gare, Boolean> viewGareSubventionnees;

    private ObservableList<Gare> allGares = Donnees.getObservableGare();
    @FXML
    private TableView<EntrepriseFerroviaire> tableViewEntrepriseF;
    @FXML
    private TableColumn<EntrepriseFerroviaire, String> viewEntrepriseNom;
    @FXML
    private TableColumn<EntrepriseFerroviaire, Integer> viewEntrepriseSiren;
    @FXML
    private TableView<Train> TableViewTrain;
    @FXML
    private TableColumn<Train, Position> positionTrain;
    @FXML
    private TableColumn<Train, EntrepriseFerroviaire> proprietaireTrain;
    @FXML
    private TableColumn<Train, Double> prixTrain;
    @FXML
    private TableColumn<Train, Integer> vitesseMaxTrain;
    @FXML
    private TableColumn<Train, String> typeTrain;
    @FXML
    private TableView<LigneFerroviaire> ligneFerro;
    @FXML
    private TableColumn<LigneFerroviaire, Gare> ligneDepart;
    @FXML
    private TableColumn<LigneFerroviaire, Gare> ligneArrive;
    @FXML
    private TableView<Trajet> trajetTableView;
    @FXML
    private TableColumn<Trajet, Train> trajetsTrain;
    @FXML
    private TableColumn<Trajet, Sillon> sillonsTrajet;
    @FXML
    private TableColumn<Trajet, LigneFerroviaire> lignesTrajet;
    private ObservableList<Sillon> sillons = FXCollections.observableArrayList();
    @FXML
    private TableView<Sillon> sillonTableView;
    @FXML
    private TableColumn<Sillon, LocalTime> sillonsHeure;
    @FXML
    private TableColumn<Sillon, Boolean> sillonDisponible;
    @FXML
    private TableColumn<Sillon, LigneFerroviaire> sillonLigne;
    @FXML
    private TableColumn<Sillon, Double> sillonCoutDUtilisation;
    private ObservableList<Sillon> tousLesSillons = FXCollections.observableArrayList();

    private void initGares() {

        tableviewGare.setItems(allGares);
        tableviewGare.setEditable(true);
        viewGareGare.setCellValueFactory(new PropertyValueFactory<>("ville"));
        viewGareGare.setEditable(true);

        viewGareGare.setOnEditStart(event -> {
            TextInputDialog dialog = new TextInputDialog(event.getRowValue().getVille());
            dialog.setTitle("Modifier une gare");
            dialog.setHeaderText("Modifier une gare");
            dialog.setContentText("Entrez le nom de la gare");
            dialog.setOnCloseRequest(event1 -> {
                if (dialog.getResult() != null) {
                    event.getRowValue().setVille(dialog.getResult());
                    tableviewGare.refresh();
                }
            });
            dialog.show();
        });

        tableviewGare.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                allGares.add(new Gare("Nouvelle Gare"));
            }
        });


        viewGareSubventionnees.setCellValueFactory(cell -> {
            boolean p = cell.getValue().getSubvention();
            SimpleBooleanProperty simpleBooleanProperty = new SimpleBooleanProperty(p);
            simpleBooleanProperty.addListener((observable, oldValue, newValue) -> {
                cell.getValue().setSubvention(newValue);
            });
            return simpleBooleanProperty;
        });
        viewGareSubventionnees.setCellFactory(CheckBoxTableCell.forTableColumn(viewGareSubventionnees));
        viewGareSubventionnees.setEditable(true);

    }

    private void initEntreprisesFerroviaires() {
        ObservableList<EntrepriseFerroviaire> entrepriseFerroviaires = Donnees.getObservableEntreprises();
        tableviewGare.setEditable(true);
        viewEntrepriseSiren.setEditable(true);
        viewEntrepriseNom.setEditable(true);

        tableViewEntrepriseF.setItems(entrepriseFerroviaires);
        viewEntrepriseNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        viewEntrepriseSiren.setCellValueFactory(new PropertyValueFactory<>("siren"));

        viewEntrepriseNom.setOnEditStart(event -> {
            TextInputDialog dialog = new TextInputDialog(event.getRowValue().getNom());
            dialog.setTitle("Modifier une entreprise");
            dialog.setHeaderText("Modifier le nom d'une entreprise");
            dialog.setContentText("Entrez le nom de l'entreprise");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(nom -> {
                event.getRowValue().setNom(nom);
                tableViewEntrepriseF.refresh();
            });
            dialog.setOnCloseRequest(event1 -> tableViewEntrepriseF.refresh());
        });

        viewEntrepriseSiren.setOnEditStart(event -> {
            TextInputDialog dialog = new TextInputDialog(String.valueOf(event.getRowValue().getSiren()));
            dialog.setTitle("Modifier une entreprise");
            dialog.setHeaderText("Modifier le numéro SIREN de l'entreprise");
            dialog.setContentText("Entrez le numéro SIREN de l'entreprise");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(nom -> {
                try {
                    event.getRowValue().setSiren(Integer.parseInt(nom));
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText("Numéro SIREN incorrect");
                    alert.setContentText("Numéro SIREN non conforme!");
                    alert.showAndWait();
                }
            });
            dialog.setOnCloseRequest(event1 -> tableViewEntrepriseF.refresh());
        });

        tableViewEntrepriseF.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                entrepriseFerroviaires.add(new EntrepriseFerroviaireAnimaux("Nouvelle Companie", 0));
            }
        });

    }

    private void initTrains() {
        ObservableList<Train> trains = Donnees.getObservableTrains();
        TableViewTrain.setItems(trains);
        proprietaireTrain.setCellValueFactory(new PropertyValueFactory<>("proprietaire"));
        positionTrain.setCellValueFactory(new PropertyValueFactory<>("position"));
        prixTrain.setCellValueFactory(new PropertyValueFactory<>("prix"));
        vitesseMaxTrain.setCellValueFactory(new PropertyValueFactory<>("vitesseMax"));
        typeTrain.setCellValueFactory(new PropertyValueFactory<>("type"));

        prixTrain.setOnEditStart(event -> {
            TextInputDialog dialog = new TextInputDialog(String.valueOf(event.getRowValue().getPrix()));
            dialog.setTitle("Modifier un train");
            dialog.setHeaderText("Modifier le prix d'un");
            dialog.setContentText("Entrez le nouveau prix");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(nom -> {
                try {
                    event.getRowValue().setPrix(Integer.parseInt(nom));
                    TableViewTrain.refresh();
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText("Prix incorrect");
                    alert.showAndWait();
                }
            });
            dialog.setOnCloseRequest(event1 -> TableViewTrain.refresh());
        });


        vitesseMaxTrain.setOnEditStart(event -> {
            TextInputDialog dialog = new TextInputDialog(String.valueOf(event.getRowValue().getVitesseMax()));
            dialog.setTitle("Modifier un train");
            dialog.setHeaderText("Modifier la vitesse max d'un train");
            dialog.setContentText("Entrez la nouvelle vitesse");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(nom -> {
                try {
                    event.getRowValue().setVitesseMax(Integer.parseInt(nom));
                    TableViewTrain.refresh();
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText("Vitesse incorrecte");
                    alert.showAndWait();
                }
            });
            dialog.setOnCloseRequest(event1 -> TableViewTrain.refresh());
        });

        proprietaireTrain.setOnEditStart(event -> {
            ChoiceDialog<EntrepriseFerroviaire> dialog = new ChoiceDialog<>(event.getRowValue().getProprietaire(), Donnees.getObservableEntreprises());
            dialog.setTitle("Choisir Propriétaire");
            dialog.setHeaderText("Choisissez le propriétaire de ce train //// NE FONCTIONNE PAS");
            dialog.setContentText("Propriétaire");
            dialog.show();

        });

    }

    private void initLignesFerroviaire() {
        ObservableList<LigneFerroviaire> ligneFerroviaires = FXCollections.observableArrayList();
        HashSet<LigneFerroviaire> setLignes = new HashSet<>();
        for (Sillon sillon : Donnees.getAllSillons()) {
            setLignes.add(sillon.getLigneFerroviaire());
        }
        ligneFerroviaires.addAll(setLignes);
        ligneFerro.setItems(ligneFerroviaires);

        ligneDepart.setCellValueFactory(new PropertyValueFactory<>("depart"));
        ligneArrive.setCellValueFactory(new PropertyValueFactory<>("arrive"));
    }

    private void initTrajet() {

        sillons.addAll(Donnees.getAllSillons());
        ObservableList<Trajet> trajets = FXCollections.observableArrayList();
        trajets.addAll(donnees.getAllTrajet());
        trajetTableView.setItems(trajets);

        trajetsTrain.setCellValueFactory(new PropertyValueFactory<>("train"));
        trajetsTrain.setEditable(true);
        sillonsTrajet.setCellValueFactory(new PropertyValueFactory<>("sillonsEmprunte"));
        sillonsTrajet.setEditable(true);
        lignesTrajet.setCellValueFactory(new PropertyValueFactory<>("ligneFerroviairesDemande"));
    }

    private void initSillons() {
        tousLesSillons.addAll(Donnees.getAllSillons());
        sillonTableView.setItems(tousLesSillons);
        sillonsHeure.setCellValueFactory(new PropertyValueFactory<>("heure"));
        sillonLigne.setCellValueFactory(new PropertyValueFactory<>("ligneFerroviaire"));
        sillonDisponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));
        sillonCoutDUtilisation.setCellValueFactory(new PropertyValueFactory<>("coutUtilisation"));
        sillonDisponible.setCellValueFactory(cell -> {
            boolean p = cell.getValue().getDisponible();
            return new ReadOnlyBooleanWrapper(p);
        });
        sillonDisponible.setCellFactory(CheckBoxTableCell.forTableColumn(sillonDisponible));

        sillonCoutDUtilisation.setOnEditStart(event -> {
            TextInputDialog dialog = new TextInputDialog(String.valueOf(event.getRowValue().getCoutUtilisation()));
            dialog.setTitle("Modifier un sillon");
            dialog.setHeaderText("Modifier le prix d'un sillon");
            dialog.setContentText("Entrez le nouveau prix");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(nom -> {
                try {
                    event.getRowValue().setCoutUtilisation(Integer.parseInt(nom));
                    sillonTableView.refresh();
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning");
                    alert.setHeaderText("Prix incorrecte");
                    alert.showAndWait();
                }
            });
            dialog.setOnCloseRequest(event1 -> sillonTableView.refresh());
        });

    }

    @FXML
    private void initialize() {

        initGares();
        initEntreprisesFerroviaires();
        initTrains();
        initLignesFerroviaire();
        initTrajet();
        initSillons();
    }
}
