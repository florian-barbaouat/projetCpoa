package fr.univ_amu.iut.reseauferre.affichage.graphique.wrapperAffichage;

import fr.univ_amu.iut.reseauferre.traitement.positions.Gare;

import java.time.LocalTime;

public class WrapperAffichageTemps {
    Gare gare;
    LocalTime temps;
    Gare provenance;
    Gare destination;

    public WrapperAffichageTemps(Gare gare, LocalTime temps, Gare provenance, Gare destination) {
        this.gare = gare;
        this.temps = temps;
        this.provenance = provenance;
        this.destination = destination;
    }

    public Gare getGare() {
        return gare;
    }

    public void setGare(Gare gare) {
        this.gare = gare;
    }

    public LocalTime getTemps() {
        return temps;
    }

    public void setTemps(LocalTime temps) {
        this.temps = temps;
    }

    public Gare getProvenance() {
        return provenance;
    }

    public void setProvenance(Gare provenance) {
        this.provenance = provenance;
    }

    public Gare getDestination() {
        return destination;
    }

    public void setDestination(Gare destination) {
        this.destination = destination;
    }
}
