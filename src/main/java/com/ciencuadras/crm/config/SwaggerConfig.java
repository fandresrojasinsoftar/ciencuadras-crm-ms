package com.ciencuadras.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("ciencuadras-commons").select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build().apiInfo(apiEndPointsInfo());

	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Ciencuadras CRM - REST API")
				.description("Ciencuadras CRM - REST API")
				.contact(new Contact("Andres Ramirez", "https://www.insoftar.com/", "andres.ramirez@insoftar.com"))
				.contact(new Contact(" Fabio Rojas", "https://www.insoftar.com/", "fabio.rojas@insoftar.com"))
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0")
				.build();
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/documentation/v2/api-docs", "/v2/api-docs?group=ciencuadras-commons");
		registry.addRedirectViewController("/documentation/swagger-resources/configuration/ui",
				"/swagger-resources/configuration/ui");
		registry.addRedirectViewController("/documentation/swagger-resources/configuration/security",
				"/swagger-resources/configuration/security");
		registry.addRedirectViewController("/documentation/swagger-resources", "/swagger-resources");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/documentation/swagger-ui.html**")
				.addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
		registry.addResourceHandler("/documentation/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}