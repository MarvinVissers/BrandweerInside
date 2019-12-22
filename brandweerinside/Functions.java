/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brandweerinside;

import brandweerinside.EntiteitClasses.EntGebruiker;
import brandweerinside.EntiteitClasses.EntKazerne;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author visse
 */
public class Functions {

    // Variabele aanmaken voor connectie, statement en resultset
    Connection conn;
    Statement stm;
    ResultSet rsset;

    public Functions() {
        try {
            // Query maken voor connectie met de database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/brandweer_inside?user=root&password=");
            // Van de query een statement maken die naar de database kan
            stm = conn.createStatement();
        } catch (SQLException error) {
            // error in de log zetten
            System.out.println(error);
        }
        catch(Exception e){
            // error in de log zetten
            System.out.println(e);
        }
    }

    // Inlog functie
    public int loginGebruiker(String sEmail, String sWachtwoord) {
        // Query maken
        String sQuery = "SELECT * FROM gebruiker WHERE email = '" + sEmail + "' AND wachtwoord = '" + sWachtwoord + "'";

        try {
            stm = conn.createStatement();

            if (stm.execute(sQuery)) {
                // Resulataten ophalen
                rsset = stm.getResultSet();
                // Zolang er resultaten zijn
                while (rsset.next()) {
                    // Recht ophalen uit de database, heruit komt de pagina waar je naartoe gaat
                    String sRecht = rsset.getString("recht");

                    // Kijken of het recht gelijk is aan brandweer
                    if (sRecht.matches("Brandweer")) {
                        // 1 teruggeven voor brandweer rechten
                        return 1;
                    } // Kijken of het recht gelijk is aan gemeente of overheid
                    else if (sRecht.matches("OverheidGemeente")) {
                        // 2 teruggeven voor overheid / gemeente rechten
                        return 2;
                    }
                }
            } else {
                // 0 teruggeven voor geen account gevonden
                return 0;
            }
        } catch (SQLException error) {
            System.out.println(error);

            // 0 teruggeven voor geen account gevonden
            return 0;
        }
        // 0 teruggeven voor geen account gevonden
        return 0;
    }

    // Registreer functie
    public int addGebruiker(String sNaam, String sWerk, String sRegio, String sEmail, String sWachtwoord, String sRecht) {
        // Query maken
        String sQuery = "INSERT INTO gebruiker(naam, werk, email, wachtwoord, regio, recht) VALUES('" + sNaam + "', '" + sWerk + "', '" + sEmail + "', '" + sWachtwoord + "', '" + sRegio + "', '" + sRecht + "')";

        try {
            // Kijken wat het recht. Dit komt doordat na het registreren ze naar aparte pagina's gaan gebasseerd op rechten
            if (sRecht.matches("Brandweer")) {
                // Query uitvoeren
                stm.execute(sQuery);
                return 1;
            } else {
                // Query uitvoeren
                stm.execute(sQuery);
                return 2;
            }
        } catch (SQLException error) {
            System.out.println(error);

            // 0 teruggeven voor geen account gevonden
            return 0;
        }
    }

    // Functie voor het krijgen van de gebruiker
    public ObservableList<EntGebruiker> getGebruiker(String sEmail) {
        // Array voor klanten in het systeem onder bepaalde dietiste
        ObservableList<EntGebruiker> gebruiker = FXCollections.observableArrayList();

        // Query maken
        String sQuery = "SELECT * FROM gebruiker WHERE email = '" + sEmail + "'";
        System.out.println(sQuery);

        try {
            // Statement maken
            stm = conn.createStatement();
            // Query mkaen
            stm.executeQuery(sQuery);
            // Resultaten ophalen
            rsset = stm.getResultSet();

            // Door de resultaten heen lopen en deze in de Array stoppen
            while (rsset.next()) {
                // Variabelen aanmaken voor de kolommen die in de array komen
                int iGebruikerID = rsset.getInt("gid");
                String sNaam = rsset.getString("naam");
                String sWerk = rsset.getString("werk");
                String sEmailGebruiker = rsset.getString("email");
                String sWachtwoord = rsset.getString("wachtwoord");
                String sRegio = rsset.getString("regio");
                String sRecht = rsset.getString("recht");

                gebruiker.add(new EntGebruiker(iGebruikerID, sNaam, sWerk, sEmailGebruiker, sWachtwoord, sRegio, sRecht));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(gebruiker);
        // Array teruggeven
        return gebruiker;
    }

    // Functie voor het krijgen van een kazerne
    public ObservableList<EntKazerne> getKazerne(String sRegio) {
        // Array voor klanten in het systeem onder bepaalde dietiste
        ObservableList<EntKazerne> kazerne = FXCollections.observableArrayList();

        // Variabele aanmaken voor jaar
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int iJaar = localDate.getYear();

        // Query maken
        // Deze query zoekt of er lokaal een kazerne is die gelijk is aan regio, jaar. 
        // Hier haalt hij de nieuwste op, alleen het eerste resultaat wordt opgehaald
        String sQuery = "SELECT * FROM kazerne WHERE regio = '" + sRegio + "' AND jaar = " + iJaar + " ORDER BY kid DESC LIMIT 1";
        System.out.println(sQuery);

        try {
            // Statement maken
            stm = conn.createStatement();
            // Query mkaen
            stm.executeQuery(sQuery);
            // Resultaten ophalen
            rsset = stm.getResultSet();

            // Check of er resultaat is
            if (!rsset.isBeforeFirst()) {
                // Geen resultaat         
                try {
                    // Variabele voor JSON url aanmaken
                    URI uri = new URI("https://opendata.cbs.nl/ODataApi/OData/71482eng/TypedDataSet?$filter=Region%20eq%20%27"+ sRegio +"%27");
                    // JSON bestand openen
                    JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
                    // Variabele aanmaken voor het object in JSON
                    JSONObject root = new JSONObject(tokener);

                    // Door de JSON objecten heel loopen
                    for (int i = 1; i < root.length(); ++i) {
                        // JSON Array ophalen in het object
                        JSONArray arr = root.getJSONArray("value");

                        // Door de Array heen loopen
                        for (int json = 0; json < arr.length(); json++) {
                            // Regio en jaar ophalen 
                            String sRegion = arr.getJSONObject(json).getString("Region");
                            String sYearOld = arr.getJSONObject(json).getString("Years");

                            // Omdat jaar wordt geleverd als 2019JJ00 wordt dit aangepast naar 2019 en wordt het omgezet naar int
                            String sYearNew = sYearOld.replace("JJ00", "");
                            int iYear = Integer.parseInt(sYearNew);
                            //System.out.println("Regio = " + sRegion + " | Jaar = " + iYear + " | Nummer = " + a);

                            // Kijken of regio en jaar gelijk zijn aan de geselecteerde regio en het jaar
                            if (sRegion.matches(sRegio) && iYear == iJaar) {
                                // Variabelen aanmaken voor de kolommen die in de array komen
                                int iKazernID = arr.getJSONObject(json).getInt("ID");
                                int iProfessioneelMan = arr.getJSONObject(json).getInt("Male_4");
                                int iProfessioneelVrouw = arr.getJSONObject(json).getInt("Female_5");
                                Long LongProfessioneelHogeMiddenRank = arr.getJSONObject(json).optLong("HigherAndMidLevelRanks_6", 0);
                                Long LongProfessioneelLageRank = arr.getJSONObject(json).optLong("LowerLevelRanks_9", 0);
                                int iVrijwilligerMan = arr.getJSONObject(json).getInt("Male_11");
                                int iVrijwilligerVrouw = arr.getJSONObject(json).getInt("Female_12");
                                Long LongVrijwilligerHogeMiddenRank = arr.getJSONObject(json).optLong("HigherAndMidLevelRanks_13", 0);
                                Long LongVrijwilligerLageRank = arr.getJSONObject(json).optLong("LowerLevelRanks_16", 0);
                                int iOpleidingHboWo = arr.getJSONObject(json).getInt("HboWoLevel_18");
                                int iOpleidingMbo = arr.getJSONObject(json).getInt("MboLevel_19");
                                int iOpleidingLbo = arr.getJSONObject(json).getInt("LboLevel_20");
                                String sTekort = "";
                                
                                // Long omzetten naar int, in de API wordt long gebruikt voor deze datatype voor deze kolommen
                                Integer iProfessioneelHogeMiddenRank = LongProfessioneelHogeMiddenRank != null ? LongProfessioneelHogeMiddenRank.intValue() : null;
                                Integer iProfessioneelLageRank = LongProfessioneelLageRank != null ? LongProfessioneelLageRank.intValue() : null;
                                Integer iVrijwilligerHogeMiddenRank = LongVrijwilligerHogeMiddenRank != null ? LongVrijwilligerHogeMiddenRank.intValue() : null;
                                Integer iVrijwilligerLageRank = LongVrijwilligerLageRank != null ? LongVrijwilligerLageRank.intValue() : null;
                                
                                kazerne.add(new EntKazerne(iKazernID, sRegio, iJaar, iProfessioneelMan, iProfessioneelVrouw, iProfessioneelHogeMiddenRank, iProfessioneelLageRank, iVrijwilligerMan, iVrijwilligerVrouw, iVrijwilligerHogeMiddenRank, iVrijwilligerLageRank, iOpleidingHboWo, iOpleidingMbo, iOpleidingLbo, sTekort));
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                // Wel resultaat
                // door het resultaat lopen
                while (rsset.next()) {
                    // Variabelen aanmaken voor de kolommen die in de array komen
                    int iKazernID = rsset.getInt("kid");
                    int iProfessioneelMan = rsset.getInt("professioneel_man");
                    int iProfessioneelVrouw = rsset.getInt("professioneel_vrouw");
                    int iProfessioneelHogeMiddenRank = rsset.getInt("professioneel_hoger_midden_rank");
                    int iProfessioneelLageRank = rsset.getInt("professioneel_laag_rank");
                    int iVrijwilligerMan = rsset.getInt("vrijwilliger_man");
                    int iVrijwilligerVrouw = rsset.getInt("vrijwilliger_vrouw");
                    int iVrijwilligerHogeMiddenRank = rsset.getInt("vrijwilliger_hoger_midden_rank");
                    int iVrijwilligerLageRank = rsset.getInt("vrijwilliger_laag_rank");
                    int iOpleidingHboWo = rsset.getInt("niet_operationeel_hbo_wo");
                    int iOpleidingMbo = rsset.getInt("niet_operationeel_mbo");
                    int iOpleidingLbo = rsset.getInt("niet_operationeel_lbo");
                    String sTekort = rsset.getString("tekort");

                    // Rij aan Array toevoegen
                    kazerne.add(new EntKazerne(iKazernID, sRegio, iJaar, iProfessioneelMan, iProfessioneelVrouw, iProfessioneelHogeMiddenRank, iProfessioneelLageRank, iVrijwilligerMan, iVrijwilligerVrouw, iVrijwilligerHogeMiddenRank, iVrijwilligerLageRank, iOpleidingHboWo, iOpleidingMbo, iOpleidingLbo, sTekort));
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(kazerne);
        // Array teruggeven
        return kazerne;
    }

    // Functie voor het krijgen van alle kazernes
    public ObservableList<EntKazerne> getOverviewKazernes() {
        // Array voor klanten in het systeem onder bepaalde dietiste
        ObservableList<EntKazerne> ovKazernes = FXCollections.observableArrayList();

        // Variabele aanmaken voor jaar
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int iJaar = localDate.getYear();

        try {
            // Variabele voor JSON url aanmaken
            URI uri = new URI("https://opendata.cbs.nl/ODataApi/OData/71482eng/TypedDataSet?$filter=Years%20eq%20%27" + iJaar + "JJ00%27");
            // JSON bestand openen
            JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
            // Variabele aanmaken voor het object in JSON
            JSONObject root = new JSONObject(tokener);

            // Door de JSON objecten heel loopen
            for (int i = 1; i < root.length(); ++i) {
                // JSON Array ophalen in het object
                JSONArray arr = root.getJSONArray("value");

                // Door de Array heen loopen van JSON
                for (int json = 0; json < arr.length(); json++) {
                    // Regio en jaar ophalen 
                    String sRegioJSON = arr.getJSONObject(json).getString("Region");
                    String iYear = arr.getJSONObject(json).getString("Years");

                    // Omdat jaar wordt geleverd als 2019JJ00 wordt dit aangepast naar 2019 en wordt het omgezet naar int
                    String sYearNew = iYear.replace("JJ00", "");
                    int iJaarJSON = Integer.parseInt(sYearNew);
                    //System.out.println("JSON: Regio = " + sRegioJSON + " | Jaar = " + iJaarJSON);

                    // Query maken
                    // Deze query haalt eerst het laatste id omdat dat het meest resent is en dan groupt hij op regio om 1 resultaat te krijgen
                    String sQuery = "SELECT MAX(kid) AS kid, regio, jaar, professioneel_man, professioneel_vrouw, vrijwilliger_man, vrijwilliger_vrouw, "
                            + "niet_operationeel_hbo_wo, niet_operationeel_mbo, niet_operationeel_lbo, tekort\n"
                            + "FROM kazerne \n"
                            + "WHERE jaar = " + iJaar + " AND regio = '" + sRegioJSON + "' \n"
                            + "GROUP BY regio";

                    // Statement maken
                    stm = conn.createStatement();
                    // Query mkaen
                    stm.executeQuery(sQuery);
                    // Resultaten ophalen
                    rsset = stm.getResultSet();

                    // Check of er resultaat is
                    if (!rsset.isBeforeFirst()) {
                        // Geen resultaat
                        // Variabele aanmaken van de kolommen
                        int iKazernID = arr.getJSONObject(json).getInt("ID");
                        int iProfessioneelMan = arr.getJSONObject(json).getInt("Male_4");
                        int iProfessioneelVrouw = arr.getJSONObject(json).getInt("Female_5");
                        Long LongProfessioneelHogeMiddenRank = arr.getJSONObject(json).optLong("HigherAndMidLevelRanks_6", 0);
                        Long LongProfessioneelLageRank = arr.getJSONObject(json).optLong("LowerLevelRanks_9", 0);
                        int iVrijwilligerMan = arr.getJSONObject(json).getInt("Male_11");
                        int iVrijwilligerVrouw = arr.getJSONObject(json).getInt("Female_12");
                        Long LongVrijwilligerHogeMiddenRank = arr.getJSONObject(json).optLong("HigherAndMidLevelRanks_13", 0);
                        Long LongVrijwilligerLageRank = arr.getJSONObject(json).optLong("LowerLevelRanks_16", 0);
                        int iOpleidingHboWo = arr.getJSONObject(json).getInt("HboWoLevel_18");
                        int iOpleidingMbo = arr.getJSONObject(json).getInt("MboLevel_19");
                        int iOpleidingLbo = arr.getJSONObject(json).getInt("LboLevel_20");
                        String sTekort = "";

                        // Long omzetten naar int, in de API wordt long gebruikt voor deze datatype voor deze kolommen
                        Integer iProfessioneelHogeMiddenRank = LongProfessioneelHogeMiddenRank != null ? LongProfessioneelHogeMiddenRank.intValue() : null;
                        Integer iProfessioneelLageRank = LongProfessioneelLageRank != null ? LongProfessioneelLageRank.intValue() : null;
                        Integer iVrijwilligerHogeMiddenRank = LongVrijwilligerHogeMiddenRank != null ? LongVrijwilligerHogeMiddenRank.intValue() : null;
                        Integer iVrijwilligerLageRank = LongVrijwilligerLageRank != null ? LongVrijwilligerLageRank.intValue() : null;

                        ovKazernes.add(new EntKazerne(iKazernID, sRegioJSON, iJaar, iProfessioneelMan, iProfessioneelVrouw, iProfessioneelHogeMiddenRank, iProfessioneelLageRank, iVrijwilligerMan, iVrijwilligerVrouw, iVrijwilligerHogeMiddenRank, iVrijwilligerLageRank, iOpleidingHboWo, iOpleidingMbo, iOpleidingLbo, sTekort));
                    } else {
                        // Door Database resultaten heen lopen
                        while (rsset.next()) {
                            // Variabele aanmaken voor de database regio en jaar
                            String sRegioDB = rsset.getString("regio");
                            int iJaarDB = rsset.getInt("jaar");
                            //System.out.println("Database: Regio = " + sRegioDB + " | Jaar = " + iJaarDB);

                            // Als regio en jaar overeen komen met de database dan het database resultaat gebruiken
                            if (sRegioDB.matches(sRegioJSON) && iJaarDB == iJaarJSON) {
                            // Regio en jaar komen overeen met resultaat database
                                // Variabelen aanmaken voor de kolommen die in de array komen
                                // De ranken krijgen een 0 omdat ze niet opgevraagd worden maar wel in de contructor zitten
                                int iKazernID = rsset.getInt("kid");
                                int iProfessioneelMan = rsset.getInt("professioneel_man");
                                int iProfessioneelVrouw = rsset.getInt("professioneel_vrouw");
                                int iProfessioneelHogeMiddenRank = 0;
                                int iProfessioneelLageRank = 0;
                                int iVrijwilligerMan = rsset.getInt("vrijwilliger_man");
                                int iVrijwilligerVrouw = rsset.getInt("vrijwilliger_vrouw");
                                int iVrijwilligerHogeMiddenRank = 0;
                                int iVrijwilligerLageRank = 0;
                                int iOpleidingHboWo = rsset.getInt("niet_operationeel_hbo_wo");
                                int iOpleidingMbo = rsset.getInt("niet_operationeel_mbo");
                                int iOpleidingLbo = rsset.getInt("niet_operationeel_lbo");
                                String sTekort = rsset.getString("tekort");

                                ovKazernes.add(new EntKazerne(iKazernID, sRegioDB, iJaar, iProfessioneelMan, iProfessioneelVrouw, iProfessioneelHogeMiddenRank, iProfessioneelLageRank, iVrijwilligerMan, iVrijwilligerVrouw, iVrijwilligerHogeMiddenRank, iVrijwilligerLageRank, iOpleidingHboWo, iOpleidingMbo, iOpleidingLbo, sTekort));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }       
        // Lijst teruggeven
        return ovKazernes;
    }
    
    // Functie voor het krijgen van de geschiedenis van een kazerne
    public ObservableList<EntKazerne> getGeschiedenisKazerne(String sRegio) {
        // Array voor klanten in het systeem onder bepaalde dietiste
        ObservableList<EntKazerne> gsKazerne = FXCollections.observableArrayList();

        // Variabele aanmaken voor jaar
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int iJaar = localDate.getYear();
        
        for(int iJaarLoop = iJaar; iJaarLoop >= 2000; --iJaarLoop){
            try {
                // Variabele voor JSON url aanmaken
                URI uri = new URI("https://opendata.cbs.nl/ODataApi/OData/71482eng/TypedDataSet?$filter=Years%20eq%20%27" + iJaarLoop + "JJ00%27");
                // JSON bestand openen
                JSONTokener tokener = new JSONTokener(uri.toURL().openStream());
                // Variabele aanmaken voor het object in JSON
                JSONObject root = new JSONObject(tokener);

                // Door de JSON objecten heel loopen
                for (int i = 1; i < root.length(); ++i) {
                    // JSON Array ophalen in het object
                    JSONArray arr = root.getJSONArray("value");

                    // Door de Array heen loopen van JSON
                    for (int json = 0; json < arr.length(); json++) {
                        // Regio en jaar ophalen 
                        String sRegioJSON = arr.getJSONObject(json).getString("Region");
                        String iYear = arr.getJSONObject(json).getString("Years");

                        // Omdat jaar wordt geleverd als 2019JJ00 wordt dit aangepast naar 2019 en wordt het omgezet naar int
                        String sYearNew = iYear.replace("JJ00", "");
                        int iJaarJSON = Integer.parseInt(sYearNew);
                        //System.out.println("JSON: Regio = " + sRegioJSON + " | Jaar = " + iJaarJSON);

                        // Query maken
                        // Deze query haalt eerst het laatste id omdat dat het meest resent is en dan groupt hij op regio om 1 resultaat te krijgen
                        String sQuery = "SELECT * FROM `kazerne` WHERE regio = '" + sRegio + "' AND jaar = " + iJaar + " ORDER BY kid, jaar DESC";

                        // Statement maken
                        stm = conn.createStatement();
                        // Query mkaen
                        stm.executeQuery(sQuery);
                        // Resultaten ophalen
                        rsset = stm.getResultSet();
                        
                        // Door Database resultaten heen lopen
                        while (rsset.next()) {
                            // Variabele aanmaken voor de database regio en jaar
                            String sRegioDB = rsset.getString("regio");
                            int iJaarDB = rsset.getInt("jaar");
                            //System.out.println("Database: Regio = " + sRegioDB + " | Jaar = " + iJaarDB);

                            // Als regio en jaar overeen komen met de database dan het database resultaat gebruiken
                            if (sRegioDB.matches(sRegioJSON) && iJaarDB == iJaarJSON) {
                            // Regio en jaar komen overeen met resultaat database
                                // Variabelen aanmaken voor de kolommen die in de array komen
                                int iKazernID = rsset.getInt("kid");
                                int iProfessioneelMan = rsset.getInt("professioneel_man");
                                int iProfessioneelVrouw = rsset.getInt("professioneel_vrouw");
                                int iProfessioneelHogeMiddenRank = rsset.getInt("professioneel_hoger_midden_rank");
                                int iProfessioneelLageRank = rsset.getInt("professioneel_laag_rank");
                                int iVrijwilligerMan = rsset.getInt("vrijwilliger_man");
                                int iVrijwilligerVrouw = rsset.getInt("vrijwilliger_vrouw");
                                int iVrijwilligerHogeMiddenRank = rsset.getInt("vrijwilliger_hoger_midden_rank");
                                int iVrijwilligerLageRank = rsset.getInt("vrijwilliger_laag_rank");
                                int iOpleidingHboWo = rsset.getInt("niet_operationeel_hbo_wo");
                                int iOpleidingMbo = rsset.getInt("niet_operationeel_mbo");
                                int iOpleidingLbo = rsset.getInt("niet_operationeel_lbo");
                                String sTekort = rsset.getString("tekort");

                                // Rij toevoegen aan Array
                                gsKazerne.add(new EntKazerne(iKazernID, sRegioDB, iJaarDB, iProfessioneelMan, iProfessioneelVrouw, iProfessioneelHogeMiddenRank, iProfessioneelLageRank, iVrijwilligerMan, iVrijwilligerVrouw, iVrijwilligerHogeMiddenRank, iVrijwilligerLageRank, iOpleidingHboWo, iOpleidingMbo, iOpleidingLbo, sTekort));
                            }
                        }
                        // Omdat alle resultaten erin moeten komt hier het JSON resultaat erachter
                        if(sRegio.matches(sRegioJSON)){
                            // Variabele aanmaken van de kolommen
                            int iKazernID = arr.getJSONObject(json).getInt("ID");
                            int iProfessioneelMan = arr.getJSONObject(json).getInt("Male_4");
                            int iProfessioneelVrouw = arr.getJSONObject(json).getInt("Female_5");
                            Long LongProfessioneelHogeMiddenRank = arr.getJSONObject(json).optLong("HigherAndMidLevelRanks_6", 0);
                            Long LongProfessioneelLageRank = arr.getJSONObject(json).optLong("LowerLevelRanks_9", 0);
                            int iVrijwilligerMan = arr.getJSONObject(json).getInt("Male_11");
                            int iVrijwilligerVrouw = arr.getJSONObject(json).getInt("Female_12");
                            Long LongVrijwilligerHogeMiddenRank = arr.getJSONObject(json).optLong("HigherAndMidLevelRanks_13", 0);
                            Long LongVrijwilligerLageRank = arr.getJSONObject(json).optLong("LowerLevelRanks_16", 0);
                            Long LongOpleidingHboWo = arr.getJSONObject(json).optLong("HboWoLevel_18", 0);
                            Long LongOpleidingMbo = arr.getJSONObject(json).optLong("MboLevel_19", 0);
                            Long LongOpleidingLbo = arr.getJSONObject(json).optLong("LboLevel_20", 0);
                            String sTekort = "";

                            // Long omzetten naar int, in de API wordt long gebruikt voor deze datatype voor deze kolommen
                            Integer iProfessioneelHogeMiddenRank = LongProfessioneelHogeMiddenRank != null ? LongProfessioneelHogeMiddenRank.intValue() : null;
                            Integer iProfessioneelLageRank = LongProfessioneelLageRank != null ? LongProfessioneelLageRank.intValue() : null;
                            Integer iVrijwilligerHogeMiddenRank = LongVrijwilligerHogeMiddenRank != null ? LongVrijwilligerHogeMiddenRank.intValue() : null;
                            Integer iVrijwilligerLageRank = LongVrijwilligerLageRank != null ? LongVrijwilligerLageRank.intValue() : null;
                            Integer iOpleidingHboWo = LongOpleidingHboWo != null ? LongOpleidingHboWo.intValue() : null;
                            Integer iOpleidingMbo = LongOpleidingMbo != null ? LongOpleidingMbo.intValue() : null;
                            Integer iOpleidingLbo = LongOpleidingLbo != null ? LongOpleidingLbo.intValue() : null;

                            gsKazerne.add(new EntKazerne(iKazernID, sRegioJSON, iJaarJSON, iProfessioneelMan, iProfessioneelVrouw, iProfessioneelHogeMiddenRank, iProfessioneelLageRank, iVrijwilligerMan, iVrijwilligerVrouw, iVrijwilligerHogeMiddenRank, iVrijwilligerLageRank, iOpleidingHboWo, iOpleidingMbo, iOpleidingLbo, sTekort));    
                        }  
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }          
        }
        // Lijst teruggeven
        return gsKazerne;
    }

    // Functie voor het updaten van een kazerne
    public int updateKazere(String sRegio, int iJaar, int iProfessioneelMan, int iProfessioneelVrouw, int iProfessioneelHogerMiddenRank, int iProfessioneelLageRank, int iVrijwilligMan, int iVrijwilligVrouw, int iVrijwilligHogeMiddenRank, int iVrijwilligLageRank, int iOpleidingHboWo, int iOpleidingMbo, int iOpleidingLbo, String sTekort) {
        String sQuery = "INSERT INTO kazerne(regio, jaar, professioneel_man, professioneel_vrouw, professioneel_hoger_midden_rank, professioneel_laag_rank, vrijwilliger_man, vrijwilliger_vrouw, vrijwilliger_hoger_midden_rank, vrijwilliger_laag_rank, niet_operationeel_hbo_wo, niet_operationeel_mbo, niet_operationeel_lbo, tekort)"
                + " VALUES('" + sRegio + "', " + iJaar + ", " + iProfessioneelMan + ", " + iProfessioneelVrouw + ", " + iProfessioneelHogerMiddenRank + ","
                + " " + iProfessioneelLageRank + ", " + iVrijwilligMan + ", " + iVrijwilligVrouw + ","
                + " " + iVrijwilligHogeMiddenRank + ", " + iVrijwilligLageRank + ", " + iOpleidingHboWo + ", " + iOpleidingMbo + ", " + iOpleidingLbo + ", '" + sTekort + "')";
        System.out.println(sQuery);

        try {
            // String omzetten naar statement
            stm = conn.createStatement();
            // statement uitvoeren
            stm.execute(sQuery);
            // Goedkeuring terugsturen
            return 1;
        } catch (SQLException error) {
            System.out.println(error);

            // 0 teruggeven als er iets foutgaat
            return 0;
        }
    }
}
