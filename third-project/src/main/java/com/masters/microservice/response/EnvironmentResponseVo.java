package com.masters.microservice.response;
/**
 * Response Object for Environments.
 */
public class EnvironmentResponseVo {

    private String name;
    private String id;
    private String description;

    public EnvironmentResponseVo() {
    }

    /**
     * All arguments constructor.
     *
     * @param name        Environment name.
     * @param id          Environment Id.
     * @param description Environment Description.
     */
    public EnvironmentResponseVo(String name, String id, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
