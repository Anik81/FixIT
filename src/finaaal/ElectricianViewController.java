/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaaal;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class ElectricianViewController implements Initializable {

    private Connection cn;
    private Statement st;
    private Object table1;

    @FXML
    private AnchorPane anchorPaneEEE;
    @FXML
    private JFXButton eeeBack;
    @FXML
    private TableView<Electrician> eelectrician;
    @FXML
    private TableColumn<Electrician, Integer> serial;
    @FXML
    private TableColumn<Electrician, String> name;
    @FXML
    private TableColumn<Electrician, String> phone;
    @FXML
    private TableColumn<Electrician, String> area;
    @FXML
    private TableColumn option;

    private Connection con;
    private ObservableList<Electrician> list;
    private DbHandler dbHandler;
    @FXML
    private ImageView showData;
    @FXML
    private JFXButton back;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dbHandler = new DbHandler();
        populateEEETable();
    }

    private void populateEEETable() {
        try {
            list = FXCollections.observableArrayList();
            String query = "SELECT *FROM electrician";
            con = dbHandler.getConnection();
            ResultSet set = con.createStatement().executeQuery(query);
            while (set.next()) {
                Electrician e = new Electrician();
                e.setSerial(set.getInt("Serial"));
                e.setName(set.getString("Name"));
                e.setPhone(set.getString("Phone"));
                e.setArea(set.getString("Area"));

                list.add(e);
            }
            serial.setCellValueFactory(new PropertyValueFactory<>("Serial"));
            name.setCellValueFactory(new PropertyValueFactory<>("Name"));
            phone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
            area.setCellValueFactory(new PropertyValueFactory<>("Area"));

            //inserting a button
            Callback<TableColumn<Electrician, String>, TableCell<Electrician, String>> cellFactory = (param) -> {

                final TableCell<Electrician, String> cell = new TableCell<Electrician, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            final Button hireButton = new Button("HIRE");
                            hireButton.setOnAction(event -> {
                                Electrician e = getTableView().getItems().get(getIndex());

                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setContentText("You Have Hired \n" + e.getName() + "\nArea: " + e.getArea() + "\nContact No: " + e.getPhone());
                                alert.show();
                                //new myNotification().start();
                                try {
                                    Thread.sleep(3000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(ElectricianViewController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                Image img = new Image("/bell_icon.png");
                                Notifications not = Notifications.create()
                                        .title("Hello " + e.getName() + "!!!")
                                        .text("You've Got a Work to DO. Let' get Started. Hurry!!")
                                        .graphic(new ImageView(img))
                                        .hideAfter(Duration.seconds(10))
                                        .position(Pos.TOP_LEFT)
                                        .onAction(new EventHandler<ActionEvent>() {
                                            @Override
                                            public void handle(ActionEvent event) {
                                                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                                System.out.println("Clicked On Notification");
                                            }
                                        });
                                not.darkStyle();
                                not.show();

                            });
                            setGraphic(hireButton);
                            setText(null);

                        }
                    }

                };

                return cell;
            };

            option.setCellFactory(cellFactory);
            eelectrician.setItems(list);

        } catch (SQLException ex) {
            Logger.getLogger(ElectricianViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void showElectricianList(MouseEvent event) {
    }

    private void showElectricianList(ActionEvent event) {

    }

    public ElectricianViewController() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/student", "root", "");
            st = cn.createStatement();
            //JOptionPane.showMessageDialog(null, "Connected");

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null, "NOT Connected");
        }

    }

       /* @FXML
    private void openFindMecha(MouseEvent event) throws IOException {
        //copied the prevoious method & edited
        //creating fancy slide transition to switch between scenes
        //Load the create FXMl first,and assign parent variable
        Parent root = FXMLLoader.load(getClass().getResource("MechanicView.fxml"));
        //Get Current Scene
        Scene HomeView = eeeBack.getScene();
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

    @FXML
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
    }

}
