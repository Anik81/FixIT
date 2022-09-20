/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaaal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import static javafx.scene.paint.Color.TOMATO;
import javafx.util.Duration;
import javax.swing.JOptionPane;


/**
 *
 * @author HP
 */
public class LoginViewController implements Initializable {

    private Label label;
    @FXML
    private TabPane tabPaneLogin;
    @FXML
    private Tab tabAdmin;
    @FXML
    private Tab tabUser;
    @FXML
    private Label lblCreateAccount;
    @FXML
    private Pane slidingPane;
    @FXML
    private Label lblAdmin;
    @FXML
    private Label lblStatus;
    @FXML
    private StackPane rootPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private JFXButton loginbtn;
    @FXML
    private JFXTextField userID;
    @FXML
    private JFXPasswordField pass;

    @FXML
    private StackPane rootPane2;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private Label lblMenu;

    private Connection con;
    private Statement st;
    
    public String eID,nAme,eMail,aRea;
    
     @FXML
    private JFXTextField profuleName;
    @FXML
    private JFXTextField profileMail;
    @FXML
    private JFXTextField profileArea;
    @FXML
    private JFXTextField ProfileUser;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void openAdminTab(MouseEvent event) {
        //open Employee tab when admin level is clicked
        TranslateTransition toLeftTransition = new TranslateTransition(new Duration(500), lblStatus);
        toLeftTransition.setToX(slidingPane.getTranslateX());
        toLeftTransition.play();
        toLeftTransition.setOnFinished((ActionEvent event2) -> {
            lblStatus.setText("EMPLOYEE");
        });
        tabPaneLogin.getSelectionModel().select(tabAdmin);
    }

    @FXML
    private void openUserTab(MouseEvent event) {
        //We are using translation animation to slide label left &right
        TranslateTransition toRightAnimation = new TranslateTransition(new Duration(400), lblStatus);
        //ugly fix
        toRightAnimation.setToX(slidingPane.getTranslateX() + (slidingPane.getPrefWidth() - lblStatus.getPrefWidth()));
        toRightAnimation.play();
        toRightAnimation.setOnFinished((ActionEvent event1) -> {
            lblStatus.setText("USER");
        });
        //set selected tab as USER
        tabPaneLogin.getSelectionModel().select(tabUser);

    }

    @FXML
    private void openCreateAccountScene(MouseEvent event) throws IOException {
        //creating fancy slide transition to switch between scenes
        //Load the create FXMl first,and assign parent variable
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccountView.fxml"));
        //Get Current Scene
        Scene loginScene = lblAdmin.getScene();
        //Place the new scene at the bottom of the current scene
        root.translateYProperty().set(loginScene.getHeight());
        //Add it to our holder pane which is StackPane
        rootPane.getChildren().add(root);
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
            rootPane.getChildren().remove(anchorPane);

        });
    }

    @FXML
    private void openMainMenu(MouseEvent event) throws IOException {

        String user = userID.getText();
        String pw = pass.getText();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
            //st=con.createStatement();

            PreparedStatement ps = con.prepareStatement("select *from studenttable where UserName=? and Password=?");
            ps.setString(1, user);
            ps.setString(2, pw);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                eID = rs.getString("UserName");
                nAme = rs.getString("Name");
                eMail = rs.getString("Email");
                aRea=rs.getString("Area");
                System.out.println(eID);
                //creating fancy slide transition to switch between scenes
                //Load the create FXMl first,and assign parent variable
                Parent root = FXMLLoader.load(getClass().getResource("MainMenuPage.fxml"));
                //Get Current Scene
                Scene MainScene = lblAdmin.getScene();
                //Place the new scene at the bottom of the current scene
                root.translateYProperty().set(MainScene.getHeight());
                //Add it to our holder pane which is StackPane
                //get an instance of stackPane from the Parent
                //StackPane rootPane=(StackPane) MainScene.getRoot();
                rootPane.getChildren().add(root);
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
                    rootPane.getChildren().remove(anchorPane);
                });

            } else {
                JOptionPane.showMessageDialog(null, "Invalid User ID or Password");
                userID.setText("");
                pass.setText("");
            }
            con.close();
            st.close();

        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Unable To Connect");
        }

    }
 
}
