package com.pms.vital.details;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.pms.vital.details.utilities.Auditor;

@EnableOAuth2Sso 
@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class PmsVitalDetailsApplication {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new Auditor();
	}
	public static void main(String[] args) {
		SpringApplication.run(PmsVitalDetailsApplication.class, args);
	} 

}
