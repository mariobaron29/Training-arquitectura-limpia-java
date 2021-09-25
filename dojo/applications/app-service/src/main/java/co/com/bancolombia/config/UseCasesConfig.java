package co.com.bancolombia.config;

import co.com.bancolombia.model.person.gateways.PersonService;
import co.com.bancolombia.usecase.person.PersonUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.bancolombia.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

       /* @Bean
        public PersonUseCase getPersonUseCase(PersonService serviceGateway) {
                return new PersonUseCase(serviceGateway);
        }*/
}
