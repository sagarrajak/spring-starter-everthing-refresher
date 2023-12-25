package com.springstarter.springstarterweb.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class FeatureEndpoints {
    private final Map<String, Feature> featureaMap = new ConcurrentHashMap<>();

    public FeatureEndpoints() {
        featureaMap.put("department", new Feature(true));
        featureaMap.put("auth", new Feature(false));
        featureaMap.put("user", new Feature(false));
    }


    @ReadOperation
    public Map<String, Feature> getFeatureaMap() {
        return  featureaMap;
    }

    @ReadOperation
    public  Feature getFeature(@Selector String featureName) {
        return featureaMap.get(featureName);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Feature {
        private boolean isEnabled;
    }

}
