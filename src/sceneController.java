import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Node;

public class sceneController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    // define your offsets here
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private Button enterTextTool;

    @FXML
    void bgHover(MouseEvent event) {
        // enterTextTool.setStyle("-fx-fill: red;");
        enterTextTool.setStyle("-fx-background-color: #5868a1");
    }

    @FXML
    void bgHoverRemove(MouseEvent event) {
        // enterTextTool.setStyle("");
        enterTextTool.setStyle("-fx-background-color:  #3d5fd9");
    }

    @FXML
    void bgHoverPressed(MouseEvent event) {
        enterTextTool.setStyle("-fx-background-color:  #041f80");
    }

    @FXML
    public void enterEditor(MouseEvent event) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("scenes/Editor.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root, Color.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
                    
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField inputTextBox;
    @FXML
    private Label tvArea;

    @FXML
    void inputShowtoOutput(KeyEvent event) {
        String userText = inputTextBox.getText();
        tvArea.setText(userText);
    }

    @FXML
    void clearText(InputMethodEvent event) {
        inputTextBox.clear();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }

}