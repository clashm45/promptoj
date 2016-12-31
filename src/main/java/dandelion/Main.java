package dandelion;

import com.typesafe.config.Config;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage pStage;

    @Override
    public void init() throws Exception {
        Config conf = ConfigUtils.load();
        System.setProperty("webdriver.chrome.driver", conf.getString("webdriver.chrome"));
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Primary Stageを保持
        this.pStage = primaryStage;

        // 初期表示画面 スプラッシュ画面を表示
        SplashController.show();
        // 表示
        // ここから先はstageにsetSceneすると画面遷移する。
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage() {
        return pStage;
    }
}
