package fr.univ_amu.iut.reseauferre.affichage.graphique;

import fr.univ_amu.iut.reseauferre.affichage.simplifie.modele.Donnees;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MenuPrincipal extends Application {
    private Donnees donnees = new Donnees();
    private Stage panneauArrivee = new Stage();
    private Stage panneauDepart = new Stage();
    private Stage etatDuReseau = new Stage();
    private Stage facturation = new Stage();

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private void onClickVueEtat() {
        try {
            if (!etatDuReseau.isShowing()) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EtatGeneral.fxml"));
                Parent root1 = fxmlLoader.load();
                etatDuReseau.setScene(new Scene(root1));
                etatDuReseau.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onClickPanneauArrivee() {
        try {
            if (!panneauArrivee.isShowing()) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PanneauTempsArrivees.fxml"));
                Parent root1 = fxmlLoader.load();
                panneauArrivee.setScene(new Scene(root1));
                panneauArrivee.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onClickAvancer10Minutes() {
        donnees.mouvementSuivant();
    }

    @FXML
    private void onClickPanneauDepart() {
        try {

            if (!panneauDepart.isShowing()) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PanneauTempsDepart.fxml"));
                Parent root1 = fxmlLoader.load();
                panneauDepart.setScene(new Scene(root1));
                panneauDepart.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onClickAPropos() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("A propos");
        alert.setHeaderText("Projet M3105 - Groupe 3 Année 2");
        alert.setContentText("HyperFrisette par Florian Barbaouat, Nicolas Brault, Kévin Colombani, Edouard Lebeau et Guilhem Pech ");

        alert.showAndWait();
    }

    @FXML
    private void onClickFacturation() {
        try {
            if (!facturation.isShowing()) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Facturation.fxml"));
                Parent root1 = fxmlLoader.load();
                facturation.setScene(new Scene(root1));
                facturation.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onClickQuitter() {
        System.exit(0);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            final URL url = getClass().getResource("MenuPrincipal.fxml");
            final FXMLLoader fxmlLoader = new FXMLLoader(url);
            final VBox root = fxmlLoader.load();
            final Scene scene = new Scene(root);

            primaryStage.setScene(scene);
        } catch (IOException ex) {
            System.err.println("Erreur au chargement: " + ex);
        }
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        primaryStage.setTitle("HyperFrisette");
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
