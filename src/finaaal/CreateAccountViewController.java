/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaaal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class CreateAccountViewController implements Initializable {

    @FXML
    private Label lblLogin;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXTextField uname;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private JFXPasswordField cpass;
    @FXML
    private JFXTextField area;
    @FXML
    private JFXButton createAccount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openLoginScene(MouseEvent event) throws IOException {
        //copied the prevoious method & edited
        //creating fancy slide transition to switch between scenes
        //Load the create FXMl first,and assign parent variable
        Parent root=FXMLLoader.load(getClass().getResource("LoginView.fxml"));
        //Get Current Scene
        Scene accountScene=lblLogin.getScene();
        //Place the new scene at the bottom of the current scene
        root.translateYProperty().set(accountScene.getHeight());
        //Add it to our holder pane which is StackPane
        //get an instance of stackPane from the Parent
        StackPane rootPane=(StackPane) accountScene.getRoot();
        rootPane.getChildren().add(root);
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
        rootPane.getChildren().remove(anchorpane);
    });
        
    }
    
    

    @FXML
    private void saveData(MouseEvent event) {
        
        String Name = name.getText();
        String Email = mail.getText();
        String UserName = uname.getText();
        String Area = area.getText();
        String Password = pass.getText();
        String CPassword = cpass.getText();
        
        MyConnection m=new MyConnection();
        m.insert(Name, Email, UserName, Area, Password, CPassword);
        
    }
    
}
