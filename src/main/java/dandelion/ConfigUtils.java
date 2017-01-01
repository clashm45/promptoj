package dandelion;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * 設定ファイル操作
 */
public class ConfigUtils {

    /**
     *application.confを読み込む。
     * @return Config
     */
    public static Config load() {
        return ConfigFactory.load();
    }

}
