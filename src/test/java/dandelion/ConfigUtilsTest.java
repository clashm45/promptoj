package dandelion;

import com.typesafe.config.Config;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class ConfigUtilsTest {
    @Test
    public void load() throws Exception {
        Config webdriver = ConfigUtils.load().getConfig("webdriver");
        Assert.assertThat("/usr/local/bin/chromedriver", is(webdriver.getString("chrome")));
        Assert.assertThat("/usr/local/bin/iedriver", is(webdriver.getString("ie")));
        Assert.assertThat("/usr/local/bin/firefoxdriver", is(webdriver.getString("firefox")));

        Config output = ConfigUtils.load().getConfig("output");
        Assert.assertThat("case", is(output.getString("caseid")));
        Assert.assertThat(".", is(output.getString("dirpath")));
        Assert.assertThat("jpeg", is(output.getString("image.extension")));

        Config browser = ConfigUtils.load().getConfig("browser");
        Assert.assertThat("300", is(browser.getString("width")));
        Assert.assertThat("300", is(browser.getString("height")));
    }

}