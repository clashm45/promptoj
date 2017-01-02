package dandelion.config;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class ImageConfTest {
    @Test
    public void testGetExtensionEnum() throws Exception {
        ImageConf ic = new ImageConf();
        ic.setExtension("jpg");

        Assert.assertThat(ImageExtension.jpg, is(ic.getExtensionEnum()));
    }

}