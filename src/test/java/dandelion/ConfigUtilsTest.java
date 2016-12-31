package dandelion;

import com.typesafe.config.Config;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class ConfigUtilsTest {
    @Test
    public void load() throws Exception {
        Config c = ConfigUtils.load();
        Assert.assertThat("/usr/local/bin/chromedriver", is(c.getString("webdriver.chrome")));
    }

}