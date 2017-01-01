package dandelion;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

import static dandelion.SeleniumWrapper.WebDriverNames.*;

/**
 * スプラッシュ画面Controller
 */
public class SplashController {

    @FXML
    private Button chrome;
    @FXML
    private Button ie;
    @FXML
    private Button firefox;

    /**
     * スプラッシュ画面 表示
     * @throws IOException
     */
    public static void show() {
        try {
            Parent root = FXMLLoader.load(SplashController.class.getResource("splash.fxml"));
            Main.getPrimaryStage().setTitle("ブラウザを選択する");
            Main.getPrimaryStage().setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void startChrome(){
        SeleniumWrapper.getInstance().Open(Chrome);
        MainController.show();
    }
    @FXML
    public void startIE() {
        SeleniumWrapper.getInstance().Open(IE);
        MainController.show();
    }
    @FXML
    public void startFireFox(){
        SeleniumWrapper.getInstance().Open(FireFox);
        MainController.show();
    }
}
