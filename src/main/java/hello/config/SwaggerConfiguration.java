package hello.config;

import java.util.Collections;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * SpringFoxを動かすための最低限の設定を行う。
 * 
 * 役に立ったHelloWorld
 * https://dev.classmethod.jp/beginners/springfox_create_api_specification/
 * https://dev.classmethod.jp/beginners/springfox_create_api_specification_detail_1/
 * https://dev.classmethod.jp/beginners/springfox_create_api_specification_detail_2/
 */
@Configuration

//BeanValidationをドキュメントに反映するための設定。
//https://springfox.github.io/springfox/docs/current/
@Import({ BeanValidatorPluginsConfiguration.class })
public class SwaggerConfiguration {

	// qiitaから拾った最低限の設定。
	public Docket publicDocument() {
		return new Docket(DocumentationType.SWAGGER_2) // swagger2仕様
			.groupName("public")
			.select()
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("name", "http://www.hoge", "myeaddress@company.com");
		ApiInfo apiInfo = new ApiInfo("My REST API", "Some custom description of API.", "API TOS", "Terms of service",
				contact, "License of API", "API license URL", Collections.emptyList());
		return apiInfo;
	}
}
