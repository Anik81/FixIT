/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaaal;

import static java.awt.SystemColor.window;
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
import javafx.scene.control.Label;
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
public class MainMenuPageController implements Initializable {

    @FXML
    private StackPane rootPane2;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ImageView findMec;
    @FXML
    private ImageView profile;
    @FXML
    private ImageView credit;
    @FXML
    private ImageView about;
    @FXML
    private ImageView feedback;
    @FXML
    private ImageView exit;
    
     @FXML
    private StackPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openMechanic(MouseEvent event) throws IOException {
         //copied the prevoious method & edited
        //creating fancy slide transition to switch between scenes
        //Load the create FXMl first,and assign parent variable
        Parent root=FXMLLoader.load(getClass().getResource("MechanicView.fxml"));
        //Get Current Scene
        Scene MechanicView=about.getScene();
        //Place the new scene at the bottom of the current scene
        root.translateYProperty().set(MechanicView.getHeight());
        //Add it to our holder pane which is StackPane
        //get an instance of stackPane from the Parent
        StackPane rootPane2=(StackPane) MechanicView.getRoot();
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
        rootPane2.getChildren().remove(AnchorPane2);
    });
        
    }

    @FXML
    private void openProfile(MouseEvent event) throws IOException {
           //copied the prevoious method & edited
        //creating fancy slide transition to switch between scenes
        //Load the create FXMl first,and assign parent variable
        Parent root=FXMLLoader.load(getClass().getResource("ProfileView.fxml"));
        //Get Current Scene
        Scene ProfileView=about.getScene();
        //Place the new scene at the bottom of the current scene
        root.translateYProperty().set(ProfileView.getHeight());
        //Add it to our holder pane which is StackPane
        //get an instance of stackPane from the Parent
        StackPane rootPane2=(StackPane) ProfileView.getRoot();
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
        rootPane2.getChildren().remove(AnchorPane2);
    });
       
      
    }

    @FXML
    private void openCredit(MouseEvent event) {
    }

    @FXML
    private void openAbout(MouseEvent event) throws IOException {
        //copied the prevoious method & edited
        //creating fancy slide transition to switch between scenes
        //Load the create FXMl first,and assign parent variable
        Parent root=FXMLLoader.load(getClass().getResource("AboutView.fxml"));
        //Get Current Scene
        Scene AboutView=about.getScene();
        //Place the new scene at the bottom of the current scene
        root.translateYProperty().set(AboutView.getHeight());
        //Add it to our holder pane which is StackPane
        //get an instance of stackPane from the Parent
        StackPane rootPane2=(StackPane) AboutView.getRoot();
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
        rootPane2.getChildren().remove(AnchorPane2);
    });
        
        
    }

    @FXML
    private void openFeedBack(MouseEvent event) {
    }

    @FXML
    private void openExit(MouseEvent event) {
        
       
    }
    
}
