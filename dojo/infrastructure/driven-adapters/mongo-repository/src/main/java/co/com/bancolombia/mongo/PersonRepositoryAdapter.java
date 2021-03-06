package co.com.bancolombia.mongo;

import co.com.bancolombia.model.person.Person;
import co.com.bancolombia.model.person.gateways.PersonRepository;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryAdapter extends AdapterOperations<Person, PersonData, String, PersonDBRepository>
implements PersonRepository
{

    public PersonRepositoryAdapter(PersonDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        //super(repository, mapper, d -> mapper.map(d, Object.class/* change for domain model */));
        super(repository, mapper, d -> mapper.mapBuilder(d, Person.PersonBuilder.class).build());
    }
}
