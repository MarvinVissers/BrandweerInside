/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brandweerinside;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import brandweerinside.Schermen.Inloggen;

/**
 *
 * @author visse
 */
public class BrandweerInside extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {       
       
        // Scherm aanmaken
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 1080, 875);       
        
        // Interface aanroepen
        new Inloggen(root, primaryStage, scene);  

        // Stylesheet toevoegen
        scene.getStylesheets().add(this.getClass().getResource("Assets/style.css").toExternalForm());    
        
        // Scherm instellingen
        primaryStage.setTitle("Brandweer Inside");
        primaryStage.getIcons().add(new Image(BrandweerInside.class.getResourceAsStream("Assets/brandweer-icon.png")));        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
