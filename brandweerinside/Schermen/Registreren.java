/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brandweerinside.Schermen;

import brandweerinside.Functions;
import brandweerinside.Schermen.Brandweer.BrandweerKazerne;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 *
 * @author visse
 */
public class Registreren {
    
    public Registreren(Stage primaryStage, Scene scene){
        
        /*
         * AnchorPane aanmaken voor de bovenkant van het menu
         */
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
        btnRegistrerenMenu.getStyleClass().add("menu--active");
        btnRegistrerenMenu.getStyleClass().add("menu--button");
        
        // Knoppen op de juiste plek zetten
        btnInloggenMenu.setLayoutX(425);
        btnInloggenMenu.setLayoutY(5);
        
        btnRegistrerenMenu.setLayoutX(530);
        btnRegistrerenMenu.setLayoutY(5);
        
        // Items toevoegen aan bottomMenu
        bottomMenu.getChildren().addAll(btnInloggenMenu, btnRegistrerenMenu);
        
        /*
         * alles van de root AnchorPane
         */
        AnchorPane root = new AnchorPane();
        
        // Labels aanmaken
        Label lblTitel = new Label("Registreren");
        Label lblNaam = new Label("Naam");
        Label lblWerk = new Label("Werk");
        Label lblRegio = new Label("Regio");
        Label lblEmail = new Label("Email");
        Label lblWachtwoord = new Label("Wachtwoord");
        Label lblFeedbackNaam = new Label();
        Label lblFeedbackWerk = new Label();
        Label lblFeedbackRegio = new Label();
        Label lblFeedbackEmail = new Label();
        Label lblFeedbackWachtwoord = new Label();
        Label lblFeedbackRegistreren = new Label();
        // Invoervelden aanmelden
        TextField txtNaam = new TextField();
        ComboBox cbxWerk = new ComboBox();
        TextField txtRegio = new TextField();
        TextField txtEmail = new TextField();
        PasswordField txtWachtwoord = new PasswordField();
        // Knop aanmaken
        Button btnRegistreren = new Button("Registreren");
        
        // Combobox waardes maken
        ObservableList<String> Werk = FXCollections.observableArrayList("Brandweer", "Gemeente", "Overheid");
        // Combobox vullen
        cbxWerk.setItems(Werk);
        
        // Invoervelden even groot maken
        txtNaam.setPrefWidth(300);
        cbxWerk.setPrefSize(300, 20);
        txtRegio.setPrefWidth(300);
        txtEmail.setPrefWidth(300);
        txtWachtwoord.setPrefWidth(300);
        
        // Classes toevoegen
        lblTitel.getStyleClass().add("page--title");
        lblNaam.getStyleClass().add("page--label");
        lblWerk.getStyleClass().add("page--label");
        lblRegio.getStyleClass().add("page--label");
        lblEmail.getStyleClass().add("page--label");
        lblWachtwoord.getStyleClass().add("page--label");
        btnRegistreren.getStyleClass().add("btn--default");
        lblFeedbackNaam.getStyleClass().add("feedback__label");
        lblFeedbackWerk.getStyleClass().add("feedback__label");
        lblFeedbackRegio.getStyleClass().add("feedback__label");
        lblFeedbackEmail.getStyleClass().add("feedback__label");
        lblFeedbackWachtwoord.getStyleClass().add("feedback__label");
        lblFeedbackRegistreren.getStyleClass().add("feedback__label");
        
        // Regio standaard op disabeld hebben staan
        txtRegio.setDisable(true);
        
        /* 
         * Items op de goede plaats zetten
         */
        // Titel
        lblTitel.setLayoutX(440);
        lblTitel.setLayoutY(200);
        // Naam label
        lblNaam.setLayoutX(395);
        lblNaam.setLayoutY(250);
        // Naam invoerveld
        txtNaam.setLayoutX(395);
        txtNaam.setLayoutY(280);       
        // Naam Feedback
        lblFeedbackNaam.setLayoutX(395);
        lblFeedbackNaam.setLayoutY(320);
        // Werk label
        lblWerk.setLayoutX(395);
        lblWerk.setLayoutY(360);
        // Werk invoerveld
        cbxWerk.setLayoutX(395);
        cbxWerk.setLayoutY(390);
        // Werk feedback
        lblFeedbackWerk.setLayoutX(395);
        lblFeedbackWerk.setLayoutY(430);
        // Regio label
        lblRegio.setLayoutX(395);
        lblRegio.setLayoutY(470);
        // Regio invoerveld
        txtRegio.setLayoutX(395);
        txtRegio.setLayoutY(500);
        // Regio feedback
        lblFeedbackRegio.setLayoutX(395);
        lblFeedbackRegio.setLayoutY(540);
        // Email label
        lblEmail.setLayoutX(395);
        lblEmail.setLayoutY(580);
        // Email invoer
        txtEmail.setLayoutX(395);
        txtEmail.setLayoutY(610);
        // Email feedback
        lblFeedbackEmail.setLayoutX(395);
        lblFeedbackEmail.setLayoutY(650);
        // Wachtwoord label
        lblWachtwoord.setLayoutX(395);
        lblWachtwoord.setLayoutY(690);
        // Wachtwoord invoer
        txtWachtwoord.setLayoutX(395);
        txtWachtwoord.setLayoutY(720);
        // Wachtwoord feedback
        lblFeedbackWachtwoord.setLayoutX(395);
        lblFeedbackWachtwoord.setLayoutY(760);
        // Registreer knop
        btnRegistreren.setLayoutX(395);
        btnRegistreren.setLayoutY(800);
        // Registreer feedback
        lblFeedbackRegistreren.setLayoutX(395);
        lblFeedbackRegistreren.setLayoutY(845);
        
        /*
         * Alles in de root AnchorPane zetten
         */
        root.getChildren().addAll(topMenu, bottomMenu, lblTitel, lblNaam, txtNaam, lblWerk, cbxWerk, lblRegio, txtRegio, lblEmail, txtEmail,
                                  lblWachtwoord, txtWachtwoord, btnRegistreren, lblFeedbackNaam, lblFeedbackWerk, lblFeedbackRegio, lblFeedbackEmail, 
                                  lblFeedbackWachtwoord, lblFeedbackRegistreren);
        
        /*
         * Functie achter de knoppen
         */
        // Registratie knop
        btnRegistreren.setOnAction(event -> {
            //Registreren registratie = new Registreren(primaryStage, scene);
            
            // Kijken of werk combobox leeg is, anders de functie uitvoeren
            try{
                // Waardes uit de invoervelden halen en omzetten naar string
                String sNaam = txtNaam.getText();
                String sWerk = cbxWerk.getValue().toString();
                String sRegio = txtRegio.getText();
                String sEmail = txtEmail.getText();
                String sWachtwoord = txtWachtwoord.getText();
                
                // Kijken werk gelijk is aan brandweer
                if(!sWerk.matches("Brandweer")){
                    if(sNaam.isEmpty() && sWerk.isEmpty() && sEmail.isEmpty() && sWachtwoord.isEmpty()){
                        // Foutmelding maken
                        lblFeedbackRegistreren.setText("Naam, Werk, Email en Wachtwoord zijn niet ingevuld.");

                        // Registreer knop niet klikbaar maken
                        btnRegistreren.setDisable(true);

                        // Classes toevoegen
                        lblFeedbackRegistreren.getStyleClass().add("label--error");
                        btnRegistreren.getStyleClass().add("btn-disabeld");
                    }

                    // Kijken of er een of meerdere invoerveld niet isgevuld
                    else if(sNaam.isEmpty() || sWerk.isEmpty() || sEmail.isEmpty() || sWachtwoord.isEmpty()){
                        // Foutmelding maken
                        lblFeedbackRegistreren.setText("Er is een of meerdere velden niet ingevuld.");

                        // Registreer knop niet klikbaar maken
                        btnRegistreren.setDisable(true);

                        // Classes toevoegen
                        lblFeedbackRegistreren.getStyleClass().add("label--error");
                        btnRegistreren.getStyleClass().add("btn-disabeld");
                    }

                    // Als alles is ingevuld behalve regio
                    else{
                        // Variabele voor string aanmaken
                        String sRecht = "OverheidGemeente";
                        
                        // Functie class aanroepen
                        Functions db = new Functions();
                        
                        // Ingevulde waarde naar de functie sturen
                        int iRegistratie = db.addGebruiker(sNaam, sWerk, sRegio, sEmail, sWachtwoord, sRecht);
                        
                        // Kijken of registratie gelukt is
                        if(iRegistratie == 2){
                            Alert alert = new Alert(AlertType.INFORMATION, "Je account is aangemaakt. Je bent nu gelijk ingelogd.", ButtonType.OK);
                            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                            alert.show();
                            
                            // Gebruiker naar overzicht kazernes sturen
                            System.out.println("Hai, het is gelukt");
                        }
                        else{
                            // Foutmelding maken
                            lblFeedbackRegistreren.setText("Registratie is niet gelukt, probeer het later opnieuw.");

                            // Classes toevoegen
                            lblFeedbackRegistreren.getStyleClass().add("label--error");
                            btnRegistreren.getStyleClass().add("btn-disabeld");
                        }
                    }
                }
                // Werk is hier gelijk aan brandweer
                else{
                    if(sNaam.isEmpty() && sWerk.isEmpty() && sRegio.isEmpty() && sEmail.isEmpty() && sWachtwoord.isEmpty()){
                        // Foutmelding maken
                        lblFeedbackRegistreren.setText("Naam, Werk, Regio, Email en Wachtwoord zijn niet ingevuld.");

                        // Registreer knop niet klikbaar maken
                        btnRegistreren.setDisable(true);

                        // Classes toevoegen
                        lblFeedbackRegistreren.getStyleClass().add("label--error");
                        btnRegistreren.getStyleClass().add("btn-disabeld");
                    }

                    // Kijken of er een of meerdere invoerveld niet isgevuld
                    else if(sNaam.isEmpty() || sWerk.isEmpty() || sRegio.isEmpty() || sEmail.isEmpty() || sWachtwoord.isEmpty()){
                        // Foutmelding maken
                        lblFeedbackRegistreren.setText("Er is een of meerdere velden niet ingevuld.");

                        // Registreer knop niet klikbaar maken
                        btnRegistreren.setDisable(true);

                        // Classes toevoegen
                        lblFeedbackRegistreren.getStyleClass().add("label--error");
                        btnRegistreren.getStyleClass().add("btn-disabeld");
                    }

                    // Als alles is ingevuld behalve regio
                    else{
                        // Variabele voor string aanmaken
                        String sRecht = "Brandweer";
                        
                        // Functie class aanroepen
                        Functions db = new Functions();
                        
                        // Ingevulde waarde naar de functie sturen
                        int iRegistratie = db.addGebruiker(sNaam, sWerk, sRegio, sEmail, sWachtwoord, sRecht);
                        
                        // Kijken of registratie gelukt is voor brandweer
                        if(iRegistratie == 1){
                            Alert alert = new Alert(AlertType.INFORMATION, "Je account is aangemaakt. Je bent nu gelijk ingelogd.", ButtonType.OK);
                            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                            alert.show();
                            
                            // Gebruiker naar overzicht kazernes sturen
                            BrandweerKazerne brandweer = new BrandweerKazerne(primaryStage, scene, sEmail);
                        }
                        
                        // Kijken of registratie gelukt is voor gemeente of overheid
                        else if(iRegistratie == 2){
                            Alert alert = new Alert(AlertType.INFORMATION, "Je account is aangemaakt. Je bent nu gelijk ingelogd.", ButtonType.OK);
                            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
                            alert.show();
                            
                            // Gebruiker naar overzicht kazernes sturen
                            BrandweerKazerne brandweer = new BrandweerKazerne(primaryStage, scene, sEmail);
                        }
                        
                        // Registratie niet gelukt
                        else{
                            System.out.println(iRegistratie);
                            // Foutmelding maken
                            lblFeedbackRegistreren.setText("Registratie is niet gelukt, probeer het later opnieuw.");

                            // Classes toevoegen
                            lblFeedbackRegistreren.getStyleClass().add("label--error");
                            btnRegistreren.getStyleClass().add("btn-disabeld");
                        }
                    }
                }
            }
            catch(NullPointerException e){
                // Foutmelding maken
                lblFeedbackRegistreren.setText("Vul werk in.");

                // Registreer knop niet klikbaar maken
                btnRegistreren.setDisable(true);

                // Classes toevoegen
                lblFeedbackRegistreren.getStyleClass().add("label--error");
                btnRegistreren.getStyleClass().add("btn-disabeld");
            }
            finally{
                // rotzooi opruiten, wordt altijd uitgevoerd
                // Gebruik javadoc, aka @param (parameter)
            }
        });
        
        // Inlog knop
        btnInloggenMenu.setOnAction(new EventHandler<ActionEvent>() {
            // Gebruiker terugsturen naar inlog pagina
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene);
            }
        });
        
        // Zorgen dat regio alleen maar hoofdletters bevat
        txtRegio.setTextFormatter(new TextFormatter<>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        }));
        
        /*
         * Form validation
         */
        // Naam
        txtNaam.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            // Waarden uit het invoerveld halen en omzetten in een string
            String naam = txtNaam.getText();
            // Kijken of de waarde vernieuwd is
            if (!newValue) {                
                // Kijken of de invoer leeg is
                if(naam.isEmpty()){
                    // Foutmelding maken
                    lblFeedbackNaam.setText("Naam moet ingevuld worden.");
                    
                    // Registreer knop niet klikbaar maken
                    btnRegistreren.setDisable(true);
                    
                    // Classes toevoegen
                    lblFeedbackNaam.getStyleClass().add("label--error");
                    txtNaam.getStyleClass().add("invoer--error");
                    btnRegistreren.getStyleClass().add("btn-disabeld");
                    
                    // Classes verwijderen
                    lblFeedbackNaam.getStyleClass().removeAll("label--succes");
                    txtNaam.getStyleClass().removeAll("invoer--succes");
                }
                
                else{
                    // Goedkeuring maken
                    lblFeedbackNaam.setText("oke");
                    
                    // Registreerknop klikbaar maken
                    btnRegistreren.setDisable(false);
                    
                    // Classes toevoegen
                    lblFeedbackNaam.getStyleClass().add("label--succes");        
                    txtNaam.getStyleClass().add("invoer--succes");
                    
                    // Classes verwijderen
                    lblFeedbackNaam.getStyleClass().removeAll("label--error");
                    txtNaam.getStyleClass().removeAll("invoer--error");
                    btnRegistreren.getStyleClass().removeAll("btn-disabeld");
                }
            }
        });
        
        // Werk en regio ( alleen als regio gelijk is aan brandweer )
        cbxWerk.setOnAction(event -> {
            // Waarden uit de combobox halen en omzetten naar een string
            String werk = cbxWerk.getValue().toString();
            
            // kijken of het leeg is
            if(werk.isEmpty()){
                // Foutmelding maken
                lblFeedbackWerk.setText("werk moet ingevuld worden.");

                // Registreer niet klikbaar maken
                btnRegistreren.setDisable(true);

                // Classes toevoegen
                lblFeedbackWerk.getStyleClass().add("label--error");
                cbxWerk.getStyleClass().add("invoer--error");
                btnRegistreren.getStyleClass().add("btn-disabeld");

                // Classes verwijderen
                lblFeedbackWerk.getStyleClass().removeAll("label--succes");
                cbxWerk.getStyleClass().removeAll("invoer--succes");
            }
            
            // Kijken of het niet gelijk is aan werk
            if(!werk.matches("Brandweer")){
                lblFeedbackWerk.setText("Oke");
                
                // Registreerknop klikbaar maken
                btnRegistreren.setDisable(false);
                
                // Regio invoerveld leeg maken en niet invulbaar maken
                txtRegio.clear();
                txtRegio.setDisable(true);

                // Classes toevoegen
                lblFeedbackWerk.getStyleClass().add("label--succes");        
                cbxWerk.getStyleClass().add("invoer--succes");

                // Classes verwijderen
                lblFeedbackWerk.getStyleClass().removeAll("label--error");
                cbxWerk.getStyleClass().removeAll("invoer--error");
                btnRegistreren.getStyleClass().removeAll("btn-disabeld");
                
                // Formvalidatie van de regio weghalen
                lblFeedbackRegio.setText("");
                txtRegio.getStyleClass().removeAll("invoer--error");
                txtRegio.getStyleClass().removeAll("invoer--succes");
            }
            
            else{
                // Goedkeuring maken
                lblFeedbackWerk.setText("oke");

                // Registreerknop klikbaar maken
                btnRegistreren.setDisable(false);
                
                // Regio invoerveld invulbaar maken
                txtRegio.setDisable(false);

                // Classes toevoegen
                lblFeedbackWerk.getStyleClass().add("label--succes");        
                cbxWerk.getStyleClass().add("invoer--succes");

                // Classes verwijderen
                lblFeedbackWerk.getStyleClass().removeAll("label--error");
                cbxWerk.getStyleClass().removeAll("invoer--error");
                btnRegistreren.getStyleClass().removeAll("btn-disabeld");
                
                // Regio valideren
                txtRegio.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                    // Waarden uit het invoerveld halen en omzetten in een string
                    String regio = txtRegio.getText();
                    // Kijken of de waarde vernieuwd is
                    if (!newValue) {                
                        // Kijken of de invoer leeg is
                        if(regio.isEmpty()){
                            // Foutmelding maken
                            lblFeedbackRegio.setText("Regio moet ingevuld worden.");

                            // Registreer niet klikbaar maken
                            btnRegistreren.setDisable(true);

                            // Classes toevoegen
                            lblFeedbackRegio.getStyleClass().add("label--error");
                            txtRegio.getStyleClass().add("invoer--error");
                            btnRegistreren.getStyleClass().add("btn-disabeld");

                            // Classes verwijderen
                            lblFeedbackRegio.getStyleClass().removeAll("label--succes");
                            txtRegio.getStyleClass().removeAll("invoer--succes");
                        }

                        else{
                            // Goedkeuring maken
                            lblFeedbackRegio.setText("oke");

                            // Registreerknop klikbaar maken
                            btnRegistreren.setDisable(false);

                            // Classes toevoegen
                            lblFeedbackRegio.getStyleClass().add("label--succes");        
                            txtRegio.getStyleClass().add("invoer--succes");

                            // Classes verwijderen
                            lblFeedbackRegio.getStyleClass().removeAll("label--error");
                            txtRegio.getStyleClass().removeAll("invoer--error");
                            btnRegistreren.getStyleClass().removeAll("btn-disabeld");
                        }
                    }
                });
            }
        });
        
        // Regio
        txtRegio.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            try{
                // Waarden uit het invoerveld halen en omzetten in een string
                String regio = txtRegio.getText();
                String werk = cbxWerk.getValue().toString();
                // Kijken of werk gelijk is aan brandweer
                if(werk.matches("Brandweer")){
                    // Kijken of de waarde vernieuwd is
                    if (!newValue) {
                        if(regio.isEmpty()){
                            // Foutmelding maken
                            lblFeedbackRegio.setText("Regio moet ingevuld worden.");

                            // Registreer niet klikbaar maken
                            btnRegistreren.setDisable(true);

                            // Classes toevoegen
                            lblFeedbackRegio.getStyleClass().add("label--error");
                            txtRegio.getStyleClass().add("invoer--error");
                            btnRegistreren.getStyleClass().add("btn-disabeld");

                            // Classes verwijderen
                            lblFeedbackRegio.getStyleClass().removeAll("label--succes");
                            txtRegio.getStyleClass().removeAll("invoer--succes");
                        }

                        else{
                            // Goedkeuring maken
                            lblFeedbackRegio.setText("oke");

                            // Registreerknop klikbaar maken
                            btnRegistreren.setDisable(false);

                            // Classes toevoegen
                            lblFeedbackRegio.getStyleClass().add("label--succes");        
                            txtRegio.getStyleClass().add("invoer--succes");

                            // Classes verwijderen
                            lblFeedbackRegio.getStyleClass().removeAll("label--error");
                            txtRegio.getStyleClass().removeAll("invoer--error");
                            btnRegistreren.getStyleClass().removeAll("btn-disabeld");
                        }
                    }
                }
                else{
                    // Formvalidatie weg halen
                    txtRegio.getStyleClass().removeAll("invoer--error");
                    txtRegio.getStyleClass().removeAll("invoer--succes");
                    lblFeedbackRegio.getStyleClass().removeAll("invoer--error");
                    lblFeedbackRegio.getStyleClass().removeAll("invoer--succes");
                }
            }
            catch(Exception e){
                System.out.println("Werk is nog niet ingevuld");
                
            }
        });
        
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
                    
                    // Registreer niet klikbaar maken
                    btnRegistreren.setDisable(true);
                    
                    // Classes toevoegen
                    lblFeedbackEmail.getStyleClass().add("label--error");
                    txtEmail.getStyleClass().add("invoer--error");
                    btnRegistreren.getStyleClass().add("btn-disabeld");
                    
                    // Classes verwijderen
                    lblFeedbackEmail.getStyleClass().removeAll("label--succes");
                    txtEmail.getStyleClass().removeAll("invoer--succes");
                }
                
                else{
                    // Goedkeuring maken
                    lblFeedbackEmail.setText("oke");
                    
                    // Registreerknop klikbaar maken
                    btnRegistreren.setDisable(false);
                    
                    // Classes toevoegen
                    lblFeedbackEmail.getStyleClass().add("label--succes");        
                    txtEmail.getStyleClass().add("invoer--succes");
                    
                    // Classes verwijderen
                    lblFeedbackEmail.getStyleClass().removeAll("label--error");
                    txtEmail.getStyleClass().removeAll("invoer--error");
                    btnRegistreren.getStyleClass().removeAll("btn-disabeld");
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
                    
                    // Registreer niet klikbaar maken
                    btnRegistreren.setDisable(true);
                    
                    // Classes toevoegen
                    lblFeedbackWachtwoord.getStyleClass().add("label--error");
                    txtWachtwoord.getStyleClass().add("invoer--error");
                    btnRegistreren.getStyleClass().add("btn-disabeld");
                    
                    // Classes verwijderen
                    lblFeedbackWachtwoord.getStyleClass().removeAll("label--succes");
                    txtWachtwoord.getStyleClass().removeAll("invoer--succes");
                }
                
                else{
                    // Goedkeuring maken
                    lblFeedbackWachtwoord.setText("oke");
                    
                    // Registreerknop klikbaar maken
                    btnRegistreren.setDisable(false);
                    
                    // Classes toevoegen
                    lblFeedbackWachtwoord.getStyleClass().add("label--succes");        
                    txtWachtwoord.getStyleClass().add("invoer--succes");
                    
                    // Classes verwijderen
                    lblFeedbackWachtwoord.getStyleClass().removeAll("label--error");
                    txtWachtwoord.getStyleClass().removeAll("invoer--error");
                    btnRegistreren.getStyleClass().removeAll("btn-disabeld");
                }
            }  
        });
        
        /*
         * Stage aanmaken
         */
        Scene nieuwScene = new Scene(root, 1080, 875);
        primaryStage.setScene(nieuwScene); 
        // Linken naar Stylesheet
        nieuwScene.getStylesheets().add(this.getClass().getResource("/brandweerinside/Assets/style.css").toExternalForm()); 
    }
}
