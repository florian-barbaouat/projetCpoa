package fr.univ_amu.iut;


import fr.univ_amu.iut.reseauferre.affichage.graphique.MenuPrincipal;
import fr.univ_amu.iut.reseauferre.affichage.simplifie.modele.Donnees;
import fr.univ_amu.iut.reseauferre.affichage.simplifie.vue.AfficheurVue;
import fr.univ_amu.iut.reseauferre.affichage.simplifie.vue.EtatActuel;
import fr.univ_amu.iut.reseauferre.affichage.simplifie.vue.TableauArrivee;
import fr.univ_amu.iut.reseauferre.affichage.simplifie.vue.TableauDepart;

import java.util.Scanner;



public class ApplicationHyperFrisette {
    private static String aide = "Tapez 'Etat Actuel' pour avoir une vue générale de l'état du réseau \n"
            +  "Tapez 'Temps d'arrive estime' pour avoir une vue affichant les temps d'arrivé estimé dans les gares des différents trains   \n"
            +  "Tapez 'Temps de depart estime' pour avoir une vue affichant les temps de départ estimé dans les gares des différents trains \n"
            +  "Tapez 'quitter' pour fermer le programme. \n"
            +  "Tapez 'Suivant' pour avancer de 10 minutes \n";

	public static void main(String[] args) {
        if (args.length == 0) {
            MenuPrincipal.main(args);
        } else {
            System.out.println(aide);
            Donnees donneesStatiques = new Donnees();
            AfficheurVue afficheurVue = new AfficheurVue(donneesStatiques);
            Scanner entreesUtilisateurs = new Scanner(System.in);

            Boolean continuer = true;
            while (true) {
                switch (entreesUtilisateurs.nextLine()) {
                    case "Etat Actuel":
                        afficheurVue.afficher(new EtatActuel());
                        break;
                    case "Temps d'arrivé estimé":
                        afficheurVue.afficher(new TableauArrivee());
                        break;
                    case "Temps de départ estimé":
                        afficheurVue.afficher(new TableauDepart());
                        break;
                    case "Suivant":
                        donneesStatiques.mouvementSuivant();
                        System.out.println("~10 Minutes plus tard~ (" + donneesStatiques.getHeureActuel() + ")");
                        break;
                    case "quitter":
                        continuer = false;
                        break;
                    case "aide":
                        System.out.println(aide);

                    default:
                        System.out.println("Veuillez reformuler votre demande ('aide' pour avoir la liste disponible)");
                }
            }
        }
    }
}

