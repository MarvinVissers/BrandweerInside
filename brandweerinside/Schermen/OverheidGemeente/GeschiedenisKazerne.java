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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author visse
 */
public class GeschiedenisKazerne {
    
    public GeschiedenisKazerne(Stage primaryStage, Scene scene, String sEmail, String sRegio){
    
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

        // Knoppen aanmaken
        Button btnUitloggen = new Button("Uitloggen"); 
        Button btnOverzicht = new Button("Terug naar overzicht");
        Button btnDetails = new Button("Terug naar details");

        // Classes toevoegen
        btnUitloggen.getStyleClass().add("menu--button");
        btnOverzicht.getStyleClass().add("menu--button");
        btnDetails.getStyleClass().add("menu--button");

        /* 
         * Knop op de juiste plek zetten 
         */
        // Uitlog knop
        btnUitloggen.setLayoutX(25);
        btnUitloggen.setLayoutY(5);
        // Overzicht knop
        btnOverzicht.setLayoutX(320);
        btnOverzicht.setLayoutY(5);
        // Details knop
        btnDetails.setLayoutX(545);
        btnDetails.setLayoutY(5);
        
        // Items toevoegen aan bottomMenu
        bottomMenu.getChildren().addAll(btnUitloggen, btnOverzicht, btnDetails);

        /*
         * alles van de root AnchorPane
         */
        AnchorPane root = new AnchorPane();
        
        /*
         * alles van de Root anchorPane
         */
        // Labels aanmaken
        Label lblTitel = new Label("Geschiedens kazerne " + sRegio);
        
        // Classes toevoegen
        lblTitel.getStyleClass().add("page--title");
        
        // Tableview aanmaken
        TableView<EntKazerne> tableview = new TableView();   
        tableview.setPrefSize(1000, 700);

        // Kolom Regio aanmaken, goede breedte maken en niet breedte niet aapasbaar maken
        TableColumn colRegion = new TableColumn();
        colRegion.setText("Regio");
        colRegion.setPrefWidth(100);
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

        // Kolom Totaal niet operationeel aanmaken, goede breedte maken en niet breedte niet aapasbaar maken
        TableColumn colNietOperationeel = new TableColumn();   
        colNietOperationeel.setText("Niet-operationele leden");
        colNietOperationeel.setPrefWidth(275);
        colNietOperationeel.setResizable(false);

        // Kolom Tekort aanmaken, goede breedte maken en niet breedte niet aapasbaar maken
        TableColumn colTekort = new TableColumn();  
        colTekort.setText("Tekort");
        colTekort.setPrefWidth(95);
        colTekort.setResizable(false);
        
        // Kolom Jaar aanmaken, goede breedte maken en niet breedte niet aapasbaar maken
        TableColumn colJaar = new TableColumn();  
        colJaar.setText("Jaar");
        colJaar.setPrefWidth(95);
        colTekort.setResizable(false);

        // Kolommen binden aan waardes uit Entiteit Class
        colRegion.setCellValueFactory(new PropertyValueFactory<EntKazerne, String>("Regio"));
        colProfessioneel.setCellValueFactory(new PropertyValueFactory<EntKazerne, Integer>("TotaalProfessioneel"));
        colVrijwilliger.setCellValueFactory(new PropertyValueFactory<EntKazerne, Integer>("TotaalVrijwilliger"));
        colNietOperationeel.setCellValueFactory(new PropertyValueFactory<EntKazerne, Integer>("TotaalNietOperationeel"));
        colTekort.setCellValueFactory(new PropertyValueFactory<EntKazerne, String>("Tekort"));
        colJaar.setCellValueFactory(new PropertyValueFactory<EntKazerne, Integer>("Jaar"));
        tableview.setItems(db.getGeschiedenisKazerne(sRegio));
        tableview.getColumns().addAll(colRegion, colProfessioneel, colVrijwilliger, colNietOperationeel, colTekort, colJaar);
        
        /* 
         * Items op de goede plaats zetten
         */
        // Titel
        lblTitel.setLayoutX(300);
        lblTitel.setLayoutY(180);       
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
        
        // Overzicht knop
        btnOverzicht.setOnAction(event -> {
            OverzichtKazernes ovKazernes = new OverzichtKazernes(primaryStage, scene, sEmail);
        });
        
        // Details knop
        btnDetails.setOnAction(event -> {
            DetailsKazerne dtlsKazerne = new DetailsKazerne(primaryStage, scene, sEmail, sRegio);
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
