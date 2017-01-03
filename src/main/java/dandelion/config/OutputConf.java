package dandelion.config;

import lombok.Data;

@Data
public class OutputConf {
    private String dirpath;
    private String caseid;
    private ImageConf image;
}
