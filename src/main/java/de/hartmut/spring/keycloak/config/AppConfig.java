package de.hartmut.spring.keycloak.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String kcRealm;
    private String kcAuthServerUrl;
    private String kcBackendSecret;
    private String kcSslRequired = "none";
    private String kcJsResource;

    public String getKcRealm() {
        return kcRealm;
    }

    public void setKcRealm(String kcRealm) {
        this.kcRealm = kcRealm;
    }

    public String getKcAuthServerUrl() {
        return kcAuthServerUrl;
    }

    public void setKcAuthServerUrl(String kcAuthServerUrl) {
        this.kcAuthServerUrl = kcAuthServerUrl;
    }

    public String getKcBackendSecret() {
        return kcBackendSecret;
    }

    public void setKcBackendSecret(String kcBackendSecret) {
        this.kcBackendSecret = kcBackendSecret;
    }

    public String getKcSslRequired() {
        return kcSslRequired;
    }

    public void setKcSslRequired(String kcSslRequired) {
        this.kcSslRequired = kcSslRequired;
    }

    public String getKcJsResource() {
        return kcJsResource;
    }

    public void setKcJsResource(String kcJsResource) {
        this.kcJsResource = kcJsResource;
    }
}
