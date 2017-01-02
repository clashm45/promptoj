package dandelion;

import dandelion.config.AppConfig;
import dandelion.config.ConfigUtils;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * メイン画面Controller
 */
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
     * 設定画面 表示
     */
    @FXML
    public void openConfig() {
        try {
            FXMLLoader loader = new FXMLLoader(ConfigController.class.getResource("config.fxml"));
            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            ConfigController configController = loader.getController();
            configController.init();//初期化

            // モーダルウインドウに設定
            newStage.initModality(Modality.APPLICATION_MODAL);
            // オーナーを設定
            newStage.initOwner(Main.getPrimaryStage());
            // 表示
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 出力先パス生成
     *
     * ${dir}/${caseid}/${yyyyMMdd_hhmmss}.${extension}
     *
     * @return Path
     */
    public Path generatePath() {
        AppConfig conf = ConfigUtils.getConfig();
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_hhmmss"));
        return Paths.get(conf.getOutput().getDirpath(),
                conf.getOutput().getCaseid(),
                date + "." + conf.getOutput().getImage().getExtension());
    }

}
