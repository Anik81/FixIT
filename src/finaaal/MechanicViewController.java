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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class MechanicViewController implements Initializable {

    @FXML
    private AnchorPane anchorPaneMecha;
    @FXML
    private ImageView electrician;
    @FXML
    private JFXButton FMback;
    @FXML
    private StackPane rootPaneMecha;
    @FXML
    private ImageView carMechanic;
    @FXML
    private ImageView carpenter;
    @FXML
    private ImageView cleaner;
    @FXML
    private ImageView mason;
    @FXML
    private ImageView plumber;
    @FXML
    private ImageView hvcac;
    @FXML
    private ImageView painter;
    @FXML
    private ImageView welder;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openElectricianPage(MouseEvent event) throws IOException {
        //creating fancy slide transition to switch between scenes
        //Load the create FXMl first,and assign parent variable
        Parent root = FXMLLoader.load(getClass().getResource("ElectricianView.fxml"));
        //Get Current Scene
        Scene EEEList = electrician.getScene();
        //Place the new scene at the bottom of the current scene
        root.translateYProperty().set(EEEList.getHeight());
        //Add it to our holder pane which is StackPane
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
            rootPaneMecha.getChildren().remove(anchorPaneMecha);

        });
    }

    @FXML
    private void openHomePage(MouseEvent event) throws IOException {
        //copied the prevoious method & edited
        //creating fancy slide transition to switch between scenes
        //Load the create FXMl first,and assign parent variable
        Parent root=FXMLLoader.load(getClass().getResource("MainMenuPage.fxml"));
        //Get Current Scene
        Scene HomeView=FMback.getScene();
        //Place the new scene at the bottom of the current scene
        root.translateYProperty().set(HomeView.getHeight());
        //Add it to our holder pane which is StackPane
        //get an instance of stackPane from the Parent
        StackPane rootPane2=(StackPane) HomeView.getRoot();
        rootPane2.getChildren().add(root);
        //We create sliding up Animation;
        Timeline timeline=new Timeline();
        //Use ease in interpolator to have smooth transition
        KeyValue keyValue=new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
        KeyFrame keyFrame=new KeyFrame(Duration.seconds(1),keyValue);
        //add keyFrame to animation
        timeline.getKeyFrames().add(keyFrame);
        
        //play the animation
        timeline.play();
        //remove old anchorpane after animation is complete
        timeline.setOnFinished((ActionEvent event2)->{
        //remove node from stackpane
        rootPane2.getChildren().remove(anchorPaneMecha);
        });
    }

    @FXML
    private void openCarMechanic(MouseEvent event) {
    }

    @FXML
    private void openCarpenter(MouseEvent event) {
    }

    @FXML
    private void openCleaner(MouseEvent event) {
    }

    @FXML
    private void openMason(MouseEvent event) {
    }

    @FXML
    private void openPlumber(MouseEvent event) throws IOException {
        //creating fancy slide transition to switch between scenes
        //Load the create FXMl first,and assign parent variable
        Parent root = FXMLLoader.load(getClass().getResource("PlumberView.fxml"));
        //Get Current Scene
        Scene EEEList = electrician.getScene();
        //Place the new scene at the bottom of the current scene
        root.translateYProperty().set(EEEList.getHeight());
        //Add it to our holder pane which is StackPane
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
            rootPaneMecha.getChildren().remove(anchorPaneMecha);

        });
    }

    @FXML
    private void openhvac(MouseEvent event) {
    }

    @FXML
    private void openPainter(MouseEvent event) {
    }

    @FXML
    private void openWelder(MouseEvent event) {
    }
    
}
