package dandelion;

import dandelion.config.ConfigUtils;
import dandelion.config.WebDriverConf;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Application メイン
 */
public class Main extends Application {

    /**
     * primary stage
     */
    private static Stage pStage;

    /**
     * 初期化
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        WebDriverConf conf = ConfigUtils.getConfig().getWebdriver();
        System.setProperty("webdriver.chrome.driver", conf.getChrome());
        System.setProperty("webdriver.ie.driver", conf.getIe());
        System.setProperty("webdriver.firefox.driver", conf.getFirefox());
    }

    /**
     * アプリケーション起動
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Primary Stageを保持
        this.pStage = primaryStage;

        // 初期表示画面 スプラッシュ画面を表示
        SplashController.show();
        // 表示
        // ここから先はstageにsetSceneすると画面遷移する。
        primaryStage.show();
    }

    /**
     * メイン
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * 各種Controllerからprimary stageを使用する為のgetter
     * @return
     */
    public static Stage getPrimaryStage() {
        return pStage;
    }
}
