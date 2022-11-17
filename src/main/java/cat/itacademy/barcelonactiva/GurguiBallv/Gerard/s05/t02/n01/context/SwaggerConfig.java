package cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.context;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*http://localhost:8080/swagger-ui.html#/jugador-controller*/

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors
                                .basePackage("cat.itacademy.barcelonactiva.GurguiBallv.Gerard.s05.t02.n01.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){

        return new ApiInfo(
                "Juego de los dados",
                "Cada jugador lanza dos dados, el primero que suma un 7 gana la ronda." +
                        "el ganador de 3 rondas, gana la partida",
                "1.0",
                "",
                new Contact("Gerard", "https://gerri.com", ""),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}
