package dandelion.config;

import lombok.Data;

@Data
public class ImageConf {
    private String extension;

    public ImageExtension getExtensionEnum() {
        return ImageExtension.valueOf(getExtension());
    }
}
