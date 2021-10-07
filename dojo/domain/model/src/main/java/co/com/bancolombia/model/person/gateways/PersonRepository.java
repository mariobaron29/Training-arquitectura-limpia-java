package co.com.bancolombia.model.person.gateways;

import co.com.bancolombia.model.person.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {
    Mono<Person> save(Person pet);
    Mono<Person> findById(String id);
    Flux<Person> findAll();
}
