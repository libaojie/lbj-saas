package com.lbj.saas.helper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 
 * @ClassName 
 * @Description
 * @date 2018-09-04 117:22:31
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
 
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.lbj.com.lbj.saas"))
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("利用swagger2构建全景展示api文档")
				//创建人
                .contact(new Contact("libaojie", "", "@qq.com"))
				.description("接口文档在线生成和在线接口调试")
				.termsOfServiceUrl("")
				.version("1.0")
				.build()
				;
	}

}
