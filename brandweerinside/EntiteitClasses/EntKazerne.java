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
    private final Integer iKazerneID;
    private final String sRegio;
    private final Integer iJaar;
    private final Integer iProfessioneelMan;
    private final Integer iProfessioneelVrouw;
    private final Integer iProfessioneelHogeRank;
    private final Integer iProfessioneelMiddenRank;
    private final Integer iProfessioneelLageRank;
    private final Integer iVrijwilligerMan;
    private final Integer iVrijwilligerVrouw;
    private final Integer iVrijwilligerHogeRank;
    private final Integer iVrijwilligerMiddenRank;
    private final Integer iVrijwilligerLageRank;
    private final Integer iNietOperationeelHboWo;
    private final Integer iNietOperationeelMbo;
    private final Integer iNietOperationeelLbo;
    private final Integer iTekort;
    
    public EntKazerne(Integer colKazerneID, String colRegio, Integer colJaar, Integer colProfessioneelMan, Integer colProfessioneelVrouw, Integer ProfessioneelHogeRank, Integer colrofessioneelMiddenRank, Integer colProfessioneelLageRank, Integer colVrijwilligerMan, Integer colVrijwilligerVrouw, Integer colVrijwilligerHogeRank, Integer colVrijwilligerMiddenRank, Integer colVrijwilligerLageRank, Integer colNietOperationeelHboWo, Integer colNietOperationeelMbo, Integer colNietOperationeelLbo, Integer colTekort){
        this.iKazerneID = new Integer(colKazerneID);
        this.sRegio = new String(colRegio);
        this.iJaar = new Integer(colJaar);
        this.iProfessioneelMan = new Integer(colProfessioneelMan);
        this.iProfessioneelVrouw = new Integer(colProfessioneelVrouw);
        this.iProfessioneelHogeRank = new Integer(ProfessioneelHogeRank);
        this.iProfessioneelMiddenRank = new Integer(colrofessioneelMiddenRank);
        this.iProfessioneelLageRank = new Integer(colProfessioneelLageRank);
        this.iVrijwilligerMan = new Integer(colVrijwilligerMan);
        this.iVrijwilligerVrouw = new Integer(colVrijwilligerVrouw);
        this.iVrijwilligerHogeRank = new Integer(colVrijwilligerHogeRank);
        this.iVrijwilligerMiddenRank = new Integer(colVrijwilligerMiddenRank);
        this.iVrijwilligerLageRank = new Integer(colVrijwilligerLageRank);
        this.iNietOperationeelHboWo = new Integer(colNietOperationeelHboWo);
        this.iNietOperationeelMbo = new Integer(colNietOperationeelMbo);
        this.iNietOperationeelLbo = new Integer(colNietOperationeelLbo);
        this.iTekort = new Integer(colTekort);
    }
    
    // Getters
    public Integer getKazerneID() {
        return iKazerneID;
    }

    public String getRegio() {
        return sRegio;
    }

    public Integer getJaar() {
        return iJaar;
    }

    public Integer getProfessioneelMan() {
        return iProfessioneelMan;
    }

    public Integer getProfessioneelVrouw() {
        return iProfessioneelVrouw;
    }

    public Integer getProfessioneelHogeRank() {
        return iProfessioneelHogeRank;
    }

    public Integer getProfessioneelMiddenRank() {
        return iProfessioneelMiddenRank;
    }

    public Integer getProfessioneelLageRank() {
        return iProfessioneelLageRank;
    }

    public Integer getVrijwilligerMan() {
        return iVrijwilligerMan;
    }

    public Integer getVrijwilligerVrouw() {
        return iVrijwilligerVrouw;
    }

    public Integer getVrijwilligerHogeRank() {
        return iVrijwilligerHogeRank;
    }

    public Integer getVrijwilligerMiddenRank() {
        return iVrijwilligerMiddenRank;
    }

    public Integer getVrijwilligerLageRank() {
        return iVrijwilligerLageRank;
    }

    public Integer getNietOperationeelHboWo() {
        return iNietOperationeelHboWo;
    }

    public Integer getNietOperationeelMbo() {
        return iNietOperationeelMbo;
    }

    public Integer getNietOperationeelLbo() {
        return iNietOperationeelLbo;
    }

    public Integer getTekort() {
        return iTekort;
    }
    
        
    // Waardes omzetten in string
    @Override
    public String toString() {
        return "EntGebruiker{" + "iKazerneID=" + iKazerneID + ", sRegio=" + sRegio + ", iJaar=" + iJaar + ", iProfessioneelMan=" + iProfessioneelMan + ", iProfessioneelVrouw=" + iProfessioneelVrouw + ", iProfessioneelHogeRank=" + iProfessioneelHogeRank + ", iProfessioneelMiddenRank=" + iProfessioneelMiddenRank + ", iProfessioneelLageRank=" + iProfessioneelLageRank + ", iVrijwilligerMan=" + iVrijwilligerMan + ", iVrijwilligerVrouw=" + iVrijwilligerVrouw + ", iVrijwilligerHogeRank=" + iVrijwilligerHogeRank + ", iVrijwilligerMiddenRank=" + iVrijwilligerMiddenRank + ", iVrijwilligerLageRank=" + iVrijwilligerLageRank + ", iNietOperationeelHboWo=" + iNietOperationeelHboWo + ", iNietOperationeelMbo=" + iNietOperationeelMbo + ", iNietOperationeelLbo=" + iNietOperationeelLbo + ", iTekort=" + iTekort + '}';
    }
}
