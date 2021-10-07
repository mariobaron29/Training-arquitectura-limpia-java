package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.PersonDTO;
import co.com.bancolombia.model.person.Person;
import co.com.bancolombia.usecase.person.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final PersonUseCase personaUseCase;

    public Mono<ServerResponse> getPerson(ServerRequest serverRequest) {

        return personaUseCase.getPerson(serverRequest.pathVariable("id"))
                .flatMap(person -> ServerResponse.ok().body(Mono.just(person), Person.class));
    }

    public Mono<ServerResponse> getBalance(ServerRequest serverRequest) {
        return personaUseCase.getBalance(serverRequest.pathVariable("id"))
                .flatMap(balance -> ServerResponse.ok().body(Mono.just(balance), Float.class));
    }

    public Mono<ServerResponse> savePerson(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(PersonDTO.class)
                        .map(personDTO -> personaUseCase.savePerson(Person.builder()
                                        .name(personDTO.getName())
                                        .balance(personDTO.getBalance())
                                .build()))
                .flatMap(person -> ServerResponse.ok().body(Mono.just(person), Person.class))
                .onErrorResume(e -> ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ha ocurrido un error al guardar la persona", String.class));
    }

    public Mono<ServerResponse> getPersonById(ServerRequest serverRequest) {
        return personaUseCase.getPersonById(serverRequest.pathVariable("id"))
                .flatMap(person -> ServerResponse.ok().body(Mono.just(person), Person.class));
    }

    public Mono<ServerResponse> getPeople(ServerRequest serverRequest) {
        return ServerResponse.ok().body(personaUseCase.getPeople(), Person.class);
    }

}
