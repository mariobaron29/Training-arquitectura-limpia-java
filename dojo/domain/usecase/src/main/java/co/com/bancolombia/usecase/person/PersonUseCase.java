package co.com.bancolombia.usecase.person;

import co.com.bancolombia.model.person.Person;
import co.com.bancolombia.model.person.gateways.PersonRepository;
import co.com.bancolombia.model.person.gateways.PersonService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PersonUseCase {
    private final PersonService serviceGateway;
    private final PersonRepository personRepository;

    public Mono<Person> getPerson(String id){
        return serviceGateway.getPerson(id);
    }

    public Mono<Float> getBalance(String id){
        return serviceGateway.getBalance(id);
    }

    public Flux<Person> getPeople(){
        return personRepository.findAll();
    }

    public Mono<Person> getPersonById(String id){
        return personRepository.findById(id);
    }

    public Mono<Person> savePerson(Person person){
        return personRepository.save(person);
    }


}
