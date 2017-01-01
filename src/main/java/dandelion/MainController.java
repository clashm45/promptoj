package dandelion;

import com.typesafe.config.Config;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

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
     * 出力先パス生成
     *
     * ${dir}/${caseid}/${yyyyMMdd_hhmmss}.${extension}
     *
     * @return Path
     */
    public Path generatePath() {
        Config output = ConfigUtils.load().getConfig("output");
        String dir = output.getString("dirpath");
        String caseid = output.getString("caseid");
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_hhmmss"));
        String ext = output.getString("image.extension");
        return Paths.get(dir, caseid, date + "." + ext);
    }

}
