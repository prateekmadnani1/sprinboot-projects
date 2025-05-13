package com.masters.microservice.request;


/**
 * Request Object for Platforms.
 */
public class PlatformRequestVo {

    private String platform;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "PlatformRequestVo{" + "platform='" + platform + '\'' + '}';
    }
}
