package dandelion;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * メイン画面Controller
 */
public class MainController implements Initializable {

    @FXML
    private TextField testcase;

    @FXML
    private ChoiceBox<String> imageExt;

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

    /**
     * スクリーンショット
     */
    @FXML
    public void screenShot() {
        SeleniumWrapper.getInstance().takeScreenShot(generatePath());
    }

    /**
     * アプリケーションの終了
     */
    @FXML
    public void quit() {
        SeleniumWrapper.getInstance().quit();
        Platform.exit();
    }

    /**
     * 出力先パス生成
     *
     * ${dir}/${caseid}/${yyyyMMdd_hhmmss}.${extension}
     *
     * @return Path
     */
    public Path generatePath() {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_hhmmss"));
        return Paths.get(testcase.getText(), date + "." + imageExt.getValue());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageExt.setItems(FXCollections.observableArrayList("jpeg", "gif", "png"));
        imageExt.getSelectionModel().selectFirst();
    }
}
