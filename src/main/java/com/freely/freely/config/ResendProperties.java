package com.freely.freely.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "resend")
@Getter
@Setter
public class ResendProperties {
    private String apiKey;
    private String fromEmail;

}
