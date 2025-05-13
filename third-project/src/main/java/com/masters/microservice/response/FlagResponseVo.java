package com.masters.microservice.response;

import java.util.Arrays;

/**
 * Response Object for Flags.
 */
public class FlagResponseVo {

    private String name;
    private String[] availableValues;
    private String description;
    private String enabled;
    private String value;
    private Boolean isPermanent;

    public FlagResponseVo() {
    }

    public FlagResponseVo(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAvailableValues() {
        return availableValues;
    }

    public void setAvailableValues(String[] availableValues) {
        this.availableValues = availableValues;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "FlagResponseVo{" +
                "name='" + name + '\'' +
                ", availableValues=" + Arrays.toString(availableValues) +
                ", description='" + description + '\'' +
                ", enabled='" + enabled + '\'' +
                ", value='" + value + '\'' +
                ", isPermanent=" + isPermanent +
                '}';
    }
}
