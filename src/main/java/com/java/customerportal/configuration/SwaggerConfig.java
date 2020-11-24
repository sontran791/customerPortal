package com.java.customerportal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket swaggerAPI() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.java.customerportal"))
                .paths(PathSelectors.any())
                .build();

        ArrayList<Parameter> parameters = new ArrayList<>();
        parameters.add(new ParameterBuilder()
                .modelRef(new ModelRef("string"))
                .name("Authorization")
                .parameterType("header")
                .required(true)
                .build());

        docket.globalOperationParameters(parameters);

        return docket;
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Customer Portal API Documentation")
                .description("API Documentation")
                .version("1.0")
                .contact(new Contact("Customer Portal", "http://www.customer-portal.com", "customer.portal.team@gmail.com"))
                .license("License 1.0")
                .licenseUrl("http://www.customer-portal.com/license.html")
                .build();
    }
}
