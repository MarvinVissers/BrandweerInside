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
public class EntKazerneTotaal {
    
    // Variabele aanmaken per aantal soort leden van de brandweer
    String Regio;
    Integer TotaalProfessioneel;
    Integer TotaalVrijwillig;
    Integer TotaalNietOperationeel;
    String Tekort;
    int Jaar;
    
    public EntKazerneTotaal(String sRegio, Integer iTotaalProfessioneel, Integer totaalVrijwillig, Integer TotaalNietOperationeel, String Tekort, Integer iJaar){   
        this.Regio = new String(sRegio);
        this.TotaalProfessioneel = new Integer(iTotaalProfessioneel);
        this.TotaalVrijwillig = new Integer(totaalVrijwillig);
        this.TotaalNietOperationeel = new Integer(TotaalNietOperationeel);
        this.Tekort = new String(Tekort);
        this.Jaar = new Integer(iJaar);
    }
    
    // Getters
    public String getRegio() {
        return Regio;
    }

    public Integer getTotaalProfessioneel() {
        return TotaalProfessioneel;
    }

    public Integer getTotaalVrijwillig() {
        return TotaalVrijwillig;
    }

    public Integer getTotaalNietOperationeel() {
        return TotaalNietOperationeel;
    }

    public String getTekort() {
        return Tekort;
    }

    public Integer getJaar() {
        return Jaar;
    }

    @Override
    public String toString() {
        return "EntKazerneTotaal{" + "Regio=" + Regio + ", TotaalProfessioneel=" + TotaalProfessioneel + ", TotaalVrijwillig=" + TotaalVrijwillig + ", TotaalNietOperationeel=" + TotaalNietOperationeel + ", Tekort=" + Tekort + ", Jaar=" + Jaar + '}';
    }
}
