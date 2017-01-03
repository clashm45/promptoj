package dandelion.config;

import lombok.Data;

@Data
public class AppConfig {
    private WebDriverConf webdriver;
    private OutputConf output;
    private BrowserConf browser;
}
