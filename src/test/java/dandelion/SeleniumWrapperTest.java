package dandelion;

import org.junit.Test;
import static dandelion.SeleniumWrapper.WebDriverNames.*;

/**
 * Created by subaru on 2016/12/25.
 */
public class SeleniumWrapperTest {

    @Test
    public void testOpen() throws Exception {
        SeleniumWrapper sw = new SeleniumWrapper();
        sw.Open(Chrome);
    }
}