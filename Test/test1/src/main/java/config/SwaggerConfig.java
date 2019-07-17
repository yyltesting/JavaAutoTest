package config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;



import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//阐述我是被扫描的
@RestController
public class SwaggerConfig {

@Bean
public Docket Api(){
	return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(apiInfo())
			.pathMapping("/")
			.select()
			.paths(PathSelectors.regex("/.*"))
			.build();
}
private ApiInfo apiInfo(){
	return new ApiInfoBuilder().title("我的接口文档")
			.contact(new Contact("yyl", "", "791482765@qq.com"))
			.version("1.0.0.0")
			.build();
}

}
