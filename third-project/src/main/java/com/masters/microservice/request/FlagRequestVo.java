package com.masters.microservice.request;

/**
 * Request Object for Flags.
 */
public class FlagRequestVo {

    private String platform;

    private String environment;

    private String flag;

    private String value;

    public FlagRequestVo() {
    }

    /**
     * All arguments constructor.
     */
    public FlagRequestVo(String platform, String environment, String flag, String value) {
        this.platform = platform;
        this.environment = environment;
        this.flag = flag;
        this.value = value;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
