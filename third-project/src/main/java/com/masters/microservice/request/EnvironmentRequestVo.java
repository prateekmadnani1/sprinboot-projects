package com.masters.microservice.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Request Object for Environments.
 */
@Entity
public class EnvironmentRequestVo {

    private String platformName;

    private String environmentName;

    private String description;
    @Id
    private Long id;

    public EnvironmentRequestVo() {
    }

    /**
     * All arguments constructor.
     */
    public EnvironmentRequestVo(String platformName, String environmentName, String description) {
        this.platformName = platformName;
        this.environmentName = environmentName;
        this.description = description;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
