package fr.univ_amu.iut.reseauferre.traitement.positions;

/**
 * class instance de Positions
 * @see Position
 */
public class Gare implements Position{
    /**
     * Ville où est implentée la gare
     */
    private String ville;
    /**
     * attribut booléen pour savoir si la gare a des subventions
     */
    private boolean subvention;
  


    /**
     * Constructeur de la classe Gare
     * @param ville Nom de la ville où est la gare
     * @param subvention Savoir si la gare est subventionnée
     */
   public Gare(String ville, boolean subvention) {
        this.ville = ville;
        this.subvention = subvention;
    }
  
  public String getVille() {
        return ville;
    }


    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setSubvention(boolean subvention) {
        this.subvention = subvention;
    }


    /**
     * Constructeur pour les gares non subventionnées
     * @param ville ville d'implémentation de la gare
     */
    public Gare(String ville) {
        this(ville, false);
    }

    /**
     * Getter du booléen subvention
     * @return Si la  gare est subventionnée
     */
    public boolean getSubvention() {
        return subvention;
    }

    @Override
    public String toString() {
        return "Gare de " + ville + (this.subvention ? " (subventionné)" : "");
    }

    @Override
    /**
     * @return  le nom de la ville
     */
    public String getName() {
        return ville;
    }
}
