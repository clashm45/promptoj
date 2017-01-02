package dandelion;

import com.typesafe.config.ConfigObject;
import dandelion.config.AppConfig;
import dandelion.config.ConfigUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * 設定画面Controller
 */
public class ConfigController {

    @FXML
    private TextField in_chrome;
    @FXML
    private TextField in_ie;
    @FXML
    private TextField in_firefox;

    @FXML
    private TextField in_outdir;

    @FXML
    private RadioButton radio_jpg;
    @FXML
    private RadioButton radio_png;
    @FXML
    private RadioButton radio_gif;


    /**
     * 初期化
     *
     * 設定ファイルを読み込む。
     */
    public void init() {
        AppConfig conf = ConfigUtils.getConfig();

        in_chrome.setText(conf.getWebdriver().getChrome());
        in_ie.setText(conf.getWebdriver().getIe());
        in_firefox.setText(conf.getWebdriver().getFirefox());

        in_outdir.setText(conf.getOutput().getDirpath());

        switch (conf.getOutput().getImage().getExtensionEnum()) {
            case jpg:
                radio_jpg.setSelected(true);
                break;
            case png:
                radio_png.setSelected(true);
                break;
            case gif:
                radio_gif.setSelected(true);
                break;
            default:
                radio_jpg.setSelected(true);
                break;
        }
    }

    @FXML
    public void save(ActionEvent event) {
        ConfigObject origin = ConfigUtils.load().root();
        //origin.withValue()
    }

    @FXML
    public void cancel(ActionEvent event) {
        ((Stage)((Button) event.getSource()).getScene().getWindow()).close();
    }


}
