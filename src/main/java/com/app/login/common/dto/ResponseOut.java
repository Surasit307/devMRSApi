package com.app.login.common.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties
public class ResponseOut implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("api_status")
    private ApiStatusOut apiStatus = new ApiStatusOut();
    private transient Map<String, Object> data = new HashMap<>();
    private transient Map<String, Object> data2 = new HashMap<>();
    
    public ApiStatusOut getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(ApiStatusOut apiStatus) {
        this.apiStatus = apiStatus;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

	public Map<String, Object> getData2() {
		return data2;
	}

	public void setData2(Map<String, Object> data2) {
		this.data2 = data2;
	}
}
