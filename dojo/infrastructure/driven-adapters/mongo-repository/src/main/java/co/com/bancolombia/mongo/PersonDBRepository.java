package co.com.bancolombia.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface PersonDBRepository extends ReactiveMongoRepository<PersonData, String>, ReactiveQueryByExampleExecutor<PersonData> {
}
