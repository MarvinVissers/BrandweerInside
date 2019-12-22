/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brandweerinside.Schermen.OverheidGemeente;

import brandweerinside.EntiteitClasses.EntKazerne;
import brandweerinside.Functions;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author visse
 */
public class OverzichtKazernes {
    
    public OverzichtKazernes(Stage primaryStage, Scene scene, String sEmail){
        // Connectie maken met functie class
        Functions db = new Functions();
        
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
        
        /*
         * alles van de Root anchorPane
         */
        // Labels aanmaken
        Label lblTitel = new Label("Overzicht kazernes");
        
        // Classes toevoegen
        lblTitel.getStyleClass().add("page--title");
        
        // Tableview aanmaken
        TableView<EntKazerne> tableview = new TableView();   
        tableview.setPrefSize(1000, 700);

        // Kolom Regio aanmaken, goede breedte maken en niet breedte niet aapasbaar maken
        TableColumn colRegion = new TableColumn();
        colRegion.setText("Regio");
        colRegion.setPrefWidth(180);
        colRegion.setResizable(false);

        // Kolom Totaal Professioneel aanmaken, goede breedte maken en niet breedte niet aapasbaar maken
        TableColumn colProfessioneel = new TableColumn();   
        colProfessioneel.setText("Professionele leden");
        colProfessioneel.setPrefWidth(200);
        colProfessioneel.setResizable(false);

        // Kolom Totaal Vrijwilliger aanmaken, goede breedte maken en niet breedte niet aapasbaar maken
        TableColumn colVrijwilliger = new TableColumn();    
        colVrijwilliger.setText("Vrijwillige leden");
        colVrijwilliger.setPrefWidth(200);
        colVrijwilliger.setResizable(false);

        // Kolom Totaal Niet Operationeel aanmaken, goede breedte maken en niet breedte niet aapasbaar maken
        TableColumn colNietOperationeel = new TableColumn();   
        colNietOperationeel.setText("Niet-operationele leden");
        colNietOperationeel.setPrefWidth(280);
        colNietOperationeel.setResizable(false);

        // Kolom Tekort aanmaken, goede breedte maken en niet breedte niet aapasbaar maken
        TableColumn colTekort = new TableColumn();  
        colTekort.setText("Tekort");
        colTekort.setPrefWidth(110);
        colTekort.setResizable(false);

        // Kolommen binden aan waardes uit Entiteit Class
        colRegion.setCellValueFactory(new PropertyValueFactory<EntKazerne, String>("Regio"));
        colProfessioneel.setCellValueFactory(new PropertyValueFactory<EntKazerne, Integer>("TotaalProfessioneel"));
        colVrijwilliger.setCellValueFactory(new PropertyValueFactory<EntKazerne, Integer>("TotaalVrijwilliger"));
        colNietOperationeel.setCellValueFactory(new PropertyValueFactory<EntKazerne, Integer>("TotaalNietOperationeel"));
        colTekort.setCellValueFactory(new PropertyValueFactory<EntKazerne, String>("Tekort"));
        tableview.setItems(db.getOverviewKazernes());
        tableview.getColumns().addAll(colRegion, colProfessioneel, colVrijwilliger, colNietOperationeel, colTekort);
        
        /* 
         * Items op de goede plaats zetten
         */
        // Titel
        lblTitel.setLayoutX(375);
        lblTitel.setLayoutY(200);       
        // Tableview
        tableview.setLayoutX(40);
        tableview.setLayoutY(250);
        
        /*
         * Hier worden alles in hun AnchorPane gezet
         */               
        // Items aan scherm toevoegen, ook worden hier de anchorpanes samengevoegd
        root.getChildren().addAll(topMenu, bottomMenu, lblTitel, tableview);
        
        /*
         * Functies achter de knoppen
         */
        // Uitlog knop
        btnUitloggen.setOnAction(new EventHandler<ActionEvent>() {
            // Gebruiker terugsturen naar inlog pagina
            @Override
            public void handle(ActionEvent event) {
                primaryStage.setScene(scene);
            }
        });
        
        // Rij in tableview
        tableview.setOnMouseClicked((MouseEvent event) -> {
            try{
                // Kijken of er 2 keer op een rij geklikt is
                if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                    //System.out.println(tableview.getSelectionModel().getSelectedItem());

                    // Krijgen van de regio
                    String sRegio = tableview.getSelectionModel().getSelectedItem().getRegio();
                    //System.out.println("Regio is " + sRegio);

                    // Gebruiker naar details pagina doorsturen
                    DetailsKazerne details = new DetailsKazerne(primaryStage, scene, sEmail, sRegio);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        });
        
        /*
         * Stage aanmaken
         */
        Scene nieuwScene = new Scene(root, 1080, 975);
        primaryStage.setScene(nieuwScene); 
        // Linken naar Stylesheet
        nieuwScene.getStylesheets().add(this.getClass().getResource("/brandweerinside/Assets/style.css").toExternalForm()); 
    }
}
