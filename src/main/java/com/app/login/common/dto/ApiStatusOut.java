package com.app.login.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties
public class ApiStatusOut implements Serializable {
    private static final long serialVersionUID = 1L;
    @JsonProperty("api_code")
    private String code;
    @JsonProperty("api_business_message")
    private String businessMessage;
    @JsonProperty("api_developer_message")
    private String developerMessage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBusinessMessage() {
        return businessMessage;
    }

    public void setBusinessMessage(String businessMessage) {
        this.businessMessage = businessMessage;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

}

