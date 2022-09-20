/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaaal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import static javax.swing.text.html.HTML.Tag.AREA;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ProfileViewController implements Initializable {

    @FXML
    private AnchorPane anchorPane3;
    @FXML
    private JFXTextField profuleName;
    @FXML
    private JFXTextField profileMail;
    @FXML
    private JFXTextField profileArea;
    @FXML
    private JFXTextField ProfileUser;
    @FXML
    private JFXButton backpro;
     @FXML
    private JFXButton show;
    /**
     * Initializes the controller class.
     */
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openMainMenu(MouseEvent event) throws IOException {
        //copied the prevoious method & edited
        //creating fancy slide transition to switch between scenes
        //Load the create FXMl first,and assign parent variable
        Parent root=FXMLLoader.load(getClass().getResource("MainMenuPage.fxml"));
        //Get Current Scene
        Scene HomeView=backpro.getScene();
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
        rootPane2.getChildren().remove(anchorPane3);
        });
        
    }
    
   
    
    public void ShowProfile(){
        //MyConnection con =new MyConnection(); 
        //Connection con;
       // Statement st;
        //String name,mail,area;
        //String user = userID.getText();
        



        
        /* try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "" );
            st=con.createStatement();
            PreparedStatement ps = con.prepareStatement("select *from studenttable where UserName=? ");
            ps.setString(1, eid);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                name = rs.getString("Name");
                profuleName.setText(name);
                mail= rs.getString("Email");
                profileMail.setText(mail);
                area=rs.getString("Area");
                profileArea.setText(area);
                user=rs.getString("UserName");
                ProfileUser.setText(user);
                       
                
            }
        }
        catch(Exception ex){
            System.out.println("Error "+ex);
            
        }*/
        
    }
 @FXML
    public void ShowALLPro(MouseEvent event) {
         
        
    }
  
    
}
