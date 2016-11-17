package de.hartmut.spring.keycloak.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String kcRealm;
    private String kcAuthServerUrl;
    private String kcBackendSecret;

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
}
