package de.hartmut.spring.keycloak.rest;

import de.hartmut.spring.keycloak.config.AppConfig;
import org.keycloak.representations.adapters.config.BaseAdapterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hartmut on 29.11.16.
 */
@RestController()
@RequestMapping("/keycloak")
public class KeycloakCtrl {

    private final AppConfig appConfig;

    @Autowired
    public KeycloakCtrl(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @GetMapping("/config")
    public ResponseEntity<BaseAdapterConfig> getConfig() {
        BaseAdapterConfig baseAdapterConfig = new BaseAdapterConfig();
        baseAdapterConfig.setRealm(appConfig.getKcRealm());
        baseAdapterConfig.setAuthServerUrl(appConfig.getKcAuthServerUrl());
        baseAdapterConfig.setSslRequired(appConfig.getKcSslRequired());
        baseAdapterConfig.setResource(appConfig.getKcJsResource());
        baseAdapterConfig.setPublicClient(true);

        return ResponseEntity.ok(baseAdapterConfig);
    }
}
