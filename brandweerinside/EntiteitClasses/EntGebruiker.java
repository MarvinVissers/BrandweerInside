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
public class EntGebruiker {
    
    // Variabele aanmaken per kolom in de database
    private final Integer iGebruikerID;
    private final String sNaam;
    private final String sWerk;
    private final String sEmail;
    private final String sWachtwoord;
    private final String sRegio;
    private final String sRecht;
    
    public EntGebruiker(Integer colGebruikerID, String colNaam, String colWerk, String colEmail, String colWachtwoord, String colRegio, String colRecht){
        this.iGebruikerID = new Integer(colGebruikerID);
        this.sNaam = new String(colNaam);
        this.sWerk = new String(colWerk);
        this.sEmail = new String(colEmail);
        this.sWachtwoord = new String(colWachtwoord);
        this.sRegio = new String(colRegio);
        this.sRecht = new String(colRecht);
    }
    
    // Getters    
    public Integer getGebruikerID() {
        return iGebruikerID;
    }

    public String getNaam() {
        return sNaam;
    }

    public String getWerk() {
        return sWerk;
    }

    public String getEmail() {
        return sEmail;
    }

    public String getWachtwoord() {
        return sWachtwoord;
    }

    public String getRegio() {
        return sRegio;
    }

    public String getRecht() {
        return sRecht;
    }
            
    // Waardes omzetten in string
    @Override
    public String toString() {
        return "EntGebruiker{" + "iGebruikerID=" + iGebruikerID + ", sNaam=" + sNaam + ", sWerk=" + sWerk + ", sEmail=" + sEmail + ", sWachtwoord=" + sWachtwoord + ", sRegio=" + sRegio + ", sRecht=" + sRecht + '}';
    } 
}
