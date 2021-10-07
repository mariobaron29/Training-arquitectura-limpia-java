package co.com.bancolombia.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class Router {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(Handler handler) {
        return route(RequestPredicates.GET("/api/person/{id}"), handler::getPerson)
        .andRoute(GET("/api/balance/{id}"), handler::getBalance)
        .andRoute(GET("/api/people"), handler::getPeople)
        .andRoute(GET("/api/person/{id}"), handler::getPersonById)
        .andRoute(POST("/api/savePerson"), handler::savePerson);

        }
}
