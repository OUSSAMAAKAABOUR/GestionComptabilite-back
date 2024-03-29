package stage.sir.gestioncomptabilite.vo;

import stage.sir.gestioncomptabilite.bean.EtatDeclaration;
import stage.sir.gestioncomptabilite.bean.Facture;
import stage.sir.gestioncomptabilite.bean.TauxIS;
import stage.sir.gestioncomptabilite.bean.TauxIsConfig;

import java.util.ArrayList;
import java.util.List;

public class DeclarationIsObject {
    private double annee;
    private String iceSociete;
    private Double totalHTGain;
    private Double totalHTCharge;
    private Double totalHTDiff;
    private Double montantISCalcule;
    private Double montantISPaye;
    private List<Facture> factureD = new ArrayList<Facture>();
    private List<Facture> factureC = new ArrayList<Facture>();
    private TauxIS tauxIS;
    private TauxIsConfig tauxIsConfig;
    private EtatDeclaration etatDeclaration;

    public double getAnnee() {
        return annee;
    }

    public void setAnnee(double annee) {
        this.annee = annee;
    }

    public Double getTotalHTGain() {
        return totalHTGain;
    }

    public void setTotalHTGain(Double totalHTGain) {
        this.totalHTGain = totalHTGain;
    }

    public Double getTotalHTCharge() {
        return totalHTCharge;
    }

    public void setTotalHTCharge(Double totalHTCharge) {
        this.totalHTCharge = totalHTCharge;
    }

    public Double getTotalHTDiff() {
        return totalHTDiff;
    }

    public void setTotalHTDiff(Double totalHTDiff) {
        this.totalHTDiff = totalHTDiff;
    }

    public Double getMontantISCalcule() {
        return montantISCalcule;
    }

    public void setMontantISCalcule(Double montantISCalcule) {
        this.montantISCalcule = montantISCalcule;
    }

    public Double getMontantISPaye() {
        return montantISPaye;
    }

    public void setMontantISPaye(Double montantISPaye) {
        this.montantISPaye = montantISPaye;
    }

    public List<Facture> getFactureD() {
        return factureD;
    }

    public void setFactureD(List<Facture> factureD) {
        this.factureD = factureD;
    }

    public List<Facture> getFactureC() {
        return factureC;
    }

    public void setFactureC(List<Facture> factureC) {
        this.factureC = factureC;
    }

    public String getIceSociete() {
        return iceSociete;
    }

    public void setIceSociete(String iceSociete) {
        this.iceSociete = iceSociete;
    }

    public TauxIS getTauxIS() { return tauxIS; }

    public void setTauxIS(TauxIS tauxIS) { this.tauxIS = tauxIS; }

    public TauxIsConfig getTauxIsConfig() { return tauxIsConfig; }

    public void setTauxIsConfig(TauxIsConfig tauxIsConfig) { this.tauxIsConfig = tauxIsConfig; }

    public EtatDeclaration getEtatDeclaration() {
        return etatDeclaration;
    }

    public void setEtatDeclaration(EtatDeclaration etatDeclaration) {
        this.etatDeclaration = etatDeclaration;
    }
}
