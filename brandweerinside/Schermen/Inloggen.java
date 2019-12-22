/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brandweerinside.Schermen;

import brandweerinside.Functions;
import brandweerinside.Schermen.Brandweer.BrandweerKazerne;
import brandweerinside.Schermen.OverheidGemeente.OverzichtKazernes;
import java.io.FileNotFoundException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 *
 * @author visse
 */
public class Inloggen {
        public Inloggen(AnchorPane root, Stage primaryStage, Scene scene) throws FileNotFoundException{
                
        /*
         * AnchorPane voor de bovenkant van het menu
         */
        // AnchroPane aanmaken voor de bovenkant van het menu
        AnchorPane topMenu = new AnchorPane();
        
        // Instellingen van de anchorpane
        topMenu.setPrefSize(1080, 100);
        topMenu.setLayoutX(0);
        topMenu.setLayoutY(0);
        topMenu.getStyleClass().add("menu__top");
        
        // Logo in een imageview zetten die hieronder wordt aangemaakt
        final ImageView imgv = new ImageView();
        // Foto ophalen
        Image imgLogo = new Image(brandweerinside.Schermen.Inloggen.class.getResourceAsStream("/brandweerinside/Assets/brandweer-icon.png"));
        //Foto in de view zetten
        imgv.setImage(imgLogo);       
        // instellingen van de foto
        imgv.setFitHeight(65);
        imgv.setPreserveRatio(true);
        imgv.setLayoutX(507.5);
        imgv.setLayoutY(17.5);
        
        // Items aan topmenu toevoegen
        topMenu.getChildren().addAll(imgv);
        
        /*
         * AnchorPane voor de onderkant van het menu
         */        
        // AnchorPane aanmaken voor de onderkant van het menu
        AnchorPane bottomMenu = new AnchorPane();
        
        // Instellingen van de anchorpane
        bottomMenu.setPrefSize(1080, 50);
        bottomMenu.setLayoutX(0);
        bottomMenu.setLayoutY(100);
        bottomMenu.getStyleClass().add("menu__bottom");
        
        // Knoppen aanmaken
        Button btnInloggenMenu = new Button("Inloggen");
        Button btnRegistrerenMenu = new Button("Registreren");        
        
        // Classes toevoegen
        btnInloggenMenu.getStyleClass().add("menu--button");
        btnInloggenMenu.getStyleClass().add("menu--active");
        btnRegistrerenMenu.getStyleClass().add("menu--button");
        
        // Knoppen op de juiste plek zetten
        btnInloggenMenu.setLayoutX(425);
        btnInloggenMenu.setLayoutY(5);
        
        btnRegistrerenMenu.setLayoutX(530);
        btnRegistrerenMenu.setLayoutY(5);
        
        // Items toevoegen aan bottomMenu
        bottomMenu.getChildren().addAll(btnInloggenMenu, btnRegistrerenMenu);
        
        /*
         * alles van de Root anchorPane
         */
        // Labels aanmaken
        Label lblTitel = new Label("Inloggen");
        Label lblEmail = new Label("Email");
        Label lblWachtwoord = new Label("Wachtwoord");
        Label lblFeedbackEmail = new Label("");
        Label lblFeedbackWachtwoord = new Label("");
        Label lblFeedbackInloggen = new Label("");
        // Invoervelden aanmelden
        TextField txtEmail = new TextField();
        PasswordField txtWachtwoord = new PasswordField();
        // Knop aanmaken
        Button btnInloggen = new Button("Inloggen");
        
        // Classes toevoegen
        lblTitel.getStyleClass().add("page--title");
        lblEmail.getStyleClass().add("page--label");
        lblWachtwoord.getStyleClass().add("page--label");
        btnInloggen.getStyleClass().add("btn--default");
        lblFeedbackEmail.getStyleClass().add("feedback__label");
        lblFeedbackWachtwoord.getStyleClass().add("feedback__label");
        lblFeedbackInloggen.getStyleClass().add("feedback__label");
        
        // Invoervelden breder maken
        txtEmail.setPrefWidth(300);
        txtWachtwoord.setPrefWidth(300);
        
        /* 
         * Items op de goede plaats zetten
         */
        // Titel
        lblTitel.setLayoutX(460);
        lblTitel.setLayoutY(200);
        // Email label
        lblEmail.setLayoutX(395);
        lblEmail.setLayoutY(300);
        // Email invoerveld
        txtEmail.setLayoutX(395);
        txtEmail.setLayoutY(330);
        // Email feedback
        lblFeedbackEmail.setLayoutX(395);
        lblFeedbackEmail.setLayoutY(370);
        // Wachtwoord label
        lblWachtwoord.setLayoutX(395);
        lblWachtwoord.setLayoutY(430);
        // Wachtwoord invoerveld
        txtWachtwoord.setLayoutX(395);
        txtWachtwoord.setLayoutY(460);
        // Wachtwoord feedback
        lblFeedbackWachtwoord.setLayoutX(395);
        lblFeedbackWachtwoord.setLayoutY(500);        
        // Inlog knop
        btnInloggen.setLayoutX(395);
        btnInloggen.setLayoutY(550);
        // Inlogfunctie feedback
        lblFeedbackInloggen.setLayoutX(395);
        lblFeedbackInloggen.setLayoutY(595);
        
        /*
         * Hier worden alles in hun AnchorPane gezet
         */               
        // Items aan scherm toevoegen, ook worden hier de anchorpanes samengevoegd
        root.getChildren().addAll(topMenu, bottomMenu, lblTitel, lblEmail, lblWachtwoord, txtEmail, txtWachtwoord, btnInloggen,
                                  lblFeedbackEmail, lblFeedbackWachtwoord, lblFeedbackInloggen);  
        
        /*
         * Functie achter de knoppen
         */
        // Registratie knop
        btnRegistrerenMenu.setOnAction(event -> {
            // Gebruiker naar registratie pagina sturen
            Registreren registratie = new Registreren(primaryStage, scene);
        });
        
        // Inlog knop
        btnInloggen.setOnAction(event -> {
            //TestSchermSwitch registratie = new TestSchermSwitch(primaryStage, scene);
            
            // Waardes uit de invoervelden halen en omzetten naar Strings 
            String sEmail = txtEmail.getText();
            String sWachtwoord = txtWachtwoord.getText();
            
            // Checken of alle invoervelden niet zijn ingevoerd
            if(sEmail.isEmpty() && sWachtwoord.isEmpty()){
                // Foutmelding maken
                lblFeedbackInloggen.setText("Email en wachtwoord zijn niet ingevuld.");
                
                // Inlogknop niet klikbaar maken
                btnInloggen.setDisable(true);

                // Classes toevoegen
                lblFeedbackInloggen.getStyleClass().add("label--error");
                btnInloggen.getStyleClass().add("btn-disabeld");
            }
            
            // Checken of een van de invoervelden niet is ingevoerd
            if(sEmail.isEmpty() || sWachtwoord.isEmpty()){
                // Foutmelding maken
                lblFeedbackInloggen.setText("Email of wachtwoord is niet ingevuld.");
                
                // Inlogknop niet klikbaar maken
                btnInloggen.setDisable(true);

                // Classes toevoegen
                lblFeedbackInloggen.getStyleClass().add("label--error");
                btnInloggen.getStyleClass().add("btn-disabeld");
            }
            
            // Als alles is ingevuld word de functie uitgevoerd
            else{
                // Functie class aanroepen
                Functions db = new Functions();
                
                // Email en wachtwoord naar inlogfunctie sturen
                int iRechten = db.loginGebruiker(sEmail, sWachtwoord);
                
                System.out.println(iRechten);
                
                // Kijken waaraan het recht gelijk is
                // Brandweer account gevonden
                if(iRechten == 1){
                    // Invoervelden leegmaken
                    txtEmail.clear();
                    txtWachtwoord.clear();
                    
                    // Validatie tekst weghalen
                    lblFeedbackEmail.setText("");
                    lblFeedbackWachtwoord.setText("");
                    
                    // Validatie classes weghalen
                    txtEmail.getStyleClass().remove("invoer--error");
                    txtEmail.getStyleClass().remove("invoer--succes");
                    txtWachtwoord.getStyleClass().remove("invoer--error");
                    txtWachtwoord.getStyleClass().remove("invoer--succes");
                    
                    // Stuur naar kazerne aanpassen pagina
                    BrandweerKazerne brandweer = new BrandweerKazerne(primaryStage, scene, sEmail);
                }
                // Overheid of gemeente account gevonden
                else if(iRechten == 2){
                    // Invoervelden leegmaken
                    txtEmail.clear();
                    txtWachtwoord.clear();
                    
                    // Validatie tekst weghalen
                    lblFeedbackEmail.setText("");
                    lblFeedbackWachtwoord.setText("");
                    
                    // Validatie classes weghalen
                    txtEmail.getStyleClass().remove("invoer--error");
                    txtEmail.getStyleClass().remove("invoer--succes");
                    txtWachtwoord.getStyleClass().remove("invoer--error");
                    txtWachtwoord.getStyleClass().remove("invoer--succes");
                    
                    // Stuur naar overzicht kazernes pagina
                    OverzichtKazernes overzicht = new OverzichtKazernes(primaryStage, scene, sEmail);
                }
                // Geen account gevonden
                else{
                    // Foutmelding maken
                    lblFeedbackInloggen.setText("Er is geen account gevonden op dit email en wachtwoord.");

                    // Inlogknop niet klikbaar maken
                    btnInloggen.setDisable(true);

                    // Classes toevoegen
                    lblFeedbackInloggen.getStyleClass().add("label--error");
                    btnInloggen.getStyleClass().add("btn-disabeld");
                }
            }
        });
        
        /*
         * Formulier validatie
         */
        // Email
        txtEmail.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            // Waarden uit het invoerveld halen en omzetten in een string
            String email = txtEmail.getText();
            // Kijken of de waarde vernieuwd is
            if (!newValue) {                
                // Kijken of de invoer leeg is
                if(email.isEmpty()){
                    // Foutmelding maken
                    lblFeedbackEmail.setText("Email moet ingevuld worden.");
                    
                    // Inlogknop niet klikbaar maken
                    btnInloggen.setDisable(true);
                    
                    // Classes toevoegen
                    lblFeedbackEmail.getStyleClass().add("label--error");
                    txtEmail.getStyleClass().add("invoer--error");
                    btnInloggen.getStyleClass().add("btn-disabeld");
                    
                    // Classes verwijderen
                    lblFeedbackEmail.getStyleClass().removeAll("label--succes");
                    txtEmail.getStyleClass().removeAll("invoer--succes");
                }
                
                else{
                    // Goedkeuring maken
                    lblFeedbackEmail.setText("oke");
                    
                    // Inlogknop klikbaar maken
                    btnInloggen.setDisable(false);
                    
                    // Classes toevoegen
                    lblFeedbackEmail.getStyleClass().add("label--succes");        
                    txtEmail.getStyleClass().add("invoer--succes");
                    
                    // Classes verwijderen
                    lblFeedbackEmail.getStyleClass().removeAll("label--error");
                    txtEmail.getStyleClass().removeAll("invoer--error");
                    btnInloggen.getStyleClass().removeAll("btn-disabeld");
                }
            }
        });
        
        // Wachtwoord
        txtWachtwoord.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            // Waarden uit het invoerveld halen en omzetten in een string
            String wachtwoord = txtWachtwoord.getText();
            // Kijken of de waarde vernieuwd is
            if (!newValue) {
                // Kijken of de invoer leeg is
                if(wachtwoord.isEmpty()){
                    // Foutmelding maken
                    lblFeedbackWachtwoord.setText("Wachtwoord moet ingevuld worden.");
                    
                    // Inlogknop niet klikbaar maken
                    btnInloggen.setDisable(true);
                    
                    // Classes toevoegen
                    lblFeedbackWachtwoord.getStyleClass().add("label--error");
                    txtWachtwoord.getStyleClass().add("invoer--error");
                    btnInloggen.getStyleClass().add("btn-disabeld");
                    
                    // Classes verwijderen
                    lblFeedbackWachtwoord.getStyleClass().removeAll("label--succes");
                    txtWachtwoord.getStyleClass().removeAll("invoer--succes");
                }
                
                else{
                    // Goedkeuring maken
                    lblFeedbackWachtwoord.setText("oke");
                    
                    // Inlogknop klikbaar maken
                    btnInloggen.setDisable(false);
                    
                    // Classes toevoegen
                    lblFeedbackWachtwoord.getStyleClass().add("label--succes");        
                    txtWachtwoord.getStyleClass().add("invoer--succes");
                    
                    // Classes verwijderen
                    lblFeedbackWachtwoord.getStyleClass().removeAll("label--error");
                    txtWachtwoord.getStyleClass().removeAll("invoer--error");
                    btnInloggen.getStyleClass().removeAll("btn-disabeld");
                }
            }  
        });
    }
}
