package dandelion;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;

public class MainController {

    @FXML
    private Menu menu;
    @FXML
    private MenuItem settings;
    @FXML
    private MenuItem close;

    @FXML
    private TextField testcase;

    @FXML
    private Button camera;

    /**
     * スプラッシュ画面 表示
     */
    public static void show() {
        try {
            Parent root = FXMLLoader.load(SplashController.class.getResource("main.fxml"));
            Main.getPrimaryStage().setTitle("promptoj");
            Main.getPrimaryStage().setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void screenShot() {
        SeleniumWrapper.getInstance().takeScreenShot();
    }

}
