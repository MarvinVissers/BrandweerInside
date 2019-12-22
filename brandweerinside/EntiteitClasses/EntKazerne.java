/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brandweerinside.EntiteitClasses;

/**
 *
 * @author visse
 */
public class EntKazerne {
    
    // Variabele aanmaken per kolom in de database
    private final Integer KazerneID;
    private final String Regio;
    private final Integer Jaar;
    private final Integer ProfessioneelMan;
    private final Integer ProfessioneelVrouw;
    private final Integer ProfessioneelHogeMiddenRank;
    private final Integer ProfessioneelLageRank;
    private final Integer VrijwilligerMan;
    private final Integer VrijwilligerVrouw;
    private final Integer VrijwilligerHogeMiddenRank;
    private final Integer VrijwilligerLageRank;
    private final Integer NietOperationeelHboWo;
    private final Integer NietOperationeelMbo;
    private final Integer NietOperationeelLbo;
    private final String Tekort;
    private final Integer TotaalProfessioneel;
    private final Integer TotaalVrijwilliger;
    private final Integer TotaalNietOperationeel;
    
    public EntKazerne(Integer colKazerneID, String colRegio, Integer colJaar, Integer colProfessioneelMan, Integer colProfessioneelVrouw, Integer colProfessioneelHogeMiddenRank, Integer colProfessioneelLageRank, Integer colVrijwilligerMan, Integer colVrijwilligerVrouw, Integer colVrijwilligerHogeMiddenRank, Integer colVrijwilligerLageRank, Integer colNietOperationeelHboWo, Integer colNietOperationeelMbo, Integer colNietOperationeelLbo, String colTekort){
        this.KazerneID = new Integer(colKazerneID);
        this.Regio = new String(colRegio);
        this.Jaar = new Integer(colJaar);
        this.ProfessioneelMan = new Integer(colProfessioneelMan);
        this.ProfessioneelVrouw = new Integer(colProfessioneelVrouw);
        this.ProfessioneelHogeMiddenRank = new Integer(colProfessioneelHogeMiddenRank);
        this.ProfessioneelLageRank = new Integer(colProfessioneelLageRank);
        this.VrijwilligerMan = new Integer(colVrijwilligerMan);
        this.VrijwilligerVrouw = new Integer(colVrijwilligerVrouw);
        this.VrijwilligerHogeMiddenRank = new Integer(colVrijwilligerHogeMiddenRank);
        this.VrijwilligerLageRank = new Integer(colVrijwilligerLageRank);
        this.NietOperationeelHboWo = new Integer(colNietOperationeelHboWo);
        this.NietOperationeelMbo = new Integer(colNietOperationeelMbo);
        this.NietOperationeelLbo = new Integer(colNietOperationeelLbo);
        this.Tekort = new String(colTekort);
        this.TotaalProfessioneel = new Integer(colProfessioneelMan + colProfessioneelVrouw);
        this.TotaalVrijwilliger = new Integer(colVrijwilligerMan + colVrijwilligerVrouw);
        this.TotaalNietOperationeel = new Integer(colNietOperationeelHboWo + colNietOperationeelMbo + colNietOperationeelLbo);
    }
    
    // Getters
    public Integer getKazerneID() {
        return KazerneID;
    }

    public String getRegio() {
        return Regio;
    }

    public Integer getJaar() {
        return Jaar;
    }

    public Integer getProfessioneelMan() {
        return ProfessioneelMan;
    }

    public Integer getProfessioneelVrouw() {
        return ProfessioneelVrouw;
    }

    public Integer getProfessioneelHogeMiddenRank() {
        return ProfessioneelHogeMiddenRank;
    }

    public Integer getProfessioneelLageRank() {
        return ProfessioneelLageRank;
    }

    public Integer getVrijwilligerMan() {
        return VrijwilligerMan;
    }

    public Integer getVrijwilligerVrouw() {
        return VrijwilligerVrouw;
    }

    public Integer getVrijwilligerHogeMiddenRank() {
        return VrijwilligerHogeMiddenRank;
    }

    public Integer getVrijwilligerLageRank() {
        return VrijwilligerLageRank;
    }

    public Integer getNietOperationeelHboWo() {
        return NietOperationeelHboWo;
    }

    public Integer getNietOperationeelMbo() {
        return NietOperationeelMbo;
    }

    public Integer getNietOperationeelLbo() {
        return NietOperationeelLbo;
    }

    public String getTekort() {
        return Tekort;
    }

    public Integer getTotaalProfessioneel() {
        return TotaalProfessioneel;
    }

    public Integer getTotaalVrijwilliger() {
        return TotaalVrijwilliger;
    }

    public Integer getTotaalNietOperationeel() {
        return TotaalNietOperationeel;
    }

    // to string functie
    @Override
    public String toString() {
        return "EntKazerne{" + "KazerneID=" + KazerneID + ", Regio=" + Regio + ", Jaar=" + Jaar + ", ProfessioneelMan=" + ProfessioneelMan + ", ProfessioneelVrouw=" + ProfessioneelVrouw + ", ProfessioneelHogeMiddenRank=" + ProfessioneelHogeMiddenRank + ", ProfessioneelLageRank=" + ProfessioneelLageRank + ", VrijwilligerMan=" + VrijwilligerMan + ", VrijwilligerVrouw=" + VrijwilligerVrouw + ", VrijwilligerHogeMiddenRank=" + VrijwilligerHogeMiddenRank + ", VrijwilligerLageRank=" + VrijwilligerLageRank + ", NietOperationeelHboWo=" + NietOperationeelHboWo + ", NietOperationeelMbo=" + NietOperationeelMbo + ", NietOperationeelLbo=" + NietOperationeelLbo + ", Tekort=" + Tekort + ", TotaalProfessioneel=" + TotaalProfessioneel + ", TotaalVrijwilliger=" + TotaalVrijwilliger + ", TotaalNietOperationeel=" + TotaalNietOperationeel + '}';
    }
    
}
