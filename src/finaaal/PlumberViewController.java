/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaaal;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class PlumberViewController implements Initializable {

   
    @FXML
    private JFXButton back;
    @FXML
    private AnchorPane anchorPaneEEE;
    private TableView<Plumber> PPlumber;
    @FXML
    private TableColumn<Plumber, Integer> serial;
    @FXML
    private TableColumn<Plumber, String> name;
    @FXML
    private TableColumn<Plumber, String> phone;
    @FXML
    private TableColumn<Plumber, String> area;
    @FXML
    private TableColumn option;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /*@FXML
    private void findMecha(MouseEvent event) throws IOException {
         //copied the prevoious method & edited
        //creating fancy slide transition to switch between scenes
        //Load the create FXMl first,and assign parent variable
        Parent root = FXMLLoader.load(getClass().getResource("MechanicView.fxml"));
        //Get Current Scene
        Scene HomeView = back.getScene();
        //Place the new scene at the bottom of the current scene
        root.translateYProperty().set(HomeView.getHeight());
        //Add it to our holder pane which is StackPane
        //get an instance of stackPane from the Parent
        StackPane rootPaneMecha = (StackPane) HomeView.getRoot();
        rootPaneMecha.getChildren().add(root);
        //We create sliding up Animation;
        Timeline timeline = new Timeline();
        //Use ease in interpolator to have smooth transition
        KeyValue keyValue = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), keyValue);
        //add keyFrame to animation
        timeline.getKeyFrames().add(keyFrame);

        //play the animation
        timeline.play();
        //remove old anchorpane after animation is complete
        timeline.setOnFinished((ActionEvent event2) -> {
            //remove node from stackpane
            rootPaneMecha.getChildren().remove(anchorPaneEEE);
        });
    }*/
    
}
