package org.generationbrasil.blogpessoal.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI configuraçaoOpenAPI() {
		return new OpenAPI()
					.info(new Info()
						.title("Blog Charles Amorim")
						.description("Projeto Blog Pessoal - Generation Brasil")
						.version("v0.0.1")
					.license(new License()
							.name("Generation Brasil")
							.url("https://brazil.generation.org/"))
					.contact(new Contact()
							.name("Charles Amorim")
							.url("https://www.linkedin.com/in/charlesamorimdev/")
							.email("charlesamorim.dev@gmail.com")))
					.externalDocs(new ExternalDocumentation()
							.description("GitHub")
							.url("https://github.com/CharlesAmorimDev/BlogPessoal"));
	}

	private ApiResponse novaResposta(String mensagem) {
		return new ApiResponse().description(mensagem);
	}
	
	@Bean
	public OpenApiCustomiser customizarRespostaHttp() {
		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
				ApiResponses resposta = operation.getResponses();
				resposta.addApiResponse("200", novaResposta("Sucesso!"));
				resposta.addApiResponse("201", novaResposta("Objeto Salvo!"));
				resposta.addApiResponse("204", novaResposta("Objeto Excluido!"));
				resposta.addApiResponse("400", novaResposta("Erro na Requisição!"));
				resposta.addApiResponse("401", novaResposta("Acesso não Autorizado!"));
				resposta.addApiResponse("404", novaResposta("Objeto não Encontrado!"));
				resposta.addApiResponse("500", novaResposta("Erro na Aplicação!"));
			}));
		};
	}
}
