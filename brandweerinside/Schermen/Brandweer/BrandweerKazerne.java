/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brandweerinside.Schermen.Brandweer;

import brandweerinside.EntiteitClasses.EntGebruiker;
import brandweerinside.EntiteitClasses.EntKazerne;
import brandweerinside.Functions;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author visse
 */
public class BrandweerKazerne {
    
    public BrandweerKazerne(Stage primaryStage, Scene scene, String sEmail){
        // Functie class aanspreken
        Functions db = new Functions();
        
        // Array aanmaken voor gebruikers en die vullen met de gebruiker uit getGebruiker
        ObservableList<EntGebruiker> gebruikers = FXCollections.observableArrayList(db.getGebruiker(sEmail));
        
        // Door gebruikers heen gaan
        for(EntGebruiker user: gebruikers){            
            // variabele aanmaken voor regio
            String sRegio = user.getRegio();
            System.out.println(sRegio);
            
            // Array aanmaken met waardes kazerne van de regio
            ObservableList<EntKazerne> kazernes = FXCollections.observableArrayList(db.getKazerne(sRegio));
            
            for(EntKazerne kazerne: kazernes){
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

                // Knop aanmaken
                Button btnUitloggen = new Button("Uitloggen");    

                // Classes toevoegen
                btnUitloggen.getStyleClass().add("menu--button");

                // Knop op de juiste plek zetten
                btnUitloggen.setLayoutX(25);
                btnUitloggen.setLayoutY(5);

                // Items toevoegen aan bottomMenu
                bottomMenu.getChildren().addAll(btnUitloggen);

                /*
                * alles van de root AnchorPane
                */
                AnchorPane root = new AnchorPane();

                // Labels aanmaken
                Label lblTitel = new Label("Details kazerne");
                Label lblTitelProfessioneel = new Label("Professionele werknemers");
                Label lblTitelVrijwillig = new Label("Vrijwillige werknemers");
                Label lblTitelNietOperationeel = new Label("Niet operationele werknemers");
                Label lblProfessioneelMan = new Label("Professionele mannen");
                Label lblProfessioneelVrouw = new Label("Professionele vrouwen");
                Label lblProfessioneelHogeRank = new Label("Hoge rank");
                Label lblProfessioneelMiddenRank = new Label("Midden rank");
                Label lblProfessioneelLageRank = new Label("Lage rank");
                Label lblVrijwilligMan = new Label("Mannen");
                Label lblVrijwilligVrouw = new Label("Vrouwen");
                Label lblVrijwilligHogeRank = new Label("Hoge rank");
                Label lblVrijwilligMiddenRank = new Label("Midden rank");
                Label lblVrijwilligLageRank = new Label("Lage rank");
                Label lblOpleidingHboWo = new Label("HBO of Wo Opleidingsniveau");
                Label lblOpleidingMbo = new Label("MBO opleidingsniveau");
                Label lblOpleidingLbo = new Label("LBO opleidingsniveau");
                Label lblTekort = new Label("Tekort");
                Label lblFeedbackProfessioneelMan = new Label("");
                Label lblFeedbackProfessioneelVrouw = new Label("");
                Label lblFeedbackProfessioneelHogeRank = new Label("");
                Label lblFeedbackProfessioneelMiddenRank = new Label("");
                Label lblFeedbackProfessioneelLageRank = new Label("");
                Label lblFeedbackVrijwilligMan = new Label("");
                Label lblFeedbackVrijwilligVrouw = new Label("");
                Label lblFeedbackVrijwilligHogeRank = new Label("");
                Label lblFeedbackVrijwilligMiddenRank = new Label("");
                Label lblFeedbackVrijwilligLageRank = new Label("");
                Label lblFeedbackOpleidingHboWo = new Label("");
                Label lblFeedbackOpleidingMbo = new Label("");
                Label lblFeedbackOpleidingLbo = new Label("");
                Label lblFeedbackUpdateKazerne = new Label("");
                // Invoervelden aanmelden
                TextField txtProfessioneelMan = new TextField();
                TextField txtProfessioneelVrouw = new TextField();
                TextField txtProfessioneelHogeRank = new TextField();
                TextField txtProfessioneelMiddenRank = new TextField();
                TextField txtProfessioneelLageRank = new TextField();
                TextField txtVrijwilligMan = new TextField();
                TextField txtVrijwilligVrouw = new TextField();
                TextField txtVrijwilligHogeRank = new TextField();
                TextField txtVrijwilligMiddenRank = new TextField();
                TextField txtVrijwilligLageRank = new TextField();
                TextField txtOpleidingHboWo = new TextField();
                TextField txtOpleidingMbo = new TextField();
                TextField txtOpleidingLbo = new TextField();
                //TextField txtProfessioneelHogeRank = new TextField();
                // Checkbox maken
                CheckBox cbTekort = new CheckBox("Ja, er is een tekort");
                // Knop aanmaken
                Button btnUpdateKazerne = new Button("Gegevens aanpassen");

                // Classes toevoegen
                lblTitel.getStyleClass().add("page--title");
                lblTitelProfessioneel.getStyleClass().add("page--section");
                lblTitelVrijwillig.getStyleClass().add("page--section");
                lblTitelNietOperationeel.getStyleClass().add("page--section");
                lblProfessioneelMan.getStyleClass().add("page--label");
                lblProfessioneelVrouw.getStyleClass().add("page--label");
                lblProfessioneelHogeRank.getStyleClass().add("page--label");
                lblProfessioneelMiddenRank.getStyleClass().add("page--label");
                lblProfessioneelLageRank.getStyleClass().add("page--label");
                lblVrijwilligMan.getStyleClass().add("page--label");
                lblVrijwilligVrouw.getStyleClass().add("page--label");
                lblVrijwilligHogeRank.getStyleClass().add("page--label");
                lblVrijwilligMiddenRank.getStyleClass().add("page--label");
                txtVrijwilligLageRank.getStyleClass().add("page--label");
                lblOpleidingHboWo.getStyleClass().add("page--label");
                lblOpleidingMbo.getStyleClass().add("page--label");
                lblOpleidingLbo.getStyleClass().add("page--label");
                lblTekort.getStyleClass().add("page--label");

                btnUpdateKazerne.getStyleClass().add("btn--default");

                lblFeedbackProfessioneelMan.getStyleClass().add("feedback__label");
                lblFeedbackProfessioneelVrouw.getStyleClass().add("feedback__label");
                lblFeedbackProfessioneelHogeRank.getStyleClass().add("feedback__label");
                lblFeedbackProfessioneelMiddenRank.getStyleClass().add("feedback__label");
                lblFeedbackProfessioneelLageRank.getStyleClass().add("feedback__label");
                lblFeedbackVrijwilligMan.getStyleClass().add("feedback__label");
                lblFeedbackVrijwilligVrouw.getStyleClass().add("feedback__label");
                lblFeedbackVrijwilligHogeRank.getStyleClass().add("feedback__label");
                lblFeedbackVrijwilligMiddenRank.getStyleClass().add("feedback__label");
                lblFeedbackVrijwilligLageRank.getStyleClass().add("feedback__label");
                lblFeedbackOpleidingHboWo.getStyleClass().add("feedback__label");
                lblFeedbackOpleidingMbo.getStyleClass().add("feedback__label");
                lblFeedbackOpleidingLbo.getStyleClass().add("feedback__label");
                lblFeedbackUpdateKazerne.getStyleClass().add("feedback__label");
                
                // Invoervelden met 2 per rij groter maken
                // Professioneel man en vrouw
                txtProfessioneelMan.setPrefWidth(380);
                txtProfessioneelVrouw.setPrefWidth(380);
                // Vrijwillig man en vrouw
                txtVrijwilligMan.setPrefWidth(380);
                txtVrijwilligVrouw.setPrefWidth(380);
                
                /*
                 * Tekst in de teksvelden zetten
                 */
                txtProfessioneelMan.setText(kazerne.getProfessioneelMan().toString());
                txtProfessioneelVrouw.setText(kazerne.getProfessioneelVrouw().toString());
                txtProfessioneelHogeRank.setText(kazerne.getProfessioneelHogeRank().toString());
                txtProfessioneelMiddenRank.setText(kazerne.getProfessioneelMiddenRank().toString());
                txtProfessioneelLageRank.setText(kazerne.getProfessioneelLageRank().toString());
                txtVrijwilligMan.setText(kazerne.getVrijwilligerMan().toString());
                txtVrijwilligVrouw.setText(kazerne.getVrijwilligerVrouw().toString());
                txtVrijwilligHogeRank.setText(kazerne.getVrijwilligerHogeRank().toString());
                txtVrijwilligMiddenRank.setText(kazerne.getVrijwilligerMiddenRank().toString());
                txtVrijwilligLageRank.setText(kazerne.getVrijwilligerLageRank().toString());
                txtOpleidingHboWo.setText(kazerne.getNietOperationeelHboWo().toString());
                txtOpleidingMbo.setText(kazerne.getNietOperationeelMbo().toString());
                txtOpleidingLbo.setText(kazerne.getNietOperationeelLbo().toString());
                // Kijken of er een tekort is, 1 betekent ja
                if(kazerne.getTekort() == 1){
                    // Checkbox checked maken
                    cbTekort.setSelected(true);
                }
                
                /* 
                 * Items op de goede plaats zetten
                 */
                // Titel
                lblTitel.setLayoutX(440);
                lblTitel.setLayoutY(160);
                // Titel Professioneel
                lblTitelProfessioneel.setLayoutX(100);
                lblTitelProfessioneel.setLayoutY(210);
                // Profesioneel man label
                lblProfessioneelMan.setLayoutX(100);
                lblProfessioneelMan.setLayoutY(250);       
                // Professioneel man invoerveld
                txtProfessioneelMan.setLayoutX(100);
                txtProfessioneelMan.setLayoutY(275);
                // Professioneel man feedback
                lblFeedbackProfessioneelMan.setLayoutX(100);
                lblFeedbackProfessioneelMan.setLayoutY(315);
                // Professioneel vrouw label
                lblProfessioneelVrouw.setLayoutX(550);
                lblProfessioneelVrouw.setLayoutY(250);
                // Professioneel vrouw invoerveld
                txtProfessioneelVrouw.setLayoutX(550);
                txtProfessioneelVrouw.setLayoutY(275);
                // Professioneel vrouw feedback
                lblFeedbackProfessioneelVrouw.setLayoutX(550);
                lblFeedbackProfessioneelVrouw.setLayoutY(315);
                // Professioneel hoger rank label
                lblProfessioneelHogeRank.setLayoutX(100);
                lblProfessioneelHogeRank.setLayoutY(350);
                // Professioneel hoger rank invoerveld
                txtProfessioneelHogeRank.setLayoutX(100);
                txtProfessioneelHogeRank.setLayoutY(375);
                // Professioneel hoger rank feedback
                lblFeedbackProfessioneelHogeRank.setLayoutX(100);
                lblFeedbackProfessioneelHogeRank.setLayoutY(415);
                // Professioneel midden rank label
                lblProfessioneelMiddenRank.setLayoutX(400);
                lblProfessioneelMiddenRank.setLayoutY(350);
                // Professioneel midden rank invoerveld
                txtProfessioneelMiddenRank.setLayoutX(400);
                txtProfessioneelMiddenRank.setLayoutY(375);
                // Professioneel midden rank feedback
                lblFeedbackProfessioneelMiddenRank.setLayoutX(400);
                lblFeedbackProfessioneelMiddenRank.setLayoutY(415);
                // Professioneel lager rank label
                lblProfessioneelLageRank.setLayoutX(700);
                lblProfessioneelLageRank.setLayoutY(350);
                // Professioneel lager rank invoerveld
                txtProfessioneelLageRank.setLayoutX(700);
                txtProfessioneelLageRank.setLayoutY(375);
                // Professioneel lager rank feedback
                lblFeedbackProfessioneelLageRank.setLayoutX(700);
                lblFeedbackProfessioneelLageRank.setLayoutY(415);
                // Titel vrijwilligers label
                lblTitelVrijwillig.setLayoutX(100);
                lblTitelVrijwillig.setLayoutY(450);
                // Vrijwilliger man label
                lblVrijwilligMan.setLayoutX(100);
                lblVrijwilligMan.setLayoutY(490);       
                // Vrijwilliger man invoerveld
                txtVrijwilligMan.setLayoutX(100);
                txtVrijwilligMan.setLayoutY(515);
                // Vrijwilliger man feedback
                lblFeedbackVrijwilligMan.setLayoutX(100);
                lblFeedbackVrijwilligMan.setLayoutY(555);
                // Vrijwilliger vrouw label
                lblVrijwilligVrouw.setLayoutX(550);
                lblVrijwilligVrouw.setLayoutY(490);
                // Vrijwilliger vrouw invoerveld
                txtVrijwilligVrouw.setLayoutX(550);
                txtVrijwilligVrouw.setLayoutY(515);
                // Vrijwilliger vrouw feedback
                lblFeedbackVrijwilligVrouw.setLayoutX(550);
                lblFeedbackVrijwilligVrouw.setLayoutY(555);
                // Vrijwilliger hoger rank label
                lblVrijwilligHogeRank.setLayoutX(100);
                lblVrijwilligHogeRank.setLayoutY(575);
                // Vrijwilliger hoger rank invoerveld
                txtVrijwilligHogeRank.setLayoutX(100);
                txtVrijwilligHogeRank.setLayoutY(600);
                // Vrijwilliger hoger rank feedback
                lblFeedbackVrijwilligHogeRank.setLayoutX(100);
                lblFeedbackVrijwilligHogeRank.setLayoutY(640);
                // Vrijwilliger midden rank label
                lblVrijwilligMiddenRank.setLayoutX(400);
                lblVrijwilligMiddenRank.setLayoutY(575);
                // Vrijwilliger midden rank invoerveld
                txtVrijwilligMiddenRank.setLayoutX(400);
                txtVrijwilligMiddenRank.setLayoutY(600);
                // Vrijwilliger midden rank feedback
                lblFeedbackVrijwilligMiddenRank.setLayoutX(400);
                lblFeedbackVrijwilligMiddenRank.setLayoutY(640);
                // Vrijwilliger lager rank label
                lblVrijwilligLageRank.setLayoutX(700);
                lblVrijwilligLageRank.setLayoutY(575);
                // Vrijwilliger lager rank invoerveld
                txtVrijwilligLageRank.setLayoutX(700);
                txtVrijwilligLageRank.setLayoutY(600);
                // Vrijwilliger lager rank feedback
                lblFeedbackVrijwilligLageRank.setLayoutX(700);
                lblFeedbackVrijwilligLageRank.setLayoutY(640);
                // Titel niet operationeel label
                lblTitelNietOperationeel.setLayoutX(100);
                lblTitelNietOperationeel.setLayoutY(680);
                // Niet operationeel HBO/WO label
                lblOpleidingHboWo.setLayoutX(100);
                lblOpleidingHboWo.setLayoutY(720);
                // Niet operationeel HBO/WO invoerveld
                txtOpleidingHboWo.setLayoutX(100);
                txtOpleidingHboWo.setLayoutY(745);
                // Niet operationeel HBO/WO feedback
                lblFeedbackOpleidingHboWo.setLayoutX(100);
                lblFeedbackOpleidingHboWo.setLayoutY(785);
                // Niet operationeel MBO label
                lblOpleidingMbo.setLayoutX(400);
                lblOpleidingMbo.setLayoutY(720);
                // Niet operationeel MBO invoerveld
                txtOpleidingMbo.setLayoutX(400);
                txtOpleidingMbo.setLayoutY(745);
                // Niet operationeel MBO feedback
                lblFeedbackOpleidingMbo.setLayoutX(400);
                lblFeedbackOpleidingMbo.setLayoutY(785);
                // Niet operationeel LBO label
                lblOpleidingLbo.setLayoutX(700);
                lblOpleidingLbo.setLayoutY(720);
                // Niet operationeel LBO invoerveld
                txtOpleidingLbo.setLayoutX(700);
                txtOpleidingLbo.setLayoutY(745);
                // Niet operationeel LBO feedback
                lblFeedbackOpleidingLbo.setLayoutX(700);
                lblFeedbackOpleidingLbo.setLayoutY(785);
                // Tekort label
                lblTekort.setLayoutX(100);
                lblTekort.setLayoutY(825);
                // Tekort invoerveld
                cbTekort.setLayoutX(100);
                cbTekort.setLayoutY(850);
                // Aanpas knop
                btnUpdateKazerne.setLayoutX(450);
                btnUpdateKazerne.setLayoutY(900);
                // Feedback aanpas knop
                lblFeedbackUpdateKazerne.setLayoutX(450);
                lblFeedbackUpdateKazerne.setLayoutY(950);

                /*
                 * Alles in de root AnchorPane zetten
                 */
                root.getChildren().addAll(topMenu, bottomMenu, lblTitel, lblTitelProfessioneel, lblTitelVrijwillig, lblTitelNietOperationeel, lblProfessioneelMan,
                                         lblProfessioneelVrouw, lblProfessioneelHogeRank, lblProfessioneelMiddenRank, lblProfessioneelLageRank, lblVrijwilligMan,
                                         lblVrijwilligVrouw, lblVrijwilligHogeRank, lblVrijwilligMiddenRank, lblVrijwilligLageRank, lblOpleidingHboWo,
                                         lblOpleidingMbo, lblOpleidingLbo, lblTekort, lblFeedbackProfessioneelMan, lblFeedbackProfessioneelVrouw, lblFeedbackProfessioneelHogeRank,
                                         lblFeedbackProfessioneelMiddenRank, lblFeedbackProfessioneelLageRank, lblFeedbackVrijwilligMan, lblFeedbackVrijwilligVrouw, lblFeedbackVrijwilligHogeRank,
                                         lblFeedbackVrijwilligMiddenRank, lblFeedbackVrijwilligLageRank, lblFeedbackOpleidingHboWo, lblFeedbackOpleidingMbo,
                                         lblFeedbackOpleidingLbo, txtProfessioneelMan, txtProfessioneelVrouw, txtProfessioneelHogeRank, txtProfessioneelMiddenRank,
                                         txtProfessioneelLageRank, txtVrijwilligMan, txtVrijwilligVrouw, txtVrijwilligHogeRank, txtVrijwilligMiddenRank, 
                                         txtVrijwilligLageRank, txtOpleidingHboWo, txtOpleidingMbo, txtOpleidingLbo, cbTekort, btnUpdateKazerne, lblFeedbackUpdateKazerne);        
                /*
                 * Functies achter de knoppen
                 */
                // Gegevens updaten knop knop
                btnUpdateKazerne.setOnAction(event -> {
                   // Waarden uit de invoervelden halen en omzetten in Strings
                   // Dit is zodat ik kan checken of het leeg is, wanneer het naar de functie gaat worden het ints.
                   // De formumvalidatie houdt tegen dat er letters ingevuld worden zodat het veillig naar ints kan
                   String sProfessioneelMan = txtProfessioneelMan.getText();
                   String sProfessioneelVrouw = txtProfessioneelVrouw.getText();
                   String sProfessioneelHogeRank = txtProfessioneelHogeRank.getText();
                   String sProfessioneelMiddenRank = txtProfessioneelMiddenRank.getText();
                   String sProfessioneelLageRank = txtProfessioneelLageRank.getText();
                   String sVrijwilligMan = txtVrijwilligMan.getText();
                   String sVrijwilligVrouw = txtVrijwilligVrouw.getText();
                   String sVrijwilligHogeRank = txtVrijwilligHogeRank.getText();
                   String sVrijwilligMiddenRank = txtVrijwilligMiddenRank.getText();
                   String sVrijwilligLageRank = txtVrijwilligLageRank.getText();
                   String sOpleidingHboWo = txtOpleidingHboWo.getText();
                   String sOpleidingMbo = txtOpleidingMbo.getText();
                   String sOpleidingLbo = txtOpleidingLbo.getText();

                   // Checken of alles is ingevuld behave de combobox
                   if(sProfessioneelMan.isEmpty() && sProfessioneelMan.isEmpty() && sProfessioneelVrouw.isEmpty() && sProfessioneelHogeRank.isEmpty() && sProfessioneelMiddenRank.isEmpty() && sProfessioneelLageRank.isEmpty() && sVrijwilligMan.isEmpty() && sVrijwilligVrouw.isEmpty() && sVrijwilligHogeRank.isEmpty() && sVrijwilligMiddenRank.isEmpty() && sVrijwilligLageRank.isEmpty() && sOpleidingHboWo.isEmpty() && sOpleidingMbo.isEmpty() && sOpleidingLbo.isEmpty()){       
                       // Foutmelding maken
                       lblFeedbackUpdateKazerne.setText("Alle velden moeten invoervelden behalve tekort moeten ingevuld worden.");

                       // Registreer knop niet klikbaar maken
                       btnUpdateKazerne.setDisable(true);

                       // Classes toevoegen
                       lblFeedbackUpdateKazerne.getStyleClass().add("label--error");
                       btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                       // Classes verwijderen
                       lblFeedbackUpdateKazerne.getStyleClass().removeAll("label--succes");
                   }

                   // Checken of een ding niet is ingevuld behalve de combobox
                   else if(sProfessioneelMan.isEmpty() || sProfessioneelMan.isEmpty() || sProfessioneelVrouw.isEmpty() || sProfessioneelHogeRank.isEmpty() || sProfessioneelMiddenRank.isEmpty() || sProfessioneelLageRank.isEmpty() || sVrijwilligMan.isEmpty() || sVrijwilligVrouw.isEmpty() || sVrijwilligHogeRank.isEmpty() || sVrijwilligMiddenRank.isEmpty() || sVrijwilligLageRank.isEmpty() || sOpleidingHboWo.isEmpty() || sOpleidingMbo.isEmpty() || sOpleidingLbo.isEmpty()){
                       // Foutmelding maken
                       lblFeedbackUpdateKazerne.setText("Een of meedere velden is niet ingevuld.");

                       // Registreer knop niet klikbaar maken
                       btnUpdateKazerne.setDisable(true);

                       // Classes toevoegen
                       lblFeedbackUpdateKazerne.getStyleClass().add("label--error");
                       btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                       // Classes verwijderen
                       lblFeedbackUpdateKazerne.getStyleClass().removeAll("label--succes");           
                   }

                   // Als alles ingevuld is
                   else{                
                        // String waarden omzetten naar int waarden
                        int iProfessioneelMan = Integer.parseInt(sProfessioneelMan);
                        int iProfessioneelVrouw = Integer.parseInt(sProfessioneelVrouw);
                        int iProfessioneelHogeRank = Integer.parseInt(sProfessioneelHogeRank);
                        int iProfessioneelMiddenRank = Integer.parseInt(sProfessioneelMiddenRank);
                        int iProfessioneelLageRank = Integer.parseInt(sProfessioneelLageRank);
                        int iVrijwilligMan = Integer.parseInt(sVrijwilligMan);
                        int iVrijwilligVrouw = Integer.parseInt(sVrijwilligVrouw);
                        int iVrijwilligHogeRank = Integer.parseInt(sVrijwilligHogeRank);
                        int iVrijwilligMiddenRank = Integer.parseInt(sVrijwilligMiddenRank);
                        int iVrijwilligLageRank = Integer.parseInt(sVrijwilligLageRank);
                        int iOpleidingHboWo = Integer.parseInt(sOpleidingHboWo);
                        int iOpleidingMbo = Integer.parseInt(sOpleidingMbo);
                        int iOpleidingLbo = Integer.parseInt(sOpleidingLbo);              
                        // Jaar krijgen
                        Date date = new Date();
                        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        int iJaar  = localDate.getYear();

                        // Checken of de de waardes van professioneel gender gelijk zijn professioneel per aantal rank
                        int iVerschilProfessioneel = (iProfessioneelMan + iProfessioneelVrouw) - (iProfessioneelHogeRank + iProfessioneelMiddenRank + iProfessioneelLageRank);
                        
                        // Checken of de de waardes van vrijwilliger gender gelijk zijn vrijwilliger per aantal rank
                        int iVerschilVrijwilliger = (iVrijwilligMan + iVrijwilligVrouw) - (iVrijwilligHogeRank + iVrijwilligMiddenRank + iVrijwilligLageRank);
                        
                        // Professioneel is gender en rank komen in aantallen niet overeen
                        if(iVerschilProfessioneel != 0){
                            // Foutmelding maken
                            lblFeedbackUpdateKazerne.setText("Het aantal professionele leden per gender en per rank komen niet overeen.");

                            // Registreer knop niet klikbaar maken
                            btnUpdateKazerne.setDisable(true);

                            // Classes toevoegen
                            lblFeedbackUpdateKazerne.getStyleClass().add("label--error");
                            btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                            // Classes verwijderen
                            lblFeedbackUpdateKazerne.getStyleClass().removeAll("label--succes"); 
                        }
                        // Vrijwilliger is gender en rank komen in aantallen niet overeen
                        else if(iVerschilVrijwilliger != 0){
                            // Foutmelding maken
                            lblFeedbackUpdateKazerne.setText("Het aantal vrijwillige leden per gender en per rank komen niet overeen.");

                            // Registreer knop niet klikbaar maken
                            btnUpdateKazerne.setDisable(true);

                            // Classes toevoegen
                            lblFeedbackUpdateKazerne.getStyleClass().add("label--error");
                            btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                            // Classes verwijderen
                            lblFeedbackUpdateKazerne.getStyleClass().removeAll("label--succes"); 
                        }
                        // Professioneel en Vrijwilliger gender en rank komen overeen
                        else{
                            if(cbTekort.isSelected()){
                                // Er is een tekort
                                // Variabele aanmaken voor tekort
                                int iTekort = 1;

                                // Variabele naar de functie sturen om het te updaten
                                int iResultaat = db.updateKazere(sRegio, iJaar, iProfessioneelMan, iProfessioneelVrouw, iProfessioneelHogeRank, iProfessioneelMiddenRank, iProfessioneelLageRank, iVrijwilligMan, iVrijwilligVrouw, iVrijwilligHogeRank, iVrijwilligMiddenRank, iVrijwilligLageRank, iOpleidingHboWo, iOpleidingMbo, iOpleidingLbo, iTekort);

                                if(iResultaat == 1){
                                    // Goedkeuring maken
                                    lblFeedbackUpdateKazerne.setText("De gegevens zijn gewijzigd");

                                    // Classes toevoegen
                                    lblFeedbackUpdateKazerne.getStyleClass().add("label--succes");        
                                    txtProfessioneelMan.getStyleClass().add("invoer--succes");

                                    // Classes verwijderen
                                    lblFeedbackUpdateKazerne.getStyleClass().removeAll("label--error");
                                }else{
                                    // Foutmelding maken
                                    lblFeedbackUpdateKazerne.setText("Er is iets foutgegaan, probeer het later opnieuw.");

                                    // Classes toevoegen
                                    lblFeedbackUpdateKazerne.getStyleClass().add("label--error");

                                    // Classes verwijderen
                                    lblFeedbackUpdateKazerne.getStyleClass().removeAll("label--succes");  
                                }
                            } else{
                                // Er is geen tekort
                                // Variabele aanmaken voor tekort
                                int iTekort = 0;

                                // Variabele naar de functie sturen om het te updaten
                                int iResultaat = db.updateKazere(sRegio, iJaar, iProfessioneelMan, iProfessioneelVrouw, iProfessioneelHogeRank, iProfessioneelMiddenRank, iProfessioneelLageRank, iVrijwilligMan, iVrijwilligVrouw, iVrijwilligHogeRank, iVrijwilligMiddenRank, iVrijwilligLageRank, iOpleidingHboWo, iOpleidingMbo, iOpleidingLbo, iTekort);

                                if(iResultaat == 1){
                                    // Goedkeuring maken
                                    lblFeedbackUpdateKazerne.setText("De gegevens zijn gewijzigd");

                                    // Classes toevoegen
                                    lblFeedbackUpdateKazerne.getStyleClass().add("label--succes");        
                                    txtProfessioneelMan.getStyleClass().add("invoer--succes");

                                    // Classes verwijderen
                                    lblFeedbackUpdateKazerne.getStyleClass().removeAll("label--error");
                                }else{
                                    // Foutmelding maken
                                    lblFeedbackUpdateKazerne.setText("Er is iets foutgegaan, probeer het later opnieuw.");

                                    // Classes toevoegen
                                    lblFeedbackUpdateKazerne.getStyleClass().add("label--error");

                                    // Classes verwijderen
                                    lblFeedbackUpdateKazerne.getStyleClass().removeAll("label--succes");  
                                }
                            }
                        }
                    }
                });

                // Uitlog knop
                btnUitloggen.setOnAction(new EventHandler<ActionEvent>() {
                    // Gebruiker terugsturen naar inlog pagina
                    @Override
                    public void handle(ActionEvent event) {
                        primaryStage.setScene(scene);
                    }
                });

                /*
                 * Form validation
                 */
                // Professioneel man
                txtProfessioneelMan.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                    // Waarden uit het invoerveld halen en omzetten in een string
                    String professioneelMan = txtProfessioneelMan.getText();
                    // Kijken of de waarde vernieuwd is
                    if (!newValue) {                
                        // Kijken of de invoer leeg is
                        if(professioneelMan.isEmpty()){
                            // Foutmelding maken
                            lblFeedbackProfessioneelMan.setText("Dit veld moet ingevuld worden.");

                            // Registreer knop niet klikbaar maken
                            btnUpdateKazerne.setDisable(true);

                            // Classes toevoegen
                            lblFeedbackProfessioneelMan.getStyleClass().add("label--error");
                            txtProfessioneelMan.getStyleClass().add("invoer--error");
                            btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                            // Classes verwijderen
                            lblFeedbackProfessioneelMan.getStyleClass().removeAll("label--succes");
                            txtProfessioneelMan.getStyleClass().removeAll("invoer--succes");
                        }

                        else if(!professioneelMan.matches("[0-9]*")){
                            // Foutmelding maken
                            lblFeedbackProfessioneelMan.setText("Er moet een getal ingevuld worden.");

                            // Registreer knop niet klikbaar maken
                            btnUpdateKazerne.setDisable(true);

                            // Classes toevoegen
                            lblFeedbackProfessioneelMan.getStyleClass().add("label--error");
                            txtProfessioneelMan.getStyleClass().add("invoer--error");
                            btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                            // Classes verwijderen
                            lblFeedbackProfessioneelMan.getStyleClass().removeAll("label--succes");
                            txtProfessioneelMan.getStyleClass().removeAll("invoer--succes");
                        }

                        else{
                            // Goedkeuring maken
                            lblFeedbackProfessioneelMan.setText("oke");

                            // Registreerknop klikbaar maken
                            btnUpdateKazerne.setDisable(false);

                            // Classes toevoegen
                            lblFeedbackProfessioneelMan.getStyleClass().add("label--succes");        
                            txtProfessioneelMan.getStyleClass().add("invoer--succes");

                            // Classes verwijderen
                            lblFeedbackProfessioneelMan.getStyleClass().removeAll("label--error");
                            txtProfessioneelMan.getStyleClass().removeAll("invoer--error");
                            btnUpdateKazerne.getStyleClass().removeAll("btn-disabeld");
                        }
                    }
                });

                // Professioneel vrouw
                txtProfessioneelVrouw.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                    // Waarden uit het invoerveld halen en omzetten in een string
                    String professioneelVrouw = txtProfessioneelVrouw.getText();
                    // Kijken of de waarde vernieuwd is
                    if (!newValue) {                
                        // Kijken of de invoer leeg is
                        if(professioneelVrouw.isEmpty()){
                            // Foutmelding maken
                            lblFeedbackProfessioneelVrouw.setText("Dit veld moet ingevuld worden.");

                            // Registreer knop niet klikbaar maken
                            btnUpdateKazerne.setDisable(true);

                            // Classes toevoegen
                            lblFeedbackProfessioneelVrouw.getStyleClass().add("label--error");
                            txtProfessioneelVrouw.getStyleClass().add("invoer--error");
                            btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                            // Classes verwijderen
                            lblFeedbackProfessioneelVrouw.getStyleClass().removeAll("label--succes");
                            txtProfessioneelVrouw.getStyleClass().removeAll("invoer--succes");
                        }

                        else if(!professioneelVrouw.matches("[0-9]*")){
                            // Foutmelding maken
                            lblFeedbackProfessioneelVrouw.setText("Er moet een getal ingevuld worden.");

                            // Registreer knop niet klikbaar maken
                            btnUpdateKazerne.setDisable(true);

                            // Classes toevoegen
                            lblFeedbackProfessioneelVrouw.getStyleClass().add("label--error");
                            txtProfessioneelVrouw.getStyleClass().add("invoer--error");
                            btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                            // Classes verwijderen
                            lblFeedbackProfessioneelVrouw.getStyleClass().removeAll("label--succes");
                            txtProfessioneelVrouw.getStyleClass().removeAll("invoer--succes");
                        }

                        else{
                            // Goedkeuring maken
                            lblFeedbackProfessioneelVrouw.setText("oke");

                            // Registreerknop klikbaar maken
                            btnUpdateKazerne.setDisable(false);

                            // Classes toevoegen
                            lblFeedbackProfessioneelVrouw.getStyleClass().add("label--succes");        
                            txtProfessioneelVrouw.getStyleClass().add("invoer--succes");

                            // Classes verwijderen
                            lblFeedbackProfessioneelVrouw.getStyleClass().removeAll("label--error");
                            txtProfessioneelVrouw.getStyleClass().removeAll("invoer--error");
                            btnUpdateKazerne.getStyleClass().removeAll("btn-disabeld");
                        }
                    }
                });

                // Professioneel hoger rank
                txtProfessioneelHogeRank.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                    // Waarden uit het invoerveld halen en omzetten in een string
                    String professioneelHogeRank = txtProfessioneelHogeRank.getText();
                    // Kijken of de waarde vernieuwd is
                    if (!newValue) {                
                        // Kijken of de invoer leeg is
                        if(professioneelHogeRank.isEmpty()){
                            // Foutmelding maken
                            lblFeedbackProfessioneelHogeRank.setText("Dit veld moet ingevuld worden.");

                            // Registreer knop niet klikbaar maken
                            btnUpdateKazerne.setDisable(true);

                            // Classes toevoegen
                            lblFeedbackProfessioneelHogeRank.getStyleClass().add("label--error");
                            txtProfessioneelHogeRank.getStyleClass().add("invoer--error");
                            btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                            // Classes verwijderen
                            lblFeedbackProfessioneelHogeRank.getStyleClass().removeAll("label--succes");
                            txtProfessioneelHogeRank.getStyleClass().removeAll("invoer--succes");
                        }

                        else if(!professioneelHogeRank.matches("[0-9]*")){
                            // Foutmelding maken
                            lblFeedbackProfessioneelHogeRank.setText("Er moet een getal ingevuld worden.");

                            // Registreer knop niet klikbaar maken
                            btnUpdateKazerne.setDisable(true);

                            // Classes toevoegen
                            lblFeedbackProfessioneelHogeRank.getStyleClass().add("label--error");
                            txtProfessioneelHogeRank.getStyleClass().add("invoer--error");
                            btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                            // Classes verwijderen
                            lblFeedbackProfessioneelHogeRank.getStyleClass().removeAll("label--succes");
                            txtProfessioneelHogeRank.getStyleClass().removeAll("invoer--succes");
                        }

                        else{
                            // Goedkeuring maken
                            lblFeedbackProfessioneelHogeRank.setText("oke");

                            // Registreerknop klikbaar maken
                            btnUpdateKazerne.setDisable(false);

                            // Classes toevoegen
                            lblFeedbackProfessioneelHogeRank.getStyleClass().add("label--succes");        
                            txtProfessioneelHogeRank.getStyleClass().add("invoer--succes");

                            // Classes verwijderen
                            lblFeedbackProfessioneelHogeRank.getStyleClass().removeAll("label--error");
                            txtProfessioneelHogeRank.getStyleClass().removeAll("invoer--error");
                            btnUpdateKazerne.getStyleClass().removeAll("btn-disabeld");
                        }
                    }
                });

                // Professioneel midden rank
                txtProfessioneelMiddenRank.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                   // Waarden uit het invoerveld halen en omzetten in een string
                   String professioneelMiddenRank = txtProfessioneelMiddenRank.getText();
                   // Kijken of de waarde vernieuwd is
                   if (!newValue) {                
                       // Kijken of de invoer leeg is
                       if(professioneelMiddenRank.isEmpty()){
                            // Foutmelding maken
                            lblFeedbackProfessioneelMiddenRank.setText("Dit veld moet ingevuld worden.");

                            // Registreer knop niet klikbaar maken
                            btnUpdateKazerne.setDisable(true);

                            // Classes toevoegen
                            lblFeedbackProfessioneelMiddenRank.getStyleClass().add("label--error");
                            txtProfessioneelMiddenRank.getStyleClass().add("invoer--error");
                            btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                            // Classes verwijderen
                            lblFeedbackProfessioneelMiddenRank.getStyleClass().removeAll("label--succes");
                            txtProfessioneelMiddenRank.getStyleClass().removeAll("invoer--succes");
                        }

                        else if(!professioneelMiddenRank.matches("[0-9]*")){
                            // Foutmelding maken
                            lblFeedbackProfessioneelMiddenRank.setText("Er moet een getal ingevuld worden.");

                            // Registreer knop niet klikbaar maken
                            btnUpdateKazerne.setDisable(true);

                            // Classes toevoegen
                            lblFeedbackProfessioneelMiddenRank.getStyleClass().add("label--error");
                            txtProfessioneelMiddenRank.getStyleClass().add("invoer--error");
                            btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                            // Classes verwijderen
                            lblFeedbackProfessioneelMiddenRank.getStyleClass().removeAll("label--succes");
                            txtProfessioneelMiddenRank.getStyleClass().removeAll("invoer--succes");
                       }

                        else{
                            // Goedkeuring maken
                            lblFeedbackProfessioneelMiddenRank.setText("oke");

                            // Registreerknop klikbaar maken
                            btnUpdateKazerne.setDisable(false);

                            // Classes toevoegen
                            lblFeedbackProfessioneelMiddenRank.getStyleClass().add("label--succes");        
                            txtProfessioneelMiddenRank.getStyleClass().add("invoer--succes");

                            // Classes verwijderen
                            lblFeedbackProfessioneelMiddenRank.getStyleClass().removeAll("label--error");
                            txtProfessioneelMiddenRank.getStyleClass().removeAll("invoer--error");
                            btnUpdateKazerne.getStyleClass().removeAll("btn-disabeld");
                       }
                    }
                });

                // Professioneel lage rank
                txtProfessioneelLageRank.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                   // Waarden uit het invoerveld halen en omzetten in een string
                   String professioneelLageRank = txtProfessioneelLageRank.getText();
                   // Kijken of de waarde vernieuwd is
                   if (!newValue) {                
                       // Kijken of de invoer leeg is
                       if(professioneelLageRank.isEmpty()){
                           // Foutmelding maken
                           lblFeedbackProfessioneelLageRank.setText("Dit veld moet ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackProfessioneelLageRank.getStyleClass().add("label--error");
                           txtProfessioneelLageRank.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackProfessioneelLageRank.getStyleClass().removeAll("label--succes");
                           txtProfessioneelLageRank.getStyleClass().removeAll("invoer--succes");
                       }

                       else if(!professioneelLageRank.matches("[0-9]*")){
                           // Foutmelding maken
                           lblFeedbackProfessioneelLageRank.setText("Er moet een getal ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackProfessioneelLageRank.getStyleClass().add("label--error");
                           txtProfessioneelLageRank.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackProfessioneelLageRank.getStyleClass().removeAll("label--succes");
                           txtProfessioneelLageRank.getStyleClass().removeAll("invoer--succes");
                       }

                       else{
                           // Goedkeuring maken
                           lblFeedbackProfessioneelLageRank.setText("oke");

                           // Registreerknop klikbaar maken
                           btnUpdateKazerne.setDisable(false);

                           // Classes toevoegen
                           lblFeedbackProfessioneelLageRank.getStyleClass().add("label--succes");        
                           txtProfessioneelLageRank.getStyleClass().add("invoer--succes");

                           // Classes verwijderen
                           lblFeedbackProfessioneelLageRank.getStyleClass().removeAll("label--error");
                           txtProfessioneelLageRank.getStyleClass().removeAll("invoer--error");
                           btnUpdateKazerne.getStyleClass().removeAll("btn-disabeld");
                       }
                   }
                });

                // Vrijwilliger Man
                txtVrijwilligMan.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                   // Waarden uit het invoerveld halen en omzetten in een string
                   String vrijwilligMan = txtVrijwilligMan.getText();
                   // Kijken of de waarde vernieuwd is
                   if (!newValue) {                
                       // Kijken of de invoer leeg is
                       if(vrijwilligMan.isEmpty()){
                           // Foutmelding maken
                           lblFeedbackVrijwilligMan.setText("Dit veld moet ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackVrijwilligMan.getStyleClass().add("label--error");
                           txtVrijwilligMan.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackVrijwilligMan.getStyleClass().removeAll("label--succes");
                           txtVrijwilligMan.getStyleClass().removeAll("invoer--succes");
                       }

                       else if(!vrijwilligMan.matches("[0-9]*")){
                           // Foutmelding maken
                           lblFeedbackVrijwilligMan.setText("Er moet een getal ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackVrijwilligMan.getStyleClass().add("label--error");
                           txtVrijwilligMan.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackVrijwilligMan.getStyleClass().removeAll("label--succes");
                           txtVrijwilligMan.getStyleClass().removeAll("invoer--succes");
                       }

                       else{
                           // Goedkeuring maken
                           lblFeedbackVrijwilligMan.setText("oke");

                           // Registreerknop klikbaar maken
                           btnUpdateKazerne.setDisable(false);

                           // Classes toevoegen
                           lblFeedbackVrijwilligMan.getStyleClass().add("label--succes");        
                           txtVrijwilligMan.getStyleClass().add("invoer--succes");

                           // Classes verwijderen
                           lblFeedbackVrijwilligMan.getStyleClass().removeAll("label--error");
                           txtVrijwilligMan.getStyleClass().removeAll("invoer--error");
                           btnUpdateKazerne.getStyleClass().removeAll("btn-disabeld");
                       }
                   }
                });

                // Vrijwilliger Vrouw
                txtVrijwilligVrouw.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                   // Waarden uit het invoerveld halen en omzetten in een string
                   String vrijwilligVrouw = txtVrijwilligVrouw.getText();
                   // Kijken of de waarde vernieuwd is
                   if (!newValue) {                
                       // Kijken of de invoer leeg is
                       if(vrijwilligVrouw.isEmpty()){
                           // Foutmelding maken
                           lblFeedbackVrijwilligVrouw.setText("Dit veld moet ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackVrijwilligVrouw.getStyleClass().add("label--error");
                           txtVrijwilligVrouw.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackVrijwilligVrouw.getStyleClass().removeAll("label--succes");
                           txtVrijwilligVrouw.getStyleClass().removeAll("invoer--succes");
                       }

                       else if(!vrijwilligVrouw.matches("[0-9]*")){
                           // Foutmelding maken
                           lblFeedbackVrijwilligVrouw.setText("Er moet een getal ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackVrijwilligVrouw.getStyleClass().add("label--error");
                           txtVrijwilligVrouw.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackVrijwilligVrouw.getStyleClass().removeAll("label--succes");
                           txtVrijwilligVrouw.getStyleClass().removeAll("invoer--succes");
                       }

                       else{
                           // Goedkeuring maken
                           lblFeedbackVrijwilligVrouw.setText("oke");

                           // Registreerknop klikbaar maken
                           btnUpdateKazerne.setDisable(false);

                           // Classes toevoegen
                           lblFeedbackVrijwilligVrouw.getStyleClass().add("label--succes");        
                           txtVrijwilligVrouw.getStyleClass().add("invoer--succes");

                           // Classes verwijderen
                           lblFeedbackVrijwilligVrouw.getStyleClass().removeAll("label--error");
                           txtVrijwilligVrouw.getStyleClass().removeAll("invoer--error");
                           btnUpdateKazerne.getStyleClass().removeAll("btn-disabeld");
                       }
                   }
                });

                // Vrijwilliger hoger rank
                txtVrijwilligHogeRank.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                   // Waarden uit het invoerveld halen en omzetten in een string
                   String vrijwilligHogeRank = txtVrijwilligHogeRank.getText();
                   // Kijken of de waarde vernieuwd is
                   if (!newValue) {                
                       // Kijken of de invoer leeg is
                       if(vrijwilligHogeRank.isEmpty()){
                           // Foutmelding maken
                           lblFeedbackVrijwilligHogeRank.setText("Dit veld moet ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackVrijwilligHogeRank.getStyleClass().add("label--error");
                           txtVrijwilligHogeRank.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackVrijwilligHogeRank.getStyleClass().removeAll("label--succes");
                           txtVrijwilligHogeRank.getStyleClass().removeAll("invoer--succes");
                       }

                       else if(!vrijwilligHogeRank.matches("[0-9]*")){
                           // Foutmelding maken
                           lblFeedbackVrijwilligHogeRank.setText("Er moet een getal ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackVrijwilligHogeRank.getStyleClass().add("label--error");
                           txtVrijwilligHogeRank.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackVrijwilligHogeRank.getStyleClass().removeAll("label--succes");
                           txtVrijwilligHogeRank.getStyleClass().removeAll("invoer--succes");
                       }

                       else{
                           // Goedkeuring maken
                           lblFeedbackVrijwilligHogeRank.setText("oke");

                           // Registreerknop klikbaar maken
                           btnUpdateKazerne.setDisable(false);

                           // Classes toevoegen
                           lblFeedbackVrijwilligHogeRank.getStyleClass().add("label--succes");        
                           txtVrijwilligHogeRank.getStyleClass().add("invoer--succes");

                           // Classes verwijderen
                           lblFeedbackVrijwilligHogeRank.getStyleClass().removeAll("label--error");
                           txtVrijwilligHogeRank.getStyleClass().removeAll("invoer--error");
                           btnUpdateKazerne.getStyleClass().removeAll("btn-disabeld");
                       }
                   }
                });

                // Vrijwilliger midden rank
                txtVrijwilligMiddenRank.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                   // Waarden uit het invoerveld halen en omzetten in een string
                   String vrijwilligMiddenRank = txtVrijwilligMiddenRank.getText();
                   // Kijken of de waarde vernieuwd is
                   if (!newValue) {                
                       // Kijken of de invoer leeg is
                       if(vrijwilligMiddenRank.isEmpty()){
                           // Foutmelding maken
                           lblFeedbackVrijwilligMiddenRank.setText("Dit veld moet ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackVrijwilligMiddenRank.getStyleClass().add("label--error");
                           txtVrijwilligMiddenRank.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackVrijwilligMiddenRank.getStyleClass().removeAll("label--succes");
                           txtVrijwilligMiddenRank.getStyleClass().removeAll("invoer--succes");
                       }

                       else if(!vrijwilligMiddenRank.matches("[0-9]*")){
                           // Foutmelding maken
                           lblFeedbackVrijwilligMiddenRank.setText("Er moet een getal ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackVrijwilligMiddenRank.getStyleClass().add("label--error");
                           txtVrijwilligMiddenRank.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackVrijwilligMiddenRank.getStyleClass().removeAll("label--succes");
                           txtVrijwilligMiddenRank.getStyleClass().removeAll("invoer--succes");
                       }

                       else{
                           // Goedkeuring maken
                           lblFeedbackVrijwilligMiddenRank.setText("oke");

                           // Registreerknop klikbaar maken
                           btnUpdateKazerne.setDisable(false);

                           // Classes toevoegen
                           lblFeedbackVrijwilligMiddenRank.getStyleClass().add("label--succes");        
                           txtVrijwilligMiddenRank.getStyleClass().add("invoer--succes");

                           // Classes verwijderen
                           lblFeedbackVrijwilligMiddenRank.getStyleClass().removeAll("label--error");
                           txtVrijwilligMiddenRank.getStyleClass().removeAll("invoer--error");
                           btnUpdateKazerne.getStyleClass().removeAll("btn-disabeld");
                       }
                   }
                });

                // Vrijwilliger lage rank
                txtVrijwilligLageRank.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                   // Waarden uit het invoerveld halen en omzetten in een string
                   String vrijwilligLageRank = txtVrijwilligLageRank.getText();
                   // Kijken of de waarde vernieuwd is
                   if (!newValue) {                
                       // Kijken of de invoer leeg is
                       if(vrijwilligLageRank.isEmpty()){
                           // Foutmelding maken
                           lblFeedbackVrijwilligLageRank.setText("Dit veld moet ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackVrijwilligLageRank.getStyleClass().add("label--error");
                           txtVrijwilligLageRank.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackVrijwilligLageRank.getStyleClass().removeAll("label--succes");
                           txtVrijwilligLageRank.getStyleClass().removeAll("invoer--succes");
                       }

                       else if(!vrijwilligLageRank.matches("[0-9]*")){
                           // Foutmelding maken
                           lblFeedbackVrijwilligLageRank.setText("Er moet een getal ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackVrijwilligLageRank.getStyleClass().add("label--error");
                           txtVrijwilligLageRank.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackVrijwilligLageRank.getStyleClass().removeAll("label--succes");
                           txtVrijwilligLageRank.getStyleClass().removeAll("invoer--succes");
                       }

                       else{
                           // Goedkeuring maken
                           lblFeedbackVrijwilligLageRank.setText("oke");

                           // Registreerknop klikbaar maken
                           btnUpdateKazerne.setDisable(false);

                           // Classes toevoegen
                           lblFeedbackVrijwilligLageRank.getStyleClass().add("label--succes");        
                           txtVrijwilligLageRank.getStyleClass().add("invoer--succes");

                           // Classes verwijderen
                           lblFeedbackVrijwilligLageRank.getStyleClass().removeAll("label--error");
                           txtVrijwilligLageRank.getStyleClass().removeAll("invoer--error");
                           btnUpdateKazerne.getStyleClass().removeAll("btn-disabeld");
                       }
                   }
                });

                // Niet operationeel HBO / WO
                txtOpleidingHboWo.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                   // Waarden uit het invoerveld halen en omzetten in een string
                   String opleidingHboWo = txtOpleidingHboWo.getText();
                   // Kijken of de waarde vernieuwd is
                   if (!newValue) {                
                       // Kijken of de invoer leeg is
                       if(opleidingHboWo.isEmpty()){
                           // Foutmelding maken
                           lblFeedbackOpleidingHboWo.setText("Dit veld moet ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackOpleidingHboWo.getStyleClass().add("label--error");
                           txtOpleidingHboWo.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackOpleidingHboWo.getStyleClass().removeAll("label--succes");
                           txtOpleidingHboWo.getStyleClass().removeAll("invoer--succes");
                       }

                       else if(!opleidingHboWo.matches("[0-9]*")){
                           // Foutmelding maken
                           lblFeedbackOpleidingHboWo.setText("Er moet een getal ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackOpleidingHboWo.getStyleClass().add("label--error");
                           txtOpleidingHboWo.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackOpleidingHboWo.getStyleClass().removeAll("label--succes");
                           txtOpleidingHboWo.getStyleClass().removeAll("invoer--succes");
                       }

                       else{
                           // Goedkeuring maken
                           lblFeedbackOpleidingHboWo.setText("oke");

                           // Registreerknop klikbaar maken
                           btnUpdateKazerne.setDisable(false);

                           // Classes toevoegen
                           lblFeedbackOpleidingHboWo.getStyleClass().add("label--succes");        
                           txtOpleidingHboWo.getStyleClass().add("invoer--succes");

                           // Classes verwijderen
                           lblFeedbackOpleidingHboWo.getStyleClass().removeAll("label--error");
                           txtOpleidingHboWo.getStyleClass().removeAll("invoer--error");
                           btnUpdateKazerne.getStyleClass().removeAll("btn-disabeld");
                       }
                   }
                });

                // Niet operationeel MBO
                txtOpleidingMbo.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                   // Waarden uit het invoerveld halen en omzetten in een string
                   String opleidingHboWo = txtOpleidingMbo.getText();
                   // Kijken of de waarde vernieuwd is
                   if (!newValue) {                
                       // Kijken of de invoer leeg is
                       if(opleidingHboWo.isEmpty()){
                           // Foutmelding maken
                           lblFeedbackOpleidingMbo.setText("Dit veld moet ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackOpleidingMbo.getStyleClass().add("label--error");
                           txtOpleidingMbo.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackOpleidingMbo.getStyleClass().removeAll("label--succes");
                           txtOpleidingMbo.getStyleClass().removeAll("invoer--succes");
                       }

                       else if(!opleidingHboWo.matches("[0-9]*")){
                           // Foutmelding maken
                           lblFeedbackOpleidingMbo.setText("Er moet een getal ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackOpleidingMbo.getStyleClass().add("label--error");
                           txtOpleidingMbo.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackOpleidingMbo.getStyleClass().removeAll("label--succes");
                           txtOpleidingMbo.getStyleClass().removeAll("invoer--succes");
                       }

                       else{
                           // Goedkeuring maken
                           lblFeedbackOpleidingMbo.setText("oke");

                           // Registreerknop klikbaar maken
                           btnUpdateKazerne.setDisable(false);

                           // Classes toevoegen
                           lblFeedbackOpleidingMbo.getStyleClass().add("label--succes");        
                           txtOpleidingMbo.getStyleClass().add("invoer--succes");

                           // Classes verwijderen
                           lblFeedbackOpleidingMbo.getStyleClass().removeAll("label--error");
                           txtOpleidingMbo.getStyleClass().removeAll("invoer--error");
                           btnUpdateKazerne.getStyleClass().removeAll("btn-disabeld");
                       }
                   }
                });

                // Niet operationeel LBO
                txtOpleidingLbo.focusedProperty().addListener((arg0, oldValue, newValue) -> {
                   // Waarden uit het invoerveld halen en omzetten in een string
                   String opleidingLbo = txtOpleidingLbo.getText();
                   // Kijken of de waarde vernieuwd is
                   if (!newValue) {                
                       // Kijken of de invoer leeg is
                       if(opleidingLbo.isEmpty()){
                           // Foutmelding maken
                           lblFeedbackOpleidingLbo.setText("Dit veld moet ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackOpleidingLbo.getStyleClass().add("label--error");
                           txtOpleidingLbo.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackOpleidingLbo.getStyleClass().removeAll("label--succes");
                           txtOpleidingLbo.getStyleClass().removeAll("invoer--succes");
                       }

                       else if(!opleidingLbo.matches("[0-9]*")){
                           // Foutmelding maken
                           lblFeedbackOpleidingLbo.setText("Er moet een getal ingevuld worden.");

                           // Registreer knop niet klikbaar maken
                           btnUpdateKazerne.setDisable(true);

                           // Classes toevoegen
                           lblFeedbackOpleidingLbo.getStyleClass().add("label--error");
                           txtOpleidingLbo.getStyleClass().add("invoer--error");
                           btnUpdateKazerne.getStyleClass().add("btn-disabeld");

                           // Classes verwijderen
                           lblFeedbackOpleidingLbo.getStyleClass().removeAll("label--succes");
                           txtOpleidingLbo.getStyleClass().removeAll("invoer--succes");
                       }

                       else{
                           // Goedkeuring maken
                           lblFeedbackOpleidingLbo.setText("oke");

                           // Registreerknop klikbaar maken
                           btnUpdateKazerne.setDisable(false);

                           // Classes toevoegen
                           lblFeedbackOpleidingLbo.getStyleClass().add("label--succes");        
                           txtOpleidingLbo.getStyleClass().add("invoer--succes");

                           // Classes verwijderen
                           lblFeedbackOpleidingLbo.getStyleClass().removeAll("label--error");
                           txtOpleidingLbo.getStyleClass().removeAll("invoer--error");
                           btnUpdateKazerne.getStyleClass().removeAll("btn-disabeld");
                       }
                   }
                });

                /*
                * Stage aanmaken
                */
                Scene nieuwScene = new Scene(root, 1080, 975);
                primaryStage.setScene(nieuwScene); 
                // Linken naar Stylesheet
                nieuwScene.getStylesheets().add(this.getClass().getResource("/brandweerinside/Assets/style.css").toExternalForm()); 
            } //Einde kazerne for loop
        } // Einde gebruiker for loop
    }
}
