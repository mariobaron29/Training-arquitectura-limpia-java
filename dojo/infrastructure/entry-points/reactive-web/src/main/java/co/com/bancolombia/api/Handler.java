package co.com.bancolombia.api;

import co.com.bancolombia.model.person.Person;
import co.com.bancolombia.usecase.person.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
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

}
